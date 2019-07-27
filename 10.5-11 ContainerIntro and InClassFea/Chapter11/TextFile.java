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


	//读取文件，返回 String
    public static String read(String fileName){
        StringBuilder sb  =new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                                    new FileReader(
                                        new File(fileName).getAbsoluteFile()));
            try {
                String s ;
                //BufferedReader.readLine()  如果已到达流末尾，则返回 null 
                while ( (s = in.readLine())!= null ) {
                     sb.append(s);
                     sb.append("\n");
                     //要自己加上回车
                }
            } finally {
                in.close();
            }
            
            
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();    
    }//read
    
    
    
    //往文件写入 text
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
    
    
    //构造器
    public TextFile(String fileName,String splitter) {
        super(Arrays.asList( read(fileName).split(splitter))) ;
        if (get(0).equals("")) {
            remove(0);
        }
    }
    
    public TextFile(String fileName ) {
        this(fileName, "\n");//以换行号切分
    }
    
    //复制文件 写入到文件
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
