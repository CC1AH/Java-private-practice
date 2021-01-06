package NormalFactory;

/**
 * Factory Method achieved by enormous classes. if factory is needed by user
 * himself or is not used very often.
 * 
 * @author CC1AH
 * @since 2019/6/6
 */
abstract class EnormousCreator {
	abstract Begin_Product createProduct();

	/**
	 * the method do operation on product. they can be get or set or so on.
	 * 
	 * @return Begin_product
	 */
	public Begin_Product Operation() {
		return createProduct();// now, this is a gettor.
	}
}// it is the same with Creator,in fact.

class LittleUseProduct implements Begin_Product {

	@Override
	public void performProduct() {
		System.out.println("LittleUse Product is performed");
	}

}

public class SampleUsingEnormousClass {
	public static Begin_Product createBy(EnormousCreator c) {
		return c.createProduct();
	}

	public static void main(String text[]) {
		// now users don't need know what is provided actually. They only
		// need to know if we deliver the job to the right factories, they
		// will return the object we want.
		createBy(new EnormousCreator() {

			@Override
			Begin_Product createProduct() {
				return new ConcreteProduct1();
			}
		}).performProduct();

		createBy(new EnormousCreator() {

			@Override
			Begin_Product createProduct() {
				return new LittleUseProduct();
			}
		}).performProduct();
	}
}