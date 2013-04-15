
public class Line {
	// Line is used to define lines in the field
	// We will implement a method to check if a boat
	// has passed the line.
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	
	//Contructeur par default
	
	public Line(int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		
	}

	//D�claration getters

	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	
	public int getEndX() {
		return endX;
	}
	
	public int getEndY() {
		return endY;
	}
	
	//D�claration setters
	
	public void setPosX(int pPosX){
		this.startX = pPosX;
	}
	
	public void setPosY(int pPosY) {
		this.endX = pPosY;
	}

}
