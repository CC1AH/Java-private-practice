package U15;
//409 15 创建咖啡装饰系统
/**
 * 
 * @author 15426
 *
 */
interface Coffee{
	public String pourInto();
}
class gourmetCoffee implements Coffee{

	@Override
	public String pourInto() {
		return "gourmetCoffee";
	}
	
}
class fulinCoffee implements Coffee{

	@Override
	public String pourInto() {
		// TODO Auto-generated method stub
		return "fulinCoffee";
	}
	
}

/**
 * Decorators
 * @author 15426
 *
 */
class MilkCoffee implements Coffee{
	private Coffee inner;
	public MilkCoffee(Coffee cof) {
		inner = cof;
	}
	@Override
	public String pourInto() {
		// TODO Auto-generated method stub
		return inner.pourInto() + " with Milk";
	}
}
class BubbleCoffee implements Coffee{
	private Coffee inner;
	public BubbleCoffee(Coffee cof) {
		inner = cof;
	}
	@Override
	public String pourInto() {
		// TODO Auto-generated method stub
		return inner.pourInto() + " with Bubble";
	}
	
}
public class CoffeeSystem {
	public static void main(String args[]) {
	gourmetCoffee fo = new gourmetCoffee();
	System.out.println(new BubbleCoffee(new MilkCoffee(fo)).pourInto());
	}
}
