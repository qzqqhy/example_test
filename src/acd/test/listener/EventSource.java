package acd.test.listener;

import java.util.Vector;

/**   
* @Title: EventSource.java 
* @Package adc.test.listener 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月8日 下午6:52:28 
* @version V1.0   
*/
public class EventSource {

    private Vector<ButtonListener> list=new Vector<ButtonListener>();  
    private String flag="0";//0代表close 1代表open 默认0
    public void addListener(ButtonListener listener){
        list.addElement(listener);
    }
    public void delListener(ButtonListener listener){
        list.remove(listener);
    }
    public void clickNotice(){
        for(ButtonListener b:list){
           b.handleEvent(new ButtonEvent(this, flag));
        }
    }
    
    public static EventSource initLisner(){
        LightListener lightLisener=new LightListener();
        MusicListener musicListener=new MusicListener();
        EventSource source=new EventSource();
        source.addListener(lightLisener);
        source.addListener(musicListener);
        return source;
    }
    
    public static void main(String[] args) {
        
        EventSource source =initLisner();
        //模拟开关
        char[] arr="0011001110".toCharArray();
        for(int i=0;i<arr.length;i++){
            
            source.flag=arr[i]+"";
            System.out.println("-----------");
            source.clickNotice();
        }
        
    }
}

