import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

public class SignInPanel extends JPanel
{
   private JLabel userNameLabel;
   private JLabel passwordLabel;
   private JTextField userNameField;
   private JTextField passwordField;

   private SeatSelectFrame frame;

   public SignInPanel(SeatSelectFrame frame)
   {
      this.frame = frame;

      GridBagConstraints positionConst = null;

      userNameLabel = new JLabel("User Name:");
      passwordLabel = new JLabel("Password:");

      userNameField = new JTextField(15);
      userNameField.setEditable(true);
      
      passwordField = new JTextField(15);
      passwordField.setEditable(true);
      
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      positionConst.gridx = 0;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(userNameLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      add(userNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      add(passwordLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      add(passwordField, positionConst);
  
   }
   
     public void clear(){
        userNameField.setText("");
        passwordField.setText("");
      }
      
     public void signIn(){ 
        ArrayList<User> array = new ArrayList<User>();
        array = frame.getUsersArray();
       
        for(int i = 1; i < array.size(); i++){
          if(checkSignIn() == true){
           frame.setCurrentUser(array.get(i));
          }
          return;
        }
     }
     
     public boolean checkSignIn(){
        ArrayList<User> array = new ArrayList<User>();
        array = frame.getUsersArray();
        boolean found = false;
        
        for(int i = 1; i < array.size(); i++){
          if(userNameField.getText().equals(array.get(i).getUserID())) {
            if(passwordField.getText().equals(array.get(i).getPassword())) {
            found = true;
            }
          }
        }
        
      return found;
       
     }
     
     public boolean checkFields(){
       boolean check = true;
       if(userNameField.getText().equals("") || passwordField.getText().equals("")){
         check = false;
       }
       return check;
     }    
     
}