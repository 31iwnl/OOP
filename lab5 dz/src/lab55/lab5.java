package lab55;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;

public class lab5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab5 window = new lab5();
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
	public lab5() {
		initialize();
	}
	
	public static double func(double x, int m) {
        if(m == 1) {
        	return 2 * x;
        }
        return 2 * Math.pow(x, 2*m-1) / (2*m-1) + func(x, --m);
    }
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("removal")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u041B\u0430\u0431\u043E\u0440\u0430\u0442\u043E\u0440\u043D\u0430\u044F \u0440\u0430\u0431\u043E\u0442\u0430 \u21165");
		frame.setBounds(100, 100, 502, 237);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 13, 284, 167);
		frame.getContentPane().add(textArea);	
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(330, 10, 84, 20);
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(0)));
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(330, 42, 84, 20);
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		Button button = new Button("\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
		button.setBounds(330, 71, 135, 36);		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double N = (double)spinner.getValue();
		        double w = Math.log((1+N) / (1-N));
		        int m = (int)spinner_1.getValue();
		        if(N == 1 || N == -1) {
		        	textArea.setText("Недопустимое значение X");
		        } else {
		        	double u = func(N,m);
		        	textArea.setText(""+ u);
		        }
			}
			
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		frame.getContentPane().add(spinner);
		frame.getContentPane().add(spinner_1);
	}
}