package f;
import e.*;
public class Service{
	protected class GetService implements service{
		private String s1 = "1234567";
		public GetService() {
			System.out.println("Getervice is created");
		}
		public void provide(int sig) {
			System.out.println("provided service");
		}
	}
	public static void main(String args[]) {
		Service r0 = new Service();
		Service.GetService r1 = r0.new GetService();
		System.out.println(r1.s1);//外部类可以访问内部private元素
	}
}
