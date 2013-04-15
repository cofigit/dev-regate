
public class Wind {
	// We use constants at this stage.
	//
	// We may give this role to an administrator
	// or generate them randomly at each step.
	private final static int DIRECTION=180;
	private final static int SPEED=8;
	
	//Direction du vent
	private int direction;
	//Vitesse du vent
	private int speed;
	
	
	//Contructeur par default
	public Wind(){
		this.direction = DIRECTION;
		this.speed = SPEED;
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