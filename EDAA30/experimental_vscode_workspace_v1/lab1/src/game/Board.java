package game;

public class Board {
    private int noPins;

    public void setUp(int a){
        noPins = a; 
    }

    public void takePins(int a){
        noPins = noPins - a; 
    }

    public int getNoPins(){
        return noPins; 
    }
}
