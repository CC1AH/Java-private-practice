package Observer;

import java.util.*;

/**
 * the observer pattern is used when the changes of a few subjects needed to be
 * notified to others.
 * 
 * Simple Description: first we should consider two certain systems: the
 * observers and the subjects. Often, a subject is observed by many observers so
 * the subjects needs to contain the observers. And it has the right to determine
 * what observers to be attached and detached and notified.
 * Observer need to contain the subject it observe for, apply for attach in its 
 * constructor and for update in other methods.
 * 
 * @author CC1AH
 * @since 2019/6/27
 */
public class Begin_Subject {
	private List<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	// state is a symbol that represents the content of subject.
	private int state;

	public int getState() {
		return state;
	}

	public int setState(int state) {
		this.state = state;
		notifyAllObservers();
		return state;
	}

}
