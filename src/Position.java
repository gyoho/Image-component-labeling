
public class Position {
	int row, col;

	public Position() {
		this(0, 0);
	}

	public Position(int newRow, int newCol) {
		row = newRow;
		col = newCol;
	}
	
	public Position(Position newPos) {
		row = newPos.row;
		col = newPos.col;
	}
	
	public void setPosition(int newRow, int newCol) {
		row = newRow;
		col = newCol;
	}
	
	public void setPosition(Position newPos) {
		row = newPos.row;
		col = newPos.col;
	}
	
	public boolean equals(Position target) {
		return (row == target.row && col == target.col);
	}
	
	public void print()	{
		System.out.println("(" + row + ", " + col + ")");
	}
	
}
