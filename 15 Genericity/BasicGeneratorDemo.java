//: generics/BasicGeneratorDemo.java
package U15;

public class BasicGeneratorDemo {
  public static void main(String[] args) {
    //365 4 ��ʾ����Generator����
	  Generator<CountedObject> gen = new BasicGenerator(CountedObject.class);
	  //Generator<CountedObject> gen =
      //BasicGenerator.create(CountedObject.class);
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
  }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
