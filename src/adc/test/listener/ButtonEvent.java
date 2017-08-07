package adc.test.listener;

import java.util.EventObject;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: ButtonEvent.java
 * @Package adc.test.listener
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月8日 下午6:02:30
 */
public class ButtonEvent extends EventObject {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;
    private String flag;

    public ButtonEvent(Object source, String flag) {
        super(source);
        this.flag = flag;
    }


    public void dual() {
        System.out.println("the button is dual flag=" + flag);
    }


    public String getFlag() {
        return flag;
    }


    public void setFlag(String flag) {
        this.flag = flag;
    }

}

