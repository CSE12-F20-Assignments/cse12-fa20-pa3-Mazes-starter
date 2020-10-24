package cse12pa3student;

/*
 * DO NOT MODIFY
 * Class that implements a single unit in a Maze
 * 
 */

class Square {

	@Override
	public String toString() {
		return "Square [row=" + row + ", col=" + col + ", isWall=" + isWall + ", visited=" + visited + "]";
	}

	/* Private fields */
	private final int row, col;			//the x,y position of a square
	private final boolean isWall;		//if the square is a wall
	private Square previous = null;		//the square that was visited before this
	private boolean visited = false;	//if the square has been visited

	/* Constructor */
	public Square(int x, int y, boolean isWall) {
		this.row = x;
		this.col = y;
		this.isWall = isWall;
	}
	
	/* Getters */
	public int getRow() { return this.row; }
	public int getCol() { return this.col; }
	public boolean getIsWall() { return this.isWall; }
	public boolean isVisited() { return this.visited; }
	public Square getPrevious() { return this.previous;	}
	
	/* Setters */
	public void visit() {
		this.visited = true;
	}
	public void setPrevious(Square previous) {
		this.previous = previous;
	}
}