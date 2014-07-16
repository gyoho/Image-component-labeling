
public class Image {
	
	/** How to create a matrix
	 * 1. declare: image references a pixel type of matrix
	 * 2. instantiate: image points to a certain size of matrix
	 * 		holding a pointer for the type pointing to null
	 * 3. assign: instantiate an object of the type by letting
	 * 		the pointer reference the object instead of null
	 */
	
	// image holds pixels
	private int size;
	private Pixel[][] image;				// step1

	// generate n*n dimension randomly labeled matrix according to the user input
	public Image(int newSize) {
		size = newSize;
		image = new Pixel[size+2][size+2];	// step2
		for(int i=0; i<size+2; i++)	{		// step3
			for(int j=0; j<size+2; j++) {
				image[i][j] = new Pixel();
			}
		}
		
		// create a wall surround it
		for(int i=0; i<size+2; i++) {
			image[0][i].setElem(0);
			image[size+1][i].setElem(0);
			image[i][0].setElem(0);
			image[i][size+1].setElem(0);
		}
	}
	
	// getter
	public Pixel[][] getImage() {
		return image;
	}
	
	public int getSize() {
		return size;
	}
	
	
	// TODO: use enhanced loop
	public void drawSelf() {
		for(int i=0; i<size+2; i++)	{
			System.out.println();
			for(int j=0; j<size+2; j++) {
				image[i][j].drawSelf();
			}
		}
	}
}
