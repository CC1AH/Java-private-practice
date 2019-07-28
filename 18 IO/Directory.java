package f;

import java.util.regex.*;
import java.io.*;
import java.util.*;

//532 4 ��Ҫ����� ��ӹ��� Ӌ��ߴ翂��
//args:D:\\java\\programs
public final class Directory {
	// local �������ڲ���һ������Ŀ¼������ָ���ļ�������
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

	// һ���洢Ŀ¼���ļ��ṹ����
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

	// walk��������Ŀ¼�Ľṹ�����ṩ�洢��Ϣ��TreeInfo
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

	// �ݹ�Ĵ洢startDir�е���Ϣ
	static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();
		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else // �����ļ� �ݹ����
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