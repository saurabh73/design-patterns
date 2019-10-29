// How the Decorator Design Pattern works:
// + The DrawingBoard object is wrapped by the DrawHouse, DrawTree and DrawRiver objects
// successively.
// + Calling the printDescription() method unwraps the picture description bottom up
// from the DrawingBoard to the DrawRiver object.

public class DrawingBoard {
	
	public String printDescription() {
		return "This is a picture on the Drawing Board";
	}
	
	public static void main(String[] args)
	{
		DrawingBoard d1 = new DrawingBoard();
		
		d1 = new DrawHouse(d1);
		d1 = new DrawTree(d1);
		d1 = new DrawRiver(d1);
		
		System.out.println(d1.printDescription());
	}
}

abstract class DrawingBoardAdapter extends DrawingBoard {
	public abstract String printDescription() ;
}
 
class DrawTree extends DrawingBoardAdapter
{
	DrawingBoard drawingboard;
	
	public DrawTree(DrawingBoard d) {
		drawingboard  = d;
	}
 
	public String printDescription() {
		return (drawingboard.printDescription()  + " with a Mangoo Tree");
	}
}

class DrawHouse extends DrawingBoardAdapter
{
	DrawingBoard drawingboard;
	
	public DrawHouse (DrawingBoard d) {
		drawingboard  = d;
	}
 
	public String printDescription() {
		return (drawingboard.printDescription()  + " of a small house");
	}
}
 
class DrawRiver extends DrawingBoardAdapter
{
	DrawingBoard drawingboard;
	
	public DrawRiver (DrawingBoard d) {
		drawingboard  = d;
	}
 
	public String printDescription() {
		return (drawingboard.printDescription()  + " and flowing river.");
	}
}
