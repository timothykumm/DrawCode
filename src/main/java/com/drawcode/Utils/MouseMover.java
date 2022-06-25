package com.drawcode.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import com.drawcode.Gui.Menu;

public class MouseMover {

	static boolean chooseColor = false;
	static int count = 0;
	public static int startEndX[] = {550, 1320}; 
	public static int startEndY[] = {260, 894};
	
	public static int startX = 0;
	public static int startY = 0;
	
	public static void drawPixel(int x, int y) throws AWTException, InterruptedException {
		if (chooseColor == false) {
			Robot robot = new Robot();
			robot.mouseMove(startX + x, startY + y); // X: 485 - 1300(Links nach rechts) Y: 220-820(Oben nach unten) Mitte:
			
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
			count++;
			
			if(!Menu.fastDraw.isSelected()) {
				robot.delay(1);
			}
			
			if(count > 10 && Menu.fastDraw.isSelected()) {
				robot.delay(5);
				count = 0;
			}
			
		}
	}

	public static void selectColor(int x, int y) throws AWTException, InterruptedException {
		chooseColor = true;
		Robot robot = new Robot();
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		chooseColor = false;
	}

	public static void goStart() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(490, 225);
	}

}
