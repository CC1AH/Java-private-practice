package U14;

import java.util.*;

class Part {
	public String toString() {
		return getClass().getSimpleName();
	}

	static List<factory<? extends Part>> partFactories = new ArrayList<factory<? extends Part>>();
	static {
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
	}
	private static Random rand = new Random(47);

	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
//为每一个类对象创建具体工厂
	public static class Factory implements factory<FuelFilter> {
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class Factory implements factory<AirFilter> {
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinAirFilter extends Filter {
	public static class Factory implements factory<CabinAirFilter> {
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class Factory implements factory<OilFilter> {
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	public static class Factory implements factory<FanBelt> {
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}

public class RegisteredFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			System.out.println(Part.createRandom());
	}
}
