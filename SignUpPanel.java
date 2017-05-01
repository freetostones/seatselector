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
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel userNameLabel;
   private JLabel passwordLabel;
   private JTextField firstNameField; 
   private JTextField lastNameField;
   private JTextField userNameField;
   private JTextField passwordField;
   
   private SeatSelectFrame frame;


   public SignUpPanel(SeatSelectFrame frame)
   {
      this.frame = frame;
      GridBagConstraints positionConst = null;

      firstNameLabel = new JLabel("First Name:");
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

      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      positionConst.gridx = 0;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(firstNameLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      add(firstNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      add(lastNameLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      add(lastNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 3;
      add(userNameLabel, positionConst);
      
      positionConst.gridx = 1;
      positionConst.gridy = 3;
      add(userNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 4;
      add(passwordLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 4;
      add(passwordField, positionConst);
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
      frame.setCurrentUser(user);
      return;
   }
   
   public boolean checkFields(){
       boolean check = true;
       if(firstNameField.getText().equals("") || lastNameField.getText().equals("") || userNameField.getText().equals("") || passwordField.getText().equals("")){
         check = false;
       }
       return check;
   }
}