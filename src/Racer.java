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
	private static final int MARGIN = 100;
	protected Game game;
	private Field field;
	private HashMap <Buoy, Boolean> racerBuoyList = new HashMap<Buoy, Boolean>();
	private Boolean ready = true;
	private String name;
	private int steps;
	private int classement;

	private int posX;
	private int posY;
	private Boolean raceFinished;
	private Boolean allBuoysPassed;

	public Racer ( Game pGame, Field pField, String pName ){
		this.game = pGame;
		this.field = pField;
		this.name = pName;
		this.raceFinished = false;
		this.allBuoysPassed = false;
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
	
	public Boolean checkBuoys() {
		// Logic for buoy passed
		// TODO Second iteration : check according to given order
		Boolean allBuoysPassed = true;
		Iterator it = racerBuoyList.entrySet().iterator();
		while ( it.hasNext() ){
			Map.Entry pairs = (Map.Entry) it.next();
			Buoy currentBuoy = (Buoy) pairs.getKey();
			// Account for a MARGIN pixel radius
			if (	this.posX <= currentBuoy.getPosX() + MARGIN &&	// X condition
					this.posX >= currentBuoy.getPosX() - MARGIN &&
					this.posY <= currentBuoy.getPosY() + MARGIN &&	// Y condition
					this.posY >= currentBuoy.getPosX() - MARGIN 
					) {
				pairs.setValue(true);
				//TODO remove when publishing
				System.out.println("Passed buoy!");
			}
			if ((Boolean) pairs.getValue() == false) {
				allBuoysPassed = false;
			}
		}
		if ( allBuoysPassed ) { // check end line passed
			// We assume race goes from left to right.
			if (	this.posX >= game.getField().getFinish().getStartX() &&
					this.posY >= game.getField().getFinish().getStartY() &&	
					this.posX >= game.getField().getFinish().getEndX() &&
					this.posY <= game.getField().getFinish().getEndY()
					) {
				raceFinished = true;
				//TODO remove when publishing
				System.out.println("Finished race!");
			}
		}
		return allBuoysPassed;
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
		if ( !raceFinished || !allBuoysPassed) {
			this.ready = !ready;
			calculateNewPosition();
			addStep();
			allBuoysPassed = checkBuoys();
			// TODO Remove this debug part
			System.out.println(this.getName() + " a reçu la notification. Etat : " + this.getState() +
					", posX : " + getPosX() + 
					", posY : " + getPosY() +
					", Steps : " + getSteps() + ".");
		}
	}

	@Override
	public boolean getState() {
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
	public int getClassement() {
		return classement;
	}

	public void setClassement(int classement) {
		this.classement = classement;
	}

	@Override
	public boolean getRaceFinished() {
		return raceFinished;
	}
}
