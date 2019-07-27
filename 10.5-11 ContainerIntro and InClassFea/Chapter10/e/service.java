package e;
class innerExtendsExample{
	class inner{
		private int m1;
		inner(int m1){
			System.out.println(m1 + " in inner class is created");
		}
	}
}
//195 6展示内部类继承外包的接口
public interface service{
	void provide(int sig);
}

