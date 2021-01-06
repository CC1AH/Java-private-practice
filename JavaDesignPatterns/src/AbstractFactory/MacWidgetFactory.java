package AbstractFactory;

public class MacWidgetFactory implements AbstractWidgetFactory{

	@Override
	public Begin_Window createWindow() {
		MacOSWindow mw = new MacOSWindow();
		return mw;
	}

	@Override
	public Panel createPanel() {
		return new MacOSPanel();
	}

}
