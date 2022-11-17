package game;
import javax.swing.JOptionPane;


public class UserInterface {
    UserInterface(){

    }
    
/** Visar en dialogruta med texten msg. */
public static void printMessage(String msg) {
    JOptionPane.showMessageDialog(null, msg);
    }


    /**
    * Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
    * användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
    * returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
    */

    public static int askForInt(String msg) {
    // din egen kod
        JOptionPane d = new JOptionPane();

        while(true) {
            try {
                int n = Integer.parseInt(msg);
                if (!(n == 1 || n == 2)){
                    d.showMessageDialog(null, "Fel input", "Error", d.ERROR_MESSAGE );
                    msg = d.showInputDialog("Vänligen välj 1 eller 2, ENDAST!");
                }

                return n;
            }

            catch(Exception e) {
                if(msg == null) {
                    d.showMessageDialog(null, "Avslutas", "Cancel", d.ERROR_MESSAGE);
                    System.exit(0);
                }
                d.showMessageDialog(null, "Fel input", "Error", d.ERROR_MESSAGE );
                msg = d.showInputDialog("Vänligen välj 1 eller 2, ENDAST!");
            }
          // d.showMessageDialog(null, "Fel input", "Error", d.ERROR_MESSAGE );
           // msg = d.showInputDialog("Vänligen välj 1 eller 2, ENDAST!");

        }

        /*if(msg == null) {
			d.showMessageDialog(null, "Avslutas", "Cancel", d.ERROR_MESSAGE);
			System.exit(0);
		}*/
        
        //return Integer.parseInt(msg);
    }

    public static int askForPins(String msg) {
        // din egen kod
            JOptionPane d = new JOptionPane();
    
            while(true) {
                try {
                    int n = Integer.parseInt(msg);
                    if ( n < 0){
                        d.showMessageDialog(null, "Fel input", "Error", d.ERROR_MESSAGE );
                        msg = d.showInputDialog("Vänligen välj ett posetivt tal");
                    }

                    else  {
                        return n; 
                    }
                }
    
                catch(Exception e) {
                    if(msg == null) {
                        d.showMessageDialog(null, "Avslutas", "Cancel", d.ERROR_MESSAGE);
                        System.exit(0);
                    }
                    d.showMessageDialog(null, "Fel input", "Error", d.ERROR_MESSAGE );
                    msg = d.showInputDialog("Vänligen välj ett posetivt tal");
                }
              // d.showMessageDialog(null, "Fel input", "Error", d.ERROR_MESSAGE );
               // msg = d.showInputDialog("Vänligen välj 1 eller 2, ENDAST!");
    
            }
    
            /*if(msg == null) {
                d.showMessageDialog(null, "Avslutas", "Cancel", d.ERROR_MESSAGE);
                System.exit(0);
            }*/
            
            //return Integer.parseInt(msg);
        }
    
    
}
