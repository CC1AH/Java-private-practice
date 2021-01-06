package Singleton;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sometimes the developers don't want the singleton object to be created only
 * when it is needed. They use "final" and give up lazy initialization. And as
 * is shown in this example, you can find that Singleton Patterns can be applied
 * to a container or even groups.
 * 
 * @author CC1AH 
 * @since 2019/6/5
 */
public class SingletonBeforeNeeded {
	@SuppressWarnings("deprecation")
	private static final ArrayList<Object> SingletonBeforeNeededObject = new ArrayList<Object>(
			Arrays.asList(new SingletonBeforeNeeded(), new SingletonBeforeNeeded(), new SingletonBeforeNeeded(),
					new Integer(0), new String("initalization")));

	private SingletonBeforeNeeded() {
		// System.out.System.out.printlnln("a list of SingletonBeforeNeeded is created here, the list
		// should only be filled in this method:);
	}

	public static ArrayList<?> getSingletonList() {
		return SingletonBeforeNeededObject;
	}

	public void otherMethods() {
		System.out.println("other methods of SingletonBeforeNeeded is called");
	}

}
