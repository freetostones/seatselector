import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class FlightsPanel extends JPanel
{
   private JLabel userNameLabel;      // Label for user name
   private JLabel passwordLabel;      // Label for user name
   private JTextField userNameField; // Displays user name
   private JTextField passwordField; // Displays password
   //private JButton signInButton;   // Triggers sign in


   public FlightsPanel(SeatSelectFrame frame)
   {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set hourly and yearly salary labels
      userNameLabel = new JLabel("FLIGHT:");
      passwordLabel = new JLabel("TIME:");
      
      userNameField = new JTextField(15);
      userNameField.setEditable(true);
      
      passwordField = new JTextField(15);
      passwordField.setEditable(true);

      // Create a "Calculate" button
      //signInButton = new JButton("Sign In");
      
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

      positionConst.gridx = 0;
      positionConst.gridy = 3;
      positionConst.insets = new Insets(10, 10, 10, 10);
      //add(signInButton, positionConst);
      
      class ButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent event)
        {
           String userNameInput = ""; 
           String passwordInput = ""; 

           userNameInput = userNameField.getText();
           passwordInput = passwordField.getText();
      
           userNameLabel.setVisible(false);
           passwordLabel.setVisible(false);

           return;
        }
      }
      ActionListener listener = new ButtonListener();
      //signInButton.addActionListener(listener); 
   }
}