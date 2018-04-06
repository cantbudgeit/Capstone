import java.util.*;;

public class Board 
{

	public char[][] gBoard = {{'o', 'o', 0},{'x', 'o', 'x'}, {0,0,'x'}};
	
	public Board() 
	{
	}
	
	public boolean hasAnyoneWon()
	{
		boolean win = false;
		
		//vertical
		for(int i = 0; i<3; i++)
		{
			if(this.gBoard[0][i]== this.gBoard[1][i] && this.gBoard[1][i] == this.gBoard[2][i] && this.gBoard[1][i] != 0 )
			{
				win = true;
			}
		}
		//horizontal
		for(int i = 0; i<3; i++)
		{
			if(this.gBoard[i][0]== this.gBoard[i][1] && this.gBoard[i][1] == this.gBoard[i][2] && this.gBoard[i][1] != 0)
			{
				win = true;
			}
		}
		
		//top left diagonal
		if(this.gBoard[0][0]==this.gBoard[1][1] && this.gBoard[1][1]==this.gBoard[2][2] && this.gBoard[1][1] != 0)
		{
			win = true;
		}
		//top right diagonal
		if(this.gBoard[0][2]==this.gBoard[1][1] && this.gBoard[1][1]==this.gBoard[2][0] && this.gBoard[1][1] != 0)
		{
			win = true;
		}
		return win;
	}
	public ArrayList<int[]> emptySpots()
	{
		ArrayList<int[]> empty = new ArrayList<int[]>();
		int emptyIndex = 0;
		
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				if(this.gBoard[i][j]==0)
				{
					int[] temp = {i, j};
					empty.add(temp);
					emptyIndex++;
				}
			}
		}
		
		return empty;
	}
	public void print()
	{
		System.out.print("\n\n");
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				System.out.print(gBoard[i][j]+" ");
				if(j<2) {System.out.print("|");}
			}
			if(i<2) {System.out.print("\n--------\n");}
		}
	}
}
