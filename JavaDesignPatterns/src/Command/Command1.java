package Command;

public class Command1 implements Begin_Command{

	@Override
	public void excute() {
		System.out.println("Command 1 is called");
	}
	
}
