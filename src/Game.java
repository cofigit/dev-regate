
public class Game extends Subject {
	
	public static void main(String[] args) {
		Boat boat1 = new Boat();
		Boat boat2 = new Boat();
		Game game = new Game();
		game.addObserver(boat1);
		game.addObserver(boat2);
		
		boat1.setReady();
		boat2.setReady();
		
		game.notifyObserver();
		
	}
}
