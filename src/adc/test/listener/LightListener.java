package adc.test.listener;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: RedEventListener.java
 * @Package adc.test.listener
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月8日 下午5:43:45
 */
public class LightListener implements ButtonListener {


    @Override
    public void handleEvent(ButtonEvent event) {
        switch (event.getFlag()) {
            case "0":
                System.out.println("the light is close ");
                break;
            case "1":
                System.out.println("the light is open ");
                break;
            default:
                break;
        }
    }

}

