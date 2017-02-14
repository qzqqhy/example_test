package test.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import test.bean.Employee;
import test.bean.User;

/**   
* @Title: TestPropertyDescriptor.java 
* @Package test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhongqiang.qiu
* @Company www.viewhigh.com
* @date 2016年6月14日 上午11:00:13 
* @version V1.0   
*/
public class TestPropertyDescriptor extends BaseTest{
    
    
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        TestPropertyDescriptor tpd=new TestPropertyDescriptor();
        User user=new User();
        user.setAddress("广渠门");
        user.setId(1L);
        user.setSex(1);
        user.setName("hanmeimei");
        user.setJob("it精英");
        Employee employee=new Employee();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name", "广渠门内");
        map.put("sex", "222");
        map.put("job", "方芳芳");
        map.put("address", "地地道道的");
        tpd.copyProperties(employee,map);
//      System.out.println(map.toString());
        System.out.println(employee.toString()+TestPropertyDescriptor.BEANS_BY_CLASSLOADER);
    }
    
    private static final ContextClassLoaderLocal<BeanUtilsBean>
    BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<BeanUtilsBean>() {
                // Creates the default instance used when the context classloader is unavailable
                @Override
                protected BeanUtilsBean initialValue() {
                    return new BeanUtilsBean();
                }
            };
    private final PropertyUtilsBean propertyUtilsBean;
    private final ConvertUtilsBean convertUtilsBean;
    
    public TestPropertyDescriptor() {
        this(new ConvertUtilsBean(), new PropertyUtilsBean());
    }
    public TestPropertyDescriptor(ConvertUtilsBean convertUtilsBean2, PropertyUtilsBean propertyUtilsBean2) {
        this.convertUtilsBean = convertUtilsBean2;
        this.propertyUtilsBean = propertyUtilsBean2;
    }
    private final Log log = LogFactory.getLog(TestPropertyDescriptor.class);
    
    public void copyProperties(Object dest, Object orig)
            throws IllegalAccessException, InvocationTargetException {

            // Validate existence of the specified beans
            if (dest == null) {
                throw new IllegalArgumentException
                        ("No destination bean specified");
            }
            if (orig == null) {
                throw new IllegalArgumentException("No origin bean specified");
            }

            // Copy the properties, converting as necessary
            if (orig instanceof DynaBean) {
                DynaProperty[] origDescriptors =
                    ((DynaBean) orig).getDynaClass().getDynaProperties();
                for (int i = 0; i < origDescriptors.length; i++) {
                    String name = origDescriptors[i].getName();
                    // Need to check isReadable() for WrapDynaBean
                    // (see Jira issue# BEANUTILS-61)
                    if (getPropertyUtils().isReadable(orig, name) &&
                        getPropertyUtils().isWriteable(dest, name)) {
                        Object value = ((DynaBean) orig).get(name);
                        copyProperty(dest, name, value);
                    }
                }
            } else if (orig instanceof Map) {
                @SuppressWarnings("unchecked")
                // Map properties are always of type <String, Object>
                Map<String, Object> propMap = (Map<String, Object>) orig;
                for (Map.Entry<String, Object> entry : propMap.entrySet()) {
                    String name = entry.getKey();
                    if (getPropertyUtils().isWriteable(dest, name)) {
                        copyProperty(dest, name, entry.getValue());
                    }
                }
            } else /* if (orig is a standard JavaBean) */ {
                PropertyDescriptor[] origDescriptors =
                    getPropertyUtils().getPropertyDescriptors(orig);
                for (int i = 0; i < origDescriptors.length; i++) {
                    String name = origDescriptors[i].getName();
                    if ("class".equals(name)) {
                        continue; // No point in trying to set an object's class
                    }
                    if (getPropertyUtils().isReadable(orig, name) &&
                        getPropertyUtils().isWriteable(dest, name)) {
                        try {
                            Object value =
                                getPropertyUtils().getSimpleProperty(orig, name);
                            copyProperty(dest, name, value);
                        } catch (NoSuchMethodException e) {
                            // Should not happen
                        }
                    }
                }
            }

        }
    public void copyProperty(Object bean, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {

            // Trace logging (if enabled)
            if (log.isTraceEnabled()) {
                StringBuilder sb = new StringBuilder("  copyProperty(");
                sb.append(bean);
                sb.append(", ");
                sb.append(name);
                sb.append(", ");
                if (value == null) {
                    sb.append("<NULL>");
                } else if (value instanceof String) {
                    sb.append((String) value);
                } else if (value instanceof String[]) {
                    String[] values = (String[]) value;
                    sb.append('[');
                    for (int i = 0; i < values.length; i++) {
                        if (i > 0) {
                            sb.append(',');
                        }
                        sb.append(values[i]);
                    }
                    sb.append(']');
                } else {
                    sb.append(value.toString());
                }
                sb.append(')');
                log.trace(sb.toString());
            }

            // Resolve any nested expression to get the actual target bean
            Object target = bean;
            Resolver resolver = getPropertyUtils().getResolver();
            while (resolver.hasNested(name)) {
                try {
                    target = getPropertyUtils().getProperty(target, resolver.next(name));
                    name = resolver.remove(name);
                } catch (NoSuchMethodException e) {
                    return; // Skip this property setter
                }
            }
            if (log.isTraceEnabled()) {
                log.trace("    Target bean = " + target);
                log.trace("    Target name = " + name);
            }

            // Declare local variables we will require
            String propName = resolver.getProperty(name); // Simple name of target property
            Class<?> type = null;                         // Java type of target property
            int index  = resolver.getIndex(name);         // Indexed subscript value (if any)
            String key = resolver.getKey(name);           // Mapped key value (if any)

            // Calculate the target property type
            if (target instanceof DynaBean) {
                DynaClass dynaClass = ((DynaBean) target).getDynaClass();
                DynaProperty dynaProperty = dynaClass.getDynaProperty(propName);
                if (dynaProperty == null) {
                    return; // Skip this property setter
                }
                type = dynaPropertyType(dynaProperty, value);
            } else {
                PropertyDescriptor descriptor = null;
                try {
                    descriptor =
                        getPropertyUtils().getPropertyDescriptor(target, name);
                    if (descriptor == null) {
                        return; // Skip this property setter
                    }
                } catch (NoSuchMethodException e) {
                    return; // Skip this property setter
                }
                type = descriptor.getPropertyType();
                if (type == null) {
                    // Most likely an indexed setter on a POJB only
                    if (log.isTraceEnabled()) {
                        log.trace("    target type for property '" +
                                  propName + "' is null, so skipping ths setter");
                    }
                    return;
                }
            }
            if (log.isTraceEnabled()) {
                log.trace("    target propName=" + propName + ", type=" +
                          type + ", index=" + index + ", key=" + key);
            }

            // Convert the specified value to the required type and store it
            if (index >= 0) {                    // Destination must be indexed
                value = convertForCopy(value, type.getComponentType());
                try {
                    getPropertyUtils().setIndexedProperty(target, propName,
                                                     index, value);
                } catch (NoSuchMethodException e) {
                    throw new InvocationTargetException
                        (e, "Cannot set " + propName);
                }
            } else if (key != null) {            // Destination must be mapped
                // Maps do not know what the preferred data type is,
                // so perform no conversions at all
                // FIXME - should we create or support a TypedMap?
                try {
                    getPropertyUtils().setMappedProperty(target, propName,
                                                    key, value);
                } catch (NoSuchMethodException e) {
                    throw new InvocationTargetException
                        (e, "Cannot set " + propName);
                }
            } else {                             // Destination must be simple
                value = convertForCopy(value, type);
                try {
                    getPropertyUtils().setSimpleProperty(target, propName, value);
                } catch (NoSuchMethodException e) {
                    throw new InvocationTargetException
                        (e, "Cannot set " + propName);
                }
            }

        }
    
    public ConvertUtilsBean getConvertUtils() {
        return convertUtilsBean;
    }
    protected Object convert(Object value, Class<?> type) {
        Converter converter = getConvertUtils().lookup(type);
        if (converter != null) {
            log.trace("        USING CONVERTER " + converter);
            return converter.convert(type, value);
        } else {
            return value;
        }
    }
    private Object convertForCopy(Object value, Class<?> type) {
        return (value != null) ? convert(value, type) : value;
    }
    private static Class<?> dynaPropertyType(DynaProperty dynaProperty,
            Object value) {
        if (!dynaProperty.isMapped()) {
            return dynaProperty.getType();
        }
        return (value == null) ? String.class : value.getClass();
    }
    public PropertyUtilsBean getPropertyUtils() {
        return propertyUtilsBean;
    }
    public static BeanUtilsBean getInstance() {
        return BEANS_BY_CLASSLOADER.get();
    }
    public static void setInstance(BeanUtilsBean newInstance) {
        BEANS_BY_CLASSLOADER.set(newInstance);
    }
}

