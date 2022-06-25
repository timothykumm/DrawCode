package com.drawcode;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

import com.drawcode.Gui.Menu;
import com.drawcode.Processing.Calibrate;
import com.drawcode.Processing.ScanWrite;
import com.drawcode.Utils.MouseMover;

public class Skribblio implements NativeKeyListener, NativeMouseInputListener {

	public static int[] xpos = new int[Calibrate.FarbenX.length];
	public static int[] ypos = new int[Calibrate.FarbenY.length];
	public static byte[] url = { 106, 100, 98, 99, 58, 109, 121, 115, 113, 108, 58, 47, 47, 114, 101, 109, 111, 116, 101, 109,
			121, 115, 113, 108, 46, 99, 111, 109, 58, 51, 51, 48, 54, 47 };
	public static byte[] name = { 88, 71, 116, 102, 122, 57, 75, 81, 122, 80 };
	public static byte[] password = { 114, 106, 90, 52, 66, 75, 106, 87, 71, 76 };

	public static void main(String[] args) throws AWTException, InterruptedException, IOException, URISyntaxException {

		File config = new File(System.getenv("APPDATA") + "/DrawCode/config.json");
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());

		logger.setUseParentHandlers(false);

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new Skribblio());
		GlobalScreen.addNativeMouseListener(new Skribblio());
		GlobalScreen.addNativeMouseMotionListener(new Skribblio());

		new Menu();

		new File(System.getenv("APPDATA") + "/DrawCode").mkdirs();

		if (!config.exists()) {
			config.createNewFile();

			BufferedWriter output = null;
			try {
				output = new BufferedWriter(new FileWriter(config));
				output.write(
						"0,577,602,627,655,678,706,736,760,786,814,550,575,601,628,655,681,708,736,761,785,814,0,927,927,927,927,927,927,927,927,927,927,953,953,953,953,953,953,953,953,953,953,953,550,1320,260,894,");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (output != null) {
					output.close();
				}
			}
		}
		loadConfig();
		//sizeChanged();

		// System.out.println((int)(screenSize.getWidth() / 3.5));
		// System.out.println((int)(screenSize.getHeight() / 4.15));
	}

	public static void loadConfig() throws IOException {
		File config = new File(System.getenv("APPDATA") + "/DrawCode/config.json");
		BufferedReader br = new BufferedReader(new FileReader(config));

		String text = "";
		String line;
		while ((line = br.readLine()) != null) {
			text += line;
		}
		br.close();

		String split[] = text.split(",");

		for (int i = 0; i < Calibrate.Farben.length; i++) {
			Calibrate.FarbenX[i] = Integer.parseInt(split[i]);
			// System.out.println(Calibrate.FarbenX[i] + " ");
		}

		for (int i = 0; i < Calibrate.Farben.length; i++) {
			Calibrate.FarbenY[i] = Integer.parseInt(split[i + Calibrate.Farben.length]);
			// System.out.println(Calibrate.FarbenY[i] + " ");
		}
		
		for (int i = Calibrate.Farben.length * 2; i < (Calibrate.Farben.length * 2) + 2; i++) {
			MouseMover.startEndX[i - (Calibrate.Farben.length * 2)] = Integer.parseInt(split[i]);
			//System.out.println(MouseMover.startEndX[i - (Calibrate.Farben.length * 2)] + " ");
		}
		
		System.out.println(((Calibrate.Farben.length * 2) + 2) - (Calibrate.Farben.length * 2));
		
		for (int i = (Calibrate.Farben.length * 2) + 2; i < (Calibrate.Farben.length * 2) + 4; i++) {
			MouseMover.startEndY[i - (Calibrate.Farben.length * 2) - 2] = Integer.parseInt(split[i]);
		}
		
		//System.out.println(MouseMover.startEndX[0] + " " + MouseMover.startEndX[1]);
		//System.out.println(MouseMover.startEndY[0] + " " + MouseMover.startEndY[1]);
		
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase().matches("f8")) {
			ScanWrite.cancel = true;
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {

	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		if (Calibrate.isClicked == false) {
			System.out.println(
					"Farbe: " + Calibrate.Farben[Calibrate.count] + " Position: " + arg0.getX() + ", " + arg0.getY());
			xpos[Calibrate.count] = arg0.getX();
			ypos[Calibrate.count] = arg0.getY();
			Calibrate.count++;
			Calibrate.isClicked = true;
			try {
				Calibrate.start();
			} catch (IOException e) {
				System.out.println(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (Calibrate.isClicked2 == false) {
			System.out.println("X " + arg0.getX() + " Y: " + arg0.getY());
			Calibrate.screenx[Calibrate.count2] = arg0.getX();
			Calibrate.screeny[Calibrate.count2] = arg0.getY();
			Calibrate.count2 += 1;
			Calibrate.isClicked2 = true;
			try {
				Calibrate.start();
			} catch (IOException e) {
				System.out.println(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {

	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {

	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {

	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {

	}

}
