package NormalFactory;

public abstract class Creator {
	abstract Begin_Product createProduct();
	
	/**
	 * the method do operation on product. they can be get or 
	 * set or so on.
	 * @return Begin_product
	 */
	public Begin_Product Operation() {
		return createProduct();//now, this is a gettor.
	}
}
