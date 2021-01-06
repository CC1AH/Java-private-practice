package Singleton;
/**
 * Using enum is another thread-safe way to implement singleton.
 * In fact, the definition of enum coincides with which of singleton. 
 * @author CC1AH
 * @since 2019/6/5
 */
public enum SingletonEnum {
	SINGLETON_ENUM_INSTANCE;
	public void otherMethods() {
		System.out.println("other methods of SingletonEnum is called");
	}
}
