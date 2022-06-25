package com.drawcode.Processing;

import java.awt.AWTException;
import java.awt.Color;

import com.drawcode.Gui.Menu;
import com.drawcode.Utils.ColorUtils;
import com.drawcode.Utils.FastRGB;
import com.drawcode.Utils.MouseMover;

public class ScanWrite2 {

	int red = 0;
	int green = 0;
	int blue = 0;
	
	int x, y;
	int width;
	int height;
	int delay = 0;
	int durchgang = 0;
	String nearestColor = "";
	int randomCount = 0;

	void scanandwrite(int delay, double random) throws AWTException, InterruptedException {
		durchgang++;
		ColorUtils color = new ColorUtils();

		FastRGB getPixel = new FastRGB(Menu.selectedImage);

		int[][] pixels = new int[Menu.selectedImage.getWidth()][Menu.selectedImage.getHeight()];

		width = Menu.selectedImage.getWidth();
		height = Menu.selectedImage.getHeight();

		MouseMover.goStart();

		int i = 0;
		int j = 0;

		for (int k = 0; k < Calibrate.Farben.length; k++) {
			if (ScanWrite.cancel == false) {

				MouseMover.selectColor(Calibrate.FarbenX[k], Calibrate.FarbenY[k]);
				i = 0;
				j = 0;

				while (i < width) {
					// this.delay++;

					if (i > width - 4 && j < height - 4) {
						j += 3;
						i = 0;
					}

					if (this.delay > delay) {
						pixels[i][j] = getPixel.getRGB(i, j);

						red = (pixels[i][j] >> 16) & 0xff;
						green = (pixels[i][j] >> 8) & 0xff;
						blue = pixels[i][j] & 0xff;

						String rgbcolor = color.getColorNameFromRgb(red, green, blue);

						if (getPixel.isTransparent(i, j) == false && !rgbcolor.matches("Wei�") && ScanWrite.cancel == false && Math.random() < random) {

										if ((rgbcolor.matches("Dunkelgrau4") || rgbcolor.matches("Dunkelgrau5") || rgbcolor.matches("Dunkelgrau6"))
												&& Calibrate.Farben[k].matches("Schwarz")) {
											drawIt(i, j);
										}else{
											if ((rgbcolor.matches("Dunkelgrau") || rgbcolor.matches("Dunkelgrau2") || rgbcolor.matches("Dunkelgrau3"))
													&& Calibrate.Farben[k].matches("Hellgrau")) {
												drawIt(i, j);
										} else {
											if ((rgbcolor.matches("Hellrot") || rgbcolor.matches("Hellrot2") || rgbcolor.matches("Hellrot3"))
													&& Calibrate.Farben[k].matches("Orange")) {
												drawIt(i, j);
											} else {
												if ((rgbcolor.matches("Hellrot4") || rgbcolor.matches("Hellrot5") || rgbcolor.matches("Hellrot6"))
														&& Calibrate.Farben[k].matches("Dunkelrot")) {
													drawIt(i, j);
											} else {
												if ((rgbcolor.matches("Dunkelrot") || rgbcolor.matches("Dunkelrot2") || rgbcolor.matches("Dunkelrot3"))
														&& Calibrate.Farben[k].matches("Rot")) {
													drawIt(i, j);
											} else {
											}
												if ((rgbcolor.matches("Dunkelrot4") || rgbcolor.matches("Dunkelrot5"))
														&& Calibrate.Farben[k].matches("Schwarz")) {
													drawIt(i, j);	
											} else {
												if ((rgbcolor.matches("Hellorange") || rgbcolor.matches("Hellorange2"))
														&& Calibrate.Farben[k].matches("Rot")) {
													drawIt(i, j);
												} else {
													if ((rgbcolor.matches("Hellorange3") || rgbcolor.matches("Hellorange4"))
															&& Calibrate.Farben[k].matches("Dunkelorange")) {
														drawIt(i, j);
											} else {
												if ((rgbcolor.matches("Dunkelorange3") || rgbcolor.matches("Dunkelorange4") || rgbcolor.matches("Dunkelorange5"))
														&& Calibrate.Farben[k].matches("Orange")) {
													drawIt(i, j);	
												} else {
													if ((rgbcolor.matches("Dunkelorange1") || rgbcolor.matches("Dunkelorange2"))
															&& Calibrate.Farben[k].matches("Orange")) {
														drawIt(i, j);	
											} else {
												if ((rgbcolor.matches("Hellgelb") || rgbcolor.matches("Hellgelb2") || rgbcolor.matches("Hellgelb3"))
														&& Calibrate.Farben[k].matches("Orange")) {
													drawIt(i, j);	
											} else {
												if ((rgbcolor.matches("Hellgelb4") || rgbcolor.matches("Hellgelb5"))
														&& Calibrate.Farben[k].matches("Dunkelgelb")) {
													drawIt(i, j);	
											} else {
											}
												if ((rgbcolor.matches("Dunkelgelb") || rgbcolor.matches("Dunkelgelb2"))
														&& Calibrate.Farben[k].matches("Gelb")) {
													drawIt(i, j);	
												} else {
													if ((rgbcolor.matches("Hellgr�n") || rgbcolor.matches("Hellgr�n2") || rgbcolor.matches("Hellgr�n3") || rgbcolor.matches("Hellgr�n4") || rgbcolor.matches("Hellgr�n5") || rgbcolor.matches("Hellgr�n6"))
															&& Calibrate.Farben[k].matches("Dunkelgelb")) {
														drawIt(i, j);	
													} else {
														if ((rgbcolor.matches("Hellgr�n8") || rgbcolor.matches("Hellgr�n9") || rgbcolor.matches("Hellgr�n10") || rgbcolor.matches("Hellgr�n11") || rgbcolor.matches("Hellgr�n12") || rgbcolor.matches("Hellgr�n13") || rgbcolor.matches("Hellgr�n14"))
																&& Calibrate.Farben[k].matches("Dunkelgr�n")) {
															drawIt(i, j);	
														} else {
													}
														if ((rgbcolor.matches("Dunkelgr�n3") || rgbcolor.matches("Dunkelgr�n4") || rgbcolor.matches("Dunkelgr�n5"))
																&& Calibrate.Farben[k].matches("Dunkelgrau")) {
															drawIt(i, j);	
														} else {
															if ((rgbcolor.matches("Hellblau") || rgbcolor.matches("Hellblau2"))
																	&& Calibrate.Farben[k].matches("Hellgrau")) {
																drawIt(i, j);	
															} else {
																if ((rgbcolor.matches("Hellblau3") || rgbcolor.matches("Hellblau4") || rgbcolor.matches("Hellblau5"))
																		&& Calibrate.Farben[k].matches("Blau")) {
																	drawIt(i, j);	
																} else {
																	if ((rgbcolor.matches("Blau") || rgbcolor.matches("Blau2") || rgbcolor.matches("Blau3"))
																			&& Calibrate.Farben[k].matches("Hellblau")) {
																		drawIt(i, j);	
															} else {
																if ((rgbcolor.matches("Blau4") || rgbcolor.matches("Blau5"))
																		&& (Calibrate.Farben[k].matches("Hellblau") || Calibrate.Farben[k].matches("Dunkelblau"))) {
																	drawIt(i, j);	
																} else {
																	if (rgbcolor.matches("Dunkelblau2")
																			&& Calibrate.Farben[k].matches("Mondblau")) {
																		drawIt(i, j);	
																	} else {
																		if ((rgbcolor.matches("Hellpink") || rgbcolor.matches("Hellpink2"))
																				&& Calibrate.Farben[k].matches("Hellgrau")) {
																			drawIt(i, j);	
																		} else {
																			if ((rgbcolor.matches("Hellbraun") || rgbcolor.matches("Hellbraun2") || rgbcolor.matches("Hellbraun6") || rgbcolor.matches("Hellbraun7") || rgbcolor.matches("Hellbraun8"))
																					&& Calibrate.Farben[k].matches("Dunkelorange")) {
																				drawIt(i, j);
																			} else {
																				if ((rgbcolor.matches("Hellbraun4") || rgbcolor.matches("Hellbraun5"))
																						&& Calibrate.Farben[k].matches("Dunkelbraun")) {
																					drawIt(i, j);
																			} else {
																				if ((rgbcolor.matches("Dunkelbraun2") || rgbcolor.matches("Dunkelbraun3"))
																						&& Calibrate.Farben[k].matches("Schwarz")) {
																					drawIt(i, j);		
																				} else {
																					if (rgbcolor.matches("Dunkelbraun")
																							&& Calibrate.Farben[k].matches("Hellbraun")) {
																						drawIt(i, j);		
																				}else {
																					if ((rgbcolor.matches("Hautfarbe") || rgbcolor.matches("Hautfarbe2") || rgbcolor.matches("Hautfarbe3") || rgbcolor.matches("Hautfarbe4") || rgbcolor.matches("Hautfarbe5") || rgbcolor.matches("Hautfarbe6"))
																							&& Calibrate.Farben[k].matches("Gelb")) {
																						drawIt(i, j);
																					}
																				}
																			}
																		}
																	}
																}
															}
																}
															}
														}
													}
												}
															}
														}
													}
												}
											}
											}
											}
											}
											}
											
											}
											}
										}

							}
						
						this.delay = 0;
					}
					this.delay++;
					i+=3;
				}
			}

		}
	}

	void drawIt(int x, int y)
	  {
	    try
	    {
	      Color myWhite = new Color(255, 255, 255);
	      Menu.selectedImage.setRGB(x, y, myWhite.getRGB());
    
	      MouseMover.drawPixel(x, y);
	    }
	    catch (AWTException|InterruptedException e)
	    {
	      e.printStackTrace();
	    }
	  }
	}

