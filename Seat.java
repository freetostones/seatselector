public abstract class Seat {
  protected double price;
  protected int row, column;
  protected boolean booked;
  protected String seatID;
  protected String flightID; 
  protected String userID;
  
  public abstract double calculatePrice(int column, int row);
  public abstract double getPrice();
  public abstract int getRow();
  public abstract int getColumn();
  public abstract boolean isBooked();
  public abstract void book(String userID);
  public abstract String createSeatID(int column, int row);
  public abstract String getSeatID();
  public abstract String getFlightID();
  public abstract String getUserID();
}