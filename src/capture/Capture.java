package capture;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import screen.Monitor;

/**
 * 画面キャプチャする
 * 
 * @author morikawahiroki
 * @version 2017/02/07
 */
public class Capture {
	/**
	 * 画面をキャプチャするためのインスタンス
	 */
	private Robot robot;
	/**
	 * 画面に関するクラス
	 */
	private Monitor monitor;

	/**
	 * コンストラクタ
	 *
	 * @throws AWTException
	 */
	public Capture() throws AWTException {
		monitor = new Monitor();
		robot = new Robot();
	}

	/**
	 * 画面をキャプチャする
	 */
	public BufferedImage takeDisplay() {
		return robot.createScreenCapture(monitor.getRectangle());
	}

	/**
	 * 画面をキャプチャしてバイトコードに変換する
	 * 
	 * @param imageFormat
	 *            画像フォーマット
	 * @return バイトコード
	 * @throws IOException
	 */
	public byte[] takeBufferedDisplay(String imageFormat) throws IOException {
		BufferedImage image = takeDisplay();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(baos);
		image.flush();
		ImageIO.write(image, imageFormat, bos);
		bos.flush();
		bos.close();
		return baos.toByteArray();
	}

	public static void main(String[] args) {
		try {
			Capture cap = new Capture();
			byte[] image = cap.takeBufferedDisplay("jpg");
			for(byte data : image) {
				System.out.println(data);
			}
		} catch (AWTException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.exit(0);
		}

	}
}
