package game; 
import javax.swing.JOptionPane;

public class BigBrainC extends Player {

    BigBrainC(String userID){
        super(userID);
    }

    public int takePins(Board b){
        JOptionPane d = new JOptionPane();

        if ((b.getNoPins() % 2 == 0) && (b.getNoPins() >= 0) && (b.getNoPins() != 2)){
            b.takePins(2);
            d.showMessageDialog(null, userID + " valde att plocka 2 st pinnar");
            d.showMessageDialog(null, "Antal pinnar kvar: " + b.getNoPins());
        }
        else {
            b.takePins(1);
            d.showMessageDialog(null, userID + " Valde att plocka 1 st pinnar");
            d.showMessageDialog(null, "Antal pinnar kvar: " + b.getNoPins());
        }

        return b.getNoPins();
        
    }
}