package f;
interface Serv{
	void way1() ;
	void way2();
}
interface ServFac{
	Serv getServ();
}
class Bicycle implements Serv{
	public static ServFac fac = new ServFac(){
		public Serv getServ() {
			return new Bicycle();
		}
	};
	public void way1() {
		System.out.println("Bicycle way1");
	}
	public void way2() {
		System.out.println("Bicycle way2");
	}
}
class Tricycle implements Serv{
	public static ServFac fac = new ServFac(){
		public Serv getServ() {
			return new Tricycle();
		}
	};
	public void way1() {
		System.out.println("Tricycle way1");
	}
	public void way2() {
		System.out.println("Tricycle way2");
	}
}
class Unicycle implements Serv{
	public static ServFac fac = new ServFac(){
		public Serv getServ() {
			return new Unicycle();
		}
	};
	public void way1() {
		System.out.println("Unicycle way1");
	}
	public void way2() {
		System.out.println("Unicycle way2");
	}
}
public class FactoryExample {
	public static void FactoryConsumer(ServFac fact) {
		Serv s = fact.getServ();
		s.way1();
		s.way2();
	}
	public static void main(String args[]) {
		FactoryConsumer(Tricycle.fac);
		FactoryConsumer(Bicycle.fac);
		FactoryConsumer(Unicycle.fac);
	}
}
