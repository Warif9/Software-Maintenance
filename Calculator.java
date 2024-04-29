
package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField numField1, numField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(900, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        numField1 = new JTextField(10);
        numField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        inputPanel.add(new JLabel("Number 1:"));
        inputPanel.add(numField1);
        inputPanel.add(new JLabel("Number 2:"));
        inputPanel.add(numField2);
        inputPanel.add(new JLabel("Result:"));
        inputPanel.add(resultField);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(numField1.getText());
        double num2 = Double.parseDouble(numField2.getText());

        if (e.getSource() == addButton) {
            double result = num1 + num2;
            resultField.setText(String.valueOf(result));
        } else if (e.getSource() == subtractButton) {
            double result = num1 - num2;
            resultField.setText(String.valueOf(result));
        } else if (e.getSource() == multiplyButton) {
            double result = num1 * num2;
            resultField.setText(String.valueOf(result));
        } else if (e.getSource() == divideButton) {
           
                double result = num1 / num2;
                resultField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator calculator = new Calculator();
                calculator.setVisible(true);
            }
        });
    }
}