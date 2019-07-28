package f;

import java.util.Enumeration;
import java.util.zip.*;
import java.io.*;

//568 18.1 演示文件的壓縮和多文件保存
//单文件压缩.gz
class GZIPcompress {
	public static void showSingleContract(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream("test.gz")));

		// 向壓縮文件中寫入
		int c;
		while ((c = bufferedReader.read()) != -1)
			bufferedOutputStream.write(c);
		bufferedOutputStream.close();
		bufferedReader.close();
		// 從壓縮文件中讀取
		BufferedReader bufferedReader2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		String string;
		while ((string = bufferedReader2.readLine()) != null)
			System.out.println(string);
	}
}

//多文件压缩.zip
class ZIPcompress {
	public static void showPluralContract(String args[]) throws Exception {
		// 校验和
		CheckedOutputStream csum = new CheckedOutputStream(new FileOutputStream("test.zip"), new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);

		// 向壓縮文件中寫入
		BufferedOutputStream out = new BufferedOutputStream(zos);
		for (String arg : args) {
			BufferedReader in = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));// 向zipoutputstream中添加新的条目
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.flush();// 刷新
		}
		out.close();
		System.out.println("Checksum: " + csum.getChecksum().getValue());

		// 解压文件并读取文件内容
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
		 * 另一种读取方式 ZipFile zf = new ZipFile("test.zip"); Enumeration<? extends ZipEntry>
		 * e = zf.entries(); while(e.hasMoreElements()) { ZipEntry ze2 =
		 * (ZipEntry)e.nextElement(); System.out.println("File: " + ze2); // 仿照第一种方式解压数据
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
