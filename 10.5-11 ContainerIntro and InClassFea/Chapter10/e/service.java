package e;
class innerExtendsExample{
	class inner{
		private int m1;
		inner(int m1){
			System.out.println(m1 + " in inner class is created");
		}
	}
}
//195 6չʾ�ڲ���̳�����Ľӿ�
public interface service{
	void provide(int sig);
}

