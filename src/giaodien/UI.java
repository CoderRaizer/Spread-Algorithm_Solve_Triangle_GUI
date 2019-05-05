package giaodien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import process.BootDataRecipe;
import process.Processor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class UI extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblVariable;
	private JTextField textField_variable;
	private JLabel lblValue;
	private JTextField textField_value;
	private JButton btnSolve;
	JTextArea textArea;
	private JTextField textField_Component;
	private JLabel lblTnh;
	private JTextField textField_FindVariable;
	private JButton btnReset;
	private JButton btnFilterResult;
	private JTextField textFieldAddRecipe;
	private JButton btnAddRecipe;
	private JComboBox comboBox;
	

	private static final String FILENAME = "D:\\zFile\\recipe.txt";
	/**
	 * Launch the application.
	 */
	BootDataRecipe bootDataRecipe = new BootDataRecipe();
	Processor processor = new Processor();
	int sothanhphandabiet;
	String variableKnown_Temp = "";
	Double valueKnown_Temp = 0.0;
	String line = "";
	String ShowOut = "";
	
	private JPanel panelCheckBox;
	private JCheckBox checkBox_A;
	private JCheckBox checkBox_B;
	private JCheckBox checkBox_C;
	private JCheckBox checkBox_a;
	private JCheckBox checkBox_b;
	private JCheckBox checkBox_c;
	private JCheckBox checkBox_ma;
	private JCheckBox checkBox_mb;
	private JCheckBox checkBox_mc;
	private JCheckBox checkBox_ha;
	private JCheckBox checkBox_hb;
	private JCheckBox checkBox_hc;
	private JCheckBox checkBox_p;
	private JCheckBox checkBox_r;
	private JCheckBox checkBox_R;
	private JCheckBox checkBox_S;
	private JTextField value_A;
	private JTextField value_B;
	private JTextField value_C;
	private JTextField value_a;
	private JTextField value_b;
	private JTextField value_c;
	private JTextField value_ma;
	private JTextField value_mb;
	private JTextField value_mc;
	private JTextField value_ha;
	private JTextField value_hb;
	private JTextField value_hc;
	private JTextField value_p;
	private JTextField value_r;
	private JTextField value_R;
	private JTextField value_S;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
					frame.setTitle("SOLVE TRIANGLE");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		
		processor.TurnOn();
		


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHeader = new JButton("GI\u1EA2I TAM GI\u00C1C");
		btnHeader.setIcon(new ImageIcon("C:\\Users\\ASUS\\Documents\\WorkSpace-Schools\\SpreadAlgorithm\\image\\tamgiac.png"));
		btnHeader.setBackground(new Color(102, 205, 170));
		btnHeader.setBounds(0, 0, 627, 273);
		contentPane.add(btnHeader);
		
		lblVariable = new JLabel("Variable");
		lblVariable.setBounds(411, 298, 49, 20);
		contentPane.add(lblVariable);
		
		textField_variable = new JTextField();
		textField_variable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				variableKnown_Temp = textField_variable.getText().toString();
			}
		});
		textField_variable.setBounds(459, 298, 62, 19);
		contentPane.add(textField_variable);
		textField_variable.setColumns(10);
		
		lblValue = new JLabel("Value");
		lblValue.setBounds(531, 298, 35, 20);
		contentPane.add(lblValue);
		
		textField_value = new JTextField();
		textField_value.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valueKnown_Temp = Double.parseDouble(textField_value.getText());
				processor.setVariableToArrayVarKnow(variableKnown_Temp, valueKnown_Temp);
				line += variableKnown_Temp + " ";
				textField_Component.setText(line);
				variableKnown_Temp = "";
				valueKnown_Temp = 0.0;
				
				textField_variable.setText("");
				textField_value.setText("");
			}
		});
		textField_value.setBounds(565, 298, 62, 20);
		contentPane.add(textField_value);
		textField_value.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 248, 220));
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setBounds(10, 322, 617, 288);
		contentPane.add(textArea);
		
		textField_Component = new JTextField();
		textField_Component.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Component.setBackground(new Color(102, 205, 170));
		textField_Component.setBounds(459, 278, 167, 20);
		contentPane.add(textField_Component);
		textField_Component.setColumns(10);
		
		lblTnh = new JLabel("Variable to find");
		lblTnh.setBounds(10, 298, 86, 20);
		contentPane.add(lblTnh);
		
		textField_FindVariable = new JTextField();
		textField_FindVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.setFindResult(textField_FindVariable.getText().toString());
			}
		});
		textField_FindVariable.setBounds(93, 298, 35, 20);
		contentPane.add(textField_FindVariable);
		textField_FindVariable.setColumns(10);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				variableKnown_Temp = "";
				valueKnown_Temp = 0.0;
				sothanhphandabiet = 0;
				line = "";
				ShowOut = "";
				textField_variable.setText("");
				textField_value.setText("");
				textField_Component.setText("");
				textField_FindVariable.setText("");
				textArea.setText("");
				processor.reset();
				processor.setarrayVarKnown();
				processor.TurnOn();
				
				//////////////////////////////
				checkBox_A.setSelected(false);
				checkBox_B.setSelected(false);
				checkBox_C.setSelected(false);
				checkBox_a.setSelected(false);
				checkBox_b.setSelected(false);
				checkBox_c.setSelected(false);
				checkBox_ma.setSelected(false);
				checkBox_mb.setSelected(false);
				checkBox_mc.setSelected(false);
				checkBox_ha.setSelected(false);
				checkBox_hb.setSelected(false);
				checkBox_hc.setSelected(false);
				checkBox_p.setSelected(false);
				checkBox_r.setSelected(false);
				checkBox_R.setSelected(false);
				checkBox_S.setSelected(false);
				//////////////////////////////
				value_A.setBackground(Color.WHITE);value_A.setText("");
				value_B.setBackground(Color.WHITE);value_B.setText("");
				value_C.setBackground(Color.WHITE);value_C.setText("");
				value_a.setBackground(Color.WHITE);value_a.setText("");
				value_b.setBackground(Color.WHITE);value_b.setText("");
				value_c.setBackground(Color.WHITE);value_c.setText("");
				value_ma.setBackground(Color.WHITE);value_ma.setText("");
				value_mb.setBackground(Color.WHITE);value_mb.setText("");
				value_mc.setBackground(Color.WHITE);value_mc.setText("");
				value_ha.setBackground(Color.WHITE);value_ha.setText("");
				value_hb.setBackground(Color.WHITE);value_hb.setText("");
				value_hc.setBackground(Color.WHITE);value_hc.setText("");
				value_p.setBackground(Color.WHITE);value_p.setText("");
				value_r.setBackground(Color.WHITE);value_r.setText("");
				value_R.setBackground(Color.WHITE);value_R.setText("");
				value_S.setBackground(Color.WHITE);value_S.setText("");
				//////////////////////////////
				
			}
		});
		btnReset.setBounds(295, 298, 106, 20);
		contentPane.add(btnReset);

		/*---------------------------------------------------------------------------*/
		
		panelCheckBox = new JPanel();
		panelCheckBox.setBackground(new Color(224, 255, 255));
		panelCheckBox.setBounds(630, 0, 204, 610);
		contentPane.add(panelCheckBox);
		panelCheckBox.setLayout(null);
		
		checkBox_A = new JCheckBox("A");
		checkBox_A.setBounds(0, 0, 97, 23);
		panelCheckBox.add(checkBox_A);
		
		checkBox_B = new JCheckBox("B");
		checkBox_B.setBounds(0, 26, 97, 23);
		panelCheckBox.add(checkBox_B);
		
		checkBox_C = new JCheckBox("C");
		checkBox_C.setBounds(0, 52, 97, 23);
		panelCheckBox.add(checkBox_C);
		
		checkBox_a = new JCheckBox("a");
		checkBox_a.setBounds(0, 78, 97, 23);
		panelCheckBox.add(checkBox_a);
		
		checkBox_b = new JCheckBox("b");
		checkBox_b.setBounds(0, 104, 97, 23);
		panelCheckBox.add(checkBox_b);
		
		checkBox_c = new JCheckBox("c");
		checkBox_c.setBounds(0, 130, 97, 23);
		panelCheckBox.add(checkBox_c);
		
		checkBox_ma = new JCheckBox("ma");
		checkBox_ma.setBounds(0, 156, 97, 23);
		panelCheckBox.add(checkBox_ma);
		
		checkBox_mb = new JCheckBox("mb");
		checkBox_mb.setBounds(0, 182, 97, 23);
		panelCheckBox.add(checkBox_mb);
		
		checkBox_mc = new JCheckBox("mc");
		checkBox_mc.setBounds(0, 208, 97, 23);
		panelCheckBox.add(checkBox_mc);
		
		checkBox_ha = new JCheckBox("ha");
		checkBox_ha.setBounds(0, 234, 97, 23);
		panelCheckBox.add(checkBox_ha);
		
		checkBox_hb = new JCheckBox("hb");
		checkBox_hb.setBounds(0, 260, 97, 23);
		panelCheckBox.add(checkBox_hb);
		
		checkBox_hc = new JCheckBox("hc");
		checkBox_hc.setBounds(0, 287, 97, 23);
		panelCheckBox.add(checkBox_hc);
		
		checkBox_p = new JCheckBox("p");
		checkBox_p.setBounds(0, 313, 97, 23);
		panelCheckBox.add(checkBox_p);
		
		checkBox_r = new JCheckBox("r");
		checkBox_r.setBounds(0, 339, 97, 23);
		panelCheckBox.add(checkBox_r);
		
		checkBox_R = new JCheckBox("R");
		checkBox_R.setBounds(0, 365, 97, 23);
		panelCheckBox.add(checkBox_R);
		
		checkBox_S = new JCheckBox("S");
		checkBox_S.setBounds(0, 391, 97, 23);
		panelCheckBox.add(checkBox_S);
		
		/*---------------------------------------------------------------------------*/
		value_A = new JTextField();
		value_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_A.isSelected()) {
					processor.setVariableToArrayVarKnow("A", Double.parseDouble(value_A.getText()));
					value_A.setBackground(Color.yellow);
					System.out.println("A = " + Double.parseDouble(value_A.getText()));
				}
			}
		});
		value_A.setBounds(103, 1, 101, 20);
		panelCheckBox.add(value_A);
		value_A.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_B = new JTextField();
		value_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_B.isSelected()) {
					processor.setVariableToArrayVarKnow("B", Double.parseDouble(value_B.getText()));
					value_B.setBackground(Color.yellow);
					System.out.println("B = " + Double.parseDouble(value_B.getText()));
				}
			}
		});
		value_B.setBounds(103, 26, 101, 20);
		panelCheckBox.add(value_B);
		value_B.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_C = new JTextField();
		value_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_C.isSelected()) {
					processor.setVariableToArrayVarKnow("C", Double.parseDouble(value_C.getText()));
					value_C.setBackground(Color.yellow);
					System.out.println("C = " + Double.parseDouble(value_C.getText()));
				}
			}
		});
		value_C.setBounds(103, 52, 101, 20);
		panelCheckBox.add(value_C);
		value_C.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_a = new JTextField();
		value_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_a.isSelected()) {
					processor.setVariableToArrayVarKnow("a", Double.parseDouble(value_a.getText()));
					value_a.setBackground(Color.yellow);
					System.out.println("a = " + Double.parseDouble(value_a.getText()));
				}
			}
		});
		value_a.setBounds(103, 78, 101, 20);
		panelCheckBox.add(value_a);
		value_a.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_b = new JTextField();
		value_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_b.isSelected()) {
					processor.setVariableToArrayVarKnow("b", Double.parseDouble(value_b.getText()));
					value_b.setBackground(Color.yellow);
					System.out.println("b = " + Double.parseDouble(value_b.getText()));
				}
			}
		});
		value_b.setBounds(103, 104, 101, 20);
		panelCheckBox.add(value_b);
		value_b.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_c = new JTextField();
		value_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_c.isSelected()) {
					processor.setVariableToArrayVarKnow("c", Double.parseDouble(value_c.getText()));
					value_c.setBackground(Color.yellow);
					System.out.println("c = " + Double.parseDouble(value_c.getText()));
				}
			}
		});
		value_c.setBounds(103, 130, 101, 20);
		panelCheckBox.add(value_c);
		value_c.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_ma = new JTextField();
		value_ma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_ma.isSelected()) {
					processor.setVariableToArrayVarKnow("ma", Double.parseDouble(value_ma.getText()));
					value_ma.setBackground(Color.yellow);
					System.out.println("ma = " + Double.parseDouble(value_ma.getText()));
				}
			}
		});
		value_ma.setBounds(103, 156, 101, 19);
		panelCheckBox.add(value_ma);
		value_ma.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_mb = new JTextField();
		value_mb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_mb.isSelected()) {
					processor.setVariableToArrayVarKnow("mb", Double.parseDouble(value_mb.getText()));
					value_mb.setBackground(Color.yellow);
					System.out.println("mb = " + Double.parseDouble(value_mb.getText()));
				}
			}
		});
		value_mb.setBounds(103, 182, 101, 19);
		panelCheckBox.add(value_mb);
		value_mb.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_mc = new JTextField();
		value_mc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_mc.isSelected()) {
					processor.setVariableToArrayVarKnow("mc", Double.parseDouble(value_mc.getText()));
					value_mc.setBackground(Color.yellow);
					System.out.println("mc = " + Double.parseDouble(value_mc.getText()));
				}
			}
		});
		value_mc.setBounds(103, 208, 101, 19);
		panelCheckBox.add(value_mc);
		value_mc.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_ha = new JTextField();
		value_ha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_ha.isSelected()) {
					processor.setVariableToArrayVarKnow("ha", Double.parseDouble(value_ha.getText()));
					value_ha.setBackground(Color.yellow);
					System.out.println("ha = " + Double.parseDouble(value_ha.getText()));
				}
			}
		});
		value_ha.setBounds(103, 234, 101, 20);
		panelCheckBox.add(value_ha);
		value_ha.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_hb = new JTextField();
		value_hb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_hb.isSelected()) {
					processor.setVariableToArrayVarKnow("hb", Double.parseDouble(value_hb.getText()));
					value_hb.setBackground(Color.yellow);
					System.out.println("hb = " + Double.parseDouble(value_hb.getText()));
				}
			}
		});
		value_hb.setBounds(103, 260, 101, 19);
		panelCheckBox.add(value_hb);
		value_hb.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_hc = new JTextField();
		value_hc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_hc.isSelected()) {
					processor.setVariableToArrayVarKnow("hc", Double.parseDouble(value_hc.getText()));
					value_hc.setBackground(Color.yellow);
					System.out.println("hc = " + Double.parseDouble(value_hc.getText()));
				}
			}
		});
		value_hc.setBounds(103, 287, 101, 19);
		panelCheckBox.add(value_hc);
		value_hc.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_p = new JTextField();
		value_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_p.isSelected()) {
					processor.setVariableToArrayVarKnow("p", Double.parseDouble(value_p.getText()));
					value_p.setBackground(Color.yellow);
					System.out.println("p = " + Double.parseDouble(value_p.getText()));
				}
			}
		});
		value_p.setBounds(103, 313, 101, 19);
		panelCheckBox.add(value_p);
		value_p.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_r = new JTextField();
		value_r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_r.isSelected()) {
					processor.setVariableToArrayVarKnow("r", Double.parseDouble(value_r.getText()));
					value_r.setBackground(Color.yellow);
					System.out.println("r = " + Double.parseDouble(value_r.getText()));
				}
			}
		});
		value_r.setBounds(103, 339, 101, 20);
		panelCheckBox.add(value_r);
		value_r.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_R = new JTextField();
		value_R.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_R.isSelected()) {
					processor.setVariableToArrayVarKnow("R", Double.parseDouble(value_R.getText()));
					value_R.setBackground(Color.yellow);
					System.out.println("R = " + Double.parseDouble(value_R.getText()));
				}
			}
		});
		value_R.setBounds(103, 365, 101, 19);
		panelCheckBox.add(value_R);
		value_R.setColumns(10);
		/*---------------------------------------------------------------------------*/
		value_S = new JTextField();
		value_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (checkBox_S.isSelected()) {
					processor.setVariableToArrayVarKnow("S", Double.parseDouble(value_S.getText()));
					value_S.setBackground(Color.yellow);
					System.out.println("S = " + Double.parseDouble(value_S.getText()));
				}
			}
		});
		value_S.setBounds(103, 391, 101, 19);
		panelCheckBox.add(value_S);
		value_S.setColumns(10);
		
		btnSolve = new JButton("Start");
		btnSolve.setIcon(new ImageIcon("C:\\Users\\ASUS\\Documents\\WorkSpace-Schools\\SpreadAlgorithm\\image\\iconSolve.png"));
		btnSolve.setBounds(39, 432, 128, 78);
		panelCheckBox.add(btnSolve);
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				processor.TurnOn();
				textArea.setText("");
				ShowOut = "";
				ShowOut = processor.Calculating("normal");
				textArea.setText(ShowOut);
				
			}
		});
		btnSolve.setBackground(new Color(152, 251, 152));
		
		btnFilterResult = new JButton("Filter Result");
		btnFilterResult.setIcon(new ImageIcon("C:\\Users\\ASUS\\Documents\\WorkSpace-Schools\\SpreadAlgorithm\\image\\aaa.png"));
		btnFilterResult.setBounds(39, 521, 128, 78);
		panelCheckBox.add(btnFilterResult);
		btnFilterResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				processor.TurnOn();
				textArea.setText("");
				ShowOut = "";
				ShowOut = processor.Calculating("filterResult");
				textArea.setText(ShowOut);
			}
		});
		btnFilterResult.setBackground(new Color(192, 192, 192));
		
		/*---------------------------------------------------------------------------*/
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.setFindResult(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setBounds(132, 284, 153, 32);
		contentPane.add(comboBox);
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
		comboBox.addItem("a");
		comboBox.addItem("b");
		comboBox.addItem("c");
		comboBox.addItem("ma");
		comboBox.addItem("mb");
		comboBox.addItem("mc");
		comboBox.addItem("ha");
		comboBox.addItem("hb");
		comboBox.addItem("hc");
		comboBox.addItem("p");
		comboBox.addItem("r");
		comboBox.addItem("R");
		comboBox.addItem("S");

		

	}

}
