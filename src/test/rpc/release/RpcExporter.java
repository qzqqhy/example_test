package test.rpc.release;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 
 * @ClassName: RpcExporter
 * @Description: RPC 服务端发布者代码实现
 * @author qzq
 * @date 2016年12月15日 上午9:49:27
 *
 */
public class RpcExporter {
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void exporter(String hostName, int port) throws Exception {

	}
}
