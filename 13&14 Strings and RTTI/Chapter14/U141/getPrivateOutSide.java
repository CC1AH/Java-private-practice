package U141;
import U14.*;
import java.lang.reflect.*;
//350 25 运用反射在包外调用包内私用和保护方法 Field也是可以的
public class getPrivateOutSide {
	static void callHiddenMethod(Object a,String methodName)throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
	public static void main(String args[]) throws Exception {
		SSuper ss = ClassDeal.makeSSuper();
		ss.publicMethod();//you will find it is the only method you can call
		
		//now use reflection:
		callHiddenMethod(ss,"hiddenPublicMethod");
		callHiddenMethod(ss,"protectedMethod");
		callHiddenMethod(ss,"privateMethod");
		//实现接口的内部类 匿名内部类也可以被无限制的访问
	}
}
