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

public class SignUpPanel extends JPanel
{
   private JLabel firstNameLabel;     // Label for first name
   private JLabel lastNameLabel;     // Label for last name
   private JLabel userNameLabel;      // Label for user name
   private JLabel passwordLabel;      // Label for user name
   private JTextField firstNameField;  // Displays first name 
   private JTextField lastNameField; // Displays last name
   private JTextField userNameField; // Displays user name
   private JTextField passwordField; // Displays password
   private JButton signUpButton;   // Triggers sign up
   
   private SeatSelectFrame frame;


   public SignUpPanel(SeatSelectFrame frame)
   {
      this.frame = frame;
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set hourly and yearly salary labels
      firstNameLabel = new JLabel("Fist Name:");
      lastNameLabel = new JLabel("Last Name:");
      userNameLabel = new JLabel("User Name:");
      passwordLabel = new JLabel("Password:");

      firstNameField = new JTextField(15);
      firstNameField.setEditable(true);
      
      lastNameField = new JTextField(15);
      lastNameField.setEditable(true);
      
      userNameField = new JTextField(15);
      userNameField.setEditable(true);
      
      passwordField = new JTextField(15);
      passwordField.setEditable(true);

      // Create a "Calculate" button
      signUpButton = new JButton("Sign Up");
      
      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      // Specify component's grid location
      positionConst.gridx = 0;
      positionConst.gridy = 0;
      
      // 10 pixels of padding around component
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      // Add component using the specified constraints
      add(firstNameLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(firstNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(lastNameLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(lastNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 3;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(userNameLabel, positionConst);
      
      positionConst.gridx = 1;
      positionConst.gridy = 3;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(userNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 4;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(passwordLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 4;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(passwordField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 5;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(signUpButton, positionConst);
      
      class ButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent event)
        {
           String firstNameInput = ""; 
           String lastNameInput = ""; 
           String userNameInput = ""; 
           String passwordInput = ""; 

           firstNameInput = firstNameField.getText();
           lastNameInput = lastNameField.getText();
           userNameInput = userNameField.getText();
           passwordInput = passwordField.getText();
      
           firstNameLabel.setVisible(false);
           lastNameLabel.setVisible(false);
           userNameLabel.setVisible(false);
           passwordLabel.setVisible(false);
      

           frame.createUser(firstNameInput, lastNameInput, userNameInput, passwordInput);
           
           frame.bookSeat("1");


           return;
        }
      }
      ActionListener listener = new ButtonListener();
      signUpButton.addActionListener(listener); 
   }
}