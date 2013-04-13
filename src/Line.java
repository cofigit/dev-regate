
public class Line {
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

	//DŽclaration getters

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
	
	//DŽclaration setters
	
	public void setPosX(int pPosX){
		this.startX = pPosX;
	}
	
	public void setPosY(int pPosY) {
		this.endX = pPosY;
	}

}
