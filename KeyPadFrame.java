//********************************************************************
//  KeyPadFrame.java       Author: Daniel Luzarraga
//
//  
//********************************************************************

import javax.swing.JFrame;

public class KeyPadFrame
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Numeric Keypad");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new KeyPadPanel());
      frame.pack();
      frame.setVisible(true);
   }
}
