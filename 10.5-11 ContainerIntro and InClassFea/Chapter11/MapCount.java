package container;
import java.util.*;
//236 25 Mapʹ����ϰ
public class MapCount{
	public static TreeMap<String,ArrayList<Integer>> map;
	//��Ҫ���� ����ֵȡ����
	//���������ǲ���ֵ����Ԫ�طֱ�Ϊi,j��key
	public static String getKey(TreeMap<String,ArrayList<Integer>> map,Integer i,Integer j) {
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(i);
		v.add(j);
		String key = "";
		for(Map.Entry<String, ArrayList<Integer>> m: map.entrySet()) {//����map
		if(m.getValue().equals(v)) {
			key = m.getKey();
			}
		}
		return key;
	}
	public static void main(String args[]) {
		Set<String> words = new TreeSet<String>(new TextFile("D:\\java\\programs\\Chapter 11-12 Pra\\src\\container\\java.txt","\\W+"));
		map=new TreeMap<String,ArrayList<Integer>>();//��Ҫ�����������ʼ������ֱ�ӼӵĻ��ᱨNullPointerException
		//FileDealing.java is picked in the book
		int num = 0;
		for(String i: words) {
			int counter = 0;
		       for(String j:words)
		    	   if(j.charAt(0) == i.charAt(0))
		    		   counter++;
		    num++;
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(num);
		in.add(counter);//{{add(x);add(y);}};��ʼ����ʽ������final����
		map.put(i,in);
		}
		for(String key:map.keySet()) {
			System.out.println("key = " + key);
		}
		for(ArrayList<Integer> value: map.values()) {
			System.out.print("appearplace = " + value.get(0) + " ");
			System.out.print("timesOfSameFirstAlpha = " + value.get(1) + " ");
			System.out.println("");
		}
		System.out.println("find a word by FirstAlphaTimes :example 0-300,10");
		for(int i=0;i<300;++i)
			if(! ( getKey(map,(Integer)i,(Integer)10).equals("") ))
					System.out.println(getKey(map,(Integer)i,(Integer)10));
		}
}
