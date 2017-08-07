package adc.test.listener;

import java.util.EventListener;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: RedEventListener.java
 * @Package adc.test.listener
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月8日 下午5:43:45
 */
public interface ButtonListener extends EventListener {

    public void handleEvent(ButtonEvent event);
}

