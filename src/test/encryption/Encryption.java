package test.encryption;

import java.io.IOException;

import base64.Base64;
import test.util.LdapPasswordUtil;

/**
 * @Title: Encryption.java
 * @Package test.encryption
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhongqiang.qiu
 * @date 2016年8月19日 上午10:49:02
 * @version V1.0
 */
public class Encryption {
	public static void main(String[] args) throws IOException {
		String uid = "qiuzhongqiang";// 用户名
		// A61hYrjR/j8hKDDYM0VLtnQ==
		// HR0cDovL3d3dy5kYWppZS5jb20vYWNjb3VudC9sb2dpbj9hdXRoX3N0cj0xOTYwNFV6YVd6TiUyQkJDYnFRRGdZSG5RZmZ2bW41ckp3VmZQQW5OVmdreFNtUzA5cEt3JnVybD1odHRwJTNBJTJGJTJGd2VzaG9wLmRhamllLmNvbSUyRnQlMkY1c2JmdnA=
		String sha = LdapPasswordUtil.SHA(uid);

		System.out.println(Base64.decode("HR0cDovL3d3dy5kYWppZS5jb20vYWNjb3VudC9sb2dpbj9hdXRoX3N0cj0xOTYwNFV6YVd6TiUyQkJDYnFRRGdZSG5RZmZ2bW41ckp3VmZQQW5OVmdreFNtUzA5cEt3JnVybD1odHRwJTNBJTJGJTJGd2VzaG9wLmRhamllLmNvbSUyRnQlMkY1c2JmdnA="));
	}
}