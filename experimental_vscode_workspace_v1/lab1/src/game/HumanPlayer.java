package game;

import javax.swing.JOptionPane;

public class HumanPlayer extends Player{
    UserInterface f = new UserInterface();
    JOptionPane d = new JOptionPane();
    HumanPlayer(String userID){
		super(userID);
	}

    public int takePins(Board b){
        int n = 0;

        //Checkar så det är över 1 pinne kvar på bordet. Annars plockas bara 1 pinne 
        if(b.getNoPins() > 1){
            n = f.askForInt(d.showInputDialog(null, "Din tur! Vänligen välj 1 eller 2 pinnar"));
        }
        
        else if (b.getNoPins() == 1){
            b.takePins(1);
           // d.showMessageDialog(null, "Du plockade 1 pinne!");
        }
        
        while(!(n == 1 || n == 2) && b.getNoPins() > 0 ){
            n = f.askForInt(d.showInputDialog(null, "VÄLJ ENDAST 1 ELLER 2!!!"));
        }

        b.takePins(n);
        d.showMessageDialog(null, "Antal pinnar kvar: " + b.getNoPins());

        return b.getNoPins();
    }



}
