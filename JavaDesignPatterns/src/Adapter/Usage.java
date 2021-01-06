package Adapter;

/**
 * You can see adapters in even every tool system. People often meet with
 * difficulty making things work together. Such hardware's power adapter and
 * software's container changing and so on.
 * 
 * The following class gives an using example of completion
 * 
 * @author CC1AH
 * @since 2019/6/6
 */
public class Usage {
	public static void main(String text[]) {
		new Adapter(new Adaptee()).targetMethod();
	}
}
