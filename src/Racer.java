import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Class Racer provides common logic for
 * all kinds of racer (Sailing boat, motor boat,
 * jetski, canoe, etc.)
 * 
 * Particularly, it provides the method
 * to check if a buoy is passed.
 */

public class Racer implements IObserver {
	protected Game game;
	private Field field;
	private HashMap <Buoy, Boolean> racerBuoyList = new HashMap<Buoy, Boolean>();
	private Boolean ready = true;
	private String name;
	private int steps;
	private int posX;
	private int posY;

	public Racer ( Game pGame, Field pField, String pName ){
		this.game = pGame;
		this.field = pField;
		this.name = pName;
		this.posX = field.getStart().getStartX();
		// TODO Check next position available
		this.posY = field.getStart().getStartY();
		// init all buoys to false
		Iterator<Buoy> it = this.field.getBuoyList().iterator();
		while (it.hasNext()){
			Buoy currentBuoy = it.next();
			this.racerBuoyList.put(currentBuoy, false);
		}
		pGame.addObserver(this);
	}
	
	public void checkBuoys() {
		// Logic for buoy passed
		// TODO Second iteration : check according to given order
		Iterator it = racerBuoyList.entrySet().iterator();
		while ( it.hasNext() ){
			Map.Entry pairs = (Map.Entry) it.next();
			Buoy currentBuoy = (Buoy) pairs.getKey();
			// Account for a 50 pixel radius
			if (	this.posX <= currentBuoy.getPosX() + 50 &&	// X condition
					this.posX >= currentBuoy.getPosX() - 50 &&
					this.posY <= currentBuoy.getPosY() + 50 &&	// Y condition
					this.posY >= currentBuoy.getPosX() - 50 
					) {
				pairs.setValue(true);
				System.out.println("PASSED BUOY!");
			}
		}
	}

	public void setReady() {
		this.ready = !ready;
		// Tell Subject
		game.updateSubject();
	}
	
	public int getSteps() {
		return steps;
	}

	public void addStep() {
		this.steps += 1;
	}
	
	@Override
	public void updateObserver() {
		this.ready = !ready;
		// TODO Remove this debug part
		System.out.println(this.getName() + " a reçu la notification. Etat : " + this.getState() +
				" posX : " + getPosX() + 
				" posY : " + getPosY() +
				" Steps : " + getSteps() + ".");
		calculateNewPosition();
		addStep();
		checkBuoys();
	}

	@Override
	public Boolean getState() {
		return this.ready;
	}
	
	@Override
	public String getName(){
		return this.name;
	}

	// responsabilité du racer métier
	// à surcharger en cas d'implémentation d'un nouveau
	// type de coureur.
	public void calculateNewPosition() {
		// Some generic function.
		System.out.println("Not using correct object's method");	// Replace with exception
	}
	
	public String toString() { return this.name; }
	

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
