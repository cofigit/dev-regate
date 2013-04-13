
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

	//D�claration getters
	
	public int getDirection() {
		return direction;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	//D�claration setters
	
	public void setDirection(int pDirection){
		direction = pDirection;
	}
	
	public void setSpeed(int pSpeed) {
		speed = pSpeed;
	}
	
}