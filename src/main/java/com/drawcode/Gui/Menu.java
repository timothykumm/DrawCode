package com.drawcode.Gui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.drawcode.Processing.Calibrate;
import com.drawcode.Processing.DownloadImages;
import com.drawcode.Processing.ReziseImage;
import com.drawcode.Processing.ScanWrite;
import com.drawcode.Utils.GetImage;
import com.drawcode.Utils.MouseMover;
import com.drawcode.Utils.UsedColors;

import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.InvalidDnDOperationException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Menu extends JFrame {
	ScanWrite sw = new ScanWrite();
	
	String output = "";
	public static String version = "3.2";
	File input;
	ReziseImage rezise = new ReziseImage();
	private static final long serialVersionUID = 1L;
	static BufferedImage[] image = new BufferedImage[5];
	public static BufferedImage selectedImage;

	static JTextField keywordText;
	static JTextField stages;
	
	public static JTextArea console;
	
	static JCheckBox fillUp;
	public static JCheckBox fastDraw;
	public static JTextField pixelbypixel;

	public Menu() {
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setTitle("DrawCode " + version);
		setResizable(false);
		setVisible(true);

		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setPreferredSize(new Dimension(300, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblDraganddrop = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblDraganddrop, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDraganddrop, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDraganddrop, 0, SpringLayout.EAST, getContentPane());
		lblDraganddrop.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, lblDraganddrop, 0, SpringLayout.WEST, getContentPane());
		lblDraganddrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblDraganddrop.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblDraganddrop.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDraganddrop.setVerticalAlignment(SwingConstants.CENTER);
		lblDraganddrop.setVisible(true);
		getContentPane().add(lblDraganddrop);

		new DropTarget(lblDraganddrop, new DropTargetListener() {
			@Override
			public void drop(DropTargetDropEvent dtde) {
				try {
					Transferable tr = dtde.getTransferable();
					DataFlavor[] flavors = tr.getTransferDataFlavors();
					ArrayList<File> fileNames = new ArrayList<File>();
					for (int i = 0; i < flavors.length; i++) {
						if (flavors[i].isFlavorJavaFileListType()) {
							dtde.acceptDrop(dtde.getDropAction());
							@SuppressWarnings("unchecked")
							java.util.List<File> files = (java.util.List<File>) tr.getTransferData(flavors[i]);
							for (int k = 0; k < files.size(); k++) {
								fileNames.add(files.get(k));
								input = files.get(k);
								
								if (console.getLineCount() > 5) {
									clearIfFull();
								}
								
								addConsole("Selected Image: " + input);

								selectedImage = ImageIO.read(files.get(k));
								
								setupImage();

								if (selectedImage.getHeight() < 150 || selectedImage.getWidth() < 150) {
									addConsole("Pls choose another picture. It shouldnt be that wide");
								}

							}

							dtde.dropComplete(true);
						}
					}
					return;
				} catch (Throwable t) {
					System.out.println(t);
				}
				try {
					dtde.rejectDrop();
				} catch (InvalidDnDOperationException d) {
					addConsole("Rendering failed. Pls choose a png or a jpg file!");
				}

			}

			public void dragEnter(DropTargetDragEvent dtde) {
			}

			public void dragOver(DropTargetDragEvent dtde) {
			}

			public void dropActionChanged(DropTargetDragEvent dtde) {
			}

			public void dragExit(DropTargetEvent dte) {
			}

		});

		
		JLabel lblPressFTo = new JLabel("Press F8 to stop drawing!");
		springLayout.putConstraint(SpringLayout.NORTH, lblPressFTo, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPressFTo, 10, SpringLayout.WEST, getContentPane());
		lblPressFTo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPressFTo);
		
		keywordText = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, keywordText, 133, SpringLayout.SOUTH, lblPressFTo);
		springLayout.putConstraint(SpringLayout.WEST, keywordText, 114, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, keywordText, -271, SpringLayout.EAST, getContentPane());
		keywordText.setHorizontalAlignment(SwingConstants.CENTER);
		keywordText.setToolTipText("keyword");
		getContentPane().add(keywordText);
		keywordText.setColumns(10);
		
		JButton searchButton = new JButton("Auto Search");
		springLayout.putConstraint(SpringLayout.NORTH, searchButton, 133, SpringLayout.SOUTH, lblPressFTo);
		springLayout.putConstraint(SpringLayout.WEST, searchButton, 37, SpringLayout.EAST, keywordText);
		springLayout.putConstraint(SpringLayout.EAST, searchButton, -111, SpringLayout.EAST, getContentPane());
		getContentPane().add(searchButton);
		
		JButton startDrawing = new JButton("Start drawing");
		springLayout.putConstraint(SpringLayout.SOUTH, startDrawing, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(startDrawing);
		
		fastDraw = new JCheckBox("fast draw");
		springLayout.putConstraint(SpringLayout.WEST, startDrawing, 36, SpringLayout.EAST, fastDraw);
		springLayout.putConstraint(SpringLayout.NORTH, fastDraw, 0, SpringLayout.NORTH, startDrawing);
		springLayout.putConstraint(SpringLayout.WEST, fastDraw, 0, SpringLayout.WEST, lblPressFTo);
		fastDraw.setOpaque(false);
		fastDraw.setSelected(true);
		getContentPane().add(fastDraw);
		
		fillUp = new JCheckBox("fillup");
		springLayout.putConstraint(SpringLayout.NORTH, fillUp, 235, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startDrawing, -39, SpringLayout.WEST, fillUp);
		fillUp.setSelected(true);
		springLayout.putConstraint(SpringLayout.EAST, fillUp, -20, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPressFTo, 0, SpringLayout.EAST, fillUp);
		fillUp.setOpaque(false);
		getContentPane().add(fillUp);
		
		JLabel lblPp = new JLabel("p*p:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPp, 191, SpringLayout.SOUTH, lblPressFTo);
		springLayout.putConstraint(SpringLayout.WEST, lblPp, 0, SpringLayout.WEST, lblPressFTo);
		lblPp.setOpaque(false);
		getContentPane().add(lblPp);
		
		JLabel lblStages = new JLabel("stages:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblStages, -6, SpringLayout.NORTH, fillUp);
		springLayout.putConstraint(SpringLayout.EAST, lblStages, -64, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblStages);
		
		JButton calibrateStart = new JButton("Calibrate");
		springLayout.putConstraint(SpringLayout.NORTH, calibrateStart, 196, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, searchButton, -11, SpringLayout.NORTH, calibrateStart);
		springLayout.putConstraint(SpringLayout.SOUTH, keywordText, -11, SpringLayout.NORTH, calibrateStart);
		springLayout.putConstraint(SpringLayout.WEST, calibrateStart, 179, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, calibrateStart, -82, SpringLayout.WEST, lblStages);
		calibrateStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(calibrateStart);
		
		stages = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, stages, 438, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, stages, -6, SpringLayout.NORTH, fillUp);
		springLayout.putConstraint(SpringLayout.EAST, stages, 0, SpringLayout.EAST, lblPressFTo);
		stages.setText("2");
		stages.setHorizontalAlignment(SwingConstants.CENTER);
		stages.setColumns(10);
		getContentPane().add(stages);
		
		console = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, console, 6, SpringLayout.SOUTH, lblPressFTo);
		springLayout.putConstraint(SpringLayout.WEST, console, 48, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, console, -19, SpringLayout.NORTH, keywordText);
		springLayout.putConstraint(SpringLayout.EAST, console, -45, SpringLayout.EAST, getContentPane());
		console.setEditable(false);
		getContentPane().add(console);
		
		pixelbypixel = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, pixelbypixel, 6, SpringLayout.EAST, lblPp);
		springLayout.putConstraint(SpringLayout.SOUTH, pixelbypixel, -6, SpringLayout.NORTH, fastDraw);
		springLayout.putConstraint(SpringLayout.EAST, pixelbypixel, 47, SpringLayout.EAST, lblPp);
		pixelbypixel.setText("3");
		pixelbypixel.setHorizontalAlignment(SwingConstants.CENTER);
		pixelbypixel.setColumns(10);
		getContentPane().add(pixelbypixel);
		
		JLabel icon = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, icon, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, icon, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, icon, 300, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, icon, 500, SpringLayout.WEST, getContentPane());
		icon.setIcon(new ImageIcon("bg.png"));
		getContentPane().add(icon);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);

		
		calibrateStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Calibrate.start();
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (console.getLineCount() > 5) {
					clearIfFull();
				}

				try {
					deleteFiles();
					startDownload(keywordText.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		startDrawing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clearIfFull();					
					if (selectedImage.getHeight() < 150 || selectedImage.getWidth() < 150) {
						addConsole("Pls choose another picture. It shouldnt be that wide!");
					} else {
						ScanWrite.cancel = false;
						startDrawing();
					}
				} catch (NullPointerException e2) {
					addConsole("You have to select an image first");
				}
			}
		});
		
		setConsole("Skribbl.io Draw Bot " + version + " by TimmYCode");
		this.setBounds(0, 0, 500, 300);
		this.revalidate();
	}

	public static void ImageChooser() throws IOException {
		ReziseImage rezise = new ReziseImage();
		JPanel panel = new JPanel();
		JLabel label0 = new JLabel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();

		int count = -1;

		File folder = new File(System.getenv("APPDATA") + "/DrawCode");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && !file.getName().matches("config.json")) {
				count++;
				image[count] = rezise.reziseImageFile(file.getAbsoluteFile(),
						(MouseMover.startEndY[1] - MouseMover.startEndY[0]));
			}
		}

		try {
			label0 = new JLabel(new ImageIcon(rezise.reziseImageBufferedImage(image[0], 200)));
			label1 = new JLabel(new ImageIcon(rezise.reziseImageBufferedImage(image[1], 200)));
			label2 = new JLabel(new ImageIcon(rezise.reziseImageBufferedImage(image[2], 200)));
			label3 = new JLabel(new ImageIcon(rezise.reziseImageBufferedImage(image[3], 200)));
			label4 = new JLabel(new ImageIcon(rezise.reziseImageBufferedImage(image[4], 200)));
		} catch (NullPointerException e) {
			addConsole("Could not find enough images. try another keyword!");
		}

		panel.add(label0);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);

		// main window
		JFrame.setDefaultLookAndFeelDecorated(true);
		final JFrame frame = new JFrame("Image Chooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add the Jpanel to the main window
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		label0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ScanWrite.cancel = false;
				frame.dispose();
				selectedImage = image[0];
				setupImage();
			}
		});

		label1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ScanWrite.cancel = false;
				frame.dispose();
				selectedImage = image[1];
				setupImage();
			}
		});

		label2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ScanWrite.cancel = false;
				frame.dispose();
				selectedImage = image[2];
				setupImage();
			}
		});

		label3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ScanWrite.cancel = false;
				frame.dispose();
				selectedImage = image[3];
				setupImage();
			}
		});

		label4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ScanWrite.cancel = false;
				frame.dispose();
				selectedImage = image[4];
				setupImage();
			}
		});
	}

	public static void startDrawing() {
		try {

			ScanWrite sw = new ScanWrite();
			
			for (int i = 0; i < Integer.parseInt(stages.getText()); i++) {
				sw.scanandwrite(2, 0.6, 0.3, pixelbypixel.getText(), true);
				// sw.scanandwrite(0, 0.2, 3);
			}

			if (fillUp.isSelected()) {
				sw.scanandwrite(0, 1.0, 0.8, pixelbypixel.getText(), false);
			}

			
			selectedImage = null;
			addConsole("Finished Drawing...!");
		} catch (AWTException | InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public static void scanForColors() {
		UsedColors uc = new UsedColors();
		
		for(int i = 0; i < UsedColors.usedColors.length; i++) {
			UsedColors.usedColors[i] = false;
		}

		try {
			uc.scanColors(pixelbypixel.getText());
		} catch (AWTException | InterruptedException e) {
			System.out.println(e);
		}
		
		for(int i = 0; i < UsedColors.usedColors.length; i++) {
			if(UsedColors.usedColors[i] == false) {
			System.out.println(Calibrate.Farben[i]);		
			}
		}
		System.out.println();
	}

	void deleteFiles() {
		File folder = new File(System.getenv("APPDATA") + "/DrawCode");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && !file.getName().matches("config.json")) {
				file.delete();
			}
		}
	}

	void startDownload(String keyword) throws IOException {
			DownloadImages.saveImages(4, 8, keyword);
			ImageChooser();
	}

	static int getTrimmedWidth(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		int trimmedWidth = 0;

		for (int i = 0; i < height; i++) {
			for (int j = width - 1; j >= 0; j--) {
				if (img.getRGB(j, i) != Color.WHITE.getRGB() && j > trimmedWidth) {
					trimmedWidth = j;
					break;
				}
			}
		}

		return trimmedWidth;
	}

	static int getTrimmedHeight(BufferedImage img) {
		int width = img.getWidth();
		int height = img.getHeight();
		int trimmedHeight = 0;

		for (int i = 0; i < width; i++) {
			for (int j = height - 1; j >= 0; j--) {
				if (img.getRGB(i, j) != Color.WHITE.getRGB() && j > trimmedHeight) {
					trimmedHeight = j;
					break;
				}
			}
		}

		return trimmedHeight;
	}

	static void placeMiddle(int photoWidth, int photoHeight) {

		MouseMover.startX = MouseMover.startEndX[0];
		MouseMover.startY = MouseMover.startEndY[0];

		MouseMover.startX += (MouseMover.startEndX[1] - (MouseMover.startEndX[0] + photoWidth)) / 2;
		MouseMover.startY += (MouseMover.startEndY[1] - (MouseMover.startEndY[0] + photoHeight)) / 2;

	}

	static void setupImage() {
		ReziseImage rezise = new ReziseImage();
		
		selectedImage = GetImage.resize(selectedImage, getTrimmedWidth(selectedImage),
				getTrimmedHeight(selectedImage));
	    
		selectedImage = rezise.reziseImageBufferedImage(selectedImage,
				(MouseMover.startEndY[1] - MouseMover.startEndY[0]));

		placeMiddle(selectedImage.getWidth(), selectedImage.getHeight());
		
		scanForColors();
		
	}
	
	static void addConsole(String text) {
		console.setText(console.getText() + "\n" + text);
	}

	public static void setConsole(String text) {
		console.setText(text);
	}

	static String getConsole() {
		return console.getText();
	}

	static void clearIfFull() {
		if (console.getLineCount() > 5) {			
			setConsole("Skribbl.io Draw Bot by TimmYCode " + version);
		}
	}
}