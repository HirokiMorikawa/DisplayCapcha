package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author morikawahiroki
 * @version 2017/02/08
 */
public class NetWork {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress());
			System.out.println(InetAddress.getLoopbackAddress());
		} catch (UnknownHostException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
