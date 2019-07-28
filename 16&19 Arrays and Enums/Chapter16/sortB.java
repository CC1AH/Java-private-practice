package U16;
import java.util.*;
class BerylliumSphere implements Comparable<BerylliumSphere>{
	//�����implements comparator<T> Ӧ�����compare(T 1,T 2).(equal������ѡ)
	private static long counter = 0;
	private final long id = counter++;
	private static Random rand = new Random(47);
	private int value;
	public String toString() {
		return "sphere" + id + ": " + value;
	}
	public BerylliumSphere() {
		value = rand.nextInt(300);
	}
	public BerylliumSphere(int value) {
		this.value = value;
	}
	@Override
	public int compareTo(BerylliumSphere o) {
		return (value<o.value)?-1:(value==o.value?0:1);
	}//��С����
}
public class sortB {
	public static void main(String args[]) {
	//451 18 չʾ�����ǳ����
	//���ø���
	BerylliumSphere[] Group= new BerylliumSphere[20];
	for(int i=0;i<Group.length;++i)
		Group[i] = new BerylliumSphere();
	
	BerylliumSphere[] copyGroup = Group;
	System.out.println("Group is:");
	for(BerylliumSphere i:Group) {				
		System.out.print(i + " ");
	}
	System.out.println("\ncopyGroup is:");
	for(BerylliumSphere i:copyGroup) {		
		System.out.print(i + " ");
	}
	//system.copyarray����:��������ǳ���� �������Ϳ���
	BerylliumSphere[] copyGroup2 = new BerylliumSphere[Group.length];
	System.arraycopy(Group,0,copyGroup2,0,Group.length);
	System.out.println("\ncopyGroup2 is:");
	for(BerylliumSphere i:copyGroup2) {
		System.out.print(i + " ");
	}
	
	//454 21������
	System.out.println("\nAfter Sorting,Group is:");
	Arrays.sort(Group);
	//��ת����Arrays.sort(Group,Collections.reverseOrder());��binarySearch����ͬʱʹ��	
	for(BerylliumSphere i:Group) {
		System.out.print(i + " ");
	}
	//���ң�binarySearchֻ�ܲ����Ѿ��ź��������
	System.out.println("\n" + Arrays.binarySearch(Group, Group[4]));//�����Ԫ�� �򷵻�������
	System.out.println(Arrays.binarySearch(Group, new BerylliumSphere(150)));//���û��Ԫ�� �򷵻�-�����-1��
	
}}
