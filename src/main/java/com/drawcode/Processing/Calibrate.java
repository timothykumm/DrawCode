package com.drawcode.Processing;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.drawcode.Skribblio;
import com.drawcode.Gui.Menu;

public class Calibrate {

	public static String[] Farben = { "Wei�", "Hellgrau", "Rot", "Orange", "Gelb", "Gr�n", "Hellblau", "Mondblau", "Lila",
			"Pink", "Hellbraun", "Schwarz", "Dunkelgrau", "Dunkelrot", "Dunkelorange", "Dunkelgelb", "Dunkelgr�n",
			"Blau", "Dunkelblau", "Dunkellila", "Dunkelpink", "Dunkelbraun" };
	static String[] FarbenTranselated = { "White", "Light Gray", "Red", "Orange", "Yellow", "Green", "Light Blue", "(Moon) Blue", "Purple",
			"Pink", "Light Brown", "Black", "Dark Gray", "Dark Red", "Dark Orange", "Dark Yellow", "Dark Green",
			"Blue", "Dark Blue", "Dark Purple", "Dark Pink", "Dark Brown" };
	
	public static int[] FarbenX = { 0, 577, 602, 627, 655, 678, 706, 736, 760, 786, 814, 550, 575, 601, 628, 655, 681, 708,
			736, 761, 785, 814 };
	public static int[] FarbenY = { 0, 927, 927, 927, 927, 927, 927, 927, 927, 927, 927, 953, 953, 953, 953, 953, 953, 953,
			953, 953, 953, 953 };
	static int[] red = { 255, 193, 239, 255, 255, 0, 0, 35, 163, 211, 160, 0, 76, 116, 194, 232, 0, 0, 14, 85, 167,
			99 };
	static int[] green = { 255, 193, 19, 113, 228, 204, 178, 31, 0, 124, 82, 0, 76, 11, 56, 162, 85, 86, 8, 0, 85, 48 };
	static int[] blue = { 255, 193, 11, 0, 0, 0, 255, 211, 186, 170, 45, 0, 76, 7, 0, 0, 16, 158, 101, 105, 116, 13 };
	public static int[] screenx = {0, 550, 0};
	public static int[] screeny = {0, 260, 0};
	static String[] screenName = {"", "top left", "bottom right"};

	public static boolean isClicked = true;
	public static boolean isClicked2 = true;
	public static int count = 0;
	public static int count2 = 0;
	static String configx = "";
	static String configy = "";
	
	static String configyScreenX = "";
	static String configyScreenY = "";

	public static void start() throws IOException, InterruptedException {

		configx = "";
		configy = "";
		
		configyScreenX = "";
		configyScreenY = "";
		
		if (count < Farben.length) {

			isClicked = false;
			Menu.console.setForeground(returnColor(count));
			Menu.setConsole("Click on Color: " + FarbenTranselated[count]);
		}else if (count2 < screenName.length) {
				isClicked2 = false;
				Menu.setConsole("Click on the " + screenName[count2] + " of the drawing table!");
			}else{
			Menu.console.setForeground(Color.BLACK);
			Menu.setConsole("Skribbl.io Draw Bot by TimmYCode " + Menu.version);
			Menu.setConsole(Menu.console.getText() + "\n" + "Calibrating finished!");

			for (int i = 0; i < Skribblio.xpos.length; i++) {
				configx += Skribblio.xpos[i] + ",";
				configy += Skribblio.ypos[i] + ",";
			}
			
			for (int i = 1; i < screenName.length; i++) {
				configyScreenX += screenx[i] + ",";
				configyScreenY += screeny[i] + ",";
			}		
			
			overwriteConfig();
			Skribblio.loadConfig();
			
			isClicked = true;
			isClicked2 = true;
			count = 0;
			count2 = 0;
		}
	}

	static Color returnColor(int i) {
		if (red[i] == 255 && green[i] == 255 && blue[i] == 255) {
			return Color.BLACK;
		}
		return new Color(red[i], green[i], blue[i]);
	}

	static void overwriteConfig() throws IOException {
		File config = new File(System.getenv("APPDATA") + "/DrawCode/config.json");

		config.delete();

		config.createNewFile();

		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(config));
			output.write(configx + configy + configyScreenX + configyScreenY);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}
}
