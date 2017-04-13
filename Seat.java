public abstract class Seat {
  protected double price;
  protected boolean booked;
  protected int row, column;
  protected String seatID;
  
  public int getPrice();
  public boolean isBooked();
  public void book();
  public String toString();
  public String getID();
  
}