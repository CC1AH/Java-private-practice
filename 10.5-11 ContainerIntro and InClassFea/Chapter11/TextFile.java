package container;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String>{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//��ȡ�ļ������� String
    public static String read(String fileName){
        StringBuilder sb  =new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                                    new FileReader(
                                        new File(fileName).getAbsoluteFile()));
            try {
                String s ;
                //BufferedReader.readLine()  ����ѵ�����ĩβ���򷵻� null 
                while ( (s = in.readLine())!= null ) {
                     sb.append(s);
                     sb.append("\n");
                     //Ҫ�Լ����ϻس�
                }
            } finally {
                in.close();
            }
            
            
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();    
    }//read
    
    
    
    //���ļ�д�� text
    public static void write(String fileName,String text){
        try {
            PrintWriter out  = new PrintWriter
                                    (new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }//write
    
    
    //������
    public TextFile(String fileName,String splitter) {
        super(Arrays.asList( read(fileName).split(splitter))) ;
        if (get(0).equals("")) {
            remove(0);
        }
    }
    
    public TextFile(String fileName ) {
        this(fileName, "\n");//�Ի��к��з�
    }
    
    //�����ļ� д�뵽�ļ�
    public void write(String fileName){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                
                for (String item : this) {
                    out.print(item);
                }
            } finally {
                 out.close();
            }
             
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }//write 
}
