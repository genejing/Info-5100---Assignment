
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame{
	private JLabel firstLabel,secondLabel,resultLabel;
	
	private JButton button1,button2,button3,button4,
					button5,button6,button7,button8,
					button9,button0,buttonClear,buttonDot,
					plus,minus,multiply,divide;
	private JTextField first,second,result;
	private OperatorListener operatorListener;
	private NumberListener numberListener;

	public Calculator() {
		createComponents();
		setLayout();
		addComponents();
		createListeners();
		addListeners();
		makeItVisible();
	}



	private void addListeners() {
		plus.addActionListener(operatorListener);
		minus.addActionListener(operatorListener);
		multiply.addActionListener(operatorListener);
		divide.addActionListener(operatorListener);
		buttonClear.addActionListener(operatorListener);
		button1.addActionListener(numberListener);
		button2.addActionListener(numberListener);
		button3.addActionListener(numberListener);
		button4.addActionListener(numberListener);
		button5.addActionListener(numberListener);
		button6.addActionListener(numberListener);
		button7.addActionListener(numberListener);
		button8.addActionListener(numberListener);
		button9.addActionListener(numberListener);
		button0.addActionListener(numberListener);
		buttonDot.addActionListener(numberListener);
		
		
		
	}
	

	private void createListeners() {
		operatorListener = new OperatorListener();
		numberListener= new NumberListener();
		
		
	}
	class NumberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			JTextField input = null;
			if (first.isFocusOwner()) {
				input = first;
			} else if (second.isFocusOwner()) {
				input = second;
			}
			if (o==button1) {
				input.setText(input.getText()+"1");
			}
			if (o==button2) {
				input.setText(input.getText()+"2");
			}
			if (o==button3) {
				input.setText(input.getText()+"3");
			}
			if (o==button4) {
				input.setText(input.getText()+"4");
			}
			if (o==button5) {
				input.setText(input.getText()+"5");
			}
			if (o==button6) {
				input.setText(input.getText()+"6");
			}
			if (o==button7) {
				input.setText(input.getText()+"7");
			}
			if (o==button8) {
				input.setText(input.getText()+"8");
			}
			if (o==button9) {
				input.setText(input.getText()+"9");
			}
			if (o==button0) {
				input.setText(input.getText()+"0");

			}
			if (o==buttonDot) {
				input.setText(input.getText()+".");

			}
			
			
		}
		
	}
	
	class OperatorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == buttonClear) {
				first.setText("");
				second.setText("");
				result.setText("");
			}
			if (first.getText() != null && second.getText() != null && !first.getText().equals("") && !second.getText().equals("")) {
				double input1 = Double.parseDouble(first.getText());
				double input2 = Double.parseDouble(second.getText());
				
				if (o == plus) {
					
					result.setText(input1 + input2 + "");
				}
				if (o == minus) {
					result.setText(input1 - input2 + "");
				}
				if (o == multiply) {
					result.setText(input1 * input2 + "");
				}
				if (o == divide) {
					double div = input1 / input2;
					String ans = String.format("%.2f", div);
					result.setText(ans);
				}
				
			}
		}
		
	}



	

	private void createComponents() {
		firstLabel = new JLabel("First Number: ");
		secondLabel = new JLabel("Second Number: ");
		resultLabel = new JLabel("Result: ");
		
		button1 = new JButton("1");
		button1.setFocusable(false);
		button2 = new JButton("2");
		button2.setFocusable(false);
		button3 = new JButton("3");
		button3.setFocusable(false);
		button4 = new JButton("4");
		button4.setFocusable(false);
		button5 = new JButton("5");
		button5.setFocusable(false);
		button6 = new JButton("6");
		button6.setFocusable(false);
		button7 = new JButton("7");
		button7.setFocusable(false);
		button8 = new JButton("8");
		button8.setFocusable(false);
		button9 = new JButton("9");
		button9.setFocusable(false);
		button0 = new JButton("0");
		button0.setFocusable(false);
		buttonDot = new JButton(".");
		buttonDot.setFocusable(false);
		button0 = new JButton("0");
		buttonClear = new JButton("C");
		button0.setFocusable(false);
		
		plus = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("x");
		divide = new JButton("/");
		
		first = new JTextField(5);
		
		second = new JTextField(5);
		result = new JTextField(5);
		
	}
	
	private void setLayout() {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
	}
	
	private void addComponents() {
		Container container = getContentPane();
		addInputResultControl(container);
		addOperationControl(container);
		
		
	}
	


	private void addInputResultControl(Container container) {
		JPanel panel = new JPanel();
		panel.add(firstLabel);
		panel.add(first);
		panel.add(secondLabel);
		panel.add(second);
		panel.add(resultLabel);
		panel.add(result);
		container.add(panel,"North");
	}
	
	private void addOperationControl(Container container) {
		JPanel panel = new JPanel(new GridLayout(4, 3));
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(plus);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(minus);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(multiply);
		panel.add(button0);
		panel.add(buttonClear);
		panel.add(buttonDot);
		panel.add(divide);
		container.add(panel,"South");
		
	}
	
	private void makeItVisible() {
		setSize(500, 500);
		setVisible(true);
		pack();
	}
	
	

	public static void main(String[] args) {
		new Calculator();
	}
	

}
