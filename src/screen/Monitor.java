package screen;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

/**
 * スクリーンサイズを取得するためのクラス
 * 
 * @author morikawahiroki
 * @version 2017/02/07
 */
public class Monitor {

	private Rectangle rectangle;
	private double widthSize = 0;
	private double heightSize = 0;

	public Monitor() {
		rectangle = getScreenSize();
		widthSize = rectangle.getWidth();
		heightSize = rectangle.getHeight();
	}

	public double getWidthSize() {
		return widthSize;
	}

	public double heightSize() {
		return heightSize;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	/**
	 * スクリーンサイズを取得
	 * 
	 * @return
	 */
	private Rectangle getScreenSize() {
		Rectangle virtualBounds = new Rectangle();
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		for (int j = 0; j < gs.length; j++) {
			GraphicsDevice gd = gs[j];
			GraphicsConfiguration[] gc = gd.getConfigurations();
			for (int i = 0; i < gc.length; i++) {
				virtualBounds = virtualBounds.union(gc[i].getBounds());
			}
		}
		return virtualBounds;
	}

	public String toString() {
		return String.format("x=%f, y=%f", widthSize, heightSize);
	}

}
