
public class Test {

	public static void main(String[] args) {
		Image test = new Image(8);
		test.drawSelf();
		System.out.println("\n\n\n");

		Processor p = new Processor(0);
		p.run(test);
		
		test.drawSelf();
	}

}
