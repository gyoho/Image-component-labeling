import java.util.Queue;


public class Processor {
	
	private int method;

	public Processor(int newMethod) {
		method = newMethod;
	}
	
	public void run(Image inputImage) {
		Position seedPos;
		Position origin = new Position();
		Queue<Position> path;
		int elemNum = 2;	// starting at 0 and 1 is already reserved
		
		/** if there is no unlabeled element in the beginning
		    then, use do-while loop is redundant **/
		seedPos = findSeed(inputImage);
		
		while(!seedPos.equals(origin)) {
			// find the unlabeled block around it
			Searcher srchr = new BreadthFirstSearcher();
			path = srchr.findPath(inputImage, seedPos);
						
			// label them
			labelPixel(inputImage, path, elemNum);
			elemNum++;
			
			// get next seed
			seedPos = findSeed(inputImage);
		}
		
	}
	
	// scan the picture to find an unlabeled pixel (seed)
	// if no find, return position(0, 0)
	public Position findSeed(Image inputImage) {
		Position seedPos = new Position(0, 0);
		
		for(int row=1; row<=inputImage.getSize(); row++)	{
			for(int col=1; col<=inputImage.getSize(); col++) {
				if(inputImage.getImage()[row][col].getElem() == 1) {
					seedPos.setPosition(row, col);
					return seedPos;
				}
			}
		}
		return seedPos;
	}
	
	// label an unlabeled pixel with respective number
	// labelPixel shouldn't care about finding path or any
	// other than labeling is not its business
	public void labelPixel(Image inputImage, Queue<Position> path, int elemNum) {
		while(!path.isEmpty()) {
			Position unlabeledPos = path.remove();
			inputImage.getImage()[unlabeledPos.row][unlabeledPos.col].setElem(elemNum);
		}
	}
}
