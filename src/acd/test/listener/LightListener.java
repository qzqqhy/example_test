package acd.test.listener;

/**   
* @Title: RedEventListener.java 
* @Package adc.test.listener 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月8日 下午5:43:45 
* @version V1.0   
*/
public class LightListener implements ButtonListener{
 

     
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

