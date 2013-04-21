
public class Wind {
	// We use constants at this stage.
	//
	// We may give this role to an administrator
	// or generate them randomly at each step.
	private final static double DIRECTION=180.0;
	private final static double SPEED=20.5; // not bigger than the canvas!
	
	//Direction du vent
	private double direction;
	//Vitesse du vent
	private double speed;
	
	
	//Contructeur par default
	public Wind(){
		this.direction = DIRECTION;
		this.speed = SPEED;
	}

	//Déclaration getters
	
	public double getDirection() {
		return direction;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	//Déclaration setters
	// TODO Generate values randomly according to boundaries set in constants
	public void setDirection(double pDirection){
		direction = pDirection;
	}
	
	public void setSpeed(double pSpeed) {
		speed = pSpeed;
	}
	
}