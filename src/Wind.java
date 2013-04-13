
public class Wind {
	//Direction du vent
	private int direction;
	//Vitesse du vent
	private int speed;
	
	private final static int DIRECTION=180;
	private final static int SPEED=8;
	
	//Contructeur par default
	public Wind(){
		this.direction=DIRECTION;
		this.speed=SPEED;
	}

	//DŽclaration getters
	
	public int getDirection() {
		return direction;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	//DŽclaration setters
	
	public void setDirection(int pDirection){
		direction = pDirection;
	}
	
	public void setSpeed(int pSpeed) {
		speed = pSpeed;
	}
	
}