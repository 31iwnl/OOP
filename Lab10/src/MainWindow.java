import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1066, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 32));
		textArea.setBounds(10, 10, 791, 672);
		frame.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C");
		btnNewButton.setBounds(843, 7, 115, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openDialog = new JFileChooser();
				if (openDialog.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					String fileName = openDialog.getSelectedFile().getAbsolutePath();
					try {
						Scanner sc = new Scanner(new File(fileName));
						String str = "";
						while (sc.hasNext()) {
							str += sc.nextLine() + "\n";
						}
						sc.close();
						textArea.setText(str);

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u041E\u0431\u0440\u0430\u0431\u043E\u0442\u0430\u0442\u044C");
		btnNewButton_1.setBounds(843, 38, 115, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int b = 0;

				String[] words = textArea.getText().split("\n");
				for (int i = words.length - 1; i > words.length - 2; i--) {
					for (int j = 0; j < i; j++) {
						if (strcmp(words[j], words[j + 1]) > 0) {
							String t = words[j];
							words[j] = words[j + 1];
							words[j + 1] = t;
							if (t != "") {
								b = 1;
							}

						}
					}

					textArea.setText(String.join("\n", words));
					if (b == 0) {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "?????????? ?????????!");
					}
				}
			}
		});

		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveDialog = new JFileChooser();
				if (saveDialog.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					String fileName = saveDialog.getSelectedFile().getAbsolutePath();
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
						bw.write(textArea.getText());
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_2.setBounds(843, 69, 115, 21);
		frame.getContentPane().add(btnNewButton_2);
	}

	public int strcmp(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int ml = Math.min(arr1.length, arr2.length);

		for (int i = 0; i < ml; i++) {
			if (arr1[i] != arr2[i]) {
				return arr1[i] - arr2[i];
			}
		}

		return arr1.length - arr2.length;
	}
}
