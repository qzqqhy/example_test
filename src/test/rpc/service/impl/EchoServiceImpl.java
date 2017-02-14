package test.rpc.service.impl;

import test.rpc.service.EchoService;

/**
 * 
 * @ClassName: EchoServiceImpl
 * @Description: EchoService 接口实现代码
 * @author qzq
 * @date 2016年12月15日 上午9:44:47
 *
 */
public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String ping) {
		return ping != null ? ping + "--> I am ok." : "I am ok .";
	}

}
