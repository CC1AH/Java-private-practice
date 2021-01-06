package Singleton;

/**
 * Singleton is almost the most widely used patterns. In JDK, java.lang.RunTime
 * uses it in order that there is always only one run time instance that allows
 * application to interface with environment it is running; The singleton is
 * also useful when you have only limited resources especially hardware. Cache
 * is also an example. Logger and configuration files can also use it to bring
 * up efficiency&safety greatly.
 * 
 * The following class gives an overall using example of different ways of
 * completion above.
 * 
 * @author CC1AH
 * @since 2019/6/5
 */
public class Usage {
	public static void main(String args[]) {
		Begin_SingletonClass.getSingletonObject().otherMethods();
		// owing to the effect of erase, a cast must be attached.
		((SingletonBeforeNeeded) (SingletonBeforeNeeded.getSingletonList().get(0))).otherMethods();
		SingletonEnum.SINGLETON_ENUM_INSTANCE.otherMethods();
	}
}
