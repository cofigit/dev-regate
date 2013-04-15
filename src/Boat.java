
public class Boat extends Racer {
	// Comon racer logic in class racer
	// Boat provides saling boat logic
	// Direction of sail and speed according to wind
	// and angle sail / wind
	// Provides logic to calculate new position.
	private int cap;
	private int speed;

	public Boat(Field pField, String pName) {
		super(pField, pName);
	}
	
	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getSpeed() {
		return speed;
	}
}

