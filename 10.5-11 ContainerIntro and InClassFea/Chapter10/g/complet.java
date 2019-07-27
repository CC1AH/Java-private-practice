package g;
import f.*;
import e.*;
public class complet extends Service{
	service obtain() {
		Service r0 = new Service();
		Service.GetService r1 = r0.new GetService(); 
		System.out.println("obtain service:");
		r1.provide(0);
		return r1;
	}
	public static void main(String args[]) {
	     new complet().obtain();//只有静态方法可以通过类调用
	}
}
