
public class Boat implements IObserver {
	private Boolean ready = false;
	
	public void setReady() {
		this.ready = !ready;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Boat a reçu la notification. " + this.ready + ".");
		// Fetch new Wind data
		// Calculate new position
		// Control if buoy is passed (should I do it here?)
	}
	
	public Boolean getState() {
		return this.ready;
	}

}

