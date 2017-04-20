//********************************************************************
//  KeyPadPanel.java       Author: Daniel Luzarraga
//
//  Demonstrates the use of text fields.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class KeyPadPanel extends JPanel
{
   private JPanel buttonPanel, clearPanel;
   private JButton clearButton;
   private JTextField display;
   private Border lineBorder;

   public KeyPadPanel()
   {
      setLayout(new BorderLayout());
      
      lineBorder = new LineBorder (Color.BLACK, 2);
      
      display = new JTextField();
      display.setBorder(lineBorder);
      add(display, "North");
      
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 3));
      buttonPanel.setBorder(lineBorder);
      
      addButton("1");
      addButton("2");
      addButton("3");
      addButton("4");
      addButton("5");
      addButton("6");
      addButton("7");
      addButton("8");
      addButton("9");
      addButton("*");
      addButton("0");      
      addButton("#");
      
      clearPanel = new JPanel();
      
      clearButton = new JButton("Clear");
      clearPanel.add(clearButton);
      
      class ClearButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent event)
        {
          display.setText("");
        }
      }
      
      ActionListener listener = new ClearButtonListener();
      clearButton.addActionListener(new ClearButtonListener());    
      
      add(buttonPanel, "Center");
      add(clearPanel, "South");
   }
   
   private void addButton(final String label)
   {  
      class DigitButtonListener implements ActionListener
      {  
         public void actionPerformed(ActionEvent event)
         {  
            display.setText(display.getText() + label);
         }
      }

      JButton button = new JButton(label);
      buttonPanel.add(button);
      ActionListener listener = new DigitButtonListener();
      button.addActionListener(listener);
      
      
   }

   public double getValue()
   {  
      return Double.parseDouble(display.getText());
   }
   
   public void clear()
   {  
      display.setText("");
   }
}