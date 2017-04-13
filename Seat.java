public abstract class Seat {
  protected double price;
  protected boolean booked;
  protected int row, column;
  protected String seatID;
  
  public abstract double calculatePrice(int column, int row);
  public abstract double getPrice();
  public abstract int getRow();
  public abstract int getColumn();
  public abstract boolean isBooked();
  public abstract void book();
  public abstract String getID(int column, int row);
  
}