package f;
import java.util.regex.*;
import java.util.*;
import java.io.*;
//528 1��3 ʹ���ļ��������������з����ض��ļ������ļ����ݣ�regex�����ļ��������С
//Different Configurations:
//J.* .*\.java :test3.java test4.java
//D.* .*\.txt :test1.txt
//J.* .*\.txt :test2.txt
public class DirList {
	public static void main(String args[]) {
		String fileNameString = "D:\\java\\programs\\testTxt";
		File pathFile = new File(fileNameString);
		String[] list;
		if(args.length == 0) {
			list = pathFile.list();
		   System.out.println("0");}
		else {
			list = pathFile.list(new FilenameFilter(){
				private Pattern pattern = Pattern.compile(args[0]);
				private Pattern namePattern = Pattern.compile(args[1]);
				@Override
				public boolean accept(File dir, String name) {//�˴����ļ���name��������Ŀ¼��
					String string = "";
					StringBuilder stringBuilder = new StringBuilder();
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameString+"\\"+name));
						while(( string = bufferedReader.readLine() )!=null){
							stringBuilder.append(string);
							//stringBuilder.append("\n"); not necessary if we only want to know about the content of a file
						}
						bufferedReader.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
					return (namePattern.matcher(name).matches())&&(pattern.matcher(stringBuilder.toString()).matches());
				}
			});
			//����Ŀ¼�������ļ��Ĵ�С
			double sum = 0.0;
			for(String dirItem:list) {
				System.out.println(dirItem);
				File file = new File(fileNameString+"\\"+dirItem);
				sum += file.length();
			}
			System.out.print(sum + "B");
		}
	}
}
