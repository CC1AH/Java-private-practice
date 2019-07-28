package U16;
import java.util.*;
class BerylliumSphere implements Comparable<BerylliumSphere>{
	//如果是implements comparator<T> 应该填充compare(T 1,T 2).(equal方法可选)
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
	}//从小到大
}
public class sortB {
	public static void main(String args[]) {
	//451 18 展示数组的浅复制
	//引用复制
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
	//system.copyarray复制:对象数组浅复制 基本类型拷贝
	BerylliumSphere[] copyGroup2 = new BerylliumSphere[Group.length];
	System.arraycopy(Group,0,copyGroup2,0,Group.length);
	System.out.println("\ncopyGroup2 is:");
	for(BerylliumSphere i:copyGroup2) {
		System.out.print(i + " ");
	}
	
	//454 21排序类
	System.out.println("\nAfter Sorting,Group is:");
	Arrays.sort(Group);
	//反转排序：Arrays.sort(Group,Collections.reverseOrder());和binarySearch不可同时使用	
	for(BerylliumSphere i:Group) {
		System.out.print(i + " ");
	}
	//查找：binarySearch只能查找已经排好序的数组
	System.out.println("\n" + Arrays.binarySearch(Group, Group[4]));//如果有元素 则返回索引；
	System.out.println(Arrays.binarySearch(Group, new BerylliumSphere(150)));//如果没有元素 则返回-插入点-1；
	
}}
