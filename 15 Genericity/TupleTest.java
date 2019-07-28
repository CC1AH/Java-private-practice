 
package U15;
//367 15 验证陈述
class TwoTuple<A, B> {
	public final A first;
	public final B second;

	public TwoTuple(A a, B b) {
		first = a;
		second = b;
	}// 构造器不加泛型名称

	public String toString() {
		return (first + " " + second);
	}
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	public final C third;

	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		third = c;
	}

	public String toString() {
		return "(" + first + ", " + second + ", " + third + ")";
	}
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	public final D fourth;

	public FourTuple(A a, B b, C c, D d) {
		super(a, b, c);
		fourth = d;
	}

	public String toString() {
		return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
	}
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
	public final E fifth;

	public FiveTuple(A a, B b, C c, D d, E e) {
		super(a, b, c, d);
		fifth = e;
	}

	public String toString() {
		return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
	}
}

class Tuple{
	public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
		return new TwoTuple(a, b);
	}

	public static<A,B,C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
		return new ThreeTuple(a, b, c);
	}

	public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
		return new FourTuple<A, B, C, D>(a, b, c, d);
	}

	public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
		return new FiveTuple<A, B, C, D, E>(a, b, c, d, e);
	}
}
public class TupleTest{
	static TwoTuple<String,Integer> f() {
	    return Tuple.tuple("hi", 47);
	  }
	  static TwoTuple f2() { return Tuple.tuple("hi", 47); }
	  static
	  FiveTuple<Character,Float,String,Integer,Double> k() {
	    return Tuple.tuple('j', 5.6f,
	      "hi", 47, 11.1);//注意Double必須要加F
	  }
	  public static void main(String[] args) {
	    TwoTuple<String,Integer> ttsi = f();
	    System.out.println(ttsi);
	    System.out.println(f2());
	    //编译器并不会发出警告
	    TwoTuple<String,Integer> ttsi1 = f2();
	    //编译器针对unchecked convesionForm发出警告
	    System.out.println(k());
	  }
	} 
