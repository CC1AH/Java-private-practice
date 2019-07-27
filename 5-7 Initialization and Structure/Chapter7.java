
//130.9 组合和继承
//代理：定义同名方法 但是使用调用组合对象函数的方式来使用它
class component1{
	private int com1;
	component1(int x){
		com1 = x;
		System.out.println("component1 is created");
	}
}
class component2{
	private double com2;
	component2(double x){
		com2 = x;
		System.out.println("component2 is created");
	}
}
class Root{
	final long root;
	component1 roCo1;
	component2 roCo2;
	Root(int x,double y,long z){
		roCo1 = new component1(x);
		roCo2 = new component2(y);
		root = z;
		System.out.println("root is created");		
	}
}
public class Cha7Pra extends Root{
	private char a = 'a';	
	Cha7Pra(int x, double y, long z,char a) {
		super(x, y, z);
		this.a = a;
	}
	public static void main(String args[]) {
		new Cha7Pra(1,3.0,2,'4');
		System.out.println("Cha7Pra is created");
		//new Root(1,2,3).root = 15; final can't be changed
	}
}
