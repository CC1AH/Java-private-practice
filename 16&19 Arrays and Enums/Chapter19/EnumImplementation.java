package chapter19_enum;

import java.util.Random;
//596 (2) 枚举实现生成器接口及其修改
interface Generator<T> {
	public T next();
}

/*
 * Original enum CartoonCharacter implements Generator<CartoonCharacter>{
 * SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB; private Random random = new
 * Random(47); public CartoonCharacter next() { return
 * values()[random.nextInt(values().length)]; } }
 */
enum CartoonCharacter {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
}

public class EnumImplementation {
	public static CartoonCharacter next() {
		return CartoonCharacter.values()[new Random().nextInt(CartoonCharacter.values().length)];
	}

	/*
	 * Original public static<T> void System.out.printlnNext(Generator<T> generator){
	 * System.out.System.out.printlnln(generator.next() + ", "); }
	 */
	public static void printNext() {
		System.out.println(next() + ", ");
	}

	public static void main(String args[]) {
		CartoonCharacter cartoonCharacter = CartoonCharacter.BOB;
		for (int i = 0; i < 10; ++i) {
			printNext();
		}
	}
}
