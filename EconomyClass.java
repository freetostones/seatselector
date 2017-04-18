public class EconomyClass extends Seat {
    
  private double basePrice = 200.00;
  
  public EconomyClass(int row, int column, String flightID){
    this.row = row;
    this.column = column;
    this.price = calculatePrice(row, column);
    this.booked = false;
    this.seatID = createSeatID(row, column);
    this.flightID = flightID;
  }
  
  public int getRow(){
    return this.row;
  }
    
  public int getColumn(){
    return this.column;
  }
  
  public double getPrice(){
    return this.price;
  }
  
  public double calculatePrice(int row, int column){
    double newPrice = 0.0;
    
    if(row <= 6){
      newPrice = basePrice + 50;
    }
    else
      newPrice = basePrice;
    
    return newPrice;
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
    int rowNum = row + 1;
    
    switch(column){
      case 0: id = this.seatID = "A" + rowNum;
              break;
      case 1: id = this.seatID = "B" + rowNum;
              break;
      case 2: id = this.seatID = "C" + rowNum;
              break;
      case 3: id = this.seatID = "D" + rowNum;
              break;
      case 4: id = this.seatID = "E" + rowNum;
              break;
      case 5: id = this.seatID = "F" + rowNum;
              break;
    }
    return id;
  } 
  
  public String getSeatID() {
    return this.seatID;
  }
  
}