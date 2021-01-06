package Decorators;

public class Decoratee implements Begin_Component {

	@Override
	public void methodsDecorated() {
		System.out.println("methods before decorated is called");
	}

}
