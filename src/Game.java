
public class Game extends Subject {
	// We need to implement an interface so that
	// people can play.
	// On a first sprint, we may do this through
	// BlueJ.
	
	public static void main(String[] args) {
		Game game = new Game();
		
		Boat boat1 = new Boat(game, "Bateau 1");
		Boat boat2 = new Boat(game, "Bateau 2");
		Field field = new Field();
		Wind wind = new Wind();
		
		game.addObserver(boat1, boat1.getState());
		game.addObserver(boat2, boat2.getState());
		game.dumpAnnuaire();
		game.notifyObserver();
		boat1.setReady();
		boat2.setReady();
		boat1.setReady();
		game.notifyObserver();
		
		game.dumpAnnuaire();
	}
}
