
public class Game extends Subject {
	// We need to implement an interface so that
	// people can play.
	// On a first sprint, we may do this through
	// BlueJ.
	Wind wind = new Wind();
	Field field = new Field();
	
	public static void main(String[] args) {
		// needed on mac os x
	    System.setProperty("apple.laf.useScreenMenuBar", "true");
	    
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
	}
}
