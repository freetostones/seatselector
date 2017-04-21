import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.*;


public class SeatSelectFrame extends JFrame  {

   private ArrayList<Flight> flightsArray;
   private ArrayList<User> usersArray;
   private User currentUser;
   private Flight selectedFlight;
   private Seat selectedSeat;
 
    
   SeatSelectFrame() {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set frame's title
      setTitle("Seat Selector");
      
      SignInPanel signUpFrame = new SignInPanel(this);
      this.getContentPane().add(signUpFrame);
     
      this.usersArray = new ArrayList<User>();
      
      this.flightsArray = new ArrayList<Flight>();
      Flight flight = new Flight ("Chicago", "Los Angeles");
      flightsArray.add(flight);
   /* Method is automatically called when an event 
      occurs (e.g, button is pressed) */
//     @Override
//     public void actionPerformed(ActionEvent event) {
//    String firstNameInput = ""; 
//        String lastNameInput = ""; 
//        String userNameInput = ""; 
//        String passwordInput = ""; 
//  
//        firstNameInput = firstNameField.getText();
//        lastNameInput = lastNameField.getText();
//        userNameInput = userNameField.getText();
//        passwordInput = passwordField.getText();
//       
//        firstNameLabel.setVisible(false);
// // //       lastNameLabel.setVisible(false);
// // //       userNameLabel.setVisible(false);
// // //       passwordLabel.setVisible(false);
// // //       
// // //       User user = new User(firstNameInput, lastNameInput, userNameInput, passwordInput);
// // // 
// // // // 
//       return;
//   }
   }

   public void createUser(String firstName, String lastName, String userName, String password) {
      User user = new User(firstName, lastName, userName, password);
      usersArray.add(user);
       for(int i = 0; i < usersArray.size(); i++){
         System.out.print(usersArray.get(i).getFirstName() + " ");
      }
   
      return;
   }
   
   public void selectFlight(String flightID) {
      for(int i = 0; i < flightsArray.size(); i++){
         if(flightID == flightsArray.get(i).getFlightID()) {
            this.selectedFlight = flightsArray.get(i);
         }
      }
      return;
   }
   
   public Flight getSelectedFlight() {
      return this.selectedFlight;
   }
   
   public Seat selectSeat(String seatID) {
      return getSelectedFlight().getSeat(seatID);
   }
   
   public Seat getSelectedSeat() {
      return this.selectedSeat;
   }
   
   public void bookSeat(String userID) {
      getSelectedSeat().book(userID);
   
      return;
   }
}


///////////
// Make button book seat using new method in SeatSelectFrame
// Or add user to SeatSelectFrame usersArray using button