package e;
import java.io.*;
import static e.Pra6.*;
public class Pra6 {
//130.9在不同的包中实现代码
	public static void print(Object obj) {
			System.out.print(obj);
		}
	public static void printn() {
			System.out.println();
	}
	public static PrintStream printf(String format,Object...args) {
		return System.out.printf(format, args);
	}

	//113.1 foreach
	 public static void debug(String args[]) {
		for(String s:args)
			System.out.print(s+" ");
	
//123.8 权限
		for(int i=0;i<6;++i) {
			ConnectionManager.makeConObj();
		}
	}
}

//123.8
class Connection{
	int a;
	int b;
	void connect(){
		print("it is connected\n");
	}
}

class ConnectionManager{
	static Connection[] co = new Connection[5];
	static int i = 5;
	public static Connection makeConObj(){
		--i;
		if(i>=0) {
		printf("\n%d is created\n",5-i);
		return co[i];
	}
		else {
			print("\nnull is created\n");
		return null;
		}
}}


