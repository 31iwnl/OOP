package lab7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window {
private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u041B\u0430\u0431 7");
		frame.setBounds(100, 100, 441, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final Game panel = new Game();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 433, 400);
		frame.getContentPane().add(panel);
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_LEFT:
					panel.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					panel.moveRight();
					break;
				case KeyEvent.VK_UP:
					panel.moveUp();
					break;
				case KeyEvent.VK_DOWN:
					panel.moveDown();
					break;
				default:
					break;
				}
			}
			
		});
	}
}