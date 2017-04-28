import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SeatSelect {
  public static void main(String[] args){
  
    User user1 = new User("Bob", "Smith", "Bob101", "password");
  
    SeatSelectFrame myFrame = new SeatSelectFrame();

    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.pack();
    myFrame.setSize(700,500);
    myFrame.setVisible(true);
   
    //Flight flight1 = new Flight ("Chicago", "Los Angeles");
    
    User currentUser = user1;
//     System.out.println("User's First Name: " + currentUser.getFirstName());
//     System.out.println("User's Last Name: " + currentUser.getLastName());
//     System.out.println("User's User ID: " + currentUser.getUserID());
//     System.out.println("User's Password: " + currentUser.getPassword() + "\n");
//     
//     Flight selectedFlight = flight1;
//     System.out.println("Flights's Flight ID: " + selectedFlight.getFlightID());
//     System.out.println("Flight's Departure: " + selectedFlight.getFrom());
//     System.out.println("Flight's Destination: " + selectedFlight.getTo() + "\n");
//     
//     Seat selectedSeat = selectedFlight.getSeat("1A");
//     System.out.println("Seat's Flight ID: " + selectedSeat.getFlightID());
//     System.out.println("Seat's Seat ID: " + selectedSeat.getSeatID());
//     System.out.println("Seat's Row: " + selectedSeat.getRow());
//     System.out.println("Seat's Column: " + selectedSeat.getColumn());
//     System.out.println("Seat's Price: " + selectedSeat.getPrice());
//     System.out.println("Seat's Booking Status before Booking: " + selectedSeat.isBooked());
//     System.out.println("Seat's User ID before Booking: " + selectedSeat.getUserID() + "\n");
// 
//     selectedSeat.book(currentUser.getUserID());
//     System.out.println("Seat's Booking Status after Booking: " + selectedSeat.isBooked());
//     System.out.println("Seat's User ID after Booking: " + selectedSeat.getUserID() + "\n");
//     
//     currentUser.updateSeats(selectedSeat);
//     System.out.print("Seats Booked by Current User, " + selectedSeat.getUserID() + ", include: ");
//     currentUser.printSeats(); 
  }
}