/*
 * 1st working version.
 * Many implementation inaccuracies.
 * Model works.
 * Still have to implement end of race.
 */
public class Game extends Subject {
	private Boolean gameStarted;
	private Wind wind;
	private Field field;
	private Canvas canvas;
	
	public Game() {
		gameStarted = false;
		wind = new Wind();
		field = new Field();
		canvas = new Canvas(this);
	}
	
	public Boolean getGameStarted() {
		return gameStarted;
	}

	public void setGameStarted() {
		this.gameStarted = !gameStarted;
	}

	public Wind getWind() {
		return wind;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public Field getField() {
		return field;
	}

	public static void main(String[] args) {
		// needed on mac os x
	    System.setProperty("apple.laf.useScreenMenuBar", "true");
		Game game = new Game();
		
	    /*
		Game game = new Game();
		Canvas canvas = new Canvas(game);
		
		Boat boat1 = new Boat(game, game.field, "Bateau 1");
		Boat boat2 = new Boat(game, game.field, "Bateau 2");
		
		System.out.println("Dumping phone book.");
		game.dumpAnnuaire();
		
		System.out.println("Adding two boats and notifying observers 1st time.");
		game.addObserver(boat1);
		game.addObserver(boat2);
		game.notifyObserver();
	
		System.out.println("Dumping phonebook.");
		game.dumpAnnuaire();
		
		System.out.println("Updating states. Notifying");
		boat1.setReady();
		//System.out.println("echo test");
		boat2.setReady();
		//game.notifyObserver();
		
		System.out.println("Dumping phonebook.");
		game.dumpAnnuaire();
		*/
	}
}
