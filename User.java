public class User {
  
  private String firstName, lastName, userID, password;
  private Seat[] seatsArray;
  private int seatsBooked;

    public User(String firstName, String lastName, String userID, String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.userID = userID;
    this.password = password;
    this.seatsArray = new Seat[5];
    this.seatsBooked = 0;
  }
    
    public void updateSeats(Seat seat){
      
      Seat[] tempArray;
      
      if(seatsBooked == seatsArray.length){
        tempArray = new Seat[this.seatsArray.length * 2];
        for (int i=0;i<this.seatsArray.length;i++) {
          tempArray[i] = this.seatsArray[i];
          
        }
        this.seatsArray = tempArray;
      }
      seatsArray[this.seatsBooked] = seat;
      this.seatsBooked++;
    }
    
    public String getUserID() {
      return this.userID;
    }
    
    public void printSeats(){
      for(int i = 0; i < this.seatsArray.length; i++){
        System.out.println(this.seatsArray[i].getSeatID());
       }
    }
   
      
  
}