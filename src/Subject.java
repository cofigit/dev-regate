import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Subject {
	private ArrayList<IObserver> m_observers;

	public Subject() {
		m_observers = new ArrayList<IObserver>();
	}
	
	void addObserver(IObserver observer) {
		m_observers.add(observer);
	}
	
	void removeObserver(IObserver observer) {
		m_observers.remove(observer);	
	}
	
	public void updateSubject() {
		Boolean allReady = true;
		Iterator<IObserver> it = m_observers.iterator();
		while ( it.hasNext() ){
			IObserver currentObserver = it.next();
			if ( currentObserver.getState() != true ) {
				allReady = false;
			}
		}
		if ( allReady ) {
			// TODO generate new wind data (here : bad)
			notifyObserver();
		}
	}
	
	public void notifyObserver() {
		Iterator<IObserver> it = m_observers.iterator();
		while ( it.hasNext() ){
			IObserver currentObserver = it.next();
			currentObserver.updateObserver();
		}
	}
	
	public ArrayList<IObserver> getObservers(){
		return m_observers;
	}
	
	// Sera supprimé plus tard
	public void dumpAnnuaire() {
		Iterator<IObserver> it = m_observers.iterator();
		while ( it.hasNext() ){
			IObserver currentObserver = it.next();
			System.out.println("Clé : " + currentObserver + " Valeur : " + currentObserver.getState() + ".");
		}		
	}
	
}
