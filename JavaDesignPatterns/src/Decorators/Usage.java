package Decorators;
/**
 * Decorator is an good alternative to subclass especially when
 * there are to much similar or tiny features to be added in a
 * lot of class. The explosion of class always takes a lot of efforts
 * and the pattern can turn these multiple efforts to single.
 * 
 * Teachers always take the example of java io: when FileReader decorates
 * File, BufferedReader decorates FileReader, and Tokenizer decorates Buffer
 * edReader(please view the source code to obtain more).
 * @author CC1AH
 * @since 2019/6/6
 * @see java.io.FileReader
 * @see java.io.BufferedReader
 * @see java.io.Tokenizer
 */
public class Usage {
	public static void main(String text[]) {
		new Decorator(new Decoratee()).methodsDecorated();
	}
}
