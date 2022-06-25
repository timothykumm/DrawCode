package com.drawcode.Processing;

import java.awt.image.BufferedImage;
import java.io.File;

import com.drawcode.Utils.GetImage;

public class ReziseImage {

	int width, height, bigger;
	BufferedImage photo;
	
	public BufferedImage reziseImageFile(File img, int reziseTo) {
		// BufferedImage photo = GetImage.resize(GetImage.bufferImage(img), 500, 500);
		photo = GetImage.bufferImage(img);
		height = photo.getHeight();
		width = photo.getWidth();

		if (height > width) {
			bigger = height;
		} else {
			bigger = width;
		}

		//System.err.println(bigger);

		while (bigger < reziseTo) {
			height++;
			width++;
			bigger++;
		}
		
		while (bigger > reziseTo) {
			height--;
			width--;
			bigger--;
		}

		//System.out.println("Height: " + height);
		//System.out.println("Width: " + width);
		if(width < 0 || height < 0) {
			return GetImage.resize(photo, 550, 250);	
		}
		return GetImage.resize(photo, width, height);
	}
	
	public BufferedImage reziseImageBufferedImage(BufferedImage photo, int reziseTo) {

		height = photo.getHeight();
		width = photo.getWidth();

		if (height > width) {
			bigger = height;
		} else {
			bigger = width;
		}

		//System.err.println(bigger);

		while (bigger < reziseTo) {
			height++;
			width++;
			bigger++;
		}
		
		while (bigger > reziseTo) {
			height--;
			width--;
			bigger--;
		}

		//System.out.println("Height: " + height);
		//System.out.println("Width: " + width);
		if(width <= 0 || height <= 0) {
			return GetImage.resize(photo, 550, 250);	
		}
		return GetImage.resize(photo, width, height);
	}
}
