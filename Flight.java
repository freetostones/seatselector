public class Flight {
  
  private String flightID, from, to;
  private Seat[][] seatsArray;
  private int totalFirstClassSeats, bookedFirstClassSeats, availableFirstClassSeats;
  private int totalEconomyClassSeats, bookedEconomyClassSeats, availableEconomyClassSeats;
  
  public Flight(String from, String to, int totalFirstClassSeats, int totalEconomyClassSeats){
    this.from = from;
    this.to = to;
    this.totalFirstClassSeats = totalFirstClassSeats;
    this.bookedFirstClassSeats = 0;
    this.availableFirstClassSeats = calculateAvailableFirstClassSeats(totalFirstClassSeats, bookedFirstClassSeats);
    this.totalEconomyClassSeats = totalEconomyClassSeats;
    this.bookedEconomyClassSeats = 0;
    this.availableEconomyClassSeats = calculateAvailableEconomyClassSeats(totalFirstClassSeats, bookedEconomyClassSeats);
    this.flightID = getFlightID(from, to);
    
    Seat[][] a = new Seat[8][6];
    
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 6; j++)
      {
        if(i < 4)
          a[i][j] = new FirstClass(i,j, flightID);
        else
          a[i][j] = new EconomyClass(i,j, flightID);
        
      }
    }
    
    this.seatsArray = a;
  }
  
  public Seat getSeat(String id) {
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 6; j++)
      {
        if(seatsArray[i][j].getSeatID().equals(id)) {
          return seatsArray[i][j];
        }
      }
    }
    return seatsArray[0][0];
  }
  
  public String getFrom(){
    return this.from;
  }
  
  public String getTo(){
    return this.to;
  }
  
  public int calculateAvailableFirstClassSeats(int totalFirstClassSeats, int bookedFirstClassSeats){
    return this.availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
  }
  
  public int getAvailableFirstClassSeats(){
    return this.availableFirstClassSeats;
  }
  
  public int calculateAvailableEconomyClassSeats(int totalEconomyClassSeats, int bookedEconomyClassSeats){
    return this.availableEconomyClassSeats = totalEconomyClassSeats - bookedEconomyClassSeats;
  }
  
  public int getAvailableEconomyClassSeats(){
    return this.availableEconomyClassSeats;
  }
  
  public String getFlightID(String from, String to){
    String departure = from.toLowerCase();
    String destination = to.toLowerCase();
    String id = "";
    
    if (departure.equals("chicago")) {
      id = this.flightID = "11";
    }
    else if (departure.equals("los angeles")) {
      id = this.flightID = "22";
    }
    else if (departure.equals("new york city")) {
      id = this.flightID = "33";
    }
    
    if (destination.equals("chicago")) {
      id = this.flightID += 11;
    }
    else if (destination.equals("los angeles")) {
      id = this.flightID += 22;
    }
    else if (destination.equals("new york city")) {
      id = this.flightID += 33;
    }
        
    return id;
  }
  
}