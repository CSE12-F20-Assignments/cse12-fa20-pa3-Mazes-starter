package cse12pa3student;

/* 
 * DO NOT MODIFY
 * Class that implements a Maze for traversal
 * 
 */


class Maze {
	public final Square start, finish;
	public final Square[][] contents;
	public final int rows, cols;


	/*
	 * @param mazeSpec is expected to have all strings with the same length, and to
	 * have length at least 1 The strings should contain only the following
	 * characters:
	 * 
	 * - '_': means "empty space" - '#': means "wall" - 'F': means "finish", can
	 * only appear once across all strings - 'S': means "start", can only appear
	 * once across all strings
	 * 
	 * Initializes Squares in a contents array such that the start and target fields
	 * hold references to the corresponding locations in the contents array
	 */
	public Maze(String[] mazeSpec) {
		int rows = mazeSpec.length;
		int cols = mazeSpec[0].length();
		Square[][] contents = new Square[rows][cols];
		Square start = null, finish = null;
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < cols; j += 1) {
				switch (mazeSpec[i].charAt(j)) {
				case '_':
					contents[i][j] = new Square(i, j, false);
					break;
				case '#':
					contents[i][j] = new Square(i, j, true);
					break;
				case 'S':
					contents[i][j] = new Square(i, j, false);
					start = contents[i][j];
					break;
				case 'F':
					contents[i][j] = new Square(i, j, false);
					finish = contents[i][j];
					break;
				}

			}
		}
		this.start = start;
		this.finish = finish;
		this.contents = contents;
		this.rows = rows;
		this.cols = cols;
	}

	/*
	 * Produce a grid with # for walls and _ for empty spaces, nothing else (e.g. no
	 * start and finish)
	 */
	private char[][] buildBackground() {
		char[][] pieces = new char[this.rows][this.cols];
		for (int row = 0; row < this.rows; row += 1) {
			for (int col = 0; col < this.cols; col += 1) {
				Square s = this.contents[row][col];
				if (s.getIsWall()) {
					pieces[row][col] = '#';
				} else {
					pieces[row][col] = '_';
				}
			}
		}
		return pieces;
	}

	/*
	 * Produce a string array like the arguments to the String[] constructor, but
	 * with a '*' in each empty space that is part of the solution.
	 * 
	 * Assumes that the previous pointers, starting from finish, have been set and
	 * following them will reach start.
	 */
	public String[] showSolution() {
		char[][] background = buildBackground();

		Square current = this.finish.getPrevious();
		while (current != this.start) {
			background[current.getRow()][current.getCol()] = '*';
			current = current.getPrevious();
		}

		background[this.finish.getRow()][this.finish.getCol()] = 'F';
		background[this.start.getRow()][this.start.getCol()] = 'S';

		String result[] = new String[this.rows];
		int i = 0;
		for (char[] cs : background) {
			result[i] = new String(cs);
			i += 1;
		}
		return result;
	}
}