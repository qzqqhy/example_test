package test.common;

import java.util.ArrayList;
import java.util.List;

import test.bean.User;

/**
 * @Title: TestList.java
 * @Package test.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年7月14日 下午3:56:08
 * @version V1.0
 */
public class TestList {

	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		list.add(new User("amy", 1));

		referenceTransfer(list);

		System.out.println(list);
	}

	private static void referenceTransfer(List<User> list) {
		list.add(null);
		list = new ArrayList<>();
	}

	private static void test1() {
		List<User> list = new ArrayList<User>();
		list.add(new User("amy", 1));

		List<User> listnew = new ArrayList<User>();
		listnew.add(new User("amynew", 2));

		list.addAll(listnew);
		List<String> liststr = new ArrayList<String>();
		liststr.add("222");
		System.out.println(liststr.contains("2221"));
		for (User user : list) {
			int i = list.indexOf(user);
			System.out.println(i);
		}
	}
}
