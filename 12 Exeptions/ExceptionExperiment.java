package adaptMeUsuAndExp;
class MyException extends Exception{
	MyException(){}
	MyException(int msg){
		super(Integer.toString(msg) + " is reported unproper");
	}
}
public class ExceptionExperiment{
	//253 1异常恢复模型的示例
	private static int i = 0;
	private static void loopf(int f) throws MyException{
		if(i<f) {
			System.out.println("i is too samll");
			throw new MyException(i);
		}
		else {
			System.out.println("i is enough");
		}
	}
	public static void main(String args[]) {
		while(true) {
			try {
				loopf(5);
				System.out.println("i=" + i);
				break;//终止语句 直到异常不再抛出
			}
			catch(MyException e){
				e.printStackTrace(System.out);
			}
			i++;//修正语句
		}
	}
}
