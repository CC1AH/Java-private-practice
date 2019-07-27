

public class Chapter4 {
	public static void main(String args[]) {
		//67-4 检验素数的程序1-1000
		int k=0;
		for(int i=2;i<997;++i) {
			if(isPrime(i)) {
				System.out.print(i + " ");
				if(i<100)
					System.out.print(" ");
				if(i<10)
					System.out.print(" ");
				k++;
				if(k%20==0) 
					System.out.println("\n");
		    }
		}
		System.out.println("\n************\n");
		//69-6 测试是否在区间内的函数
		k=0;
		for(int i=1;i<101;++i) {
				System.out.print(Test(i,40,60) + " ");
				k++;
			if(k%20==0) 
				System.out.println("\n");
	    }
		System.out.println("************\n");
		//75-10 测试是吸血鬼数字的四位数
		for(int i=1260;i<10000;++i) {
			if(isGhostNumber(i))
				System.out.print(i + " ");
		}
		System.out.println("\n************\n");
	}
	//67-4
	static boolean isPrime(int m) {
		for(int i=2;i<Math.sqrt(m+1);++i) {
			if(m%i == 0)
				return false;
		}
		return true;
	}
	//69-6
	static int Test(int testval,int begin,int end) {
		if(testval>=begin && testval<=end) 
			 return 0;
		return (testval-begin);
	}
	//75-10
	static int PN(int i,int j) {
		return i*10+j;
	}
	static boolean test(int i,int m,int n) {
		if(m*n==i)
			return true;
		return false;
	}
	static boolean isGhostNumber(int aim) {
		int temp = aim;
		int s = 0;
		int[] save = new int[4];
		while(temp!=0) {
			save[s++] = temp%10;
			temp /= 10;
		}
		//4C2/2=3（乘数与被乘数可以互换） 第一个反序第二个反序*4 共十二种情况
		if(test(aim,PN(save[0],save[1]),PN(save[2],save[3]))) return true;
		if(test(aim,PN(save[0],save[1]),PN(save[3],save[2]))) return true;
		if(test(aim,PN(save[1],save[0]),PN(save[2],save[3]))) return true;
		if(test(aim,PN(save[1],save[0]),PN(save[3],save[2]))) return true;
		
		if(test(aim,PN(save[0],save[2]),PN(save[3],save[1]))) return true;
		if(test(aim,PN(save[0],save[2]),PN(save[1],save[3]))) return true;
		if(test(aim,PN(save[2],save[0]),PN(save[3],save[1]))) return true;
		if(test(aim,PN(save[2],save[0]),PN(save[1],save[3]))) return true;
		
		if(test(aim,PN(save[0],save[3]),PN(save[1],save[2]))) return true;
		if(test(aim,PN(save[0],save[3]),PN(save[2],save[1]))) return true;
		if(test(aim,PN(save[3],save[0]),PN(save[2],save[1]))) return true;
		if(test(aim,PN(save[3],save[0]),PN(save[1],save[2]))) return true;
		return false;
	}
}