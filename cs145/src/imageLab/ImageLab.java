package imageLab;

import java.io.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javax.imageio.ImageIO;

public class ImageLab {

	public static void main(String[] args) throws IOException {
		File f1 = new File("Geoff.jpg");
		BufferedImage geo = ImageIO.read(f1);
		mirrored(geo, "doubleGeoff.png");
	}
	
	public static void mirrored(BufferedImage img, String output) throws IOException {
		
		int width = img.getWidth();
		int height = img.getHeight();
		BufferedImage mirror = new BufferedImage(width * 2, height, BufferedImage.TYPE_INT_ARGB);
		// left side = same as img
		for (int r = 0; r < width; r++) { // row
			for (int c = 0; c < height; c++) { // column
				mirror.setRGB(r, c, img.getRGB(r, c));
			}
		}
		// right side = mirrored
		for (int r = width; r < width * 2; r++) { // row
			for (int c = 0; c < height; c++) { // column
				int p = img.getRGB(width * 2 - 1 - r, c);
				mirror.setRGB(r, c, p);
			}	
		}
		// create new image
		 File f = new File(output);
		 ImageIO.write(mirror,"png", f);

	}
}
