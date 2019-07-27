package f;
import static e.Pra6.*;
import java.text.*;
//import e.*;自动导入同一目录下的包 否则设置CLASSPATH
//import e.class.*;只导入类的静态方法而不需要方法名
public class PRA6 {
   public static void main(String args[]) {
	  DecimalFormat Df = new DecimalFormat("0.00");
	  print("Available from now on\n");
	  print("100L\n");
	  printf("it isn't %d but %s\n",100,Df.format(100));
	  debug(args);
 }}