import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
public class Foothill 
{
 
   public static void main(String[] args)
   {
      // establish main frame in which program will run
      TranspoFrame myTranspoFrame 
            = new TranspoFrame("Calculator");
      myTranspoFrame.setSize(300, 200);
      myTranspoFrame.setLocationRelativeTo(null);
      myTranspoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // show everything to the user
      myTranspoFrame.setVisible(true);
   }
}

// TranspoFrame class is derived from JFrame class
class TranspoFrame  extends JFrame
{
   JButton btnMyAddButton;
   JButton btnMySubButton;
   JButton btnMyMultButton;
   JButton btnMyDivButton;
   JTextField number1;
   JTextField number2;
   JLabel number1label;
   JLabel number2label;
   
   // TranspoFrame constructor
   public TranspoFrame(String title)
   {
      // pass the title up to the JFrame constructor
      super(title);
      
      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20); 
      setLayout(layout);
      
      // 3 controls: a label, a text field and a button
      number1label = new JLabel("Enter a number: ");
      number1 = new JTextField(10);
      number2label = new  JLabel("Enter a second number: ");
      number2 = new JTextField(10);
      
      btnMyAddButton = new JButton(" + "); 
      btnMySubButton = new JButton(" - "); 
      btnMyMultButton = new JButton(" * "); 
      btnMyDivButton = new JButton(" / "); 
      add(number1label);
      add(number1);
      add(number2label);
      add(number2);
      add(btnMyAddButton);
      add(btnMySubButton);
      add(btnMyMultButton);
      add(btnMyDivButton);
      
      // create a Listener for the JButton and register it
      Addition addition;
      addition = new Addition();
      btnMyAddButton.addActionListener( addition );
      Subtraction subtraction;
      subtraction = new Subtraction();
      btnMySubButton.addActionListener( subtraction );
      Multiply multiply;
      multiply = new Multiply();
      btnMyMultButton.addActionListener( multiply );
      Divide divide;
      divide = new Divide();
      btnMyDivButton.addActionListener( divide );
      
   }
   
   // inner class for JButton Listener
   class Addition implements ActionListener
   {
      // event handler for JButton
      public void actionPerformed(ActionEvent e)
      {
    	  try
    	  {
	    	  String number1str = number1.getText();
	          float num1 = Float.parseFloat(number1str);
	          String number2str = number2.getText();
	          float num2 = Float.parseFloat(number2str);
	          float addsum = num1 + num2;
	          JOptionPane.showMessageDialog(null, 
	               "Adding " + num1 + " to " + num2 + " = " + addsum );
    	  } catch (NumberFormatException err)	{
    		  JOptionPane.showConfirmDialog(null, "Please enter numbers only", "naughty", JOptionPane.CANCEL_OPTION	);
    	  }
      }
   }
   
   class Subtraction implements ActionListener
   {
      // event handler for JButton
      public void actionPerformed(ActionEvent e)
      {
    	  try
    	  {
	    	  String number1str = number1.getText();
	          float num1 = Float.parseFloat(number1str);
	          String number2str = number2.getText();
	          float num2 = Float.parseFloat(number2str);
	          float subsum = num1 - num2;
	         JOptionPane.showMessageDialog(null, 
               "Subtracting " + num1 + " to " + num2 + " = " + subsum );
    	  } catch (NumberFormatException err)	{
    		  JOptionPane.showConfirmDialog(null, "Please enter numbers only", "naughty", JOptionPane.CANCEL_OPTION	);
    	  }
      }
   }

   class Multiply implements ActionListener
   {
      // event handler for JButton
      public void actionPerformed(ActionEvent e)
      {
    	  try
    	  {
    		  String number1str = number1.getText();
    		  float num1 = Float.parseFloat(number1str);
              String number2str = number2.getText();
              float num2 = Float.parseFloat(number2str);
             float multsum = num1 * num2;
             JOptionPane.showMessageDialog(null, 
                   "Multiplying " + num1 + " to " + num2 + " = " + multsum );
    	  } catch (NumberFormatException err)	{
    		  JOptionPane.showConfirmDialog(null, "Please enter numbers only", "naughty", JOptionPane.CANCEL_OPTION	);
    	  }
          
      }
   }
   
   class Divide implements ActionListener
   {
      // event handler for JButton
      public void actionPerformed(ActionEvent e)
      {
    	  try
    	  {
	         String number1str = number1.getText();
	         float num1 = Float.parseFloat(number1str);
	         String number2str = number2.getText();
	         float num2 = Float.parseFloat(number2str);
	         float divsum = num1 / num2;
	         JOptionPane.showMessageDialog(null, 
	               "Dividing " + num1 + " to " + num2 + " = " + divsum );
    	  } catch (NumberFormatException err)	{
    		  JOptionPane.showConfirmDialog(null, "Please enter numbers only", "naughty", JOptionPane.CANCEL_OPTION	);
	  }
      }
   }
} // end class TranspoFrame