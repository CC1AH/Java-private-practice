package e;
class innerExtendsExample{
	class inner{
		private int m1;
		inner(int m1){
			System.out.println(m1 + " in inner class is created");
		}
	}
}
public class Chapter10{
	class innerExtends extends innerExtendsExample.inner{
		innerExtends(innerExtendsExample e1,int c){
			e1.super(c);//��Ҫ�﷨���û�������super�������ڲ���
		}
	}
	/**main function*/
	public static void main(String args[]) {
		//չʾ�ڲ���̳��ڲ���
		Chapter2 cp = new Chapter2();
		cp.new innerExtends(new innerExtendsExample(),60);
	}
}
}///:~