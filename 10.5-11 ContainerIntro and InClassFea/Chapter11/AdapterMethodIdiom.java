
import java.util.*;
//243 适配器方法惯用法 将Iterator适配反序构造
class ReversibleArrayList<T> extends ArrayList<T>{
		public ReversibleArrayList(Collection<T> c) {super(c);}
		public Iterable<T> reversed(){
			//////////////////////////////////
			return new Iterable<T>() {//1层内部类（匿名）
				public Iterator<T> iterator(){
			/********************************/		
					return new Iterator<T>(){//2层内部类（匿名）
						public int current = size() - 1;
						public boolean hasNext() {return current > -1;}
						public T next() {return get(current--);};
						public void remove() {
							throw new UnsupportedOperationException();
						}
					};
			/********************************/
				}
			};
			//////////////////////////////////
		}
	}
public class AdapterMethodIdiom {
	public static void main(String args[]) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("It is also an example".split(" ")));
		for(String s:ral.reversed())
			System.out.print(s + " ");	
	}
}
