package NormalFactory;

/**
 * An overall usage description will be given at AbstractFactoryPackage.
 * here presents the usage of examples.
 * @author CC1AH
 * @since 2019/6/6
 */
public class Usage {
	public static Begin_Product createBy(Creator c) {
		return c.createProduct();
	}
	public static void main(String text[]) {
		//now users don't need know what is provided actually. They only 
		//need to know if we deliver the job to the right factories, they 
		//will return the object we want.
		createBy(new ConcreteCreatorforConcreteProduct1()).performProduct();
		createBy(new ConcreteCreatorforConcreteProduct2()).performProduct();
	}
}
