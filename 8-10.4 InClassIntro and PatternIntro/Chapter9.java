package Music;
import static Music.Print.*;
import java.util.*;
class Print{
	static void print(Object ob){
		System.out.println(ob);
	}
}
enum Note{
	middle_C, C_sharp,B_flat
   }
//չʾ��ӵ��öԶ�̬��Ӱ��
class Instrument{
	public void rePlay(Note m) {
		play(m);
	}
	void play(Note n) {
		print("Instrument play()" + n);
	}
	public String toString() {
		return "Instrument";
	}
	void adjust() {
		print("Adjusting Instrument");
	}
}
//����
class Wind extends Instrument{
	void play(Note n) {
		print("Wind play()" + n);
	}
	public String toString() {
		return "Wind";
	}
	void adjust() {
		print("Adjusting Wind");
	}
}
class Percussion extends Instrument{
	void play(Note n) {
			print("Persussion play()" + n);
	}
	public String toString() {
			return "Percussion";
	}
	void adjust() {
			print("Adjusting Percussion");
	}
}
class Stringed extends Instrument{
	void play(Note n) {
			print("Stringed play()" + n);
	}
	public String toString() {
			return "Stringed";
	}
	void adjust() {
			print("Adjusting Stringed");
	}
}
//һ����
class Brass extends Wind{
	void play(Note n) {
			print("Brass Play()" + n);
	}
	void adjust() {
		print("Adjusting Brass");
	}
}
class WoodWind extends Wind{
	void play(Note n) {
		print("WoodWind play()" + n);
	}
	public String toString() {
		return "WoodWind";
	}
}
public class Chapter9{
	public static void tune(Instrument i){
		i.play(Note.middle_C);
	}
	public static void tuneAll(Instrument[] e) {
		for(Instrument i:e) {
			tune(i);
		}
	}
	public static void showWhat(Instrument[] e) {
		for(Instrument i:e) {
			System.out.println(i);
		}
	}
	public static void main(String args[]) {
		Instrument Orchestra[] = new Instrument[10];
		Random rand = new Random();//ÿ�β�һ�� ֻ��Ҫ�޲μ���
		for(int i=0;i<10;++i) {
			switch(rand.nextInt(5)) {
			case 0:
				Orchestra[i] = new Wind();
				break;
			case 1:
				Orchestra[i] = new Percussion();
				break;
			case 2:
				Orchestra[i] = new Stringed();
				break;
			case 3:
				Orchestra[i] = new WoodWind();
				break;
			case 4:
				Orchestra[i] = new Brass();
				break;
			}
		}
		tuneAll(Orchestra);
		print("\n");
		showWhat(Orchestra);
		//to show the result of undirectly call
		Instrument exp= new Wind();
		exp.rePlay(Note.middle_C);
	}
}

