package Strategy;

/**
 * Teachers often take the examples of sorting and validations as the most
 * characteristic usages of this pattern. And they become the best and
 * convenient homework choices. In fact, it is almost useful in most systems
 * which considers flexible features. If you are developers of Android, you may
 * choose Java or Kotlin to implements the same App. If you are users, you must
 * have different views on what suits you best. From file system to UI
 * designing, all of the things involves choosing and the pattern can offer a
 * solution.
 * 
 * The following class gives an using example of completion.
 * 
 * @author CC1AH
 * @since 2019/6/5
 */
public class Usage {
	public static void main(String text[]) {
		new Context(new ConcreteStrategy1()).performStrategy();
		new Context(((ConcreteStrategy2) (new Context(new ConcreteStrategy1()).setStrategy(new ConcreteStrategy2()))))
				.performStrategy();
	}
}
