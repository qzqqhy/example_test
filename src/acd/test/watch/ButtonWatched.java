package acd.test.watch;

import java.util.Observable;

/**   
* @Title: ButtonWatch.java 
* @Package adc.test.watch 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月8日 下午7:18:58 
* @version V1.0   
*/
public class ButtonWatched extends Observable{
    private String flag;

 
    public static ButtonWatched initWatched(){
        LightWatch lightwatch=new LightWatch();
        MusicWatch musicwatch=new MusicWatch();
        ButtonWatched source=new ButtonWatched();
        source.addObserver(lightwatch);
        source.addObserver(musicwatch);
        return source;
    }
    
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        
        ButtonWatched source =initWatched();
        //模拟开关
        char[] arr="0011001110".toCharArray();
        for(int i=0;i<arr.length;i++){
            
            source.flag=arr[i]+"";
            System.out.println("-----------");
            source.setChanged();
            source.notifyObservers(arr[i]);
        }
        
    }
    
    
}

