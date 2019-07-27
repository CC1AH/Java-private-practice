package g;
public class GreenHouseController extends Controlller{
	private boolean light = true;
	public class LightOn extends Event{
			///内部类继承事件 外部类继承主类
		public LightOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			light = true;
		}
		public String toString(){return "LightOn";};
	}
	public class LightOff extends Event{
		public LightOff(long delayTime) {
			super(delayTime);
		}
		public void action() {
			light = false;
		}
		public String toString() {return "LightOff";}
	}
	public class Bell extends Event{
		public Bell(long delayTime) {
			super(delayTime);
		}
		public void action() {
			addEvent(new Bell(delayTime));
		}
		public String toString() {
			return "bing";
		}
	}
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for(Event e:eventList) 
				addEvent(e);
		}
		public void action() {
			for(Event e:eventList) {
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);
		}
		public String toString() {
			return "Restarting System";
		}
	}
	public static class Terminate extends Event{
		public Terminate(long delayTime) {
			super(delayTime);
		}
		public void action() {
			System.exit(0);
		}
		public String toString() {
			return "Terminated";
		}
	}//测试程序
	public static void main(String args[]) {
		GreenHouseController gc = new GreenHouseController();
		gc.addEvent(gc.new Bell(900));
		Event[] eventList = {
				gc.new LightOn(200),
				gc.new LightOff(400)
		};
		gc.addEvent(gc.new Restart(2000,eventList));
		if(args.length == 1) {
			gc.addEvent(new GreenHouseController.Terminate(Integer.parseInt(args[0])));
		}//测试用
		gc.Run();
	}
}

