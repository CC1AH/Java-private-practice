package f;

import java.io.*;
import java.util.*;
//540 10��543 12 ʹ��linkedList,��ȡ��д���ļ�
public class ReadLineP {
	private static LinkedList<String> linkedList = new LinkedList<String>();

	public static void readIn(String fileString) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileString));
		String string;
		while ((string = in.readLine()) != null) {
			linkedList.add(string + "\n");
		}
		in.close();
	}

	public static void writeIn(String fileString) throws IOException {
		PrintWriter printWriter = new PrintWriter(fileString);
		int count = 0;
		for (String s : linkedList) {
			printWriter.println((count++) + ":" + s);
		}
		printWriter.close();// ��close�ͻ�һֱ�����ڻ�����
	}

	public static void main(String args[]) throws IOException {
		String tempString;
		readIn("D:\\java\\programs\\SimpleCaculator\\src\\calculator.java");
		writeIn("copy.java");
		while ((tempString = linkedList.pollLast()) != null) {// ע��peekLast�򲻻�removeԭ����
			if (tempString.contains("public"))
				System.out.println(tempString);
		}
	}
}
