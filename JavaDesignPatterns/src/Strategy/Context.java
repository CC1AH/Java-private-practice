package Strategy;

/**
 * "Context" can be a class or even a group of extension and so on. It is
 * composed of strategy objects(log) and should be able to initialize or even
 * change the strategies it uses. Of course, it can be the owner to use the
 * strategies.
 * 
 * @author CC1AH
 * @since 2019/6/5
 */
public class Context {
	private Begin_StrategyInterface Strategy;

	public void performStrategy() {
		Strategy.algorithm();
	}

	/**
	 * the constructor to initialize the strategy objects.
	 * 
	 * @param Begin_StrategyInterface
	 */
	public Context(Begin_StrategyInterface whatStrategy) {
		Strategy = whatStrategy;
		// System.out.System.out.printlnln("Context is created and Strategy is fixed");
	}

	/**
	 * the method to set the strategy objects.
	 * 
	 * @param Begin_StrategyInterface
	 */
	public Begin_StrategyInterface setStrategy(Begin_StrategyInterface whatStrategy) {
		return (Strategy = whatStrategy);
		// System.out.System.out.printlnln("Strategy has been changed by settor");
	}
}
