package f;

import java.util.Enumeration;
import java.util.zip.*;
import java.io.*;

//568 18.1 ��ʾ�ļ��ĉ��s�Ͷ��ļ�����
//���ļ�ѹ��.gz
class GZIPcompress {
	public static void showSingleContract(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream("test.gz")));

		// �򉺿s�ļ��Ќ���
		int c;
		while ((c = bufferedReader.read()) != -1)
			bufferedOutputStream.write(c);
		bufferedOutputStream.close();
		bufferedReader.close();
		// �ĉ��s�ļ����xȡ
		BufferedReader bufferedReader2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		String string;
		while ((string = bufferedReader2.readLine()) != null)
			System.out.println(string);
	}
}

//���ļ�ѹ��.zip
class ZIPcompress {
	public static void showPluralContract(String args[]) throws Exception {
		// У���
		CheckedOutputStream csum = new CheckedOutputStream(new FileOutputStream("test.zip"), new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);

		// �򉺿s�ļ��Ќ���
		BufferedOutputStream out = new BufferedOutputStream(zos);
		for (String arg : args) {
			BufferedReader in = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));// ��zipoutputstream������µ���Ŀ
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.flush();// ˢ��
		}
		out.close();
		System.out.println("Checksum: " + csum.getChecksum().getValue());

		// ��ѹ�ļ�����ȡ�ļ�����
		CheckedInputStream csumi = new CheckedInputStream(new FileInputStream("test.zip"), new Adler32());

		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while ((ze = in2.getNextEntry()) != null) {
			System.out.println("\nReading file " + ze);
			int x;
			while ((x = bis.read()) != -1)
				System.out.write(x);
		}
		if (args.length == 1)
			System.out.println("Checksum: " + csumi.getChecksum().getValue());
		bis.close();

		/*
		 * ��һ�ֶ�ȡ��ʽ ZipFile zf = new ZipFile("test.zip"); Enumeration<? extends ZipEntry>
		 * e = zf.entries(); while(e.hasMoreElements()) { ZipEntry ze2 =
		 * (ZipEntry)e.nextElement(); System.out.println("File: " + ze2); // ���յ�һ�ַ�ʽ��ѹ����
		 * }
		 */
	}
}

public class compress {
	public static void main(String args[]) throws Exception {
		// arg:D:\java\programs\testTxt\test3.java
		/* GZIPcompress.showSingleContract(args); */

		//args:D:\java\programs\testTxt\test1.txt D:\java\programs\testTxt\test2.txt D:\java\programs\testTxt\test3.java D:\java\programs\testTxt\test4.java
		ZIPcompress.showPluralContract(args);
	}
}
