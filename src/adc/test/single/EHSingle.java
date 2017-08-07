package adc.test.single;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: EHSingle.java
 * @Package adc.test.single
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 上午11:11:23
 */
public class EHSingle {

    private static EHSingle instance = new EHSingle();

    private EHSingle() {
        super();
    }

    public EHSingle getInstance() {
        return instance;
    }

}

