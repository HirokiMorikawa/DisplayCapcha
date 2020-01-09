package network;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import capture.GenerateFileName;

/**
 * データを受け取る
 * 
 * @author morikawahiroki
 * @version 2017/02/08
 */
public class Recever implements Runnable {
	private final static int PORT = 8001; // 待受ポート番号
	private Socket socket;
	private String name;

	public Recever(Socket socket) {
		this.name = "./capture/" + new GenerateFileName().getFileName("jpg");
		this.socket = socket;
	}

	@Override
	public void run() {
		byte[] buffer = new byte[256]; // ファイル受信時のバッファ
		// ストリームの準備

		try {
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = new FileOutputStream(name);

			// ファイルをストリームで受信
			int fileLength;

			while ((fileLength = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, fileLength);
			}
			// 終了処理
			outputStream.flush();
			outputStream.close();
			inputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		int count = 10;
		try {
			int i = 0;
			while (i < count) {
				// ソケットの準備
				ServerSocket serverSocket = new ServerSocket(PORT);
				new Thread(new Recever(serverSocket.accept()));
				serverSocket.close();
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
