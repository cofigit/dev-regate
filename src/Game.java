import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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
	private boolean raceFinished = false;
	
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
	
	public void updateSubject() {
		Boolean allReady = true;
		Boolean allRaceFinished = true;
		Iterator<IObserver> it = getObservers().iterator();
		while ( it.hasNext() ){
			IObserver currentObserver = it.next();
			if ( currentObserver.getState() != true ) {
				allReady = false;
			}
			if ( currentObserver.getRaceFinished() != true ) {
				allRaceFinished = false;
			}
		}
		if ( allReady && !allRaceFinished ) {
			notifyObserver();
			subjectActions();
		} else if ( allRaceFinished ) {
			this.raceFinished = true;
			// Classement
			System.out.println ("Entered classement");
			Collections.sort(getObservers(), new Comparator<IObserver>(){
				@Override
				public int compare(IObserver o1, IObserver o2) {
					int result;
					if ( o1.getSteps() < o2.getSteps() ) {
						result = 1;
					} else if ( o1.getSteps() > o2.getSteps() ) {
						result = -1;
					} else {
						result = 0;
					}
					return result;
				}
			});
			// Echo to console
			System.out.println("*** CLASSEMENT FINAL ***");
			Iterator<IObserver> it2 = getObservers().iterator();
			int i = 1;
			while ( it.hasNext() ){
				IObserver currentObserver = it2.next();
				System.out.println(""+ i + "ère place : " +
						currentObserver.getName() +
						" ! Nombre de pas : " +
						currentObserver.getSteps() +
						".");
			}
		}
	}
	
	public void subjectActions(){
		if ( !getAllRaceFinished() ) {
			wind.generateWind();
			canvas.updateCanvas();
		} else {
			gameStarted = false;
			// Reset for new game
			// TODO Implement this particular feature
			canvas.updateCanvas();
		}
	}

	public static void main(String[] args) {
		// needed on mac os x
	    System.setProperty("apple.laf.useScreenMenuBar", "true");
		Game game = new Game();
	}
	
	public boolean getAllRaceFinished() {
		return raceFinished;
	}
}
