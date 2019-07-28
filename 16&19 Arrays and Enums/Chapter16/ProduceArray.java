package U16;

import java.util.*;
import java.text.*;
import java.math.*;
//440 4展示三维数组的初始化
public class ProduceArray {
	public static double[][][] createArray(int size1,
			int size2,int size3,double bound1,double bound2){
		Random rand = new Random(47);
		double minus = bound2 - bound1;
		double result[][][] = new double[size1][size2][size3];
		for(int i=0;i<size1;i++) {
			for(int j=0;j<size2;++j) {
				for(int k=0;k<size3;++k) {
					double temp = bound1 + rand.nextDouble()*minus;
					result[i][j][k] = Math.round(temp*100)/100.0;
					//math.round 返回一个数字四舍五入后最接近的long
					//用这种巧妙的方式可以实现double的精度确定
				}
			}
		}
			return result;
	}
	public static void showDemensionArray(double[][][] ob) {
		System.out.println(Arrays.deepToString(ob));
	}
	public static void main(String args[]) {
		showDemensionArray(createArray(2,4,3,100,200));
	}
}
