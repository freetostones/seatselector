import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

public class SignInPanel extends JPanel
{
   private JLabel userNameLabel;      // Label for user name
   private JLabel passwordLabel;      // Label for user name
   private JTextField userNameField; // Displays user name
   private JTextField passwordField; // Displays password


   private SeatSelectFrame frame;

   public SignInPanel(SeatSelectFrame frame)
   {
      this.frame = frame;
      
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set hourly and yearly salary labels
      userNameLabel = new JLabel("User Name:");
      passwordLabel = new JLabel("Password:");
      
      userNameField = new JTextField(15);
      userNameField.setEditable(true);
      
      passwordField = new JTextField(15);
      passwordField.setEditable(true);
      
      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      // Specify component's grid location
      positionConst.gridx = 0;
      positionConst.gridy = 0;
      
      // 10 pixels of padding around component
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      // Add component using the specified constraints
      add(userNameLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(userNameField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(passwordLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(passwordField, positionConst);
           
   }
   
     public void clear(){
        userNameField.setText("");
        passwordField.setText("");
      }
      
     public void signIn(){ 
        ArrayList<User> array = new ArrayList<User>();
        array = frame.getUsersArray();
        for(int i = 0; i < array.size(); i++){
         if(userNameField.getText() == array.get(i).getUserID()) {
            if(passwordField.getText() == array.get(i).getPassword()) {
            frame.setCurrentUser(array.get(i));
            }
         }
         else {
            System.out.println("Username does not exist");
         }
      }
      return;
     }
}