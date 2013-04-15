import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Subject {
	private HashMap<IObserver, Boolean> m_observers;

	public Subject() {
		m_observers = new HashMap<IObserver, Boolean>();
	}
	
	void addObserver(IObserver observer, Boolean state) {
		m_observers.put(observer, state);
	}
	
	void removeObserver(IObserver observer) {
		m_observers.remove(observer);	
	}
	
	void updateSubject(IObserver observer, Boolean state) {
		this.m_observers.put(observer, state);
	}
	
	public void notifyObserver() {
		Iterator it = m_observers.entrySet().iterator();
		while ( it.hasNext() ){
			Map.Entry pairs = (Map.Entry) it.next(); 
			IObserver currentObserver = (IObserver) pairs.getKey();
			currentObserver.updateObserver();
		}
	}
	
	public void dumpAnnuaire() {
		Iterator it = m_observers.entrySet().iterator();
		while ( it.hasNext() ){
			Map.Entry pairs = (Map.Entry) it.next(); 
			IObserver currentObserver = (IObserver) pairs.getKey();
			Boolean currentState = (Boolean) pairs.getValue();
			System.out.println("Clé : " + currentObserver + " Valeur : " + currentState + ".");
		}		
	}
	
}
