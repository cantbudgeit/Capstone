import java.util.ArrayList;

public class Computer extends Human{

	public Computer(char piece) 
	{
		super(piece);
	}

	public String move(Board currentBoard, char lastMove)
	{
		Move move = new Move();
		move = Computer.minimax(currentBoard, lastMove, this);
		currentBoard.gBoard[move.pos[0]][move.pos[1]] = this.gamePiece;
		return "";
	}
	public static Move minimax(Board currentBoard, char lastMove, Computer comp)
	{
		char nextMove;
		Move move = new Move();
		Move result = new Move();
		Move bestMove = new Move();
		Board newBoard = new Board();
		copy(currentBoard, newBoard);
		ArrayList<int[]> avalibleSpots = newBoard.emptySpots();
		
		if(currentBoard.hasAnyoneWon() == true)
		{
			if(lastMove == comp.gamePiece)
			{
				move.score ++;
				move.terminal = true;
			}
			else
			{
				move.score --;
				move.terminal = true;
			}
		}
		else if (avalibleSpots.isEmpty())
		{ 
			move.score+=0;
			move.terminal = true;
		}
		
		ArrayList<Move> moves = new ArrayList<Move>();
		
		if(lastMove == 'x') {nextMove ='o';}
		else nextMove = 'x';
		
		for( int[] emptyPos : avalibleSpots)
		{
			move.pos = emptyPos;
			move.piece = nextMove;
			
			newBoard.gBoard[emptyPos[0]][emptyPos[1]] = nextMove;
			
			result = minimax(newBoard, nextMove, comp);
			move.score += result.score;
			moves.add(move);
			
		}
		if(moves.isEmpty()==false)
		{
			if (moves.get(0).piece == comp.gamePiece )
			{
				bestMove = moves.get(0);
				for(Move i : moves)
				{
					if(i.score> bestMove.score)
					{
						bestMove = i;
					}
				}
			}
			else
			{
				bestMove = moves.get(0);
				for(Move i : moves)
				{
					if(i.score < bestMove.score)
					{
						bestMove = i;
					}
				}
			}
		}
		return bestMove;
		
	}
	public static void copy(Board source, Board target)
	{
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                target.gBoard[i][j] = source.gBoard[i][j];
            }
        }
    }
}
