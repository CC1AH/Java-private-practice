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
			e1.super(c);//重要语法：用基类对象的super来构造内部类
		}
	}
	/**main function*/
	public static void main(String args[]) {
		//展示内部类继承内部类
		Chapter2 cp = new Chapter2();
		cp.new innerExtends(new innerExtendsExample(),60);
	}
}
}///:~