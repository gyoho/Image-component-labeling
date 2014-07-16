import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class DepthFirstSearcher extends Searcher{
	private Stack<Position> backPath;
	private Queue<Position> path;
	
	public DepthFirstSearcher() {
		super();
		backPath = new Stack<Position>();
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
			// while there is an available move direction
			while(moveDirection <= moveLastDirection) {
				checkNextBlock(moveDirection);
				// check if the moving direction's block is unvisited yet
				if(inputImage.getImage()[next.row][next.col].getElem() == 1) {
					// if so, break
					break;
				}
				
				// if not, try another direction
				moveDirection++;
			}
			
			// if found the adjacent area available
			if(moveDirection <= moveLastDirection) {
				/** add the back path before moving to the next
				 *  if we hit the wall, we need only the way to back
				 *  which doesn't include the position right now
				**/
				// keep track of the path to go back
				backPath.add(new Position(current));
				// move to the block
				current = new Position(next);
				// add the current block to the path
				path.add(new Position(current));				
				// mark the block visited
				inputImage.getImage()[current.row][current.col].setElem(0);
				// reset the move direction
				moveDirection = 0;
			} else { // if not found any available neighbor
				// if stuck
				if(backPath.isEmpty()) {
					return path;
				}
				
				// if the can go back, go back
				Position back =  backPath.pop();
				if (back.row == current.row) {
					moveDirection = 2 + back.col - current.col;
				} else {
					moveDirection = 3 + back.row - current.row;
				}
				
				current.setPosition(back);
			}
		}
		
	}
}
