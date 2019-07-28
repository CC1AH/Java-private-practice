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

//409 34 ���޶���������
abstract class selfBounded<T extends selfBounded<T>> {
	T t;

	selfBounded<T> set(T t) {
		this.t = t;
		return t;
	}

	T get() {
		return t;
	}
}// ϵͳ ��ȫ�� ���ͱ��߱����Ǽ̳���ϵ���·�֧�� ����������ڻ�����

class A extends selfBounded<A> {
	A getAndsSet(A a) {
		set(a);return get(); 
	}
}
//׼ȷ�� 

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
 *invalid ���ܼ̳���ϵ�����
 * }
 */

public class CaptureConversion {
	static <T> void f1(Holder<T> holder) {
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}

	static void f2(Holder<?> holder) {
		f1(holder);// f2�в��ܷ���T T ����f2��δ֪��
	}// ʹ��f2������ԭ�����ͷ��� ���ܻᲶ�����ĳ�������

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
