package AbstractFactory;

public class MSPanel implements Panel{

	public MSPanel() {
		System.out.println("a MSPanel is created");
	}

	@Override
	public void setTitle(String text) {
		System.out.println("MSPanel's setTile is called");

	}

	@Override
	public void setDefaultContent() {
		System.out.println("MSPanel's repaint is called");

	}
	
}
