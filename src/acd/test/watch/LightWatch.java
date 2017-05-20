package acd.test.watch;

import java.util.Observable;
import java.util.Observer;

/**   
* @Title: RedEventListener.java 
* @Package adc.test.listener 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月8日 下午5:43:45 
* @version V1.0   
*/
public class LightWatch  implements Observer{
 


    @Override
    public void update(Observable o, Object arg) {
        ButtonWatched bwatched=(ButtonWatched)o;
        switch (bwatched.getFlag()) {
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

