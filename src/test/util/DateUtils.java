package test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
    /**
     * HH:mm:ss
     */
    public static final String TIME_FORMAT = "HH:mm:ss";
    /**
     * yyyyMMdd
     */
    public static final String DAY_FORMAT = "yyyyMMdd";
    /**
     * yyyy-MM-dd
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * yyyyMMddHHmmss
     */
    public static final String UNIX_TIME_FORMAT_END_MINUTES = "yyyyMMddHHmm";
    /**
     * yyyyMMddHHmmss
     */
    public static final String UNIX_TIME_FORMAT = "yyyyMMddHHmmss";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATE_TIME_FORMAT_END_MINUTES = "yyyy-MM-dd HH:mm";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyyMMddHHmmssSSS
     */
    public static final String TIMESTAMP_FORMAT_WEBSERVICE = "yyyyMMddHHmmssSSS";

    /**
     * yyyyMMdd
     */
    public static String getTheDay() {
        return formatYyyyMMddDate(System.currentTimeMillis());
    }

    /**
     * @param
     * @return String 返回类型
     * @Title: getTimestamp
     * @Description: 返回timeStamp类型时间
     */
    public static String getTimestamp() {
        return fromUinxTime(getUnixTime());
    }

    public static Integer formatUnixDate(String date, String fmt) {
        if (StringUtils.isBlank(date) || StringUtils.isBlank(fmt)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return (int) (sdf.parse(date).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param millis
     * @param format
     * @return
     * @Title: formatDate
     */
    public static String formatDate(Long millis, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(millis));
    }

    /**
     * @param secend
     * @param format
     * @return
     * @Title: formatDate
     */
    public static String formatDate(Integer secend, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(secend * 1000L));
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param millis
     * @return
     */
    public static String formatDate(Long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(new Date(millis));
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param secend
     * @return
     */
    public static String formatDate(Integer secend) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(new Date(secend * 1000L));
    }

    /**
     * yyyyMMddHHmmss
     *
     * @param millis
     * @return
     */
    public static String formatUnixDate(Long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat(UNIX_TIME_FORMAT);
        return sdf.format(new Date(millis));
    }

    /**
     * yyyyMMddHHmmssSSS
     *
     * @param millis
     * @return
     */
    public static String formatTimestampDate(Long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT_WEBSERVICE);
        return sdf.format(new Date(millis));
    }

    /**
     * HHmmss
     *
     * @param millis
     * @return
     */
    public static String formatHHmmssDate(Long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(new Date(millis));
    }

    /**
     * yyyyMMdd
     *
     * @param millis
     * @return
     */
    public static String formatYyyyMMddDate(Long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
        return sdf.format(new Date(millis));
    }

    /**
     * yyyyMMdd
     *
     * @param secend
     * @return
     */
    public static String formatYyyyMMddDate(Integer secend) {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
        return sdf.format(new Date(secend * 1000L));
    }

    /****
     * 标准日期格式 转换为 uinx时间戳 标准日期格式格式为 yyyy-MM-dd HH:mm:ss
     *
     * @return 单位：秒
     */
    public static Integer getUnixTime(String fmtDate) {
        if (fmtDate == null || fmtDate.length() == 0) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        try {
            return (int) (sdf.parse(fmtDate).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /****
     * uinx时间戳转换为标准日期格式 格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     *            单位：秒
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String fromUinxTime(Integer date) {
        if (date == null || date.intValue() == 0) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        try {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(date * 1000L);
            return sdf.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /****
     * uinx时间戳转换为标准日期格式 格式为 formatPatten
     *
     * @param date
     *            单位：秒
     * @return formatPatten
     */
    public static String fromUinxTime(Integer date, String formatPatten) {
        if (date == null || date.intValue() == 0) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatPatten);
        try {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(date * 1000L);
            return sdf.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /****
     * uinx时间戳转换为标准日期格式 格式为 formatPatten
     *
     * @param date
     *            单位：秒
     * @return formatPatten
     */
    public static String fromUinxTime(Long date, String formatPatten) {
        if (date == null || date.intValue() == 0) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatPatten);
        try {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(date * 1000L);
            return sdf.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param ym
     * @return
     * @Title: getLastDayOfMonth
     * @Description: 获取指定月份最后一天 <br/>
     * 格式为：yyyyMM
     * @author qzq
     */
    public static Long getLastDayOfMonth(String ym) {

        int year = Integer.valueOf(ym.substring(0, 4));
        int month = Integer.valueOf(ym.substring(4));
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 设置小时
        cal.set(Calendar.HOUR_OF_DAY, 23);
        // 设置分钟
        cal.set(Calendar.MINUTE, 59);
        // 设置秒
        cal.set(Calendar.SECOND, 59);
        // 设置毫秒
        cal.set(Calendar.MILLISECOND, 999);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);

        return Long.valueOf(cal.getTimeInMillis() / 1000);
    }

    /**
     * @Description:返回当前秒 @Date: 2014年5月15日 下午6:49:38 @return @return Integer 单位：秒 @throws
     */
    public static Integer getUnixTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String getWsTime() {
        SimpleDateFormat sf = new SimpleDateFormat(TIMESTAMP_FORMAT_WEBSERVICE);
        return sf.format(new Date());
    }

    /**
     * 几岁几个月几天几小时几分几秒
     */
    public static class Age {
        /**
         * 几岁
         */
        public int year = 0;
        /**
         * 几个月
         */
        public int month = 0;
        /**
         * 几天
         */
        public int day = 0;
        /**
         * 几小时
         */
        public int hour = 0;
        /**
         * 几分
         */
        public int minute = 0;
        /**
         * 几秒
         */
        public int second = 0;

        @Override
        public String toString() {
            return new StringBuffer("{").append("year:").append(year).append(",").append("month:").append(month).append(",").append("day:").append(day).append(",").append("hour:").append(hour).append(",").append("minute:").append(minute).append(",").append("second:").append(second).append("}").toString();
        }

    }

    /**
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return
     * @Title: getAge
     * @Description: 年龄的秒
     * @author zhaokuner
     */
    public static Age getAge(Integer beginTime, Integer endTime) {
        Age age = new Age();
        if (null != beginTime && null != endTime) {
            Calendar bc = Calendar.getInstance();
            bc.setTimeInMillis(beginTime * 1000L);
            Calendar ec = Calendar.getInstance();
            ec.setTimeInMillis(endTime * 1000L);
            age.second = ec.get(Calendar.SECOND) - bc.get(Calendar.SECOND);
            if (age.second < 0) {
                ec.add(Calendar.MINUTE, -1);
                age.second = age.second + 60;
            }
            age.minute = ec.get(Calendar.MINUTE) - bc.get(Calendar.MINUTE);
            if (age.minute < 0) {
                ec.add(Calendar.HOUR_OF_DAY, -1);
                age.minute = age.minute + 60;
            }
            age.hour = ec.get(Calendar.HOUR_OF_DAY) - bc.get(Calendar.HOUR_OF_DAY);
            if (age.hour < 0) {
                ec.add(Calendar.DAY_OF_MONTH, -1);
                age.hour = age.hour + 24;
            }
            age.day = ec.get(Calendar.DAY_OF_MONTH) - bc.get(Calendar.DAY_OF_MONTH);
            if (age.day < 0) {
                ec.add(Calendar.MONTH, -1);
                // 计算上月的天数
                Month m = getMonth(new Date(ec.getTimeInMillis()));
                age.day = age.day + (int) ((m.lastDay - m.firstDay + 1) / (24 * 60 * 60 * 1000));
            }
            age.month = ec.get(Calendar.MONTH) - bc.get(Calendar.MONTH);
            if (age.month < 0) {
                ec.add(Calendar.YEAR, -1);
                age.month = age.month + 12;
            }
            age.year = ec.get(Calendar.YEAR) - bc.get(Calendar.YEAR);
            if (age.year < 0) {
                // 说明输入参数有误
                return new Age();
            }
        }
        return age;
    }

    /**
     * @param time
     * @return
     * @Title: getAge
     * @Description: 年龄的秒
     * @author zhaokuner
     */
    public static Age getAge(Integer time) {
        Age age = new Age();
        if (null != time) {
            // 年 365 * 24 * 60 * 60
            if (time >= 31536000) {
                age.year = time / 31536000;
                time = time % 31536000;
            }
            // 月 30 * 24 * 60 * 60
            if (time >= 2592000) {
                age.month = time / 2592000;
                time = time % 2592000;
            }
            // 天 24 * 60 * 60
            if (time >= 86400) {
                age.day = time / 86400;
                time = time % 86400;
            }
            // 小时 60 * 60
            if (time >= 3600) {
                age.hour = time / 3600;
                time = time % 3600;
            }
            // 分钟 60
            if (time >= 60) {
                age.minute = time / 60;
                time = time % 60;
            }
            // 秒
            age.second = time;
        }
        return age;
    }

    /**
     * @param one
     * @param two
     * @return boolean
     */
    public static boolean isSameDay(Long one, Long two) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String ones = sdf.format(new Date(one));
        String twos = sdf.format(new Date(two));
        return ones.equals(twos);
    }

    /**
     * 一天的0点和24点
     */
    public static class Day {
        /**
         * 毫秒 0点
         */
        public Long clock0 = 0L;
        /**
         * 毫秒 24点
         */
        public Long clock24 = 24L;
        /**
         * 秒 0点
         */
        public Integer clock0Second = 0;
        /**
         * 秒 24点
         */
        public Integer clock24Second = 24;
    }

    /**
     * 获取某一天的0点和24点
     */
    public static Day getDay(Long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Day today = new Day();
        today.clock0 = cal.getTimeInMillis();
        today.clock0Second = (int) (today.clock0 / 1000);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        today.clock24 = cal.getTimeInMillis();
        today.clock24Second = (int) (today.clock24 / 1000);
        return today;
    }

    /**
     * 获取某一天的0点和24点
     */
    public static Day getDay(Date now) {
        return getDay(now.getTime());
    }

    /**
     * 中国 周一~周日
     */
    public static class Weak {
        public Long firstDayMonday = 0L;
        public Long lastDaySunday = 0L;
    }

    /**
     * 中国 周一~周日
     */
    public static Weak getWeak(Date now) {
        Weak w = new Weak();
        /** 以下先根据第一个时间找出所在周的星期一、星期日, 再对第二个时间进行比较 */
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        w.firstDayMonday = cal.getTimeInMillis();
        cal.add(Calendar.DATE, 6);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        w.lastDaySunday = cal.getTimeInMillis();

		/*
         * DateFormat datetimeDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); System.out.println("星期一开始时间：" + datetimeDf.format(w.firstDayMonday)); System.out.println("星期日结束时间：" + datetimeDf.format(w.lastDaySunday));
		 */
        return w;
    }

    public static class Month {
        public Long firstDay = 0L;
        public Long lastDay = 0L;
    }

    public static Month getMonth(Date now) {
        Month m = new Month();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        m.firstDay = cal.getTimeInMillis();

        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        m.lastDay = cal.getTimeInMillis();

        return m;
    }

    public static class Year {
        public Long firstDay = 0L;
        public Long lastDay = 0L;
    }

    public static Year getYear(Date now) {
        Year y = new Year();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        y.firstDay = cal.getTimeInMillis();

        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        y.lastDay = cal.getTimeInMillis();

        return y;
    }

    /**
     * 中国 周一~周日
     */
    public static boolean isSameWeak(Long firstDate, Long secondDate) {

        Weak w = getWeak(new Date(firstDate));
        // 比较第二个时间是否与第一个时间在同一周
        if (secondDate >= w.firstDayMonday && secondDate <= w.lastDaySunday) {
            return true;
        }
        return false;
    }

    /**
     * 洋玩意儿 周日-周六
     */
    public static boolean isSameWeak(Date d1, Date d2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        // subYear==0,说明是同一年
        if (subYear == 0) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        // 例子:cal1是"2005-1-1"，cal2是"2004-12-25"
        // java对"2004-12-25"处理成第52周
        // "2004-12-26"它处理成了第1周，和"2005-1-1"相同了
        // 大家可以查一下自己的日历
        // 处理的比较好
        // 说明:java的一月用"0"标识，那么12月用"11"
        else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        // 例子:cal1是"2004-12-31"，cal2是"2005-1-1"
        else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        return false;
    }

}