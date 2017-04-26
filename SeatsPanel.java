import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

public class SeatsPanel extends JPanel
{
   public SeatsPanel(SeatSelectFrame frame)
   { 
      GridBagConstraints positionConst = null;
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();
      
      for(int i = 0; i < 8; i++){
         for(int j = 0; j < 6; j++)
         {
            if(j > 2) { 
               positionConst.gridx = j + 1;
            }
            else {
               positionConst.gridx = j;
            }
            
            if(i > 3) { 
               positionConst.gridy = i + 1;
            }
            else {
               positionConst.gridy = i;
            }
            
            
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
            ArrayList<Component> components = new ArrayList<Component>();
            components = this.getComponents; 
            // Component[] components = this.getComponents();
            ArrayList<String> array = new ArrayList<String>();
                  for (int i = 0; i < components.size(); i++) {
                    // JCheckBox cb = (JCheckBox) components[i];
                    JCheckBox cb = (JCheckBox) components.get(i);
                    if (cb.isSelected())
                        array.add(cb.getName());
                  }
                  return array;
         }
}
