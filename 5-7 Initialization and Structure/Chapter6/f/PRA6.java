package f;
import static e.Pra6.*;
import java.text.*;
//import e.*;�Զ�����ͬһĿ¼�µİ� ��������CLASSPATH
//import e.class.*;ֻ������ľ�̬����������Ҫ������
public class PRA6 {
   public static void main(String args[]) {
	  DecimalFormat Df = new DecimalFormat("0.00");
	  print("Available from now on\n");
	  print("100L\n");
	  printf("it isn't %d but %s\n",100,Df.format(100));
	  debug(args);
 }}