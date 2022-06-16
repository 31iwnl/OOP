import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class Form {
    private JFrame frame;
    private JTable table;
    private LinkedList<Person> list = new LinkedList<>();
    private boolean directLookup = true;
    private static JButton btnNewButton_1_1_1_1;    // чтобы можно было ее нажать после отрисовки

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Form window = new Form();
                    window.frame.setVisible(true);
                    btnNewButton_1_1_1_1.doClick();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Form() {
        initialize();

        String[][] data = {
            {"Петров", "Иван", "Иванович", "+79128488648"},
            {"Сидоров", "Василий", "Федорович", "+79641264988"},
            {"Кнопка", "Евгений", "Николаевич", "+79349841995"},
            {"Иванов", "Георгий", "Петрович", "+79279497996"},
            {"Васильев", "Иван", "Константинович", "+79264979466"},
            {"Кнопка", "Николай", "Андреевич", "+79234484949"},
        };

        for (int i = 0; i < data.length; i++) {
            list.add(new Person(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 770, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setModel(new DefaultTableModel(
            new String[][] {},
            new String[] {
                "Фамилия", "Имя", "Отчество", "Номер телефона"
            }
        ));
        table.setBounds(10, 10, 594, 426);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 735, 555);
        frame.getContentPane().add(scrollPane);

        JButton btnNewButton = new JButton("Добавить");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame dialogFrame = new JFrame();
                dialogFrame.setResizable(false);
                JDialog dialog = new JDialog(dialogFrame);
                SpringLayout sLayout = new SpringLayout();
                dialog.getContentPane().setLayout(sLayout);
                dialog.setBounds(500, 300, 455, 250);
                dialog.setResizable(false);
                dialog.setTitle("Ввод данных");

                JLabel lnLabel = new JLabel("Фамилия: ");
                lnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                JTextField lnField = new JTextField();
                lnField.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lnField.setColumns(24);
                JLabel fnLabel = new JLabel("Имя: ");
                fnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                JTextField fnField = new JTextField();
                fnField.setFont(new Font("Tahoma", Font.PLAIN, 14));
                fnField.setColumns(24);
                JLabel mnLabel = new JLabel("Отчество: ");
                mnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                JTextField mnField = new JTextField();
                mnField.setFont(new Font("Tahoma", Font.PLAIN, 14));
                mnField.setColumns(24);
                JLabel pnLabel = new JLabel("Номер телефона: ");
                pnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                JTextField pnField = new JTextField();
                pnField.setFont(new Font("Tahoma", Font.PLAIN, 14));
                pnField.setColumns(24);

                JButton confirm = new JButton("OK");
                confirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        list.add(new Person(lnField.getText(), fnField.getText(), mnField.getText(), pnField.getText()));
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.addRow(new Object[] {lnField.getText(), fnField.getText(), mnField.getText(), pnField.getText()});
                        dialog.setVisible(false);
                    }
                });

                JButton cancel = new JButton("Отмена");
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });

                dialog.getContentPane().add(lnLabel);
                dialog.getContentPane().add(lnField);
                dialog.getContentPane().add(fnLabel);
                dialog.getContentPane().add(fnField);
                dialog.getContentPane().add(mnLabel);
                dialog.getContentPane().add(mnField);
                dialog.getContentPane().add(pnLabel);
                dialog.getContentPane().add(pnField);
                dialog.getContentPane().add(confirm);
                dialog.getContentPane().add(cancel);

                sLayout.putConstraint(SpringLayout.NORTH, lnLabel, 10, SpringLayout.NORTH, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, lnField, 10, SpringLayout.NORTH, dialogFrame);
                sLayout.putConstraint(SpringLayout.WEST, lnField, 10, SpringLayout.EAST, lnLabel);

                sLayout.putConstraint(SpringLayout.NORTH, fnLabel, 14, SpringLayout.SOUTH, lnField);
                sLayout.putConstraint(SpringLayout.NORTH, fnField, 14, SpringLayout.SOUTH, lnField);
                sLayout.putConstraint(SpringLayout.WEST, fnField, 10, SpringLayout.EAST, fnLabel);

                sLayout.putConstraint(SpringLayout.NORTH, mnLabel, 14, SpringLayout.SOUTH, fnField);
                sLayout.putConstraint(SpringLayout.NORTH, mnField, 14, SpringLayout.SOUTH, fnField);
                sLayout.putConstraint(SpringLayout.WEST, mnField, 10, SpringLayout.EAST, mnLabel);

                sLayout.putConstraint(SpringLayout.WEST, pnLabel, 10, SpringLayout.WEST, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, pnLabel, 14, SpringLayout.SOUTH, mnField);
                sLayout.putConstraint(SpringLayout.NORTH, pnField, 14, SpringLayout.SOUTH, mnField);
                sLayout.putConstraint(SpringLayout.WEST, pnField, 10, SpringLayout.EAST, pnLabel);

                sLayout.putConstraint(SpringLayout.EAST, lnField, 0, SpringLayout.EAST, pnField);
                sLayout.putConstraint(SpringLayout.EAST, fnField, 0, SpringLayout.EAST, pnField);
                sLayout.putConstraint(SpringLayout.EAST, mnField, 0, SpringLayout.EAST, pnField);
                sLayout.putConstraint(SpringLayout.WEST, lnField, 0, SpringLayout.WEST, pnField);
                sLayout.putConstraint(SpringLayout.WEST, fnField, 0, SpringLayout.WEST, pnField);
                sLayout.putConstraint(SpringLayout.WEST, mnField, 0, SpringLayout.WEST, pnField);

                sLayout.putConstraint(SpringLayout.EAST, lnLabel, 0, SpringLayout.EAST, pnLabel);
                sLayout.putConstraint(SpringLayout.EAST, fnLabel, 0, SpringLayout.EAST, pnLabel);
                sLayout.putConstraint(SpringLayout.EAST, mnLabel, 0, SpringLayout.EAST, pnLabel);

                sLayout.putConstraint(SpringLayout.WEST, confirm, 160, SpringLayout.WEST, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, confirm, 32, SpringLayout.SOUTH, pnField);
                sLayout.putConstraint(SpringLayout.NORTH, cancel, 32, SpringLayout.SOUTH, pnField);
                sLayout.putConstraint(SpringLayout.WEST, cancel, 16, SpringLayout.EAST, confirm);

                dialog.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(21, 575, 120, 24);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Поиск");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame dialogFrame = new JFrame();
                dialogFrame.setResizable(false);
                JDialog dialog = new JDialog(dialogFrame);
                SpringLayout sLayout = new SpringLayout();
                dialog.getContentPane().setLayout(sLayout);
                dialog.setBounds(500, 300, 390, 150);
                dialog.setResizable(false);
                dialog.setTitle("Ввод данных");

                JLabel qLabel = new JLabel("Запрос: ");
                qLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                JTextField qField = new JTextField();
                qField.setFont(new Font("Tahoma", Font.PLAIN, 14));
                qField.setColumns(24);

                JButton confirm = new JButton("OK");
                confirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        Iterator<Person> it = list.iterator();

                        model.setRowCount(0);

                        while (it.hasNext()) {
                            Person current = it.next();
                            if (current.firstName.equals(qField.getText())) {
                                model.addRow(new Object[] {current.lastName, current.firstName, current.midName, current.phone});
                            }
                        }

                        dialog.setVisible(false);
                    }
                });

                JButton cancel = new JButton("Отмена");
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });

                dialog.getContentPane().add(qLabel);
                dialog.getContentPane().add(qField);
                dialog.getContentPane().add(confirm);
                dialog.getContentPane().add(cancel);

                sLayout.putConstraint(SpringLayout.NORTH, qLabel, 10, SpringLayout.NORTH, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, qField, 10, SpringLayout.NORTH, dialogFrame);
                sLayout.putConstraint(SpringLayout.WEST, qField, 10, SpringLayout.EAST, qLabel);
                sLayout.putConstraint(SpringLayout.WEST, qLabel, 10, SpringLayout.WEST, dialogFrame);

                sLayout.putConstraint(SpringLayout.WEST, confirm, 125, SpringLayout.WEST, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, confirm, 32, SpringLayout.SOUTH, qField);
                sLayout.putConstraint(SpringLayout.NORTH, cancel, 32, SpringLayout.SOUTH, qField);
                sLayout.putConstraint(SpringLayout.WEST, cancel, 16, SpringLayout.EAST, confirm);

                dialog.setVisible(true);
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(162, 575, 120, 24);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Смена направления");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                Iterator<Person> it = directLookup ? list.descendingIterator() : list.iterator();

                model.setRowCount(0);

                while (it.hasNext()) {
                    Person current = it.next();
                    model.addRow(new Object[] {current.lastName, current.firstName, current.midName, current.phone});
                }

                directLookup = !directLookup;
            }
        });
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1_1.setBounds(303, 575, 165, 24);
        frame.getContentPane().add(btnNewButton_1_1);

        JButton btnNewButton_1_1_1 = new JButton("Удалить");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame dialogFrame = new JFrame();
                dialogFrame.setResizable(false);
                JDialog dialog = new JDialog(dialogFrame);
                SpringLayout sLayout = new SpringLayout();
                dialog.getContentPane().setLayout(sLayout);
                dialog.setBounds(500, 300, 390, 150);
                dialog.setResizable(false);
                dialog.setTitle("Ввод данных");

                JLabel qLabel = new JLabel("Запрос: ");
                qLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                JTextField qField = new JTextField();
                qField.setFont(new Font("Tahoma", Font.PLAIN, 14));
                qField.setColumns(24);

                JButton confirm = new JButton("OK");
                confirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.setRowCount(0);

                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).lastName.equals(qField.getText())) {
                                list.remove(i);
                                break;
                            }
                        }

                        Iterator<Person> it = list.iterator();
                        while (it.hasNext()) {
                            Person current = it.next();
                            model.addRow(new Object[] {current.lastName, current.firstName, current.midName, current.phone});
                        } 

                        dialog.setVisible(false);
                    }
                });

                JButton cancel = new JButton("Отмена");
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });

                dialog.getContentPane().add(qLabel);
                dialog.getContentPane().add(qField);
                dialog.getContentPane().add(confirm);
                dialog.getContentPane().add(cancel);

                sLayout.putConstraint(SpringLayout.NORTH, qLabel, 10, SpringLayout.NORTH, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, qField, 10, SpringLayout.NORTH, dialogFrame);
                sLayout.putConstraint(SpringLayout.WEST, qField, 10, SpringLayout.EAST, qLabel);
                sLayout.putConstraint(SpringLayout.WEST, qLabel, 10, SpringLayout.WEST, dialogFrame);

                sLayout.putConstraint(SpringLayout.WEST, confirm, 125, SpringLayout.WEST, dialogFrame);
                sLayout.putConstraint(SpringLayout.NORTH, confirm, 32, SpringLayout.SOUTH, qField);
                sLayout.putConstraint(SpringLayout.NORTH, cancel, 32, SpringLayout.SOUTH, qField);
                sLayout.putConstraint(SpringLayout.WEST, cancel, 16, SpringLayout.EAST, confirm);

                dialog.setVisible(true);
            }
        });
        btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1_1_1.setBounds(489, 575, 100, 24);
        frame.getContentPane().add(btnNewButton_1_1_1);

        btnNewButton_1_1_1_1 = new JButton("Вывод всех");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                Iterator<Person> it = list.iterator();

                model.setRowCount(0);

                while (it.hasNext()) {
                    Person current = it.next();
                    model.addRow(new Object[] {current.lastName, current.firstName, current.midName, current.phone});
                } 
            }
        });
        btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1_1_1_1.setBounds(610, 575, 120, 24);
        frame.getContentPane().add(btnNewButton_1_1_1_1);
        frame.setVisible(true);
    }
}