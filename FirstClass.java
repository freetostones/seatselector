public class FirstClass extends Seat {
  public FirstClass(int row, int column){
    this.price = getPrice(row, column);
    this.booked = false;
    this.row = row;
    this.column = column;
    this.seatID = getID(row, column);
  }
}