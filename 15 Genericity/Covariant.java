package U15;
import java.util.*;
public class Covariant {
	//391 26
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		// 数组的协变性证明
		Number[] numbers = new Number[3];
		numbers[0] = Integer.parseInt("100");
		numbers[1] = Integer.parseInt("200");
		numbers[2] = Integer.parseInt("300");
		//容器不具有协变性
		List<? extends Number> numbers2 =new ArrayList<Integer>();
		List<? extends Number> numbers3 = new ArrayList<Number>();
		//numbers2.add(new Integer(Integer.parseInt("400")));
		//numbers3.add(new Integer(Integer.parseInt("500")));
		//compile error:The method add(capture#1-of ? extends Number) in the type 
		//List<capture#1-of ? extends Number> is not applicable for the arguments Integer
		//唯一的方法是放弃在容器类中使用协变的向上转型
	}
	
}
