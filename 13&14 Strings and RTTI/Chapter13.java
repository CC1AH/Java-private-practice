import java.util.*;
import java.util.regex.Matcher;//��Ҫ�� ��ʹ���������Ҳ����ֱ������
import java.util.regex.Pattern;
//294 5 ��ʽ��;297 7��ʶ����;301 ƥ������
public class Chapter13 {
	private static Formatter f = new Formatter(System.out); 
	private static String[] m = {"\\^Java","\\Breg.*","n.w\\s+h(a|i)s",
			"s?","s*","s","s+","s{4}","s{1}","s{1,3}"};
	public static boolean request1(String s) {
		return s.matches("^[A-Z].*[\\.\\��]$");
		//��д��ͷ ; ����.��β
	}
	private static String request2(String s) {
		return s.replaceAll("[aeiouAEIOU]", "_");
	}
	public static ArrayList<Boolean> MatchGroup(String s){
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		int counter = 0;
		for(String i:m) {
		Pattern p = Pattern.compile(i);
		Matcher m = p.matcher(s); 
		result.add(m.find());
		}
		return result;
	}
	public static void main(String args[]) {
		/*f.format("%-10s%-10s%-5.3f\n","�����㷸ɵ�Ĵ���","�ﵽ��",2.55555,"��");
		f.format("250%5d%5h%5x",250,250,250);*/
		Scanner sc = new Scanner(System.in);
		/*while(sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(request1(s));
			System.out.println(request2(s));//��������sc.nextLine()ʱ������޷����
		}*/
		System.out.print("�������ַ�����ƥ��������ʽ");
		while(sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(MatchGroup(s));
	}
	}	
}
