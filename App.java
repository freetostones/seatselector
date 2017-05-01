import javax.swing.JFrame;

public class App {
  public static void main(String[] args){

    SeatSelectFrame myFrame = new SeatSelectFrame();

    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.pack();
    myFrame.setSize(750,500);
    myFrame.setVisible(true);
    
  }
}