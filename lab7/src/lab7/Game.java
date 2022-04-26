package lab7;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Game extends JPanel {
	private BufferedImage image;

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int h;
	private int w;
	private int[][] arr;
	private int numberLvl = 1;

	public Game() {
		newLvl();
		try {
			image = ImageIO.read(new File("C:\\Users\\vovaf\\Desktop\\╦ря°ют\\JAVA\\Z.png"));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	public void newLvl() {
		String LVL = "C:\\Users\\vovaf\\Desktop\\╦ря°ют\\JAVA\\";
		LVL += numberLvl + ".txt";
		try {
			Scanner sc = new Scanner(new File(LVL));
			h = sc.nextInt();
			w = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			arr = new int[h][w];

			for (int j = 0; j < h; j++) {
				for (int i = 0; i < w; i++) {
					arr[j][i] = sc.nextInt();
				}
			}

			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	private void colorGame(Graphics g) {
		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				switch (arr[j][i]) {
				case 0:
					g.setColor(new Color(255, 255, 255));
					break;
				case 1:
					g.setColor(new Color(0, 0, 0));
					break;
				case 2:
					g.setColor(new Color(255, 0, 0));
					break;
				case 3:
					g.setColor(new Color(255, 0, 0));
					break;
				case 4:
					g.setColor(new Color(255, 0, 0));
					break;
				default:
					g.setColor(new Color(0, 0, 128));
				}
				g.fillRect(35 + i * 35, 35 + j * 35, 40, 40);
				g.setColor(new Color(0, 0, 0));
				g.drawRect(35 + i * 35, 35 + j * 35, 40, 40);

			}
		}
		g.setColor(new Color(10, 0, 128));

		g.fillRect(38 + x * 35, 38 + y * 35, 30, 30);
	}

	public void moveLeft() {
		if (arr[y][x - 1] == 0) {
			x--;
		} else if (arr[y][x - 1] == 2) {
			numberLvl = 2;
			x--;
			newLvl();
		} else if (arr[y][x - 1] == 3) {
			numberLvl = 3;
			newLvl();
		} else if (arr[y][x - 1] == 4) {
			System.exit(0);
			x--;
			newLvl();
		}
		repaint();
	}

	public void moveUp() {
		if (arr[y - 1][x] == 0) {
			y--;
		} else if (arr[y - 1][x] == 2) {
			numberLvl = 2;
			y--;
			newLvl();
		} else if (arr[y - 1][x] == 3) {
			numberLvl = 3;

			y--;
			newLvl();
		} else if (arr[y - 1][x] == 4) {
			System.exit(0);

			y--;
			newLvl();
		}
		repaint();
	}

	public void moveRight() {
		if (arr[y][x + 1] == 0) {
			x++;
		} else if (arr[y][x + 1] == 2) {
			numberLvl = 2;

			newLvl();
		} else if (arr[y][x + 1] == 3) {
			numberLvl = 3;

			x++;
			newLvl();
		} else if (arr[y][x + 1] == 4) {
			System.exit(0);
			x++;
			newLvl();
		}
		repaint();
	}

	public void moveDown() {
		if (arr[y + 1][x] == 0) {
			y++;
		} else if (arr[y + 1][x] == 2) {
			numberLvl = 2;

			y++;
			newLvl();
		} else if (arr[y + 1][x] == 3) {
			numberLvl = 3;

			y++;
			newLvl();
		} else if (arr[y + 1][x] == 4) {
			System.exit(0);

			y++;
			newLvl();
		}
		repaint();
	}

	@Override

	public void paint(Graphics g) {
		super.paint(g);
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		colorGame(g);
	}
}
