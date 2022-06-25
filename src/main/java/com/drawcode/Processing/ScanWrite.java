package com.drawcode.Processing;

import java.awt.AWTException;
import java.awt.Color;

import com.drawcode.Gui.Menu;
import com.drawcode.Utils.ColorUtils;
import com.drawcode.Utils.FastRGB;
import com.drawcode.Utils.MouseMover;
import com.drawcode.Utils.UsedColors;

public class ScanWrite {

	int red = 0;
	int green = 0;
	int blue = 0;

	int x, y;
	int width;
	int height;
	int delay = 0;
	String nearestColor = "";
	public static boolean cancel = true;
	String rgbcolor = "";
	static double randomNumb = 1.0;

	int goback = 0;

	public void scanandwrite(int delay, double random, double random2, String plusxy, boolean phase2)
			throws AWTException, InterruptedException {

		ColorUtils color = new ColorUtils();
		FastRGB getPixel = new FastRGB(Menu.selectedImage);
		int[][] pixels = new int[Menu.selectedImage.getWidth()][Menu.selectedImage.getHeight()];

		width = Menu.selectedImage.getWidth();
		height = Menu.selectedImage.getHeight();
		randomNumb = random;

		MouseMover.goStart();

		int i = 0;
		int j = 0;

		for (int k = 1; k < Calibrate.Farben.length; k++) {

			/*
			 * if (random != 1.0) { if (goback == 0) { goback++;
			 * 
			 * } else { if (goback == 1) { k--; goback = 0;
			 * 
			 * } } }
			 */

			if (UsedColors.usedColors[k] == false) {
				System.out.println(Calibrate.Farben[k]);
				// k++;
				continue;
			}

			if (cancel == false) {

				MouseMover.selectColor(Calibrate.FarbenX[k], Calibrate.FarbenY[k]);

				i = 0;
				j = 0;

				while (i < width) {

					if (i > width - (Integer.parseInt(plusxy) + 1) && j < height - (Integer.parseInt(plusxy) + 1)) {
						j += Integer.parseInt(plusxy);
						i = 0;
					}

					if (Math.random() < random && this.delay > delay && getPixel.isTransparent(i, j) == false) {

						pixels[i][j] = getPixel.getRGB(i, j);

						red = (pixels[i][j] >> 16) & 0xff;
						green = (pixels[i][j] >> 8) & 0xff;
						blue = pixels[i][j] & 0xff;

						rgbcolor = color.getColorNameFromRgb(red, green, blue);
						
						if ((!(rgbcolor.matches("Wei�") || rgbcolor.matches("Wei�2"))) && ScanWrite.cancel == false) {

							if ((rgbcolor.matches("Dunkelgrau") || rgbcolor.matches("Dunkelgrau2")
									|| rgbcolor.matches("Dunkelgrau3") || rgbcolor.matches("Dunkelgrau4")
									|| rgbcolor.matches("Dunkelgrau5") || rgbcolor.matches("Dunkelgrau6"))
									&& Calibrate.Farben[k].matches("Dunkelgrau")) {
								drawIt(i, j);
							} else {
								if ((rgbcolor.matches("Hellgrau") || rgbcolor.matches("Hellgrau2")
										|| rgbcolor.matches("Hellgrau3") || rgbcolor.matches("Hellgrau4")
										|| rgbcolor.matches("Hellgrau5")) && Calibrate.Farben[k].matches("Hellgrau")
										&& Math.random() < 0.8) {
									drawIt(i, j);
								} else {
									if ((rgbcolor.matches("Hellrot") || rgbcolor.matches("Hellrot2")
											|| rgbcolor.matches("Hellrot3") || rgbcolor.matches("Hellrot4")
											|| rgbcolor.matches("Hellrot5") || rgbcolor.matches("Hellrot6"))
											&& Calibrate.Farben[k].matches("Rot")) {
										drawIt(i, j);
									} else {
										if ((rgbcolor.matches("Dunkelrot") || rgbcolor.matches("Dunkelrot2")
												|| rgbcolor.matches("Dunkelrot3") || rgbcolor.matches("Dunkelrot4")
												|| rgbcolor.matches("Dunkelrot5"))
												&& Calibrate.Farben[k].matches("Dunkelrot")) {
											drawIt(i, j);
										} else {
											if ((rgbcolor.matches("Hellorange") || rgbcolor.matches("Hellorange2")
													|| rgbcolor.matches("Hellorange3")
													|| rgbcolor.matches("Hellorange4")
													|| rgbcolor.matches("Hellorange5")
													|| rgbcolor.matches("Hellorange6"))
													&& Calibrate.Farben[k].matches("Orange")) {
												drawIt(i, j);
											} else {
												if ((rgbcolor.matches("Dunkelorange")
														|| rgbcolor.matches("Dunkelorange2")
														|| rgbcolor.matches("Dunkelorange3")
														|| rgbcolor.matches("Dunkelorange4"))
														&& Calibrate.Farben[k].matches("Dunkelorange")) {
													drawIt(i, j);
												} else {
													if ((rgbcolor.matches("Hellgelb") || rgbcolor.matches("Hellgelb2")
															|| rgbcolor.matches("Hellgelb3")
															|| rgbcolor.matches("Hellgelb4")
															|| rgbcolor.matches("Hellgelb5"))
															&& Calibrate.Farben[k].matches("Gelb")) {
														drawIt(i, j);
													} else {
														if ((rgbcolor.matches("Dunkelgelb")
																|| rgbcolor.matches("Dunkelgelb2")
																|| rgbcolor.matches("Dunkelgelb3")
																|| rgbcolor.matches("Dunkelgelb4")
																|| rgbcolor.matches("Dunkelgelb5")
																|| rgbcolor.matches("Gold")
																|| rgbcolor.matches("Gold2"))
																&& Calibrate.Farben[k].matches("Dunkelgelb")) {
															drawIt(i, j);
														} else {
															if ((rgbcolor.matches("Hellgr�n")
																	|| rgbcolor.matches("Hellgr�n2")
																	|| rgbcolor.matches("Hellgr�n3")
																	|| rgbcolor.matches("Hellgr�n4")
																	|| rgbcolor.matches("Hellgr�n5")
																	|| rgbcolor.matches("Hellgr�n6")
																	|| rgbcolor.matches("Hellgr�n7")
																	|| rgbcolor.matches("Hellgr�n8")
																	|| rgbcolor.matches("Hellgr�n9")
																	|| rgbcolor.matches("Hellgr�n10")
																	|| rgbcolor.matches("Hellgr�n11")
																	|| rgbcolor.matches("Hellgr�n12")
																	|| rgbcolor.matches("Hellgr�n13")
																	|| rgbcolor.matches("Hellgr�n14")
																	|| rgbcolor.matches("Hellgr�n15")
																	|| rgbcolor.matches("Hellgr�n16"))
																	&& Calibrate.Farben[k].matches("Gr�n")) {
																drawIt(i, j);
															} else {
																if ((rgbcolor.matches("Dunkelgr�n")
																		|| rgbcolor.matches("Dunkelgr�n2")
																		|| rgbcolor.matches("Dunkelgr�n3")
																		|| rgbcolor.matches("Dunkelgr�n4")
																		|| rgbcolor.matches("Dunkelgr�n5")
																		|| rgbcolor.matches("Dunkelgr�n6")
																		|| rgbcolor.matches("Dunkelgr�n7")
																		|| rgbcolor.matches("Dunkelgr�n8"))
																		&& Calibrate.Farben[k].matches("Dunkelgr�n")) {
																	drawIt(i, j);
																} else {
																	if ((rgbcolor.matches("Hellblau")
																			|| rgbcolor.matches("Hellblau2")
																			|| rgbcolor.matches("Hellblau3")
																			|| rgbcolor.matches("Hellblau4")
																			|| rgbcolor.matches("Hellblau5")
																			|| rgbcolor.matches("Blauwei�"))
																			&& Calibrate.Farben[k]
																					.matches("Hellblau")) {
																		drawIt(i, j);
																	} else {
																		if ((rgbcolor.matches("Blau")
																				|| rgbcolor.matches("Blau2")
																				|| rgbcolor.matches("Blau3")
																				|| rgbcolor.matches("Blau4")
																				|| rgbcolor.matches("Blau5mmy"))
																				&& Calibrate.Farben[k]
																						.matches("Blau")) {
																			drawIt(i, j);
																		} else {
																			if (rgbcolor.matches("Mondblau")
																					&& Calibrate.Farben[k]
																							.matches("Mondblau")) {
																				drawIt(i, j);
																			} else {
																				if ((rgbcolor.matches("Dunkelblau")
																						|| rgbcolor
																								.matches("Dunkelblau2")
																						|| rgbcolor
																								.matches("Dunkelblau3")
																						|| rgbcolor
																								.matches("Dunkelblau4")
																						|| rgbcolor
																								.matches("Dunkelblau5"))
																						&& Calibrate.Farben[k].matches(
																								"Dunkelblau")) {
																					drawIt(i, j);
																				} else {
																					if ((rgbcolor.matches("Hellpink")
																							|| rgbcolor.matches(
																									"Hellpink2")
																							|| rgbcolor.matches(
																									"Hellpink3")
																							|| rgbcolor.matches(
																									"Hellpink4")
																							|| rgbcolor.matches(
																									"Hellpink5"))
																							&& Calibrate.Farben[k]
																									.matches("Pink")) {
																						drawIt(i, j);
																					} else {
																						if ((rgbcolor
																								.matches("Dunkelpink")
																								|| rgbcolor.matches(
																										"Dunkelpink2")
																								|| rgbcolor.matches(
																										"Dunkelpink3")
																								|| rgbcolor.matches(
																										"Dunkelpink4"))
																								&& Calibrate.Farben[k]
																										.matches(
																												"Dunkelpink")) {
																							drawIt(i, j);
																						} else {
																							if ((rgbcolor
																									.matches("Helllila")
																									|| rgbcolor.matches(
																											"Helllila2")
																									|| rgbcolor.matches(
																											"Helllila3")
																									|| rgbcolor.matches(
																											"Helllila4"))
																									&& Calibrate.Farben[k]
																											.matches(
																													"Lila")) {
																								drawIt(i, j);
																							} else {
																								if ((rgbcolor.matches(
																										"Dunkellila")
																										|| rgbcolor
																												.matches(
																														"Dunkellila2")
																										|| rgbcolor
																												.matches(
																														"Dunkellila3")
																										|| rgbcolor
																												.matches(
																														"Dunkellila4"))
																										&& Calibrate.Farben[k]
																												.matches(
																														"Dunkellila")) {
																									drawIt(i, j);
																								} else {
																									if ((rgbcolor
																											.matches(
																													"Dunkelbraun")
																											|| rgbcolor
																													.matches(
																															"Dunkelbraun2")
																											|| rgbcolor
																													.matches(
																															"Dunkelbraun3")
																											|| rgbcolor
																													.matches(
																															"Dunkelbraun4")
																											|| rgbcolor
																													.matches(
																															"Dunkelbraun5"))
																											&& Calibrate.Farben[k]
																													.matches(
																															"Dunkelbraun")) {
																										drawIt(i, j);
																									} else {
																										if ((rgbcolor
																												.matches(
																														"Hellbraun")
																												|| rgbcolor
																														.matches(
																																"Hellbraun2")
																												|| rgbcolor
																														.matches(
																																"Hellbraun3")
																												|| rgbcolor
																														.matches(
																																"Hellbraun4")
																												|| rgbcolor
																														.matches(
																																"Hellbraun5")
																												|| rgbcolor
																														.matches(
																																"Hellbraun6")
																												|| rgbcolor
																														.matches(
																																"Hellbraun7"))
																												&& Calibrate.Farben[k]
																														.matches(
																																"Hellbraun")) {
																											drawIt(i,
																													j);
																										} else {
																											if ((rgbcolor
																													.matches(
																															"Schwarz")
																													|| rgbcolor
																															.matches(
																																	"Schwarz2")
																													|| rgbcolor
																															.matches(
																																	"Schwarz3")
																													|| rgbcolor
																															.matches(
																																	"Schwarz4"))
																													&& Calibrate.Farben[k]
																															.matches(
																																	"Schwarz")) {
																												drawIt(i,
																														j);

																											} else {
																												if ((rgbcolor
																														.matches(
																																"Hautfarbe")
																														|| rgbcolor
																																.matches(
																																		"Hautfarbe2")
																														|| rgbcolor
																																.matches(
																																		"Hautfarbe3")
																														|| rgbcolor
																																.matches(
																																		"Hautfarbe4")
																														|| rgbcolor
																																.matches(
																																		"Hautfarbe5")
																														|| rgbcolor
																																.matches(
																																		"Hautfarbe6"))
																														&& Calibrate.Farben[k]
																																.matches(
																																		"Pink")) {
																													drawIt(i,
																															j);
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

						if (getPixel.isTransparent(i, j) == false && !rgbcolor.matches("Wei�")
								&& ScanWrite.cancel == false && Math.random() < random2 && phase2 == true) {

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
									|| rgbcolor.matches("Hellbraun4")
									|| rgbcolor.matches("Dunkelbraun3") && Math.random() < 0.4)
									&& Calibrate.Farben[k].matches("Hellgrau")) {
								drawIt(i, j);
							} else {
								if ((rgbcolor.matches("Dunkelrot") || rgbcolor.matches("Dunkelrot2")
										|| rgbcolor.matches("Hellgelb")) && Calibrate.Farben[k].matches("Rot")) {
									drawIt(i, j);
								} else {
									if ((rgbcolor.matches("Hellrot") || rgbcolor.matches("Hellrot2")
											|| rgbcolor.matches("Dunkelorange") || rgbcolor.matches("Dunkelorange2")
											|| rgbcolor.matches("Dunkelgelb5"))
											&& Calibrate.Farben[k].matches("Orange")) {
										drawIt(i, j);
									} else {
										if ((rgbcolor.matches("Hellorange") || rgbcolor.matches("Hellorange2")
												|| rgbcolor.matches("Dunkelgelb") || rgbcolor.matches("Dunkelgelb2")
												|| rgbcolor.matches("Hellgr�n") || rgbcolor.matches("Hellgr�n2")
												|| rgbcolor.matches("Hellgr�n3") || rgbcolor.matches("Hellgr�n4")
												|| rgbcolor.matches("Hellgr�n5"))
												&& Calibrate.Farben[k].matches("Gelb")) {
											drawIt(i, j);
										} else {
											if ((rgbcolor.matches("Dunkelgr�n") || rgbcolor.matches("Dunkelgr�n2")
													|| rgbcolor.matches("Dunkelgr�n3"))
													&& Calibrate.Farben[k].matches("Gr�n")) {
												drawIt(i, j);
											} else {
												if ((rgbcolor.matches("Blau") || rgbcolor.matches("Blau2"))
														&& Calibrate.Farben[k].matches("Hellblau")) {
													drawIt(i, j);
												} else {
													if ((rgbcolor.matches("") || rgbcolor.matches(""))
															&& Calibrate.Farben[k].matches("Mondblau")) {
														drawIt(i, j);
													} else {
														if ((rgbcolor.matches("Dunkelpink3")
																|| rgbcolor.matches("Dunkelpink4")
																|| rgbcolor.matches("Dunkellila"))
																&& Calibrate.Farben[k].matches("Lila")) {
															drawIt(i, j);
														} else {
															if ((rgbcolor.matches("Dunkelpink")
																	|| rgbcolor.matches("Dunkelpink2"))
																	&& Calibrate.Farben[k].matches("Pink")) {
																drawIt(i, j);
															} else {
																if ((rgbcolor.matches("Dunkelrot4")
																		|| rgbcolor.matches("Dunkelrot5")
																		|| rgbcolor.matches("Dunkelorange4")
																		|| rgbcolor.matches("Gold")
																		|| rgbcolor.matches("Gold2")
																		|| rgbcolor.matches("Dunkelgr�n6")
																		|| rgbcolor.matches("Dunkelgr�n7")
																		|| rgbcolor.matches("Dunkelgr�n8")
																		|| rgbcolor.matches("Dunkelbraun")
																		|| rgbcolor.matches("Dunkelbraun2")
																				&& Math.random() < 0.5)
																		&& Calibrate.Farben[k].matches("Hellbraun")) {
																	drawIt(i, j);
																} else {
																	if ((rgbcolor.matches("Dunkelgrau5")
																			|| rgbcolor.matches("Dunkelgrau6")
																			|| rgbcolor.matches("Dunkelgr�n7")
																			|| rgbcolor.matches("Dunkelgr�n8")
																			|| rgbcolor.matches("Dunkelblau3")
																			|| rgbcolor.matches("Dunkelblau4")
																			|| rgbcolor.matches("Dunkelblau5")
																			|| rgbcolor.matches("Dunkellila3")
																			|| rgbcolor.matches("Dunkellila4")
																			|| rgbcolor.matches("Dunkelbraun4")
																			|| rgbcolor.matches("Dunkelbraun5"))
																			&& Calibrate.Farben[k].matches("Schwarz")) {
																		drawIt(i, j);
																	} else {
																		if ((rgbcolor.matches("Hellgrau3")
																				|| rgbcolor.matches("Hellgrau4")
																				|| rgbcolor.matches("Hellgrau5")
																				|| rgbcolor.matches("Schwarz")
																				|| rgbcolor.matches("Schwarz2"))
																				&& Calibrate.Farben[k]
																						.matches("Dunkelgrau")) {
																			drawIt(i, j);
																		} else {
																			if ((rgbcolor.matches("Hellrot5")
																					|| rgbcolor.matches("Hellrot6")
																					|| rgbcolor.matches("Hellbraun")
																					|| rgbcolor.matches("Hellbraun2"))
																					&& Calibrate.Farben[k]
																							.matches("Dunkelrot")) {
																				drawIt(i, j);
																			} else {
																				if ((rgbcolor.matches("Hellorange5")
																						|| rgbcolor
																								.matches("Hellorange6"))
																						&& Calibrate.Farben[k].matches(
																								"Dunkelorange")) {
																					drawIt(i, j);
																				} else {
																					if ((rgbcolor.matches("Hellgelb4")
																							|| rgbcolor.matches(
																									"Hellgelb5"))
																							&& Calibrate.Farben[k]
																									.matches(
																											"Dunkelgelb")) {
																						drawIt(i, j);
																					} else {
																						if ((rgbcolor
																								.matches("Hellgr�n12")
																								|| rgbcolor.matches(
																										"Hellgr�n13")
																								|| rgbcolor.matches(
																										"Hellgr�n14")
																								|| rgbcolor.matches(
																										"Hellgr�n15")
																								|| rgbcolor.matches(
																										"Hellgr�n16"))
																								&& Calibrate.Farben[k]
																										.matches(
																												"Dunkelgr�n")) {
																							drawIt(i, j);
																						} else {
																							if ((rgbcolor.matches(
																									"Hellblau3")
																									|| rgbcolor.matches(
																											"Hellblau4")
																									|| rgbcolor.matches(
																											"Hellblau5")
																									|| rgbcolor.matches(
																											"Dunkelblau")
																									|| rgbcolor.matches(
																											"Dunkelblau2"))
																									&& Calibrate.Farben[k]
																											.matches(
																													"Blau")) {
																								drawIt(i, j);
																							} else {
																								if ((rgbcolor.matches(
																										"Blau3")
																										|| rgbcolor
																												.matches(
																														"Blau4")
																										|| rgbcolor
																												.matches(
																														"Blau5")
																										|| rgbcolor
																												.matches(
																														"Mondblau"))
																										&& Calibrate.Farben[k]
																												.matches(
																														"Dunkelblau")) {
																									drawIt(i, j);
																								} else {
																									if ((rgbcolor
																											.matches(
																													"Helllila3")
																											|| rgbcolor
																													.matches(
																															"Helllila4"))
																											&& Calibrate.Farben[k]
																													.matches(
																															"Dunkellila")) {
																										drawIt(i, j);
																									} else {
																										if ((rgbcolor
																												.matches(
																														"Hellpink4")
																												|| rgbcolor
																														.matches(
																																"Hellpink5")
																												|| rgbcolor
																														.matches(
																																"Helllila")
																												|| rgbcolor
																														.matches(
																																"Helllila2"))
																												&& Calibrate.Farben[k]
																														.matches(
																																"Dunkelpink")) {
																											drawIt(i,
																													j);
																										} else {
																											if ((rgbcolor
																													.matches(
																															"hellbraun5")
																													|| rgbcolor
																															.matches(
																																	"hellbraun6")
																													|| rgbcolor
																															.matches(
																																	"hellbraun7"))
																													&& Calibrate.Farben[k]
																															.matches(
																																	"Dunkelbraun")) {
																												drawIt(i,
																														j);
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
					i += Integer.parseInt(plusxy);
				}
			}

		}

	}

	void drawIt(int x, int y) {
		try {
			Menu.selectedImage.setRGB(x, y, Color.WHITE.getRGB());
			MouseMover.drawPixel(x, y);
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
