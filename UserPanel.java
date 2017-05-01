import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

public class UserPanel extends JPanel
{
   private SeatSelectFrame frame;
   private User currentUser;
   private JLabel nameLabel, instructionLabel, explanationLabel1, explanationLabel2;
   private ArrayList<JLabel> labelsArray;

   public UserPanel(SeatSelectFrame frame)
   {
      this.frame = frame;
      
      setLayout(new GridBagLayout());
      GridBagConstraints positionConst = new GridBagConstraints();
      positionConst.insets = new Insets(3, 3, 3, 3);
      
      currentUser = frame.getCurrentUser();
      
      nameLabel = new JLabel("Hello: " + currentUser.getFirstName());
      positionConst.gridx = 2;
      positionConst.gridy = 0;
      add(nameLabel, positionConst);
     
      double runningTotal = 0.0;
      
      if (currentUser.getSeatsBooked() == 0){
        instructionLabel = new JLabel("Please proceed to the Flights screen to begin the booking process.");
        positionConst.gridx = 2;
        positionConst.gridy = 1;
        add(instructionLabel, positionConst);
        
        explanationLabel1 = new JLabel("Once you have booked a seat, its details will appear below.");
        positionConst.gridx = 2;
        positionConst.gridy = 2;
        add(explanationLabel1, positionConst);
      }
      else if (currentUser.getSeatsBooked() != 0){
        explanationLabel2 = new JLabel("Your booked seat(s) appear below.");
        positionConst.gridx = 2;
        positionConst.gridy = 1;
        add(explanationLabel2, positionConst);
        
        labelsArray = new ArrayList<JLabel>();
        
        int l = 0;
        int y = 2;  
        
        while(y < ((currentUser.getBookedSeatsArray().size() * 2) + 2)){
          
          for(int i = 0; i < currentUser.getBookedSeatsArray().size(); i++){
            
            for(int j = 0; j < frame.getFlightsArray().size(); j++){
              
              if((frame.getFlightsArray().get(j).getFlightID().equals(currentUser.getBookedSeatsArray().get(i).getFlightID()))){
                
                JLabel flightID = new JLabel("Flight ID: " + currentUser.getBookedSeatsArray().get(i).getFlightID());
                labelsArray.add(flightID);
                JLabel departure = new JLabel("Departure: " + frame.getFlightsArray().get(j).getFrom());
                labelsArray.add(departure);
                JLabel destination = new JLabel("Destination: " + frame.getFlightsArray().get(j).getTo());
                labelsArray.add(destination);
                JLabel date = new JLabel("Date: " + frame.getFlightsArray().get(j).getDate());
                labelsArray.add(date);
                JLabel time = new JLabel("Time: " + frame.getFlightsArray().get(j).getTime());
                labelsArray.add(time);
                JLabel seatID = new JLabel("Seat ID: " + currentUser.getBookedSeatsArray().get(i).getSeatID());
                labelsArray.add(seatID);
                JLabel variety = new JLabel("Variety: " + currentUser.getBookedSeatsArray().get(i).getVariety());
                labelsArray.add(variety);
                JLabel price = new JLabel("Price: $" + currentUser.getBookedSeatsArray().get(i).getPrice());
                labelsArray.add(price);
                runningTotal += currentUser.getBookedSeatsArray().get(i).getPrice();
                JLabel total = new JLabel("Running Total: $" + runningTotal);
                labelsArray.add(total);
                
                positionConst.gridx = 0;
                positionConst.gridy = y;
                add(labelsArray.get(l), positionConst);
                l++;
                
                positionConst.gridx = 1;
                add(labelsArray.get(l), positionConst);
                l++;
                           
                positionConst.gridx = 2;
                add(labelsArray.get(l), positionConst);
                l++;
                           
                positionConst.gridx = 3;
                add(labelsArray.get(l), positionConst);
                l++;
                           
                positionConst.gridx = 4;
                add(labelsArray.get(l), positionConst);
                y++;
                l++;
               
                positionConst.gridx = 0;
                positionConst.gridy = y;
                add(labelsArray.get(l), positionConst);
                l++;
                           
                positionConst.gridx = 1;
                add(labelsArray.get(l), positionConst);
                l++;
                           
                positionConst.gridx = 2;
                add(labelsArray.get(l), positionConst);
                l++;
                
                positionConst.gridx = 3;
                add(labelsArray.get(l), positionConst);
                y++; 
                l++;
                
              }
            }
          }
        }
      }
   }
} 