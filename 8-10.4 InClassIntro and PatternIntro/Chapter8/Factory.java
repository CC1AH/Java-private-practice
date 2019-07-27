package classProcessor;
import java.util.*;
//工厂设计模式
interface Service{
	boolean isup();
	int upNum();
}
interface ServiceFactory{
	Service getService();
}
class Implement implements Service{
	Implement(){}
	public boolean isup(){
		Random rm = new Random();
		int x = rm.nextInt(2);
		if(x == 1)
			return true;
		return false;
	}
	public int upNum() {
		Random rm = new Random();
		return (rm.nextInt(6)+1);//生成1，2，3，4，5，6
	}
}
class ImplementationFactory implements ServiceFactory{
	public Service getService() {
		return new Implement();//如果有多个Service类型 工厂方法可以允许你不指定具体的Service类型
	}
}
public class Factory {
	public static void ServiceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		System.out.println(s.isup());
		System.out.println(s.upNum());
	}
	public static void main(String args[]) {
		for(int i=0;i<10;++i) {
			ServiceConsumer(new ImplementationFactory());
			System.out.println("\n");
		}
	}
}
