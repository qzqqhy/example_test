package test.common;

import test.bean.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: TestList.java
 * @Package test.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年7月14日 下午3:56:08
 */
public class TestList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = integers.stream().filter(a -> {
             return a.intValue() == 1 ;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * jdk1.8 新特性&筛选过滤
     */
    public static void jdk1_8Filter(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(111);

        List<Integer> collect = integers.stream().filter(a -> {

            if (a.intValue() == 1) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
    /**
     *  jdk1.8 新特性&去重复
     */
    public static void jdk1_8Quchong(){
        List<User> list = new ArrayList<>();
        list.add(new User("1",1));
        list.add(new User("2",1));
        list.add(new User("3",1));
        list.add(new User("1",1));

        List<User> unique = list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(User::getName))), ArrayList::new)
        );
        unique.forEach(System.out::println);
    }
    /**
     * jdk1.8 新特性&排序
     */
    public static void jdk1_8Sort(){
        List<Integer> list = Arrays.asList(1, 3, 4, 7, 8, 1, 2, 8);
        list.sort((a, b) -> {
            return b.compareTo(a);
        });
        System.out.println(list);
    }
    /**
     * debug模式查看方法中变量，堆的信息<br/>
     * 以此得出 在传参过程中，只是拷贝的栈的地址，如果重新指定（new Object）的堆给栈，也只是在方法内改变了栈指向的堆，原来的在运行时记录了
     */
    private static void stackAddress() {
        List<User> list = new ArrayList<User>();
        list.add(new User("amy", 1));


        User user = new User();
        user.setName("1111");
        System.out.print(list + "    " + user);
        referenceTransfer(list, user);
        System.out.print(list + "    " + user);

    }

    private static List<User> referenceTransfer(List<User> list, User user) {

        list.add(null);
        list = new ArrayList<>();

        List<User> list1 = list;
        user.setSex(111);
        user = new User();
        return list;
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

    /**
     * 完整的堆栈信息
     *
     * @param e Exception
     * @return Full StackTrace
     */
    public static String getStackTrace(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
