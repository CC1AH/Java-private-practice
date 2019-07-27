package g;
import java.util.*;
public class Controlller {
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c) {
		eventList.add(c);
	}
	public void Run() {
		while(eventList.size()>0) {
			for(Event e:new ArrayList<Event>(eventList)) {
				if(e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
}
