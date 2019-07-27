public class Chapter2{
	/**
 	*main function
	*/
	public static void main(String args[]) {
		//31（2） 查询用户名和java库的路径
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
		//37 (8)展示静态域变量只能在一个类内单独存在
		Example1 example1 = new Example1();
		example1.showItem();
		Example1 example2 = new Example1();
		example2.showItem();
		example1.showItem();
	}
}
class Example1{
	static int item;
	public void showItem() {
		System.out.println(item);
		item++;
}