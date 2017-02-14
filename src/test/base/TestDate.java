package test.base;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import test.util.DateUtils;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		Long time = new Date().getTime();
		String ds1 = DateUtils.formatDate(1483027199, DateUtils.DATE_TIME_FORMAT);
		// System.out.println(ds1);
		// System.out.println(1480930200 + 60 * 10);
		System.out.println(ds1);

		// System.out.println(1480478400 + 1600);
		// for (int i = 10; i <= 24; i++) {
		// Integer aa = test4(i);
		// Integer bb = test5(i);
		// // System.out.println(aa + " " + bb);
		// System.out.println(DateUtils.formatDate(bb, DateUtils.DATE_TIME_FORMAT));
		// }
		// System.out.println(test4(9));
	}

	public static Integer test4(Integer m) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 10);
		c.set(Calendar.HOUR_OF_DAY, m);
		c.set(Calendar.MINUTE, 00);
		c.set(Calendar.SECOND, 0);
		Date d1 = c.getTime();
		Integer unixTime = Long.valueOf(d1.getTime() / 1000).intValue();
		// System.out.println(unixTime);
		return unixTime;
	}

	public static Integer test5(Integer m) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 06);
		c.set(Calendar.HOUR_OF_DAY, m);
		c.set(Calendar.MINUTE, 10);
		c.set(Calendar.SECOND, 0);
		Date d1 = c.getTime();
		Integer unixTime = Long.valueOf(d1.getTime() / 1000).intValue();
		// System.out.println(unixTime);
		return unixTime;
	}

	public static void test3() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date d1 = c.getTime();
		String ds1 = DateUtils.formatDate(d1.getTime(), DateUtils.DATE_TIME_FORMAT);
		System.out.println(ds1);

		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date d2 = c.getTime();
		String ds2 = DateUtils.formatDate(d2.getTime(), DateUtils.DATE_TIME_FORMAT);
		System.out.println(d2.getTime() / 1000 + " " + ds2);
	}

	// 1476848388
	public static void test2() {
		// 当前时间减一小时
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, c.get(Calendar.HOUR) - 1);
		Date endDate = c.getTime();
		String ds2 = DateUtils.formatDate(endDate.getTime(), DateUtils.DATE_TIME_FORMAT);
		System.out.println(ds2);
	}

	public static void test1() {
		Date d1 = new Date();// 1476089421
		String ds1 = DateUtils.formatDate(1476115199, DateUtils.DATE_FORMAT);
		String ds2 = DateUtils.formatDate(d1.getTime(), DateUtils.DATE_FORMAT);
		String fmtDate = ds2 + " 23:59:59";
		Integer unixTime = DateUtils.getUnixTime(fmtDate);
		System.out.println(unixTime);
		System.out.println(d1.getTime() / 1000);
		System.out.println(ds2);
	}
}