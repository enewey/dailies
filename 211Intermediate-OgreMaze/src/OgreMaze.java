import java.util.Vector;

public class OgreMaze 
{	
	public static final String _input = "@@........"
									+	"@@O......."
									+	".....O.O.."
									+	".........."
									+	"..O.O....."
									+	"..O....O.O"
									+	".O........"
									+	".........."
									+	".....OO..."
									+	".........$";
	public static final String _input2 = "$.O...O..."
										+"...O......"
										+".........."
										+"O..O..O..."
										+".........."
										+"O..O..O..."
										+".........."
										+"......OO.."
										+"O..O....@@"
										+"........@@";	
	public static final String _input3 = ".@@.....O."
										+".@@......."
										+"..O..O...."
										+".......O.."
										+"...O......"
										+".........."
										+".......O.O"
										+"...O.O...."
										+".......O.."
										+".........$";
	public enum Direction{UP,DOWN,LEFT,RIGHT}

	//Anchor the Ogre at the top-left @
	public static Vector<Integer> getOgrePos(char[][] board)
	{
		Vector<Integer> ret = new Vector<Integer>();
		for (int i=0; i<board.length; i++)
			for (int j=0; j<board[i].length; j++)
				if (board[i][j] == '@')
				{
					ret.add(j);
					ret.add(i);
					return ret;
				}
		
		return null;
	}

	public static boolean isPassable(char c) { return (c == '.' || c == '$'); }
	
	public static boolean canMove(int x_pos, int y_pos, Direction d, char[][] board)
	{
		if (d == Direction.RIGHT) //right
		{
			return (x_pos < 8 
					&& isPassable(board[y_pos][x_pos+2]) 
					&& isPassable(board[y_pos+1][x_pos+2]));
		}
		else if (d == Direction.LEFT)
		{
			return (x_pos > 0 
					&& isPassable(board[y_pos][x_pos-1]) 
					&& isPassable(board[y_pos+1][x_pos-1]));
		}
		else if (d == Direction.UP)
		{
			return (y_pos > 0 
					&& isPassable(board[y_pos-1][x_pos]) 
					&& isPassable(board[y_pos-1][x_pos+1]));
		}
		else if (d == Direction.DOWN)
		{
			return (y_pos < 8
					&& isPassable(board[y_pos+2][x_pos]) 
					&& isPassable(board[y_pos+2][x_pos+1]));
		}
		return false;
	}
	
	public static boolean isThereMoney(int x_pos, int y_pos, Direction d, char[][] board)
	{	
		if (d == Direction.RIGHT) //right
			return (board[y_pos][x_pos+2] == '$' || board[y_pos+1][x_pos+2] == '$');
		else if (d == Direction.LEFT)
			return (board[y_pos][x_pos-1] == '$' || board[y_pos+1][x_pos-1] == '$');
		else if (d == Direction.UP)
			return (board[y_pos-1][x_pos] == '$' || board[y_pos-1][x_pos+1] == '$');
		else if (d == Direction.DOWN)
			return (board[y_pos+2][x_pos] == '$' || board[y_pos+2][x_pos+1] == '$');
		
		return false;
	}
	
	public static char[][] getBoard(String in)
	{
		char[][] board = new char[10][10];
		int counter=0;
		for (int i=0; i<10; i++)
			for (int j=0; j<10; j++)
				board[i][j] = in.charAt(counter++);
		
		return board;
	}
	
	public static char[][] copyBoard(char[][] board)
	{
		char[][] copy = new char[10][];
		for (int i=0; i<10; i++)
			copy[i] = board[i].clone();
		return copy;
	}
	
	public static char[][] getPath(int x, int y, char[][] board)
	{
		//Down Case
		if (canMove(x, y, Direction.DOWN, board)){			
			char[][] nextBoard = copyBoard(board);
			nextBoard[y][x] = '&';
			nextBoard[y][x+1] = '&';
			nextBoard[y+2][x] = '@';
			nextBoard[y+2][x+1] = '@';
			if (isThereMoney(x, y, Direction.DOWN, board))
				return nextBoard;
			char[][] ret = getPath(x, y+1, nextBoard);
			if (ret != null)
				return ret;
		}
		//Up Case
		if (canMove(x, y, Direction.UP, board)){
			char[][] nextBoard = copyBoard(board);
			nextBoard[y+1][x] = '&';
			nextBoard[y+1][x+1] = '&';
			nextBoard[y-1][x] = '@';
			nextBoard[y-1][x+1] = '@';
			if (isThereMoney(x, y, Direction.UP, board))
				return nextBoard;
			char[][] ret = getPath(x, y-1, nextBoard);
			if (ret != null)
				return ret;
		}
		//Left Case
		if (canMove(x, y, Direction.LEFT, board)){
			char[][] nextBoard = copyBoard(board);
			nextBoard[y][x+1] = '&';
			nextBoard[y+1][x+1] = '&';
			nextBoard[y][x-1] = '@';
			nextBoard[y+1][x-1] = '@';
			if (isThereMoney(x, y, Direction.LEFT, board))
				return nextBoard;
			char[][] ret = getPath(x-1, y, nextBoard);
			if (ret != null)
				return ret;
		}
		//Right Case
		if (canMove(x, y, Direction.RIGHT, board)){
			char[][] nextBoard = copyBoard(board);
			nextBoard[y][x] = '&';
			nextBoard[y+1][x] = '&';
			nextBoard[y][x+2] = '@';
			nextBoard[y+1][x+2] = '@';
			if (isThereMoney(x, y, Direction.RIGHT, board))
				return nextBoard;
			char[][] ret = getPath(x+1, y, nextBoard);
			if (ret != null)
				return ret;
		}
		
		return null;
	}
	
	public static void main(String[] args) 
	{
		char[][] board = getBoard(_input2);
		Vector<Integer> pos = getOgrePos(board);
		char[][] ret = getPath(pos.get(0), pos.get(1), board);
		
		if (ret != null)
		{
			for (int i=0; i<10; i++)
			{
				for (int j=0; j<10; j++)
					System.out.print(ret[i][j]);
				System.out.print("\n");
			}	
		}
		else
			System.out.println("No Path");
	}
}