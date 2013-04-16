
public class Boat extends Racer {
	// Comon racer logic in class racer
	// Boat provides saling boat logic
	// Direction of sail and speed according to wind
	// and angle sail / wind
	// Provides logic to calculate new position.
	private int cap;
	private int speed;
	private int direction;

	public Boat(Game pGame, Field pField, String pName) {
		super(pGame, pField, pName);
	}
	
	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		if ( cap >= 0 && cap <= 360 ) {
			this.cap = cap;
		} else {
			// TODO Alert cap value incorrect or change to correct cap
		}
	}

	public int getSpeed() {
		return speed;
	}

	@Override
	public void calculateNewPosition() {
		// TODO Auto-generated method stub
			int windDirection = super.game.wind.getDirection();
			int windSpeed = super.game.wind.getSpeed();
			if ( this.cap > 30 && this.cap < (360-30)) {
				// Algorithm
				// Wind speed X (calculation on angles)
				// 	speed = wind speed if (calculation on angles == 1)
				//	speed = wind speed * (sin 90) <= angle avec le vent
				// 	boat direction = parallel to wind if sin(angles difference) = 1
				this.speed = (int) (windSpeed * Math.sin(	Math.toRadians(windDirection-this.cap)	));
				this.direction = (int) (Math.toRadians(windDirection) * Math.sin(	Math.toRadians(windDirection-this.cap) ));
				
				// Calculation of new place
				// Basic algorithm : windSpeed shows pixel displacement
				//		this.direction shows the angle of displacement
				//		we use trigonometry to project relative displacement
				//		on X and Y axis.
				super.posX = (int) (this.speed * Math.cos(this.direction));
				super.posY = (int) (this.speed * Math.sin(this.direction));
				
			} else {
				this.speed = 0;
				this.direction = 0;
			}
	}
	
}

