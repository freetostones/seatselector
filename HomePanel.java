import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class HomePanel extends JPanel
{
   private JLabel nameLabel;      // Label for user name
   private JLabel passwordLabel;      // Label for user name
   private JTextField userNameField; // Displays user name
   private JTextField passwordField; // Displays password
   //private JButton signInButton;   // Triggers sign in


   public HomePanel(SeatSelectFrame frame)
   {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set hourly and yearly salary labels
      nameLabel = new JLabel("Hello: " + frame.getCurrentUser().getFirstName());

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
      add(nameLabel, positionConst);

//       positionConst.gridx = 1;
//       positionConst.gridy = 0;
//       positionConst.insets = new Insets(10, 10, 10, 10);
//       add(nameField, positionConst);
   }
   
   
}