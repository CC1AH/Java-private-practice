//�����c�m����������ʾ
import java.util.*;
interface Processor{
	String name();
	Object Process(Object input);
}
/*class Processor{
	public String name() {
		return getClass().getSimpleName();
	}
	Object process(Object input) {return input;}
}
class Upcase extends Processor{
	String process(Object input) {
		return((String)input).toUpperCase();
	}
}
class split extends Processor{
	String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}//Arrays.toString-�������ӡ����
}*/
class changing{
	String process(String s) {
		String result = "";
		for(int i=0;i<s.length()-1;i+=2) {
			result += s.charAt(i+1);
			result += s.charAt(i);
		}
		if(s.length()%2 == 1) {
			result += s.charAt(s.length()-1);
		}
		return result;
	}
}
class changingAdapter implements Processor{
	changing sh;
	public changingAdapter(changing sh) {
		this.sh = sh;
	}
	public String name() {
		return " changing ";
	}
	public String Process(Object input) {
		return sh.process((String) input);
	}
}
public class Apply{
	/*public static void process(Processor p,Object s) {
		System.out.println("Using processor"+p.name());
		System.out.println(p.process(s));
	}//�������ģʽ ������ͬ�����޸�һ����*/
	public static void process(Processor p,Object s) {
		System.out.println("Using processor"+p.name());
		System.out.println(p.Process(s));
	}//���������ģʽ ʹ�ô���Ľӿ��໥ͳһ
	public static String s = "ABCDEFGHIJKLM";
	public static void main(String args[]) {
		/*process(new Upcase(),s);
		process(new split(),s);*/
		process(new changingAdapter(new changing()),s);
	}
}

