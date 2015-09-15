public class ConnectFour {
	
	private static final int[] DIRECTIONS = new int[]{0,1,2,3,4,5,6,7};
	private enum Piece { X, O } //this might be overkill..
	private Piece[][] board;
	
	public ConnectFour(char[] moves) {
		board = new Piece[7][6]; // column-justified
		int oMove = 0, xMove = 0, move = 0;
		for (char c : moves) { 
			Piece piece;
			char p;
			if (Character.isLowerCase(c)) { //lower case letters = O
				piece = Piece.O; 
				p = 'O'; 
				move = ++oMove; 
			} else {
				piece = Piece.X; 
				p = 'X'; 
				move = ++xMove; 
			}
			if (dropPiece(Character.toUpperCase(c), piece, move, p)){ //dropPiece expects capital letter
				break; //this means a winner was found.
			}
			
		}
	}
	
	/**
	 * @return true when dropping a piece at the given column wins the game, false otherwise
	 */
	private boolean dropPiece(char col, Piece piece, int move, char p) {
		int column = (int)(col - 65); //convert from ascii to int for array access (A=0, B=1, etc)
		for (int i=0; i<board[column].length; i++){ //iterate from bottom of board up
			if (board[column][i] == null) { //if we find a blank spot, piece will drop there
				board[column][i] = piece;
				break;
			}
		}
		String checkWin = checkWin(); //this is where we check if X or O has won
		if (checkWin != null) {
			System.out.println(p + " won at move "+move+" (with "+checkWin+")");
			return true;
		}
		else
			return false;
	}
	
	/**
	 * @return a string containing the winning sequence of pieces, null if there's no winner
	 */
	private String checkWin() {
		for (int d : DIRECTIONS) { 
			int x=0, y=0;
			switch (d) {
			case 0: //north
				y=1;
				break;
			case 1: //northeast
				x=1; y=1;
				break;
			case 2: //east
				x=1;
				break;
			case 3: //southeast
				x=1; y=-1;
				break;
			case 4: //south
				y=-1;
				break;
			case 5: //southwest
				x=-1; y=-1;
				break;
			case 6: //west
				x=-1;
				break;
			case 7: //northwest
				x=-1; y=1;
				break;
			}
			//now check every piece in the board, moving in the given x,y direction,
			// and counting matching pieces until it finds four in a row, or encounters a mismatch
			for (int j=0; j<7; j++){
				for (int i=0; i<6; i++) {
					int row=i, col=j, count=1;
					Piece curr = board[j][i];
					if (curr == null) continue;  //empty piece, move to the next
					String seq = (char)(col+65)+""+(row+1); //possible winning sequence
					
					//move across board in x,y direction
					while (row+y < 6 && row+y >= 0
						&& col+x < 7 && col+x >= 0) {
						row += y;
						col += x;
						if (curr == board[col][row]) { //piece matches
							count++;
							seq += " " + (char)(col+65) + "" + (row+1);
						}
						else break; //mismatch, break moving across board
					}
					if (count >= 4)	{ //winning sequence found
						seq += ")";
						return seq;
					}
				}
			}
		}
		return null; //no winning sequence found
	}
	
	public static void main(String[] args) {
		char[] moves = new char[args.length*2];
		int i=0;
		for (String pair : args) {
			char[] twoMoves = pair.toCharArray();
			for (char c : twoMoves) if (!Character.isWhitespace(c)) moves[i++] = c;
		}
		//'moves' should be array of individual columns. Uppercase = X, lowercase = O
		new ConnectFour(moves);
	}
}
