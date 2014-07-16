import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearcher extends Searcher{
	private Queue<Position> backPath;
	private Queue<Position> path;
	
	public BreadthFirstSearcher() {
		super();
		backPath = new LinkedList<Position>();
		path = new LinkedList<Position>();
	}
	
	@Override
	public Queue<Position> findPath(Image inputImage, Position seedPos) {
		// start at the seed point
		current.setPosition(seedPos.row, seedPos.col);
		// set the start point to already visited 
		inputImage.getImage()[current.row][current.col].setElem(0);
		// add the current block to the path
		path.add(new Position(current));
		
		// move to the next adjacent position until stuck
		while(true) {
			for(moveDirection = 0; moveDirection <= moveLastDirection; moveDirection++) {
				checkNextBlock(moveDirection);
				// check if the moving direction's block is unvisited yet
				if(inputImage.getImage()[next.row][next.col].getElem() == 1) {
					// keep track of the path to go back
					backPath.add(new Position(next));
					// add the current block to the path
					path.add(new Position(next));
					// mark the block visited
					inputImage.getImage()[next.row][next.col].setElem(0);
				}
			}
			
			// if stuck
			if(backPath.isEmpty()) {
				return path;
			}
			
			// if the can go back, go back
			Position back =  backPath.remove();
			current.setPosition(back);
		}
	}
}
