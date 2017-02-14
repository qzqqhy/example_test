package test.base;
/**   
* @Title: TestFor.java 
* @Package test 
* @Description: 循环测试
* @author zhongqiang.qiu
* @Company www.viewhigh.com
* @date 2016年6月14日 上午10:35:57 
* @version V1.0   
*/
public class TestFor {

    public static void main(String[] args) {
        int i=0;
        for (;;) {
            i++;
            System.out.println(i);
            if(i>100){
                return ;
            }
        }
    }

}

