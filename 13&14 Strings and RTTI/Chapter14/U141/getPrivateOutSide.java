package U141;
import U14.*;
import java.lang.reflect.*;
//350 25 ���÷����ڰ�����ð���˽�úͱ������� FieldҲ�ǿ��Ե�
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
		//ʵ�ֽӿڵ��ڲ��� �����ڲ���Ҳ���Ա������Ƶķ���
	}
}
