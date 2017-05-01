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
   private User temporaryUser;
   private Flight selectedFlight, flight1, flight2, flight3;
   private Seat selectedSeat;
   private JPanel panel, buttons;
   private SignInPanel signInPanel;
   private SignUpPanel signUpPanel;
   private FlightsPanel flightsPanel;
   private SeatsPanel seatsPanel1;
   private SeatsPanel seatsPanel2;
   private SeatsPanel seatsPanel3;
   private HomePanel homePanel;
   private UserPanel userPanel;
   private JButton signInButton, signUpButton1, signUpButton2, signOutButton;
   private JButton flightsButton, seatsButton, back1, back2, home1, home2, home3, quit;
   private JFrame frame;
   
   SeatSelectFrame() {
      setTitle("Seat Selector");
     
      this.usersArray = new ArrayList<User>();
      this.temporaryUser = new User("Temporary", "User", "temporary.user", "password");
      this.usersArray.add(temporaryUser);
      setCurrentUser(this.temporaryUser);
      
      this.flightsArray = new ArrayList<Flight>();
      this.flight1 = new Flight ("New York City", "Chicago", "12/12/12", "11:00 AM");
      this.flightsArray.add(flight1);
      selectFlight("3311");
      
      this.flight2 = new Flight ("Chicago", "New York City", "11/11/11", "12:00 PM");
      this.flightsArray.add(flight2);
      
      this.flight3 = new Flight ("Los Angeles", "New York City", "10/10/10", "1:00 PM");
      this.flightsArray.add(flight3);
      
      signInButton = new JButton("Sign In");
      signUpButton1 = new JButton("Sign Up");
      signUpButton2 = new JButton("Sign Up");
      signOutButton = new JButton("Sign Out");
      flightsButton = new JButton("Select a Flight");
      seatsButton = new JButton("Select a Seat");
      back1 = new JButton("Back");
      back2 = new JButton("Back");
      home1 = new JButton("Book Seats");
      home2 = new JButton("Book Seats");
      home3 = new JButton("Book Seats");
      quit = new JButton("Quit");
      
      frame = new JFrame();
      
      ActionListener listener = new ButtonListener();
      
      signInButton.addActionListener(listener); 
      signUpButton1.addActionListener(listener);
      signUpButton2.addActionListener(listener);
      signOutButton.addActionListener(listener);
      flightsButton.addActionListener(listener);
      seatsButton.addActionListener(listener);
      back1.addActionListener(listener);
      back2.addActionListener(listener);
      home1.addActionListener(listener);
      home2.addActionListener(listener);
      home3.addActionListener(listener);
      quit.addActionListener(listener);
        
      buttons = new JPanel();
      
      buttons.add(quit);
      buttons.add(signInButton);
      buttons.add(signUpButton1);
      buttons.add(signUpButton2);
      buttons.add(signOutButton);
      buttons.add(back1);
      buttons.add(flightsButton);
      buttons.add(back2);
      buttons.add(seatsButton);
      buttons.add(home1);
      buttons.add(home2);
      buttons.add(home3);
      
      signUpButton2.setVisible(false);
      signOutButton.setVisible(false);
      flightsButton.setVisible(false);
      seatsButton.setVisible(false);
      back1.setVisible(false);
      back2.setVisible(false);
      home1.setVisible(false);
      home2.setVisible(false);
      home3.setVisible(false);
      quit.setVisible(false);
        
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      signInPanel = new SignInPanel(this);
      
      panel.add(buttons, BorderLayout.SOUTH);
      panel.add(signInPanel, BorderLayout.CENTER);
      
      this.getContentPane().add(panel);
 
      signUpPanel = new SignUpPanel(this);
      flightsPanel = new FlightsPanel(this);
      seatsPanel1 = new SeatsPanel(this);
      seatsPanel2 = new SeatsPanel(this);
      seatsPanel3 = new SeatsPanel(this);
      homePanel = new HomePanel(this);
      userPanel = new UserPanel(this);
      
      homePanel.add(userPanel);
   }

   public ArrayList<User> getUsersArray() {
      return this.usersArray;
   }
   
   public void setCurrentUser(String userID) {
       for(int i = 0; i < usersArray.size(); i++){
         if(userID.equals(usersArray.get(i).getUserID())) {
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
   
   public void updateUserPanel(){
     homePanel.remove(userPanel);
     userPanel = new UserPanel(this);
     homePanel.add(userPanel);
   }       
   
   public ArrayList<Flight> getFlightsArray() {
      return this.flightsArray;
   }
   
   class ButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent event)
        {
          if (event.getSource() == signInButton && signInPanel.checkFields() && signInPanel.checkSignIn()) {
            panel.remove(signInPanel);
            panel.remove(signUpPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            panel.add(homePanel, BorderLayout.CENTER);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            signInPanel.signIn();
            updateUserPanel();
            signInPanel.clear();
          }
          else if(event.getSource() == signInButton && signInPanel.checkFields() == false){
            JOptionPane.showMessageDialog(frame, "Please fill in the Username and Password fields.");
          }
          else if(event.getSource() == signInButton && signInPanel.checkSignIn() == false){
            JOptionPane.showMessageDialog(frame, "That Username and Password do not exist.");
          }
          else if (event.getSource() == signUpButton1){
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
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
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            signInPanel.clear();
          }
          else if (event.getSource() == signUpButton2 && signUpPanel.checkFields()){
            panel.remove(signInPanel);
            panel.remove(signUpPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            signUpPanel.createUser();
            signUpPanel.clear();
            updateUserPanel();
            panel.add(homePanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == signUpButton2 && signUpPanel.checkFields() == false){
            JOptionPane.showMessageDialog(frame, "Please fill in the First Name, Last Name, Username, and Password fields.");
          }
          else if (event.getSource() == signOutButton){
            panel.remove(signUpPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            panel.remove(homePanel);
            panel.add(signInPanel, BorderLayout.CENTER);
            quit.setVisible(true);
            signInButton.setVisible(true);
            signUpButton1.setVisible(true);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
          }
          else if(event.getSource() == flightsButton){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            panel.remove(homePanel);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(true);
            back1.setVisible(true);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(flightsPanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == seatsButton && (selectedFlight.getFlightID().equals(flight1.getFlightID()))){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(homePanel);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(true);
            home1.setVisible(true);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(seatsPanel1, BorderLayout.CENTER);
          }
          else if(event.getSource() == seatsButton && (selectedFlight.getFlightID().equals(flight2.getFlightID()))){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(homePanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(true);
            home1.setVisible(false);
            home2.setVisible(true);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(seatsPanel2, BorderLayout.CENTER);
          }      
          else if(event.getSource() == seatsButton && (selectedFlight.getFlightID().equals(flight3.getFlightID()))){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(homePanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(true);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(true);
            quit.setVisible(false);
            panel.add(seatsPanel3, BorderLayout.CENTER);
          } 
          else if(event.getSource() == back1){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            updateUserPanel();
            panel.add(homePanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == back2){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(homePanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(false);
            flightsButton.setVisible(false);
            seatsButton.setVisible(true);
            back1.setVisible(true);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(flightsPanel, BorderLayout.CENTER);
          }
          else if(event.getSource() == home1){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(homePanel, BorderLayout.CENTER);
            seatsPanel1.bookSeats();
            seatsPanel1.updatePanel();
            updateUserPanel();
          }
          else if(event.getSource() == home2){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(homePanel, BorderLayout.CENTER);
            seatsPanel2.bookSeats();
            seatsPanel2.updatePanel();
            updateUserPanel();
          }
          else if(event.getSource() == home3){
            panel.remove(signUpPanel);
            panel.remove(signInPanel);
            panel.remove(flightsPanel);
            panel.remove(seatsPanel1);
            panel.remove(seatsPanel2);
            panel.remove(seatsPanel3);
            signInButton.setVisible(false);
            signUpButton1.setVisible(false);
            signUpButton2.setVisible(false);
            signOutButton.setVisible(true);
            flightsButton.setVisible(true);
            seatsButton.setVisible(false);
            back1.setVisible(false);
            back2.setVisible(false);
            home1.setVisible(false);
            home2.setVisible(false);
            home3.setVisible(false);
            quit.setVisible(false);
            panel.add(homePanel, BorderLayout.CENTER);
            seatsPanel3.bookSeats();
            seatsPanel3.updatePanel();
            updateUserPanel();
          }
          else if (event.getSource() == quit) {
            System.exit(0);
          }
          panel.validate();
          panel.repaint();
          panel.revalidate();
        }
      }

}