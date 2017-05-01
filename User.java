import java.util.ArrayList;

public class User {
  
  private String firstName, lastName, userID, password;
  private ArrayList<Seat> bookedSeatsArray;
  private int seatsBooked;

    public User(String firstName, String lastName, String userID, String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.userID = userID;
    this.password = password;
    this.bookedSeatsArray = new ArrayList<Seat>();
    this.seatsBooked = 0;
  }
    
    public void updateSeats(Seat seat){
      bookedSeatsArray.add(seat);
      this.seatsBooked++;
    }
    
    public ArrayList<Seat> getBookedSeatsArray(){
      return bookedSeatsArray;
    }
    
    public String getFirstName() {
      return this.firstName;
    }
        
    public String getLastName() {
      return this.lastName;
    }
    
    public String getUserID() {
      return this.userID;
    }
    
    public String getPassword() {
      return this.password;
    }
    
    public int getSeatsBooked() {
      return this.seatsBooked;
    }

}