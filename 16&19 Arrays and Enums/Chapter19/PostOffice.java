package chapter19_enum;
//609 8 Enumְ�������ת������
//ģ���ʾ�.
import java.util.*;

/**
 * ���������ȡһ��ö��ֵ
 */
class Enums {
	private static Random rand = new Random(47);

	public static <T extends Enum<T>> T random(Class<T> ec) {
		// ע�⺯�����������޶���������ö��ʵ������
		return random(ec.getEnumConstants());
	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}
}

class Mail {
	//һ���ʼ��Ļ������Ժͷ���
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

//�������һ�������ʼ�
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
//�ṩ����֧��
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
//CORE��ְ����
public class PostOffice {
	enum MailHandler {
		GENERAL_DELIVERY {
			//����ͨͶ�ݾ���ͨͶ��
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
			//���� ��ɨ��ַ���ܷ� ���Զ���
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
			//���� �ɶ���ַ���ܷ� ���˹���
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
			//����������ܷ��� ����ת��
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
			//���� ������ҵ������ؾͷ���ȥ
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
//ʹ��ְ����
	static void handle(Mail m) {
		for (MailHandler handler : MailHandler.values())
			if (handler.handle(m))
				return;
		//ְ����������ɺ� ��������
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
