package test.des3;

import com.sevenchildren.framework.util.GenerateUtil;

// key 分成3端 每段8个字节     encrypt 根据index索引分成3端 (可调整索引的参数)
public class Password {
    // 取随机index
    private static final int bit1 = 9;
    private static final int bit2 = 5;
    private static final int bit3 = 8;

    public static void main(String[] args) {
        // 设定一个时间值 选取
        Long time = 346930923512L;
        // int index = Integer.valueOf(time.toString().substring(time.toString().length() - 1));
        // // index 2
        // System.out.println(index);
        System.out.println("----------------------------First----------------------------");
        String conteng = "1234567890";

        String[] ek = encrypt(conteng, time);

        String pwd = decrypt(time, ek[0], ek[1]);
        System.out.println("解密密码为：" + pwd);

        System.exit(0);
    }

    /**
     * @param time
     * @param encrypt_y
     * @param key2
     * @return
     * @Title: decrypt
     * @Description: des3解密
     * @author qzq
     */
    private static String decrypt(Long time, String encrypt_y, String key2) {
        int[] is = retIndexs(time);
        int index1 = is[0];
        int index2 = is[1];
        int index3 = is[2];
        String decrypt3 = Des3Util.decrypt(encrypt_y, key2);

        String start = decrypt3.substring(index3, index3 + 8);// key-----------值1
        String decrypt2 = decrypt3.substring(0, index3).concat(decrypt3.substring(index3 + start.length(), decrypt3.length())); // 第一段

        String mid = decrypt2.substring(index2, index2 + 8);// key-----------值2
        String decrypt1 = decrypt2.substring(0, index2).concat(decrypt2.substring(index2 + mid.length(), decrypt2.length()));

        String fina = decrypt1.substring(index1, index1 + 8); // key-----------值3
        String decrypt = decrypt1.substring(0, index1).concat(decrypt1.substring(index1 + fina.length(), decrypt1.length()));
        // 拼 key
        String key = fina.concat(mid).concat(start);
        String pwd = Des3Util.decrypt(decrypt, key);
        return pwd;
    }

    /**
     * @param content
     * @param time
     * @return
     * @Title: encrypt
     * @Description: des3加密
     * @author qzq
     */
    private static String[] encrypt(String content, Long time) {
        String key = GenerateUtil.getRandomStr(24);
        String key2 = GenerateUtil.getRandomStr(24);

        String encrypt = Des3Util.encrypt(content, key);

        int[] is = retIndexs(time);
        int index1 = is[0];
        int index2 = is[1];
        int index3 = is[2];
        String start = key.substring(0, 8);// key-----------值1
        String mid = key.substring(8, 16);// key-----------值2
        String fina = key.substring(16, 24); // key-----------值3
        String encrypt1 = encrypt.substring(0, index1).concat(start).concat(encrypt.substring(index1, encrypt.length()));
        String encrypt2 = encrypt1.substring(0, index2).concat(mid).concat(encrypt1.substring(index2, encrypt1.length()));
        String encrypt3 = encrypt2.substring(0, index3).concat(fina).concat(encrypt2.substring(index3, encrypt2.length()));

        String encrypt_y = Des3Util.encrypt(encrypt3, key2);// 2次加密
        System.out.println("encrypt_y: " + encrypt_y + " key2: " + key2);
        String[] ek = {encrypt_y, key2};
        return ek;
    }

    private static int[] retIndexs(Long time) {
        int index1 = retIndex(time, bit1);
        int index2 = retIndex(time, bit2);
        int index3 = retIndex(time, bit3);
        int[] is = {index1, index2, index3};
        return is;
    }

    public static int retIndex(Long orgi, int i) {
        char array[] = orgi.toString().toCharArray();
        char index1 = array[i];
        return Integer.valueOf(String.valueOf(index1));
    }
}
