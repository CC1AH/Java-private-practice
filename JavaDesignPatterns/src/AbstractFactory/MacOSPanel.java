package AbstractFactory;

public class MacOSPanel implements Panel{

	public MacOSPanel() {
		System.out.println("a MacOSPanel is created");
	}

	@Override
	public void setTitle(String text) {
		System.out.println("MacOSPanel's setTile is called");

	}

	@Override
	public void setDefaultContent() {
		System.out.println("MacOSPanel's repaint is called");

	}
	
}
