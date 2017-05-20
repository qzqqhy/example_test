package adc.test.builder;

import adc.test.listener.ButtonListener;
import adc.test.listener.LightListener;
import adc.test.listener.MusicListener;

import java.util.ArrayList;
import java.util.List;

/**建造者模式-   工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象
* @Title: Builder.java 
* @Package adc.test.builder 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午2:07:49 
* @version V1.0   
*/
public class Builder {

    
    private List<ButtonListener> builds=new ArrayList<ButtonListener>();
    
    public void builderLightListeners(){
        for(int i=0;i<10;i++){
            builds.add(new LightListener());
        }
    }
    
    public void builderMusicListener(){
        for(int i=0;i<10;i++){
            builds.add(new MusicListener());
        }
    }
    
    public static void main(String[] args) {
        Builder b=new Builder();
        b.builderLightListeners();
    }
     
    
}

