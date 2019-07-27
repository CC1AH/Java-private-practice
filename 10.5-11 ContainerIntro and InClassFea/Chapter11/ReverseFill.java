package container;
import java.util.*;
//228 12 反向填充Integer:迭代器使用示例
public class ReverseFill {
	public static void main(String args[]) {
	List<Integer> l1 = new ArrayList<Integer>();
	for(int i=1;i<11;++i)
	l1.add((Integer)i);
	List<Integer> l2 = new ArrayList<Integer>();
	for(int i=20;i>10;--i)
	l2.add((Integer)i);
	//Collections.reverse(l1);l2.addAll(l1);//不用迭代器一行解决：注意是Collections哦sssss
	ListIterator<Integer> ite = l1.listIterator();
	while(ite.hasNext()) 
		ite.next();
	while(ite.hasPrevious()) 
		l2.add(ite.previous());
	System.out.println(l2);
	}
}
