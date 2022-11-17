package game;

import java.util.Random;
import javax.swing.JOptionPane;

public class ComputerPlayer extends Player {
    Random rand = new Random();
    JOptionPane d = new JOptionPane();
    ComputerPlayer(String userID){
        super(userID);
    }

    public int takePins(Board b){

        int a = rand.nextInt(2) + 1;

        if(b.getNoPins() > 1){
            b.takePins(a);
            d.showMessageDialog(null, userID + " valde: " + a + "pinnar");
        }
        
        else if(b.getNoPins() == 1){
            b.takePins(1);
            d.showMessageDialog(null, userID +  " plockade 1 pinne!");
        }
        
        return b.getNoPins();
        
    }
}
