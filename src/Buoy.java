
public class Buoy {
	private int posX;
	private int posY;
	
	
	//Contructeur par default
	
	public Buoy(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	//D�claration getters
	
	public int getPosX() {
		return posX;
	}
	
	
	public int getPosY() {
		return posY;
	}
	
	//D�claration setters
	
	public void setPosX(int pPosX){
		this.posX = pPosX;
	}
	
	public void setPosY(int pPosY) {
		this.posY = pPosY;
	}

}
