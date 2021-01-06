package Observer;

/**
 * the observer pattern is used when state changes need to be emphasizes, it
 * usually refers to one-to-many relationships.
 * 
 * Master the following: JDK provides an interface called Observer
 * 
 *public interface Observer{ 
 *  	void update(Observable o, Object obj);
 *  } 
 *  
 * and Observable is usually to be extended if you want a class to be Observed:
 *  
 *public class Observable { 
 *   private boolean changed = false; 
 *   private Vector<Observer> obs = new Vector(); 
 *   public Observable() { } 
 *
 *   public synchronized void addObserver(Observer var1) { 
 *   if (var1 == null) 
 *    throw new NullPointerException();  
 *    else {
 *     if (!this.obs.contains(var1)) 
 * 		  this.obs.addElement(var1); 
 *    	} 
 *    } 
 *    public synchronized void deleteObserver(Observer var1) { 
 *    	this.obs.removeElement(var1); 
 *    }
 * 
 * 	  public void notifyObservers(){
 * 		this.notifyObservers((Object)null);
 * 	  }
 *    public void notifyObservers(Object var1){
 *  	Object[] var2; 
 *      synchronized(this) {
 *       if (!this.changed)  
 *       	return;
 *       var2 = this.obs.toArray(); 
 *       this.clearChanged();
 *      }
 *      for(int var3 = var2.length - 1; var3 >= 0; --var3) {
 * 			((Observer)var2[var3]).update(this, var1); 
 *      }
 *    }
 *    
 * 		public synchronized void deleteObservers() {
 * 			this.obs.removeAllElements(); 
 *    }
 * 		synchronized void setChanged(){
 *      	this.changed = true;
 *    } 
 *      synchronized void clearChanged(){
 *      	this.changed = false; 
 *    } 
 * 		public synchronized boolean hasChanged(){
 *       	return this.changed; 
 *    } 
 *		public synchronized int countObservers(){
 * 			return this.obs.size(); 
 * 	  }
 * } 
 * when it comes to observer in java, please first consider if the Observable and Observer class is 
 * proper to be used. 
 * An overview usage of the above codes are as follows:
 * @see java.util.Observer
 * @see java.util.Observable
 */
public class Usage {
	public static void main(String args[]) {
		Begin_Subject begin_Subject = new Begin_Subject();
		new Observer1(begin_Subject);
		new Observer2(begin_Subject);

		begin_Subject.setState(10);
		begin_Subject.setState(0);
	}
}
