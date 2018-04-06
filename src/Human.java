
public class Human 
{
	public char gamePiece;
	
	public Human(char piece)
	{
		this.gamePiece = piece;
	}
	
	public String move(Board board, int x, int y)
	{
		if(board.gBoard[x-1][y-1] == 0 )
		{
			board.gBoard[x-1][y-1] = this.gamePiece;
			return "";
		}
		else {return "\nSomeone already moved there\n";}
	}

}

