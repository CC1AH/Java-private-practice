
import java.util.*;
import java.text.*;
public class Chapter3{
	enum result{
		up,down
	};
	static double CalculateV(double s,double t) {
		return s/t;
	}
	public static void main(String args[]) {
		DecimalFormat Df = new DecimalFormat("0.00");
		//56 չʾ����Math.round();
		double above = 0.7,below = 0.4;
		float fabove = 0.7f,fbelow = 0.4f;
		System.out.println("Math.round(above)" + Math.round(above));
		System.out.println("Math.round(below)" + Math.round(below));
		System.out.println("Math.round(fabove)" + Math.round(fabove));
		System.out.println("Math.round(fbelow)" + Math.round(fbelow));
		//43.4 չʾ�ٶȳ���
		Random rand = new Random(47);
		double s1 = 0.0;
		double t1 = 0.0;
		for(int i=0;i<10;++i) {
			s1 = 100 + rand.nextInt(200) + rand.nextDouble();//��100.0 - 300.0��ѡ��ֵ
		    t1 = 10 + rand.nextInt(30) + rand.nextDouble();//ע��nextInt�����������Ͻ�
		    System.out.println(i + " distance: " + Double.toString(s1) +
		    		" time: " + Double.toString(t1) + "\n");
		    System.out.println("speed: " + Df.format(CalculateV(s1,t1)));
		}
		//46.7 ��Ӳ��ģ��
		int Up = 0;
		int Down = 0;
		int offer = 1000;
		Scanner sc = new Scanner(System.in);//��ȡ��������
		offer = Integer.parseInt(sc.next());
		for(int i=1;i<=offer;++i) {
			result m = result.values()[rand.nextInt(2)];//intתö��
			System.out.print(m + "  ");
			//if(m == result.up)�Ƚ�ע�� �Ƽ���switch
			switch(m) {
			case up:
				Up++;
				break;
			case down:
				Down++;
			}
			if(i%15==0)
			System.out.print("\n");
		}
		System.out.println("\nUp Number is: " + Up +" Down Number is: " + Down
				+ "\nThe rate is: " + Df.format((double)Up/Down));
		//49.չʾ��λ����
		int m = 0xAAAAAA;
		int n = 0x555555;
		System.out.println("m is:" + Integer.toBinaryString(m));
		System.out.println("n is:0100" + Integer.toBinaryString(n));
		System.out.println("m&n :" + Integer.toBinaryString(m&n));
		System.out.println("m|n :" + Integer.toBinaryString(m|n));
		System.out.println("m^n :" + Integer.toBinaryString(m^n));
		System.out.println("~m  :" + Integer.toBinaryString(~m));
		System.out.println("~n  :" + Integer.toBinaryString(~n));
		sc.close();
	}
}