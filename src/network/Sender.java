package network;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import capture.Capture;

/**
 *
 * データを送信する
 * 
 * @author morikawahiroki
 * @version 2017/02/08
 */
public class Sender {
	final static String HOST = "192.168.0.8"; // 接続先アドレス
	final static int PORT = 8001; // 接続先ポート番号
	final static byte[] bytes = new byte[512];

	public static void main(String[] args) {
		try {
			Socket client = new Socket(HOST, PORT);
			Capture cap = new Capture();
			InputStream is = new ByteArrayInputStream(
					cap.takeBufferedDisplay("jpg"));
			OutputStream os = client.getOutputStream();

			// ファイルをストリームで送信
			int fileLength;
			while ((fileLength = is.read(bytes)) > 0) {
				os.write(bytes, 0, fileLength);
			}

			// 終了処理
			os.flush();
			os.close();
			is.close();
			client.close();
		} catch (AWTException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
