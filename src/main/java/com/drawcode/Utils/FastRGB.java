package com.drawcode.Utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class FastRGB {

	int width;
	int height;
	boolean hasAlphaChannel;
	int pixelLength;
	byte[] pixels;

	public FastRGB(BufferedImage image) {
					
		pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		width = image.getWidth();
		height = image.getHeight();
		hasAlphaChannel = image.getAlphaRaster() != null;
		pixelLength = 3;
		if (hasAlphaChannel) {
			pixelLength = 4;
		}
	}
	

	public int getRGB(int x, int y) {
		int pos = (y * pixelLength * width) + (x * pixelLength);

		int argb = -16777216; // 255 alpha
		if (hasAlphaChannel) {
			argb = (((int) pixels[pos++] & 0xff) << 24); // alpha
		}

		argb += ((int) pixels[pos++] & 0xff); // blue
		argb += (((int) pixels[pos++] & 0xff) << 8); // green
		argb += (((int) pixels[pos++] & 0xff) << 16); // red
		return argb;
	}

	public boolean isTransparent(int x, int y) {
		int pixel = getRGB(x, y);
		if ((pixel >> 24) == 0x00) {
			return true;
		}
		return false;
	}
	

	
}
