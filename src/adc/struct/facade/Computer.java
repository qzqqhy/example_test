package adc.struct.facade;
/**   
* @Title: Computer.java 
* @Package adc.struct.facade 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午4:08:44 
* @version V1.0   
*/
public class Computer {
    private cpu cpu;  
    private memery memory;  
    public Computer(){  
        cpu = new cpu();  
        memory = new memery();  
     }  
      
    public void startup(){  
        System.out.println("start the computer!");  
        cpu.startup();  
        memory.startup();  
        System.out.println("start computer finished!");  
    }  
}

