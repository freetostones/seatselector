public class SeatSelect {
  public static void main(String[] args){
    FirstClass seat1 = new FirstClass(0,0);
    EconomyClass seat2 = new EconomyClass(1,0);
    
    System.out.println("First Class Price: " + seat1.getPrice());
    System.out.println("First Class Booking: " + seat1.isBooked());
    seat1.book();
    System.out.println("First Class Booking: " + seat1.isBooked());
    System.out.println("First Class Row: " + seat1.getRow());
    System.out.println("First Class Column: " + seat1.getColumn());
    System.out.println("First Class Seat ID: " + seat1.getID(seat1.getColumn(), seat1.getRow()));
    
    System.out.println("Economy Class Price: " + seat2.getPrice());
    System.out.println("Economy Class Booking: " + seat2.isBooked());
    seat2.book();
    System.out.println("Economy Class Booking: " + seat2.isBooked());
    System.out.println("Economy Class Row: " + seat2.getRow());
    System.out.println("Economy Class Column: " + seat2.getColumn());
    System.out.println("Economy Class Seat ID: " + seat2.getID(seat2.getColumn(), seat2.getRow()));
  }
}