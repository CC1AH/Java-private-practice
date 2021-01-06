package AbstractFactory;

public class MSWidgetFactory implements AbstractWidgetFactory {

	@Override
	public Begin_Window createWindow() {
		MSWindow mw = new MSWindow();
		return mw;
	}

	@Override
	public Panel createPanel() {
		return new MSPanel();
	}

}
