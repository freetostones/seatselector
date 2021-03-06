public class FirstClass extends Seat {
 
  private double basePrice = 500.00;
  
  public FirstClass(int row, int column, String flightID){
    this.price = calculatePrice(row, column);
    this.row = row;
    this.column = column;
    this.booked = false;
    this.seatID = createSeatID(row, column);
    this.flightID = flightID;
    this.userID = "";
    this.variety = "First Class";
  }
  
  public double calculatePrice(int row, int column){
    double newPrice = 0.0;
    
    if(row <= 2){
      newPrice = basePrice + 50;
    }
    else
      newPrice = basePrice;
    
    return newPrice;
  }
  
  public double getPrice(){
    return this.price;
  }
  
  public int getRow(){
    return this.row;
  }
    
  public int getColumn(){
    return this.column;
  }
  
  public boolean isBooked(){
    return this.booked;
  }

  public void book(String userID){
    this.userID = userID;
    this.booked = true;
  }
  
  public String createSeatID(int column, int row){
    String id = "";
    int colNum = column + 1;
    
    switch(row){
      case 0: id = this.seatID = colNum + "A";
              break;
      case 1: id = this.seatID = colNum + "B";
              break;
      case 2: id = this.seatID = colNum + "C";
              break;
      case 3: id = this.seatID = colNum + "D";
              break;
      case 4: id = this.seatID = colNum + "E";
              break;
      case 5: id = this.seatID = colNum + "F";
              break;
    }
    return id;
  } 
  
  public String getSeatID() {
    return this.seatID;
  }
  
  public String getFlightID(){
    return this.flightID;
  }
  
  public String getUserID(){
    return this.userID;
  }
  
  public String getVariety(){
    return this.variety;
  }
  
  
}