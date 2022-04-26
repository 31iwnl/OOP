import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class ArrayPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[][] arr;
	int w;
	int max;
	int max_i = 0;
	int min_i = 0;
	int min;
	int h;

	public void Update() {
		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					max_i = j;
				}
				if (arr[i][j] < min) {
					min = arr[i][j];
					min_i = j;
				}
			}
		}
		for (int i = 0; i < w; i++) {
			arr[i][min_i] += arr[i][max_i];
			arr[i][max_i] = arr[i][min_i] - arr[i][max_i];
			arr[i][min_i] -= arr[i][max_i];
		}
		repaint();
	}

	public ArrayPanel() {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\vovaf\\Desktop\\Ëàïøîâ\\JAVA\\input.txt"));
			w = sc.nextInt();
			h = sc.nextInt();
			arr = new int[w][h];
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					arr[x][y] = sc.nextInt();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				switch (arr[x][y]) {
				case 0:
					g.setColor(Color.BLACK);
					break;
				case 1:
					g.setColor(Color.GREEN);
					break;
				case 2:
					g.setColor(Color.YELLOW);
					break;
				case 3:
					g.setColor(Color.WHITE);
					break;
				case 4:
					g.setColor(Color.RED);
					break;
				case 5:
					g.setColor(Color.ORANGE);
					break;
				case 6:
					g.setColor(Color.BLUE);
					break;
				case 7:
					g.setColor(Color.PINK);
					break;
				case 8:
					g.setColor(Color.GRAY);
					break;
				case 9:
					g.setColor(Color.CYAN);
					break;
				}
				g.fillRect(10 + x * 20, 10 + y * 20, 20, 20);
			}
		}
	}

}
