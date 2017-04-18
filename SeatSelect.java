public class SeatSelect {
  public static void main(String[] args){
    
    User user1 = new User("Bob", "Smith", "Bob101", "password");
    
    Flight flight1 = new Flight ("Chicago", "Los Angeles", 18, 18);
    User currentUser = user1;
    Flight selectedFlight = flight1;
    Seat selectedSeat = selectedFlight.getSeat("D1"); 
    System.out.println(selectedSeat.isBooked());
    selectedSeat.book(currentUser.getUserID());
    System.out.println(selectedSeat.isBooked());
    currentUser.updateSeats(selectedSeat);
    currentUser.printSeats(); 
  }
}