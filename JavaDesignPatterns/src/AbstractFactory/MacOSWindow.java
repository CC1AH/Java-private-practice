package AbstractFactory;

public class MacOSWindow implements Begin_Window {

	public MacOSWindow() {
		System.out.println("a MacOSWindow is created");
	}

	@Override
	public void setTitle(String text) {
		System.out.println("MacOSWindow's setTile is called");

	}

	@Override
	public void repaint() {
		System.out.println("MacOSWindow's repaint is called");

	}

}
