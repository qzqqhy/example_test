package test.socket;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class TestSocket {

	public static void main(String[] args) {

	}

}

class BaseCase {
	public String execute(String host, int port, String request) throws UnknownHostException, IOException {
		long begin = System.currentTimeMillis();
		InputStream in = new InputStream() {

			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		DataInputStream input = new DataInputStream(in);
		Socket socket = new Socket(host, port);

		try {

			System.out.println("send+++++++++++>");
			System.out.println("请求字符串：" + request);
			// 打开输出流
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			// 发送字节数组流长度
			output.writeInt(request.getBytes("utf-8").length);
			// 发送字节数组流内容
			output.write(request.getBytes("utf-8"));
			output.flush();
			// 打开输入流
			input = new DataInputStream(socket.getInputStream());
			int length = input.readInt();
			byte[] bytes = new byte[length];
			// 读取服务端返回的字节数组流
			input.readFully(bytes, 0, length);
			long end = System.currentTimeMillis();
			System.out.println("total time:" + (end - begin) + "ms");
			return new String(bytes, "UTF-8");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				InputStream dos = new InputStream() {

					@Override
					public int read() throws IOException {
						// TODO Auto-generated method stub
						return 0;
					}
				};
				if (socket != null || dos != null) {
					input.close();
					dos.close();
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}
}

class GetCode extends BaseCase {
	public String host = "192.168.1.10";
	public int port = 12345;

	@Test
	public void test1() throws UnknownHostException, IOException {
		String ss = "{\"authCodeType\":4,\"cmd\":\"getAuthCode\",\"userName\":\"13600136123\"}";
		System.out.println(execute(host, port, ss));
	}
}