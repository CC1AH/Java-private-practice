package Strategy;

/**
 * Strategy Pattern is used when you need to realize something dynamically by
 * different ways to achieve the same or just similar aim. It defines a set of
 * encapsulated algorithms that can be swapped to carry out a specific behavior.
 * 
 * Simple Description: An interface "Strategy" is needed to integrate all the
 * strategies together. It contains the method to needed. Different concrete
 * classes implements the interface with different content in them. The class
 * "Context" composed of "Strategy" could be anything that would require chan
 * ging behaviors.
 * 
 * @author CC1AH
 * @since 2019/6/5
 */
public interface Begin_StrategyInterface {
	public void algorithm();
}
