
public class Buoy {
	private int posX;
	private int posY;
	int buoyNumber;
	
	
	//Contructeur par default
	
	public Buoy(int posX, int posY, int buoyNumber) {
		this.posX = posX;
		this.posY = posY;
		this.buoyNumber = buoyNumber;
	}
	
	//Déclaration getters
	
	public int getPosX() {
		return posX;
	}
	
	
	public int getPosY() {
		return posY;
	}
	
	//Déclaration setters
	
	public void setPosX(int pPosX){
		this.posX = pPosX;
	}
	
	public void setPosY(int pPosY) {
		this.posY = pPosY;
	}

	public int getBuoyNumber() {
		return this.buoyNumber;
	}

}
