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
import java.util.ArrayList;

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
   //private JButton signUpButton;   // Triggers sign up
   
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
      //signUpButton = new JButton("Sign Up");
      
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
   }
   
   public void clear(){
     firstNameField.setText("");
     lastNameField.setText("");
     userNameField.setText("");
     passwordField.setText("");
   }
   
   public void createUser() {
      ArrayList<User> array = new ArrayList<User>();
      array = frame.getUsersArray();
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      String userName = userNameField.getText();
      String password = passwordField.getText();
      User user = new User(firstName, lastName, userName, password);
      array.add(user);
      return;
   }
}