package game; 

import javax.swing.JOptionPane;

public class TakePinsGame {
    public static void main(String[] args) {
        JOptionPane d = new JOptionPane();
        UserInterface f = new UserInterface();
        boolean gameOn = true; 
        Board b = new Board();
        Player p2;

        Player p1 = new HumanPlayer(d.showInputDialog(null, "Vad ska du heta?"));
       int cChoice = f.askForInt(d.showInputDialog(null, "Vem vill du möta? Skriv 1 för dum dator, 2 för smart dator"));

       if (cChoice == 1){
        p2 = new ComputerPlayer("Dum Dator");
        d.showMessageDialog(null, "Du valde dumma datorn");
       }
       else{
        p2 = new BigBrainC("Smart Dator"); 
        d.showMessageDialog(null, "Du valde smarta datorn");
       }

        b.setUp(f.askForPins(d.showInputDialog(null, "Välj antal pinnar att spela med: ")));

        while (gameOn){

            p1.takePins(b);
            if(b.getNoPins() == 0 || b.getNoPins() < 0){
                gameOn = false; 
                d.showMessageDialog(null, "Grattis " + p1.getUserId() + " vann!");
            }
            else{
                p2.takePins(b);
                if(b.getNoPins() == 0 || b.getNoPins() < 0){
                    gameOn = false;
                    d.showMessageDialog(null, "onej... " + p2.getUserId() + " vann!");
                }
            }            
            


        }



	}
}