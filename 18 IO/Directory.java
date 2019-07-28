package f;

import java.util.regex.*;
import java.io.*;
import java.util.*;

//532 4 重要工具類 添加功能 計算尺寸總和
//args:D:\\java\\programs
public final class Directory {
	// local 方法用于产生一个给定目录下所有指定文件的数组
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}

	public static File[] local(String path, final String regex) { // Overloaded
		return local(new File(path), regex);
	}

	// 一个存储目录和文件结构的类
	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();

		public Iterator<File> iterator() {
			return files.iterator();
		}

		void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		public String toString() {
			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
		}
	}

	// walk方法遍历目录的结构用于提供存储信息的TreeInfo
	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) {
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(File start) {
		return recurseDirs(start, ".*");
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	// 递归的存储startDir中的信息
	static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();
		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else // 常规文件 递归基线
			if (item.getName().matches(regex))
				result.files.add(item);
		}
		return result;
	}

	public static long produceSum(TreeInfo treeInfo) {
		long sum = 0;
		for (File item : treeInfo.files)
			sum += item.length();
		return sum;
	}

	public static void main(String[] args) {
		long sum = 0;
		if (args.length == 0)
			System.out.println(produceSum(walk(".")) + "kB");
		else {
			for (String arg : args)
				sum += produceSum(walk(arg));
			System.out.println((sum/1024)/1024 + "MB");
		}
	}
}