package test.thread;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: ThreadTest.java
 * @Package test.thread
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年6月27日 下午1:49:58
 */
public class ThreadTest {

    public static void main(String[] args) {
        UserGirl user = new UserGirl();
        Thread thread = user.getThread();
        System.out.println(thread.getName());
    }

}

class UserGirl {
    private String name;
    private String sex;

    UserGirl(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    UserGirl() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Thread getThread() {
        Thread thread = Thread.currentThread();
        return thread;
    }

    @Override
    public String toString() {
        return "name:" + name + " sex:" + sex;
    }
}