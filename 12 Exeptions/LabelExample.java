package adaptMeUsuAndExp;
//267 label Ê¹ÓÃÊ¾Àı
public class LabelExample {
	public static void main(String args[]) {
	for(int i=0;i<=9;++i) { 
		label:{
		for(int j=0;j<=9;++j) {
			System.out.print(i + "*" + j + "=" + (i*j) + "  ");
			if(j>=i)
				break label;
			}
		}
	System.out.println("");
	}
}}
