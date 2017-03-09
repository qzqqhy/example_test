package test.common;


import com.sevenchildren.framework.util.URLCoderUtil;

/**   
* @Title: TestStringUtils.java 
* @Package test.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhongqiang.qiu
* @Company www.viewhigh.com
* @date 2016年6月18日 下午3:39:25 
* @version V1.0   
*/
public class TestStringUtils extends BaseTest{

//    public static void main(String[] args) {
//        String str="   1   ";
//        StringUtils.isBlank(str);
//        System.out.println("|"+str+"|");
//        
//    }
	public static void main(String[] args) {
		String str=URLCoderUtil.decodeUTF8("#%F0%9F%92%8BA%E3%80%81Mo%E9%BB%98%27%F0%9F%8D%80-%C2%B0RYB%C2%B0");
		System.out.println(str);
	}

}

