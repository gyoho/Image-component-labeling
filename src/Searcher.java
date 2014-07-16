import java.util.Queue;

public abstract class Searcher {
	
	Position current, next;						
	int moveDirection = 0;					// the same among all subclass
	final int moveLastDirection = 3;		// apply to all subclass
	Position [] offset = new Position [4];
	
	public Searcher() {
		current = new Position(1,1);
		next = new Position(0,0);
		offset[0] = new Position(0, 1);   // right
		offset[1] = new Position(1, 0);   // down
		offset[2] = new Position(0, -1);  // left
		offset[3] = new Position(-1, 0);  // up
	}
	
	public void checkNextBlock(int direction) {
		next.row = current.row + offset[direction].row;
		next.col = current.col + offset[direction].col;
	}
	public abstract Queue<Position> findPath(Image inputImage, Position seedPos);
}
