package transmit;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author morikawahiroki
 * @version 2017/02/08
 */
public class SendImage {
	public byte[] getBufferedImageBytes(BufferedImage image, String imageFormat)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(baos);
		image.flush();
		ImageIO.write(image, imageFormat, bos);
		bos.flush();
		bos.close();
		return baos.toByteArray();
	}
}
