public class Chapter2{
	/**
 	*main function
	*/
	public static void main(String args[]) {
		//31��2�� ��ѯ�û�����java���·��
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
		//37 (8)չʾ��̬�����ֻ����һ�����ڵ�������
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