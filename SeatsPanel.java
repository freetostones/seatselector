import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

public class SeatsPanel extends JPanel
{
   private SeatSelectFrame frame;

   public SeatsPanel(SeatSelectFrame frame)
   { 
      this.frame = frame;
      GridBagConstraints positionConst = null;
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();
      
      for(int i = 0; i < 8; i++){
         for(int j = 0; j < 6; j++)
         {
           positionConst.gridx = j;
           positionConst.gridy = i;
           positionConst.insets = new Insets(10, 10, 10, 10);
           add(new JCheckBox(createSeatID(i,j)), positionConst);
         }
        }
      }
       
         public String createSeatID(int column, int row){
          String id = "";
          int colNum = column + 1;
          
          switch(row){
            case 0: id = colNum + "A";
                    break;
            case 1: id = colNum + "B";
                    break;
            case 2: id = colNum + "C";
                    break;
            case 3: id =  colNum + "D";
                    break;
            case 4: id =  colNum + "E";
                    break;
            case 5: id =  colNum + "F";
                    break;
          }
          return id;
        } 
        
         public ArrayList<String> getSelectedSeats() { 
            Component[] components = this.getComponents();
            ArrayList<String> array = new ArrayList<String>();
                  for (int i = 0; i < components.length; i++) {
                    JCheckBox cb = (JCheckBox) components[i];
                    if (cb.isSelected()) {
                        array.add(cb.getText());
                        cb.setEnabled(false);
                        }
                  }
                  return array;
         }
         
         public void bookSeats() { 
            Component[] components = this.getComponents();
            ArrayList<String> array = new ArrayList<String>();
                  for (int i = 0; i < components.length; i++) {
                    JCheckBox cb = (JCheckBox) components[i];
                    if (cb.isSelected()) {
                        frame.getSelectedFlight().getSeat(cb.getText()).book(frame.getCurrentUser().getUserID());
                        frame.getCurrentUser().updateSeats(frame.getSelectedFlight().getSeat(cb.getText()));
                        cb.setEnabled(false);
                        cb.setSelected(false);
                        }
                  }
                  return;
         }
         
         public void updatePanel() {
            Component[] components = this.getComponents();
            ArrayList<String> array = new ArrayList<String>();
                  for (int i = 0; i < components.length; i++) {
                    JCheckBox cb = (JCheckBox) components[i];
                    if (frame.getSelectedFlight().getSeat(cb.getText()).isBooked()) {
                        cb.setEnabled(false);
                        cb.setSelected(false);
                    }
                  }
                  return;
         }
}
