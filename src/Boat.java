
public class Boat extends Racer {
	// Comon racer logic in class racer
	// Boat provides saling boat logic
	// Direction of sail and speed according to wind
	// and angle sail / wind
	// Provides logic to calculate new position.
	private int cap;
	private int speed;

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
}

