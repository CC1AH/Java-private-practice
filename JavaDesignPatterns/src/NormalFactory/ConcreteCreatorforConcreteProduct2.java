package NormalFactory;

public class ConcreteCreatorforConcreteProduct2 extends Creator{

	@Override
	Begin_Product createProduct() {
		return new ConcreteProduct2();
	}

}
