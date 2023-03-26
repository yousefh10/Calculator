import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CalculatorGUI implements ActionListener {
    
    private JFrame frame;
    private JPanel panel;
    private JTextField text;

    // buttons on calculator
    private JButton add, subtract, divide, multiply;
    private JButton equal, decimal, percent, negative, clear, pi;
    private JButton[] numbers = new JButton[10]; // numbers 0-9

    double firstNumber, secondNumber = 0, result = 0;
    char operation;

    public CalculatorGUI(){ 
        frame = new JFrame("Calculator");
        frame.setSize(400, 500); // size of calculator GUI
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text = new JTextField();
        text.setBounds(50, 25, 300, 50); // sets where the textfield will be located
        text.setEditable(false); // sets it so the user cannot edit the textbook by typing
        
        divide = new JButton("/");
        multiply = new JButton("x");
        subtract = new JButton("-");
        add = new JButton("+");
        equal = new JButton("=");
        pi = new JButton("π");
        decimal = new JButton(".");
        percent = new JButton("%");
        negative = new JButton("(-)");
        clear = new JButton("AC");

        clear.setBounds(205, 430, 45, 50);

        divide.addActionListener(this);
        multiply.addActionListener(this);
        subtract.addActionListener(this);
        add.addActionListener(this);
        equal.addActionListener(this);
        pi.addActionListener(this);
        decimal.addActionListener(this);
        percent.addActionListener(this);
        negative.addActionListener(this);
        clear.addActionListener(this);

        clear.setBounds(205, 430, 45, 50);

        for (int j = 0; j < 10; j++){
            numbers[j] = new JButton(String.valueOf(j));
            numbers[j].addActionListener(this);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.add(clear);
        panel.add(negative);
        panel.add(percent);
        panel.add(pi);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(divide);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(multiply);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(subtract);
        panel.add(numbers[0]);
        panel.add(decimal);
        panel.add(equal);
        panel.add(add);

        frame.add(text);
        frame.add(panel);

        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        for (int m = 0; m < 10; m++){ // for loop for numbers
        if (e.getSource() == numbers[m]) { // getSource() method is used in actionPerformed to determine which button was clicked
            text.setText(text.getText().concat(String.valueOf(m))); 
        }
      } 

      if (e.getSource() == equal){ 
        secondNumber = Double.parseDouble(text.getText());
        
        if (operation == '+'){
            result = firstNumber + secondNumber;
        }
        else if (operation == '-'){
            result = firstNumber - secondNumber;
        }
        else if (operation == 'x'){
            result = firstNumber * secondNumber;
        }
        else if (operation == '/'){
            result = firstNumber / secondNumber;
        }

        text.setText(String.valueOf(result)); // updates text field
        firstNumber = result;

      }

      if (e.getSource() == add){
        firstNumber = Double.parseDouble((text.getText())); 
        operation = '+';
        text.setText("");
      }

      if (e.getSource() == subtract){
        firstNumber = Double.parseDouble((text.getText())); 
        operation = '-';
        text.setText("");
      }

      if (e.getSource() == multiply){
        firstNumber = Double.parseDouble((text.getText())); 
        operation = 'x';
        text.setText("");
      }

      if (e.getSource() == divide){
        firstNumber = Double.parseDouble((text.getText())); 
        operation = '/';
        text.setText("");
      }

      if (e.getSource() == decimal){
        text.setText(text.getText().concat(String.valueOf(".")));
      }

      if (e.getSource() == clear){
        text.setText("");
      }

      if (e.getSource() == negative){
        double temp = Double.parseDouble(text.getText()); // assigns what is in the text field to temp variable
        temp *=-1; // multiply whatever is in the text field by -1 to either make it a negative or make it a positive again
        text.setText(String.valueOf(temp));
      }

      if (e.getSource() == percent){
        double temp = Double.parseDouble(text.getText());
        temp /=100;
        text.setText(String.valueOf(temp));
      }

      if (e.getSource() == pi){
        text.setText(text.getText().concat(String.valueOf("3.141592653589793")));
      }

    }

    public static void main(String[] args){
        new CalculatorGUI();
    }
}
