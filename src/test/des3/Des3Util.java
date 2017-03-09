package test.des3;

import test.util.SecurityUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class Des3Util extends SecurityUtil {

	private static final String ALGORITHM = "DESede";

	// 定义 加密算法,可用 DES,DESede,Blowfish
	// keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public byte[] encrypt(byte[] keybyte, byte[] src) {

		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
			// 加密
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public byte[] decrypt(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
			// 解密
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密 Base64（3DES（ URLDecoder.decode (消息体) ））
	 * 
	 * @param args
	 * @param key
	 * @return
	 */
	public static String decryptWithURLDecoder(String args, String key) {
		String result = args;
		if (null != result && !result.isEmpty()) {
			try {
				result = URLDecoder.decode(result, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			return decrypt(result, key);
		}
		return result;
	}

	/**
	 * 解密 Base64（3DES（消息体））
	 * 
	 * @param args
	 * @param key
	 * @return
	 */
	public static String decrypt(String args, String key) {
		try {
			Des3Util d3u = new Des3Util();

			// Security.addProvider(new com.sun.crypto.provider.SunJCE());

			return d3u.decryptFromBase64(key, args, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}



	/**
	 * URLEncoder.encode( 加密 Base64（3DES（消息体））)
	 * 
	 * @param body
	 * @param key
	 * @return
	 */
	public static String encryptWithURLEncoder(String body, String key) {
		String result = encrypt(body, key);
		if (null != result && !result.isEmpty()) {
			try {
				return URLEncoder.encode(result, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 加密 Base64（3DES（消息体））
	 * 
	 * @param body
	 * @param key
	 * @return
	 */
	public static String encrypt(String body, String key) {
		try {
			Des3Util d3u = new Des3Util();

			// Security.addProvider(new com.sun.crypto.provider.SunJCE());

			return d3u.encryptToBase64(key, body, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 消息签名
	public static String getSigned(String buf) {

		try {

			byte[] input;

			input = buf.getBytes("UTF-8");
			MessageDigest alga = MessageDigest.getInstance("MD5");
			// MessageDigest alga = MessageDigest.getInstance("SHA-1");
			alga.update(input);

			byte[] md5Hash = alga.digest();
			// System.out.println("MD5:" + new String(md5Hash));

			if (md5Hash != null) {
				return org.apache.commons.codec.binary.Base64.encodeBase64String(md5Hash);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
