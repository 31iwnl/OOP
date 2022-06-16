import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm {
	
	String PatternSurname = "[а-яА-ЯёЁ]+";
	String PatternName = "[а-яА-ЯёЁ]+";
	String PatternMiddleName = "[а-яА-ЯёЁ]+";
	String PatternPhoneNumber = "\\d{11}";
	String Surname = "";
	String Name = "";
	String MiddleName = "";
	String PhoneNumber = "";
	
	static String MainText = "";

	AltList list = new AltList();
	
	static boolean schet = false;
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
	
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u041B\u0410\u0411\u0410\u0428\u041E\u0412 \u041F\u0418\u0414\u0410\u0420\u0410\u0421");
		frame.setBounds(100, 100, 665, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(304, 11, 321, 287);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setToolTipText("\u0418\u043C\u044F");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(10, 8, 270, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u0424\u0430\u043C\u0438\u043B\u0438\u044F");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 49, 270, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 88, 270, 28);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("\u041D\u043E\u043C\u0435\u0440 \u0442\u0435\u043B\u0435\u0444\u043E\u043D\u0430");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(10, 127, 270, 28);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				boolean key = true;
				
				if (textField.getText().matches(PatternSurname)) { 
					Surname = textField.getText();
					textField.setText("");
				}
				else {
					textField.setText("Фамилия на латинице");
					key = false;
				}
				
				if (textField_1.getText().matches(PatternName)) { 
					Name = textField_1.getText();
					textField_1.setText("");
				}
				else {
					textField_1.setText("Имя на русском");
					key = false;
				}
				
				if (textField_2.getText().matches(PatternMiddleName)) { 
					MiddleName = textField_2.getText();
					textField_2.setText("");
				}
				else {
					textField_2.setText("Отчество на русском");
					key = false;
				}
				
				if (textField_3.getText().matches(PatternPhoneNumber)) { 
					PhoneNumber = textField_3.getText();
					textField_3.setText("");
				}
				else {
					textField_3.setText("Неправильный номер телефона");
					key = false;
				}
				
				if (key == true) {
					
					String[] Input = {Surname, Name, MiddleName, PhoneNumber};
					list.addLast(Input);
					
				}
				MainText = list.print();
				textArea.setText(MainText);
				schet = false;
				
			}
		});
		btnNewButton.setBounds(10, 166, 270, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0421\u043C\u0435\u043D\u0430 \u043D\u0430\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u0438\u044F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (schet == false) {
					MainText = list.prints();
					textArea.setText(MainText);
					schet = true;
				}
				else {
					MainText = list.print();
					textArea.setText(MainText);
					schet = false;
				}
			}
		});
		btnNewButton_1.setBounds(336, 309, 270, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("\u041F\u043E\u0438\u0441\u043A \u043F\u043E \u0438\u043C\u0435\u043D\u0438");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(10, 270, 270, 28);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton_1_1 = new JButton("\u041F\u043E\u0438\u0441\u043A");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = "";
				String PatternName = "[а-яА-ЯёЁ]+";
				
				if (textField_4.getText().matches(PatternName)) { 
					Name = textField_4.getText();
					MainText = list.printName(Name);
					textArea.setText(MainText);
				}
				else {
					textField_1.setText("Введено неправильно");
				}
				
			}
		});
		btnNewButton_1_1.setBounds(10, 309, 134, 28);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = "";
				String PatternName = "[а-яА-ЯёЁ]+";
				
				if (textField_4.getText().matches(PatternName)) { 
					Name = textField_4.getText();
					list.remoteAt(Name);
					MainText = list.printName(Name);
					textArea.setText(MainText);
				}
				else {
					textField_1.setText("Имя русскими буквами");
				}
			}
		});
		btnNewButton_1_1_1.setBounds(146, 309, 134, 28);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2 = new JButton("\u0412\u044B\u0432\u0435\u0441\u0442\u0438 \u0432\u0441\u0435\u0445");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainText = list.prints();
				textArea.setText(MainText);
				schet = true;
				
			}
		});
		btnNewButton_1_2.setBounds(336, 348, 270, 28);
		frame.getContentPane().add(btnNewButton_1_2);
	}
}
