import java.util.*;
import java.util.regex.Matcher;//必要的 即使有了上面的也不会直接引入
import java.util.regex.Pattern;
//294 5 格式化;297 7初识正则;301 匹配正则
public class Chapter13 {
	private static Formatter f = new Formatter(System.out); 
	private static String[] m = {"\\^Java","\\Breg.*","n.w\\s+h(a|i)s",
			"s?","s*","s","s+","s{4}","s{1}","s{1,3}"};
	public static boolean request1(String s) {
		return s.matches("^[A-Z].*[\\.\\。]$");
		//大写开头 ; 。或.结尾
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
		/*f.format("%-10s%-10s%-5.3f\n","今天你犯傻的次数","达到了",2.55555,"次");
		f.format("250%5d%5h%5x",250,250,250);*/
		Scanner sc = new Scanner(System.in);
		/*while(sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(request1(s));
			System.out.println(request2(s));//两个都用sc.nextLine()时该语句无法达成
		}*/
		System.out.print("请输入字符串以匹配正则表达式");
		while(sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(MatchGroup(s));
	}
	}	
}
