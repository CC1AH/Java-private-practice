package container;
import java.util.*;
//223 4 容器类的填充演示
class produce{
	private static int i = -1;
	public static String[]
			food = { "B馒头","A饺子",
				"E包子","D花卷","C油条" };
	public String next(){
		++i;
		if(i>food.length-1)
			i -= food.length;
		return food[i];
	}
}
public class Drive {
	public static TreeSet<String> s1 = new TreeSet<String>();
	static Collection<String> fillTwoRound(Collection<String> collection) {
		for(int i=0;i<produce.food.length*2;++i)
		collection.add(new produce().next());
		return collection;
	}
	public static void main(String args[]) {
		System.out.println(fillTwoRound(new ArrayList<String>()));
		System.out.println(fillTwoRound(new LinkedList<String>()));
		System.out.println(fillTwoRound(new HashSet<String>()));
		System.out.println(fillTwoRound(new LinkedHashSet<String>()));
		System.out.println(fillTwoRound(s1));
	}
}
