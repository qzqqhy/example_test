package test.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: LongTest.java
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年5月30日 下午10:35:26
 * @version V1.0
 */
public class TestMap {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "2");
		map.containsKey("1");
		String[] uids = new String[map.size()];
		map.keySet().toArray(uids);
		System.out.println(uids[0]);

	}

	private static void getField(Object model) throws IllegalArgumentException, IllegalAccessException {
		java.lang.reflect.Field[] fields = model.getClass().getDeclaredFields();
		for (java.lang.reflect.Field f : fields) {
			System.out.println(f.getName() + f.getType().getName() + String[].class.getName());
			if (f.getType().getName().equals(String[].class.getName())) {
				System.out.println(f.get(model));
			}
		}
	}

	/**
	 * 
	 * @Title: getVariableValue @Description:根据变量名获取对象内对应变量值 @param @param model @param @param variableName @param @return 设定文件 @return List<String> 返回类型 @throws
	 */
	protected static Object getVariableValue(Object model, String variableName) {
		// 获取所有的变量
		java.lang.reflect.Field[] fields = model.getClass().getDeclaredFields();
		try {
			// 循环处理变量
			for (java.lang.reflect.Field f : fields) {
				System.out.println(f.getName() + f.getType().getName() + String[].class.getName());
				if (f.getName().equals(variableName)) {
					f.setAccessible(true);
					Object value = f.get(model);
					if (value.getClass().isArray()) {
						System.out.println("，变量值等于：" + Arrays.toString((Object[]) value));
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	// kill
	public static Map<String, Object> arrayToMap(String[] strs, String key) {
		Map<String, String> mapo = new HashMap<>();// 二级map
		Map<String, Object> mapt = new HashMap<>();// 一级map
		for (int i = 0; i < strs.length; i++) {
			mapo.put(String.valueOf(i), strs[i]);
		}
		mapt.put(key, mapo);
		return mapt;
	}

	static class User {
		private Integer id;
		private String[] gorps;
		private String name;

		public void setStrs(String[] gorps) {
			this.gorps = gorps;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String[] getGorps() {
			return gorps;
		}

		public void setGorps(String[] gorps) {
			this.gorps = gorps;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
