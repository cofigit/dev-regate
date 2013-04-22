
public class Boat extends Racer {
	// Comon racer logic in class racer
	// Boat provides saling boat logic
	// Direction of sail and speed according to wind
	// and angle sail / wind
	// Provides logic to calculate new position.
	private double cap;
	private double speed;
	private double direction;

	public Boat(Game pGame, Field pField, String pName) {
		super(pGame, pField, pName);
		this.cap = 0;
		this.speed = 0;
		this.direction = 0;
	}
	
	public double getCap() {
		return cap;
	}

	public void setCap(int cap) {
		if ( cap >= 0 && cap <= 360 ) {
			this.cap = cap;
		} else {
			// TODO Alert cap value incorrect or change to correct cap
		}
	}

	public double getSpeed() {
		return speed;
	}

	@Override
	public void calculateNewPosition() {
		double windDirection = super.game.getWind().getDirection();
		double windSpeed = super.game.getWind().getSpeed();
		System.out.println("wind direction : " + windDirection + " wind speed : " + windSpeed);
		//if ( (windDirection - this.cap) > 30 && (windDirection - this.cap) < (360-30)) {
		if (true ) { // condition on cap and wind direction difference > 30
			// Algorithm
			// Wind speed X (calculation on angles)
			// 	speed = wind speed if (calculation on angles == 1)
			//	speed = wind speed * (sin 90) <= angle avec le vent
			// 	boat direction = parallel to wind if sin(angles difference) = 1
			System.out.println("entered calculation algorithm");
			this.speed = (double) ( (double)windSpeed * Math.sin(	Math.toRadians((double)windDirection-(double)this.cap)	));
			this.direction = (double) (Math.toRadians((double)windDirection) * Math.sin(	Math.toRadians((double)windDirection-(double)this.cap) ));
			
			
			// Calculation of new place
			// Basic algorithm : windSpeed shows pixel displacement
			//		this.direction shows the angle of displacement
			//		we use trigonometry to project relative displacement
			//		on X and Y axis.
			setPosX(getPosX() + (int) ((double)this.speed * Math.cos((double)this.direction)));
			setPosY(getPosY() + (int) ((double)this.speed * Math.sin((double)this.direction)));
			this.direction = (double) Math.toDegrees(this.direction);
			game.getCanvas().drawBoat();
			
		} else {
			this.speed = 0;
			this.direction = 0;
		}
	}
}

