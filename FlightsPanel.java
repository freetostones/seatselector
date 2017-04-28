import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class FlightsPanel extends JPanel
{
  private JLabel categoriesLabel; //flightIDLabel, departureLabel, destinationLabel, dateLabel, timeLabel;
  private JComboBox cBox;
  private SeatSelectFrame frame;
  
   public FlightsPanel(SeatSelectFrame frame)
   {
      GridBagConstraints positionConst = null;

      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();
      
     this.frame = frame;
     cBox = new JComboBox();
     cBox.setRenderer(new MyRenderer());
     cBox.addItemListener(new ItemListener() {
       @Override
       public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == ItemEvent.SELECTED) {
           String[] stringArray = (String[]) cBox.getSelectedItem();
           selectFlight(stringArray[0]);
           System.out.println(stringArray[0]);
           
         }
       }
     });
     
      //flightIDLabel = new JLabel("FLIGHT ID");
      //departureLabel = new JLabel("DEPARTURE");
      //destinationLabel = new JLabel("DESTINATION");
      //dateLabel = new JLabel("DATE");
      //timeLabel = new JLabel("TIME");
 
     categoriesLabel = new JLabel("FLIGHT ID        DEPARTURE    DESTINATION DATE             TIME                    ");
      
     positionConst.gridx = 0;
     positionConst.gridy = 0;
     positionConst.insets = new Insets(2, 2, 2, 2);
     this.add(categoriesLabel, positionConst);

     positionConst.gridx = 0;
     positionConst.gridy = 1;
     positionConst.insets = new Insets(2, 2, 2, 2);
     this.add(cBox, positionConst);

     frame.selectFlight("3311");
     Flight selectedFlight = frame.getSelectedFlight();
     cBox.addItem(new String[]{selectedFlight.getFlightID(), selectedFlight.getFrom(), 
       selectedFlight.getTo(), selectedFlight.getDate(), selectedFlight.getTime()});
     
     frame.selectFlight("1133");
     selectedFlight = frame.getSelectedFlight();
     cBox.addItem(new String[]{selectedFlight.getFlightID(), selectedFlight.getFrom(), 
       selectedFlight.getTo(), selectedFlight.getDate(), selectedFlight.getTime()});
     
     frame.selectFlight("2233");
     selectedFlight = frame.getSelectedFlight();
     cBox.addItem(new String[]{selectedFlight.getFlightID(), selectedFlight.getFrom(), 
       selectedFlight.getTo(), selectedFlight.getDate(), selectedFlight.getTime()});
     
     frame.selectFlight("3311");   
   }
   
   public void selectFlight(String flightID) {
      frame.selectFlight(flightID);
      return;
   }
   
   
   
}
     
   class MyRenderer extends JPanel implements ListCellRenderer
{
  JLabel[] label = new JLabel[5];
  public MyRenderer()
  {
    setLayout(new GridLayout(0,5));
    for(int x = 0; x < label.length; x++)
    {
      label[x] = new JLabel();
      add(label[x]);
    }
  }
  public Component getListCellRendererComponent(JList list, Object value,
                      int index, boolean isSelected, boolean cellHasFocus)
  {
    for(int x = 0; x < label.length; x++)
    {
      label[x].setText((String)((String[])value)[x]);
    }
    return this;
  }
}