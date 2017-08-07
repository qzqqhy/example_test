package adc.test.watch;

import java.util.Observable;
import java.util.Observer;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: RedEventListener.java
 * @Package adc.test.listener
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月8日 下午5:43:45
 */
public class MusicWatch implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        ButtonWatched bwatched = (ButtonWatched) o;
        switch (bwatched.getFlag()) {
            case "0":
                System.out.println("the music is close ");
                break;
            case "1":
                System.out.println("the music is open ");
                break;
            default:
                break;
        }

    }


}

