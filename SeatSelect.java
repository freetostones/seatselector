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
    System.out.println("Economy Class Seat ID: " + seat2.getID(seat2.getColumn(), seat2.getRow())  + "\n");
    
    
    Seat[][] a = new Seat[8][6];
    
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 6; j++)
      {
        if(i < 4)
          a[i][j] = new FirstClass(i,j);
        else
          a[i][j] = new EconomyClass(i,j);
        
      }
    }
    
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 6; j++)
      {
        System.out.println("Seat ID: " + a[i][j].getID(a[i][j].getColumn(), a[i][j].getRow()));
        System.out.println("Price: " + a[i][j].getPrice());
        System.out.println("Booking Status: " + a[i][j].isBooked());
        a[i][j].book();
        System.out.println("Booking Status: " + a[i][j].isBooked());
        System.out.println("Row: " + a[i][j].getRow());
        System.out.println("Column: " + a[i][j].getColumn() + "\n");
      }
    }
    
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 6; j++)
      {
        System.out.print(a[i][j].getID(a[i][j].getColumn(), a[i][j].getRow()) + "\t");
      }
      System.out.println("\n");
    }
    
    
    
  }
}