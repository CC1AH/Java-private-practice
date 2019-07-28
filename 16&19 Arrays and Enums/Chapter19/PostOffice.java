package chapter19_enum;
//609 8 Enum职责链添加转发功能
//模拟邮局.
import java.util.*;

/**
 * 用于随机获取一个枚举值
 */
class Enums {
	private static Random rand = new Random(47);

	public static <T extends Enum<T>> T random(Class<T> ec) {
		// 注意函数泛型中自限定的意义是枚举实例类型
		return random(ec.getEnumConstants());
	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}
}

class Mail {
	//一个邮件的基本属性和方法
	enum GeneralDelivery {
		YES, NO1, NO2, NO3, NO4, NO5
	}

	enum Scannability {
		UNSCANNABLE, YES1, YES2, YES3, YES4
	}

	enum Readability {
		ILLEGIBLE, YES1, YES2, YES3, YES4
	}

	enum Address {
		INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
	}

	enum IndirectAddress{
		ABLE1,ABLE2,ABLE3,NO1,NO2,NO3
	}
	enum ReturnAddress {
		MISSING, OK1, OK2, OK3, OK4, OK5
	}

	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	IndirectAddress indirectAddress;
	ReturnAddress returnAddress;
	static long counter = 0;
	long id = counter++;

	public String toString() {
		return "Mail " + id;
	}

	public String details() {
		return toString() + ", General Delivery: " + generalDelivery + ", Address Scanability: " + scannability
				+ ", Address Readability: " + readability + ", Address Address: " + address + ", Indirect adress: " + 
				indirectAddress + ", Return address: "+ returnAddress;
	}

//随机生成一个测试邮件
	public static Mail randomMail() {
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
		m.indirectAddress = Enums.random(IndirectAddress.class);
		m.returnAddress = Enums.random(ReturnAddress.class);
		return m;
	}
//提供迭代支持
	public static Iterable<Mail> generator(final int count) {
		return new Iterable<Mail>() {
			int n = count;

			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					public boolean hasNext() {
						return n-- > 0;
					}

					public Mail next() {
						return randomMail();
					}

					public void remove() { // Not implemented
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
//CORE：职责链
public class PostOffice {
	enum MailHandler {
		GENERAL_DELIVERY {
			//能普通投递就普通投递
			boolean handle(Mail m) {
				switch (m.generalDelivery) {
				case YES:
					System.out.println("Using general delivery for " + m);
					return true;
				default:
					return false;
				}
			}
		},
		MACHINE_SCAN {
			//否则 能扫地址且能发 就自动发
			boolean handle(Mail m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						System.out.println("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		},
		VISUAL_INSPECTION {
			//否则 可读地址且能发 就人工发
			boolean handle(Mail m) {
				switch (m.readability) {
				case ILLEGIBLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						System.out.println("Delivering " + m + " normally");
						return true;
					}
				}
			}
		},
		ADDRESS_BY_OTHERS{
			//否则如果不能发送 尝试转发
			boolean handle(Mail m) {
				switch(m.address){
				case INCORRECT:
					switch (m.indirectAddress) {
					case ABLE1:
					case ABLE2:
					case ABLE3:
						System.out.println("Delivering " + m + " indirectly");
						return true;
					default:
						break;
					}
				default:break;
				}
				return false;
			}
			
		},
		RETURN_TO_SENDER {
			//否则 如果能找到发出地就发回去
			boolean handle(Mail m) {
				switch (m.returnAddress) {
				case MISSING:
					return false;
				default:
					System.out.println("Returning " + m + " to sender");
					return true;
				}
			}
		};
		abstract boolean handle(Mail m);
	}
//使用职责链
	static void handle(Mail m) {
		for (MailHandler handler : MailHandler.values())
			if (handler.handle(m))
				return;
		//职责链遍历完成后 就是死局
		System.out.println(m + " is a dead letter");
	}

	public static void main(String[] args) {
		for (Mail mail : Mail.generator(10)) {
			System.out.println(mail.details());
			handle(mail);
			System.out.println("*****");
		}
	}
}
