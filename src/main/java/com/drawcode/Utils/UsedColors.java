package com.drawcode.Utils;

import java.awt.AWTException;

import com.drawcode.Gui.Menu;

public class UsedColors {

	int red = 0;
	int green = 0;
	int blue = 0;

	int x, y;
	int width;
	int height;
	String nearestColor = "";
	String rgbcolor = "";

	public static boolean usedColors[] = { false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false };

	public void scanColors(String plusxy) throws AWTException, InterruptedException {

		ColorUtils color = new ColorUtils();
		FastRGB getPixel = new FastRGB(Menu.selectedImage);
		int[][] pixels = new int[Menu.selectedImage.getWidth()][Menu.selectedImage.getHeight()];

		width = Menu.selectedImage.getWidth();
		height = Menu.selectedImage.getHeight();

		for (int y = 0; y < height - 4; y += Integer.parseInt(Menu.pixelbypixel.getText())) {
			for (int x = 0; x < width - 4; x += Integer.parseInt(Menu.pixelbypixel.getText())) {
				if (getPixel.isTransparent(x, y) == false) {

					pixels[x][y] = getPixel.getRGB(x, y);

					red = (pixels[x][y] >> 16) & 0xff;
					green = (pixels[x][y] >> 8) & 0xff;
					blue = pixels[x][y] & 0xff;

					rgbcolor = color.getColorNameFromRgb(red, green, blue);

					if (rgbcolor.matches("Hellgrau") || rgbcolor.matches("Hellgrau2") || rgbcolor.matches("Hellgrau3")
							|| rgbcolor.matches("Hellgrau4") || rgbcolor.matches("Hellgrau5")) {
						usedColors[1] = true;
					}
					if (rgbcolor.matches("Hellrot") || rgbcolor.matches("Hellrot2") || rgbcolor.matches("Hellrot3")
							|| rgbcolor.matches("Hellrot4") || rgbcolor.matches("Hellrot5")
							|| rgbcolor.matches("Hellrot6")) {
						usedColors[2] = true;
					}
					if (rgbcolor.matches("Hellorange") || rgbcolor.matches("Hellorange2")
							|| rgbcolor.matches("Hellorange3") || rgbcolor.matches("Hellorange4")) {
						usedColors[3] = true;
					}
					if (rgbcolor.matches("Hellgelb") || rgbcolor.matches("Hellgelb2") || rgbcolor.matches("Hellgelb3")
							|| rgbcolor.matches("Hellgelb4") || rgbcolor.matches("Hellgelb5")) {
						usedColors[4] = true;
					}
					if (rgbcolor.matches("Hellgr�n") || rgbcolor.matches("Hellgr�n2") || rgbcolor.matches("Hellgr�n3")
							|| rgbcolor.matches("Hellgr�n4") || rgbcolor.matches("Hellgr�n5")
							|| rgbcolor.matches("Hellgr�n6") || rgbcolor.matches("Hellgr�n7")
							|| rgbcolor.matches("Hellgr�n8") || rgbcolor.matches("Hellgr�n9")
							|| rgbcolor.matches("Hellgr�n10") || rgbcolor.matches("Hellgr�n11")
							|| rgbcolor.matches("Hellgr�n12") || rgbcolor.matches("Hellgr�n13")
							|| rgbcolor.matches("Hellgr�n14") || rgbcolor.matches("Hellgr�n15")) {
						usedColors[5] = true;
					}
					if (rgbcolor.matches("Hellblau") || rgbcolor.matches("Hellblau2") || rgbcolor.matches("Hellblau3")
							|| rgbcolor.matches("Hellblau4") || rgbcolor.matches("Hellblau5")
							|| rgbcolor.matches("Blauwei�")) {
						usedColors[6] = true;
					}
					if (rgbcolor.matches("Mondblau")) {
						usedColors[7] = true;
					}
					if (rgbcolor.matches("Helllila") || rgbcolor.matches("Helllila2") || rgbcolor.matches("Helllila3")
							|| rgbcolor.matches("Helllila4")) {
						usedColors[8] = true;
					}
					if (rgbcolor.matches("Hellpink") || rgbcolor.matches("Hellpink2") || rgbcolor.matches("Hellpink3")
							|| rgbcolor.matches("Hellpink4") || rgbcolor.matches("Hellpink5")
							|| rgbcolor.matches("Hellpink6") || rgbcolor.matches("Hellpink7")) {
						usedColors[9] = true;
					}
					if (rgbcolor.matches("Hellbraun") || rgbcolor.matches("Hellbraun2")
							|| rgbcolor.matches("Hellbraun3") || rgbcolor.matches("Hellbraun4")
							|| rgbcolor.matches("Hellbraun5") || rgbcolor.matches("Hellbraun6")
							|| rgbcolor.matches("Hellbraun7") || rgbcolor.matches("Hellbraun8")
							|| rgbcolor.matches("Hellbraun9")) {
						usedColors[10] = true;
					}
					if (rgbcolor.matches("Schwarz") || rgbcolor.matches("Schwarz2") || rgbcolor.matches("Schwarz3")
							|| rgbcolor.matches("Schwarz4") || rgbcolor.matches("Schwarz5")) {
						usedColors[11] = true;
					}
					if (rgbcolor.matches("Dunkelgrau") || rgbcolor.matches("Dunkelgrau2")
							|| rgbcolor.matches("Dunkelgrau3") || rgbcolor.matches("Dunkelgrau4")
							|| rgbcolor.matches("Dunkelgrau5") || rgbcolor.matches("Dunkelgrau6")) {
						usedColors[12] = true;
					}
					if (rgbcolor.matches("Dunkelrot") || rgbcolor.matches("Dunkelrot2")
							|| rgbcolor.matches("Dunkelrot3") || rgbcolor.matches("Dunkelrot4")
							|| rgbcolor.matches("Dunkelrot5")) {
						usedColors[13] = true;
					}
					if (rgbcolor.matches("Dunkelorange") || rgbcolor.matches("Dunkelorange2")
							|| rgbcolor.matches("Dunkelorange3") || rgbcolor.matches("Dunkelorange4")
							|| rgbcolor.matches("Dunkelorange5") || rgbcolor.matches("Dunkelorange6")) {
						usedColors[14] = true;
					}
					if (rgbcolor.matches("Dunkelgelb") || rgbcolor.matches("Dunkelgelb2")
							|| rgbcolor.matches("Dunkelgelb3") || rgbcolor.matches("Dunkelgelb4")
							|| rgbcolor.matches("Gold") || rgbcolor.matches("Gold2")) {
						usedColors[15] = true;
					}
					if (rgbcolor.matches("Dunkelgr�n") || rgbcolor.matches("Dunkelgr�n2")
							|| rgbcolor.matches("Dunkelgr�n3") || rgbcolor.matches("Dunkelgr�n4")
							|| rgbcolor.matches("Dunkelgr�n5") || rgbcolor.matches("Dunkelgr�n6")
							|| rgbcolor.matches("Dunkelgr�n7") || rgbcolor.matches("Dunkelgr�n8")
							|| rgbcolor.matches("Dunkelgr�n9") || rgbcolor.matches("Dunkelgr�n10")) {
						usedColors[16] = true;
					}
					if (rgbcolor.matches("Blau") || rgbcolor.matches("Blau2") || rgbcolor.matches("Blau3")
							|| rgbcolor.matches("Blau4") || rgbcolor.matches("Blau5")) {
						usedColors[17] = true;
					}
					if (rgbcolor.matches("Dunkelblau") || rgbcolor.matches("Dunkelblau2")
							|| rgbcolor.matches("Dunkelblau3") || rgbcolor.matches("Dunkelblau4")
							|| rgbcolor.matches("Dunkelblau5")) {
						usedColors[18] = true;
					}
					if (rgbcolor.matches("Dunkellila") || rgbcolor.matches("Dunkellila2")
							|| rgbcolor.matches("Dunkellila3") || rgbcolor.matches("Dunkellila4")) {
						usedColors[19] = true;
					}
					if (rgbcolor.matches("Dunkelpink") || rgbcolor.matches("Dunkelpink2")) {
						usedColors[20] = true;
					}
					if (rgbcolor.matches("Dunkelbraun") || rgbcolor.matches("Dunkelbraun2")
							|| rgbcolor.matches("Dunkelbraun3")) {
						usedColors[21] = true;
					}

					// start

					if ((rgbcolor.matches("Dunkelgrau") || rgbcolor.matches("Dunkelgrau2")
							|| rgbcolor.matches("Hellrot3") || rgbcolor.matches("Hellgelb2")
							|| rgbcolor.matches("Hellgelb3") || rgbcolor.matches("Hellrot4")
							|| rgbcolor.matches("Dunkelrot3") || rgbcolor.matches("Hellorange3")
							|| rgbcolor.matches("Hellorange4") || rgbcolor.matches("Dunkelorange3")
							|| rgbcolor.matches("Dunkelgelb3") || rgbcolor.matches("Dunkelgelb4")
							|| rgbcolor.matches("Hellgr�n6") || rgbcolor.matches("Hellgr�n7")
							|| rgbcolor.matches("Hellgr�n8") || rgbcolor.matches("Hellgr�n9")
							|| rgbcolor.matches("Hellgr�n10") || rgbcolor.matches("Hellgr�n11")
							|| rgbcolor.matches("Dunkelgr�n4") || rgbcolor.matches("Dunkelgr�n5")
							|| rgbcolor.matches("Hellblau") || rgbcolor.matches("Hellblau2")
							|| rgbcolor.matches("Hellpink") || rgbcolor.matches("Hellpink2")
							|| rgbcolor.matches("Hellpink3") || rgbcolor.matches("Hellbraun3")
							|| rgbcolor.matches("Hellbraun4") || rgbcolor.matches("Dunkelbraun3"))) {
						usedColors[1] = true;
					}
					if ((rgbcolor.matches("Dunkelrot") || rgbcolor.matches("Dunkelrot2")
							|| rgbcolor.matches("Hellgelb"))) {
						usedColors[2] = true;
					}
					if ((rgbcolor.matches("Hellrot") || rgbcolor.matches("Hellrot2") || rgbcolor.matches("Dunkelorange")
							|| rgbcolor.matches("Dunkelorange2") || rgbcolor.matches("Dunkelgelb5"))) {
						usedColors[3] = true;
					}
					if ((rgbcolor.matches("Hellorange") || rgbcolor.matches("Hellorange2")
							|| rgbcolor.matches("Dunkelgelb") || rgbcolor.matches("Dunkelgelb2"))) {
						usedColors[4] = true;
					}
					if ((rgbcolor.matches("Dunkelgr�n") || rgbcolor.matches("Dunkelgr�n2")
							|| rgbcolor.matches("Dunkelgr�n3") || rgbcolor.matches("Hellgr�n")
							|| rgbcolor.matches("Hellgr�n2") || rgbcolor.matches("Hellgr�n3")
							|| rgbcolor.matches("Hellgr�n4") || rgbcolor.matches("Hellgr�n5"))) {
						usedColors[5] = true;
					}
					if ((rgbcolor.matches("Blau") || rgbcolor.matches("Blau2"))) {
						usedColors[6] = true;
					}
					if ((rgbcolor.matches("") || rgbcolor.matches(""))) {
						usedColors[7] = true;
					}
					if ((rgbcolor.matches("Dunkelpink3") || rgbcolor.matches("Dunkelpink4")
							|| rgbcolor.matches("Dunkellila"))) {
						usedColors[8] = true;
					}
					if ((rgbcolor.matches("Dunkelpink") || rgbcolor.matches("Dunkelpink2"))) {
						usedColors[9] = true;
					}
					if ((rgbcolor.matches("Dunkelrot4") || rgbcolor.matches("Dunkelrot5")
							|| rgbcolor.matches("Dunkelorange4") || rgbcolor.matches("Gold")
							|| rgbcolor.matches("Gold2") || rgbcolor.matches("Dunkelgr�n6")
							|| rgbcolor.matches("Dunkelgr�n7") || rgbcolor.matches("Dunkelgr�n8")
							|| rgbcolor.matches("Dunkelbraun") || rgbcolor.matches("Dunkelbraun2"))) {
						usedColors[10] = true;
					}
					if ((rgbcolor.matches("Dunkelgrau5") || rgbcolor.matches("Dunkelgrau6")
							|| rgbcolor.matches("Dunkelgr�n7") || rgbcolor.matches("Dunkelgr�n8")
							|| rgbcolor.matches("Dunkelblau3") || rgbcolor.matches("Dunkelblau4")
							|| rgbcolor.matches("Dunkelblau5") || rgbcolor.matches("Dunkellila3")
							|| rgbcolor.matches("Dunkellila4") || rgbcolor.matches("Dunkelbraun4")
							|| rgbcolor.matches("Dunkelbraun5"))) {
						usedColors[11] = true;
					}
					if ((rgbcolor.matches("Hellgrau3") || rgbcolor.matches("Hellgrau4") || rgbcolor.matches("Hellgrau5")
							|| rgbcolor.matches("Schwarz") || rgbcolor.matches("Schwarz2"))) {
						usedColors[12] = true;
					}
					if ((rgbcolor.matches("Hellrot5") || rgbcolor.matches("Hellrot6") || rgbcolor.matches("Hellbraun")
							|| rgbcolor.matches("Hellbraun2"))) {
						usedColors[13] = true;
					}
					if ((rgbcolor.matches("Hellorange5") || rgbcolor.matches("Hellorange6"))) {
						usedColors[14] = true;
					}
					if ((rgbcolor.matches("Hellgelb4") || rgbcolor.matches("Hellgelb5") || rgbcolor.matches("Hellgr�n")
							|| rgbcolor.matches("Hellgr�n2"))) {
						usedColors[15] = true;
					}
					if ((rgbcolor.matches("Hellgr�n12") || rgbcolor.matches("Hellgr�n13")
							|| rgbcolor.matches("Hellgr�n14") || rgbcolor.matches("Hellgr�n15")
							|| rgbcolor.matches("Hellgr�n16"))) {
						usedColors[16] = true;
					}
					if ((rgbcolor.matches("Hellblau3") || rgbcolor.matches("Hellblau4") || rgbcolor.matches("Hellblau5")
							|| rgbcolor.matches("Dunkelblau") || rgbcolor.matches("Dunkelblau2"))) {
						usedColors[17] = true;
					}
					if ((rgbcolor.matches("Blau3") || rgbcolor.matches("Blau4") || rgbcolor.matches("Blau5")
							|| rgbcolor.matches("Mondblau"))) {
						usedColors[18] = true;
					}
					if ((rgbcolor.matches("Helllila3") || rgbcolor.matches("Helllila4"))) {
						usedColors[19] = true;
					}
					if ((rgbcolor.matches("Hellpink4") || rgbcolor.matches("Hellpink5") || rgbcolor.matches("Helllila")
							|| rgbcolor.matches("Helllila2"))) {
						usedColors[20] = true;
					}
					if ((rgbcolor.matches("hellbraun5") || rgbcolor.matches("hellbraun6")
							|| rgbcolor.matches("hellbraun7"))) {
						usedColors[21] = true;
					}

					// end
				}

			}
		}

	}

}