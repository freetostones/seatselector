import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class SeatSelectFrame extends JFrame{

   private ArrayList<Flight> flightsArray;
   private ArrayList<User> usersArray;
   private User currentUser;
   private User testUser;
   private Flight selectedFlight;
   private Flight testFlight;
   private Seat selectedSeat;
   private JPanel panel, buttons;
   private SignInPanel signInPanel;
   private SignUpPanel signUpPanel;
   private FlightsPanel flightsPanel;
   private SeatsPanel seatsPanel;
   private HomePanel homePanel;
   private JButton signInButton, signUpButton1, signUpButton2, signOutButton;   // Sends to sign up page
   private JButton flightsButton, seatsButton, back1, back2, home;   // Sends to sign up page
   
   SeatSelectFrame() {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;
      
      // Set frame's title
      setTitle("Seat Selector");
     
      this.usersArray = new ArrayList<User>();
      this.testUser = new User("Test", "User", "testuser", "password");
      this.usersArray.add(testUser);
      setCurrentUser(this.testUser);
      
      this.flightsArray = new ArrayList<Flight>();
      this.testFlight = new Flight ("Chicago", "Los Angeles");
      this.flightsArray.add(testFlight);
      selectFlight("1122");
      
      this.flightsArray = new ArrayList<Flight>();
      Flight flight = new Flight ("Chicago", "Los Angeles");
      flightsArray.add(flight);
      
      // Create a "Sign In" button
      signInButton = new JButton("Sign In");
      signUpButton1 = new JButton("Sign Up");
      signUpButton2 = new JButton("Sign Up");
      signOutButton = new JButton("Sign Out");
      flightsButton = new JButton("Select a Flight");
      seatsButton = new JButton("Select a Seat");
      back1 = new JButton("Back1");
      back2 = new JButton("Back2");
      home = new JButton("Book Seats");
      
      ActionListener listener = new ButtonListener();
      
      signInButton.addActionListener(listener); 
      signUpButton1.addActionListener(listener);
      signUpButton2.addActionListener(listener);
      signOutButton.addActionListener(listener);
      flightsButton.addActionListener(listener);
      seatsButton.addActionListener(listener);
      back1.addActionListener(listener);
      back2.addActionListener(listener);
      home.addActionListener(listener);
      
      buttons = new JPanel();
      
      buttons.add(signInButton);
      buttons.add(signUpButton1);
      buttons.add(signUpButton2);
      buttons.add(signOutButton);
      buttons.add(back1);
      buttons.add(flightsButton);
      buttons.add(back2);
      buttons.add(seatsButton);
      buttons.add(home);
      
      signUpButton2.setVisible(false);
      signOutButton.setVisible(false);
      flightsButton.setVisible(false);
      seatsButton.setVisible(false);
      back1.setVisible(false);
      back2.setVisible(false);
      home.setVisible(false);
        
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      signInPanel = new SignInPanel(this);
      
      panel.add(buttons, BorderLayout.SOUTH);
      panel.add(signInPanel, BorderLayout.CENTER);
      
      this.getContentPane().add(panel);
 
      signUpPanel = new SignUpPanel(this);
      flightsPanel = new FlightsPanel(this);
      seatsPanel = new SeatsPanel(this);
      homePanel = new HomePanel(this);
   }

  //  public void createUser(String firstName, String lastName, String userName, String password) {
//       User user = new User(firstName, lastName, userName, password);
//       usersArray.add(user);
//        for(int i = 0; i < usersArray.size(); i++){
//          System.out.print(usersArray.get(i).getFirstName() + " ");
//       }
//    
//       return;
//    }
   
   public ArrayList<User> getUsersArray() {
      return this.usersArray;
   }
   
   public void setCurrentUser(String userID) {
       for(int i = 0; i < usersArray.size(); i++){
         if(userID == usersArray.get(i).getUserID()) {
            this.currentUser = usersArray.get(i);
         }
      }
      return;
   }
   
   public User getCurrentUser() {
      return this.currentUser;
   }
   
   public void setCurrentUser(User user) {
      this.currentUser = user;
      return;
   }
   
   public void selectFlight(String flightID) {
      for(int i = 0; i < flightsArray.size(); i++){
         if(flightID.equals(flightsArray.get(i).getFlightID())) {
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
   
   class ButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent event)
        {
          if (event.getSource() == signInButton) {
            panel.remove(signInPanel);
            panel.remove(signUpPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            panel.add(homePanel, BorderLayout.CENTER);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home.setVisible(false);
            signInPanel.signIn();
            signInPanel.clear();
          }
          else if (event.getSource() == signUpButton1){
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            panel.remove(homePanel);
            panel.add(signUpPanel, BorderLayout.CENTER);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(true);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home.setVisible(false);
            signInPanel.clear();
          }
          else if (event.getSource() == signUpButton2){
            panel.remove(signInPanel);
            panel.remove(signUpPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            panel.add(homePanel, BorderLayout.CENTER);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home.setVisible(false);
            signUpPanel.clear();
          }
          else if (event.getSource() == signOutButton){
            panel.remove(signUpPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            panel.remove(homePanel);
            panel.add(signInPanel, BorderLayout.CENTER);
            signInButton.setVisible(true);
            signUpButton1.setVisible(true);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home.setVisible(false);
          }
          else if(event.getSource() == flightsButton){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(seatsPanel);
            panel.remove(homePanel);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(true);
            back1.setVisible(true);
            back2.setVisible(false);
            home.setVisible(false);
            panel.add(flightsPanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == seatsButton){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(homePanel);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(true);
            home.setVisible(true);
            panel.add(seatsPanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == back1){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home.setVisible(false);
            panel.add(homePanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == back2){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(true);
            back1.setVisible(true);
            back2.setVisible(false);
            home.setVisible(false);
            panel.add(homePanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == home){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home.setVisible(false);
            panel.add(homePanel, BorderLayout.CENTER);
            
            seatsPanel.bookSeats();
            seatsPanel.updatePanel();
//            ArrayList<String> array = seatsPanel.getSelectedSeats();
//            for(int i = 0; i < array.size(); i++){
//               System.out.println(array.get(i));
              //  Flight flight = getSelectedFlight();
//                Seat seat = flight.getSeat(array.get(i));
//                seat.book(currentUser.getUserID());
//            }
            
            
            
          }
          validate();
          repaint();
          

          //String passwordInput = ""; 
          
          //userNameInput = userNameField.getText();
          //passwordInput = passwordField.getText();
          
          //return;
        }
      }

}
///////////
// Make button book seat using new method in SeatSelectFrame
// Or add user to SeatSelectFrame usersArray using button