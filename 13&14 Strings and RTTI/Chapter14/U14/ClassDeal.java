package U14;

import java.lang.reflect.Field;
import java.util.*;

//用于测试
class Super implements SSuper{
	private int superPrivateInt = 1;
	public double superPublicDouble = 2.0;
	protected String superProtectString = "SuperProtectString";
	public void publicMethod() {
		System.out.println("you can get public outside of package");
	}
	public void hiddenPublicMethod() {
		System.out.println("you can get hidden public outside of package");
	}
	protected void protectedMethod() {
		System.out.println("you can get protected outside of package");
	}
	private void privateMethod() {
		System.out.println("you can get private outside of package");
	}
}
class Super1 extends Super{
	private int super1PrivateInt = 3;
	public double super1PublicDouble = 4.0;
	protected String super1ProtectString = "Super1ProtectString";
}
class Extends extends Super1{
	private int ExtendsPrivateInt = 5;
	public double ExtendsPublicDouble = 6.0;
	protected String ExtendsProtectString = "ExtendsProtectString";
}
final class Bottom extends Extends{
	private int BottomPrivateInt = 7;
	public double BottomPublicDouble = 8.0;
	protected String BottomProtectString = "BottomProtectString";
}

public class ClassDeal {
	//318 8,9打印超类(根据测试 接口不属于超类)及其域
	public static void showAllSuperClass(Object o) throws Exception {
		Class oc = o.getClass();
	    if(oc.getSuperclass()==null) {
	    	return;
	    }
	    else {
			Object oo = oc.getSuperclass().newInstance();
	    	Class ooc = oo.getClass();
	    	System.out.println(ooc.getCanonicalName()+"\n");
	    	for(Field i:ooc.getDeclaredFields()) {
	    		System.out.print(i+"\n");
	    	}
	    	showAllSuperClass(oo);
	    }
	}
	//318 10 判断char[]是基本类型还是一个对象
	public static void showIsInfo(Class cl) {
		System.out.println("for "+cl.getCanonicalName());
		System.out.println("is it an primitive type? " + cl.isPrimitive());
		System.out.println("is it an array? " + cl.isArray());
		System.out.println("is it an enum? " + cl.isEnum());
	}
	public static void main(String args[]) throws Exception {
		showAllSuperClass(new Bottom());
		showIsInfo(int.class);
		showIsInfo(char[].class);
	}
	public static SSuper makeSSuper() {
		return new Super();
	}
}
