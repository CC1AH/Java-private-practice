package Decorators;
public class Decorator implements Begin_Component {
	private Begin_Component decorateeObject;

	// their may be other decoratees, so we use the interface as @param and field log.
	public Decorator(Begin_Component decoratee) {
		decorateeObject = decoratee;
	}

	/**
	 * the core of decorator pattern exists in the added part both in methods and
	 * fields. different from adapter, you can remain the most similarity of
	 * decorator and decoratee by making them implements the same interface and add
	 * extensions easily.
	 */
	public String addedComponent = ", and now it is decorated";

	@Override
	public void methodsDecorated() {
		decorateeObject.methodsDecorated();
		System.out.println(addedComponent);
	}
}
