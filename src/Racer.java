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

	private Field field;
	private HashMap <Buoy, Boolean> racerBuoyList = new HashMap<Buoy, Boolean>();
	private Boolean ready = false;
	private String name;
	private int steps;
	private int posX;
	private int posY;
	
	public Racer ( Field pField, String pName ){
		this.field = pField;
		this.name = pName;
		// init all buoys to false
		Iterator<Buoy> it = this.field.getBuoyList().iterator();
		while (it.hasNext()){
			Buoy currentBuoy = it.next();
			this.racerBuoyList.put(currentBuoy, false);
		}
	}
	
	public void checkBuoys() {
		// Logic for buoy passed
		// First iteration : iterate through all buoys
		// Second iteration : check according to given order
		Iterator it = racerBuoyList.entrySet().iterator();
		while ( it.hasNext() ){
			Map.Entry pairs = (Map.Entry) it.next();
			Buoy currentBuoy = (Buoy) pairs.getKey();
			// Modify condition so that we account a radius
			// around the buoy.
			if (	this.posX == currentBuoy.getPosX() &&
					this.posY == currentBuoy.getPosY()
					) {
				pairs.setValue(true);
			}
		}
	}

	public void setReady() {
		this.ready = !ready;
	}
	
	public int getSteps() {
		return steps;
	}

	public void addStep() {
		this.steps += 1;
	}
	
	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		System.out.println(this.getName() + " a reçu la notification. Etat : " + this.getState() + ".");
		// Fetch new Wind data	-> how do we do that? 
		// Calculate new position
		// Control if buoy is passed (should I do it here?)
		this.checkBuoys();
	}

	@Override
	public Boolean getState() {
		return this.ready;
	}
	
	@Override
	public String getName(){
		return this.name;
	}

}
