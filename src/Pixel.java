
public class Pixel {
	
	private int elem;

	// generate random background(0) or point(1)
	public Pixel() {
		if(Math.random()<0.5) {
			elem = 0;
		} else {
			elem = 1;
		}
	}
	
	// getter
	public int getElem() {
		return elem;
	}
	
	// setter
	public void setElem(int newElem) {
		elem = newElem;
	}
	
	// draw itself according to itself's color and number
	public void drawSelf() {
		System.out.print(elem);
		System.out.print(" ");
	}

}
