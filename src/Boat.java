
public class Boat implements IObserver {
	private Boolean ready = false;
	private String name;
	private Game game;
	
	public Boat(Game game, String pName) {
		this.game = game;
		this.name = pName;
	}

	public void setReady() {
		this.ready = !ready;
		game.updateSubject(this, this.ready);
	}
	
	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " a reçu la notification. Etat : " + this.ready + ".");
		// Fetch new Wind data
		// Calculate new position
		// Control if buoy is passed (should I do it here?)
	}
	
	public Boolean getState() {
		return this.ready;
	}

}

