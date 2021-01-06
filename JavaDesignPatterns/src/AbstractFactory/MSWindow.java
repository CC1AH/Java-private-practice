package AbstractFactory;

public class MSWindow implements Begin_Window{

	public MSWindow() {
		System.out.println("a MSWindow is created");
	}
	
	@Override
	public void setTitle(String text) {
		System.out.println("MSWindow's setTile is called");
		
	}

	@Override
	public void repaint() {
		System.out.println("MSWindow's repaint is called");
		
	}

}
