package mountain;

import fractal.TurtleGraphics;
import fractal.Fractal;

public class Mountain extends Fractal  {
    private int length;

    public Mountain(int length) {
		super();
		this.length = length;
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
    @Override
	public String getTitle() {
		return "Mountain";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
    @Override
	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0, turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
        Point a = new Point((int) turtle.getX(), (int) turtle.getX());
        //Point a = new Point(150, 121);
        Point b = new Point(295, 222);
        Point c = new Point(445, 480);
        fractalMountain(turtle, order, length, a, b, c);
	}

	/* 
	 * Reursive method: Draws a recursive line of the triangle. 
	 */
	private void fractalMountain(TurtleGraphics turtle, int order, double length, Point a, Point b, Point c) {
		if (order == 0) {
			//"rita en linje med längden length och riktningen alpha"
            turtle.moveTo(a.getX(),a.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(a.getX(), a.getY());
			} else {
			
			}
			
	}

    private void createPoint(){

    }
}
