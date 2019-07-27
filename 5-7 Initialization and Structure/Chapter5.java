
import java.util.*;
//89.12
class Tank{
	boolean hasPeople = false;
	Tank(boolean addOrNot){
		hasPeople = addOrNot;
	}
	Tank(){
		
	}
	void DoSomething() {
		System.out.println("Something is done");
	}
	void ClearPeople() {
		hasPeople = false;
		System.out.println("the people has just been cleared");
	}
	protected void finalize() {
		if(hasPeople)
			System.out.println("Error Happened: There is People IN it when you wanna close");
	}
}
public class e {
	static enum type{
		white,brown,red,green,purple,blue,yellow,cyan,pink
	}
	public static void main(String...args) {//刚才又漏掉main参数了...
		 //89.12 finalize演示
		Tank n1 = new Tank(true);
		n1.DoSomething();
		n1.ClearPeople();
		//当你忘记清人：默认状态下
		new Tank().DoSomething();
		//当你忘记清人：有人的时候
		new Tank(true).DoSomething();
		System.gc();//强制终结

		 //105.20 可变参数列表的main(eclipse下输命令行:run - run as - run configurations)
		int i = 0;
		for(String s:args) {
			System.out.println("argument " + (++i) + ": " + s);
		}

		//107.21
		System.out.println("basic information:");
		for (type s:type.values()) {
			System.out.println(s + "'s ordinal is 5" + s.ordinal());
		}
		Scanner sc = new Scanner(System.in);
		type tp = type.values()[Integer.parseInt(sc.next())];
		while(tp!=type.white) {
		switch(tp) {
		case brown:
			System.out.println("0.1");
			break;
		case red:
			System.out.println("0.5");
			break;
		case green:
			System.out.println("1");
			break;
		case purple:
			System.out.println("5");
			break;
		case blue:
			System.out.println("10");
			break;
		case yellow:
			System.out.println("20");
			break;
		case cyan:
			System.out.println("50");
			break;
		case pink:
			System.out.println("100");
			break;
		default:
			break;
			}
		tp = type.values()[Integer.parseInt(sc.next())];
		sc.close();
		}
	}
}
