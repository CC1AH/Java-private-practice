package AbstractFactory;
/*
 * a detailed usage
 * reference: @ http://coding-geek.com/design-pattern-factory-patterns/
 * java logging system,string class(value of...),containers;Spring;
 * most DAO frameworks.
 */

/**
 * The class is used to build a GUI using different widgets defined. It just
 * takes the advantage of all above functionally.
 * 
 * @author CC1AH
 * @since 2019/6/6
 */
class GUIBuilder {
	
	public Begin_Window createWindow(AbstractWidgetFactory abf) {
		Begin_Window window = abf.createWindow();
		window.setTitle("hello");
		return window;
	}

	public Panel createPanel(AbstractWidgetFactory abf) {
		Panel panel = abf.createPanel();
		panel.setTitle("look here");
		return panel;
	}
}

/**
 * The class uses a GUI builder to create a GUI group without knowing concrete
 * classes
 */
public class Usage {
	public static void main(String text[]) {
		GUIBuilder gb = new GUIBuilder();
		gb.createWindow(new MacWidgetFactory()).repaint();
		gb.createWindow(new MSWidgetFactory()).repaint();
		gb.createPanel(new MacWidgetFactory()).setDefaultContent();
		gb.createPanel(new MSWidgetFactory()).setDefaultContent();
	}
}
