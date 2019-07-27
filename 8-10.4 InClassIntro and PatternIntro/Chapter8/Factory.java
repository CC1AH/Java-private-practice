package classProcessor;
import java.util.*;
//�������ģʽ
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
		return (rm.nextInt(6)+1);//����1��2��3��4��5��6
	}
}
class ImplementationFactory implements ServiceFactory{
	public Service getService() {
		return new Implement();//����ж��Service���� �����������������㲻ָ�������Service����
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
