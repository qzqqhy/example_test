package acd.test.listener;

import java.util.EventListener;

/**   
* @Title: RedEventListener.java 
* @Package adc.test.listener 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月8日 下午5:43:45 
* @version V1.0   
*/
public interface ButtonListener extends EventListener{
    
    public void handleEvent(ButtonEvent event);
}

