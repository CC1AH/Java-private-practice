package NormalFactory;

public class ConcreteCreatorforConcreteProduct1 extends Creator{

	@Override
	Begin_Product createProduct() {
		return new ConcreteProduct1();
	}

}
