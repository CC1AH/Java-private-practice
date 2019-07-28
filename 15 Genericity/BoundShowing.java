package U15;
//389 25 演示边界的使用
public class BoundShowing {
	public <T extends gobulin> void developGobulin(T t){
		System.out.println("develop giligili now");
	}
	public <R extends thief> void developThief(R r) {
		System.out.println("develop steal now");
	}
	public static void main(String[] args) {
		new BoundShowing().developGobulin(new evil());
		new BoundShowing().developThief(new evil());
	}
}
interface gobulin{
	void giligili();
}
interface thief{
	void steal();
}
class evil implements gobulin,thief{
	@Override
	public void steal() {
		System.out.println("steal now");
		
	}
	@Override
	public void giligili() {
		System.out.println("giligili now");
	}
}
