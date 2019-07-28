package U15;

import java.util.*;

class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}

class Holder<T> {
	private T value;

	public Holder() {
	}

	public Holder(T val) {
		value = val;
	}

	public void set(T val) {
		value = val;
	}

	public T get() {
		return value;
	}

	public boolean equals(Object obj) {
		return value.equals(obj);
	}

	public static void main(String[] args) {
		Holder<Apple> Apple = new Holder<Apple>(new Apple());
		Apple d = Apple.get();
		Apple.set(d);
		// Holder<Fruit> Fruit = Apple; // Cannot upcast
		Holder<? extends Fruit> fruit = Apple; // OK
		Fruit p = fruit.get();
		d = (Apple) fruit.get(); // Returns 'Object'
		try {
			Orange c = (Orange) fruit.get(); // No warning
		} catch (Exception e) {
			System.out.println(e);
		}
		// fruit.set(new Apple()); // Cannot call set()
		// fruit.set(new Fruit()); // Cannot call set()
		System.out.println(fruit.equals(d)); // OK
	}
}

//409 34 自限定泛型类型
abstract class selfBounded<T extends selfBounded<T>> {
	T t;

	selfBounded<T> set(T t) {
		this.t = t;
		return t;
	}

	T get() {
		return t;
	}
}// 系统 安全性 泛型边线必须是继承体系的下分支点 导出类出现在基类下

class A extends selfBounded<A> {
	A getAndsSet(A a) {
		set(a);return get(); 
	}
}
//准确性 

class B extends selfBounded<A> {

}

class D {

}

/*
 * 
 * Bound mismatch: The type D is not a valid substitute for the bounded
 * parameter <T extends selfBounded<T>> of the type selfBounded<T>
 */
/**
 * 
 * class C extends selfBounded<D>{
 *invalid 不能继承体系外的类
 * }
 */

public class CaptureConversion {
	static <T> void f1(Holder<T> holder) {
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}

	static void f2(Holder<?> holder) {
		f1(holder);// f2中不能返回T T 对于f2是未知的
	}// 使用f2来调用原生类型方法 可能会捕获具体的抽象类型

	public static void main(String args[]) {
		Holder raw = new Holder<Integer>(1);
		f1(raw);
		f2(raw);

		Holder rawBasic = new Holder();
		rawBasic.set(new Object());
		f1(rawBasic);
		f2(rawBasic);

		Holder<?> wild = new Holder<Double>(1.0);
		f1(wild);
		f2(wild);
		A a = new A();
		a.set(new A());
		a.getAndsSet(new A());
	}
}
