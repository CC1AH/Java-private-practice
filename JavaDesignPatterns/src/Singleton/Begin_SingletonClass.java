package Singleton;

/**
 * In java, the Singleton will ensure there is only one instance of class is
 * created in the Java Virtual Machine. It is used to provide GLOBAL point of
 * access to the object. The Singleton can avoid the problem that keyword 
 * "static class"  brought in limiting flexibility, both run-time and designing.
 * 
 * 
 * Simple Description: A class is needed to realize it. The necessity are a
 * static member of this class(a log), a private constructor and a public
 * static(so others can call it without creating an object)method to call the
 * constructor.
 * 
 * @author CC1AH 
 * @since 2019/6/5
 */
public class Begin_SingletonClass {
	private static Begin_SingletonClass SingletonObject;

	private Begin_SingletonClass() {
		// System.out.System.out.printlnln("a BeginSingletonClass is created here");
	};

	/*
	 * keyword synchronized is used when you are doing multiple threads. it ensures
	 * that thread2 cannot be accessible to the class when thread1 is using the
	 * method. Optimization will be mentioned in other files of the package.
	 */
	public static synchronized Begin_SingletonClass getSingletonObject() {

		if (SingletonObject == null) {
			SingletonObject = new Begin_SingletonClass();
		}
		return SingletonObject;
	}

	public void otherMethods() {
		System.out.println("other methods of SingletonClass is called");
	}
}
