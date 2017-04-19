public class Flight {
  
  private String flightID, from, to;
  private Seat[][] seatsArray;
  
  public Flight(String from, String to){
    this.from = from;
    this.to = to;
    this.flightID = calculateFlightID(from, to);
    
    Seat[][] a = new Seat[8][6];
    
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 6; j++)
      {
        if(i < 3)
          a[i][j] = new FirstClass(i,j, flightID);
        else
          a[i][j] = new EconomyClass(i,j, flightID);
      }
    }
    
    this.seatsArray = a;
  }
  
  public String calculateFlightID(String from, String to){
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
  
  public String getFlightID(){
    return this.flightID;
  }
  
  public String getFrom(){
    return this.from;
  }
  
  public String getTo(){
    return this.to;
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
  
}