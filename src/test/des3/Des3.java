package test.des3;

import com.sevenchildren.framework.util.GenerateUtil;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: Des3.java
 * @Package test.des3
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年8月29日 下午5:29:48
 */
public class Des3 {

    public static void main(String[] args) {
        String yz = GenerateUtil.getRandomStr(5);// 添加延值
        Long time = 1471957578L;

        int index = Integer.valueOf(time.toString().substring(time.toString().length() - 1));
        System.out.println(index);
        System.out.println("-----------------------------------第一次加密----------------------------------");
        String key1 = GenerateUtil.getRandomStr(24);
        String encrypt1 = Des3Util.encrypt("123456", key1);
        String encrypt1_yz = encrypt1.substring(0, index).concat(yz).concat(encrypt1.substring(index));
        System.out.println("encrypt1:" + encrypt1 + " key1:" + key1 + " encrypt1_yz:" + encrypt1_yz);

        // String base64decrypt1 = Base64.decode(base64encrypt1);
        // String decrypt1 = Des3Util.decrypt(base64decrypt1, key1);
        // System.out.println(decrypt1 + " base64decrypt:" + base64decrypt1);

        System.out.println("-----------------------------------第二次加密----------------------------------");
        String key2 = GenerateUtil.getRandomStr(24);
        String encrypt2 = Des3Util.encrypt(encrypt1_yz, key2);
        System.out.println("encrypt2:" + encrypt2 + " key2:" + key2);

        // String base64decrypt2 = Base64.decode(base64encrypt2);
        // String decrypt2 = Des3Util.decrypt(base64decrypt2, key2);
        // System.out.println(decrypt2 + " base64decrypt:" + base64decrypt1);
        System.out.println("-----------------------------------第三次加密----------------------------------");
        String key3 = GenerateUtil.getRandomStr(24);
        String encrypt3 = Des3Util.encrypt(encrypt2, key3);
        // String base64encrypt3 = Base64.encode(encrypt3);
        System.out.println("encrypt3:" + encrypt3 + " key3:" + key3);

        System.out.println("-----------------------------------第一次解密----------------------------------");
        String decrypt3 = Des3Util.decrypt(encrypt3, key3);
        System.out.println(decrypt3);
        System.out.println("-----------------------------------第二次解密----------------------------------");
        String decrypt2 = Des3Util.decrypt(decrypt3, key2);
        System.out.println(decrypt2);
        System.out.println("-----------------------------------第三次解密----------------------------------");
        String decrypt2_yz = decrypt2.substring(0, index).concat(decrypt2.substring(index + 5));// 去掉延值
        String decrypt1 = Des3Util.decrypt(decrypt2_yz, key1);
        System.out.println(decrypt1);
    }
}