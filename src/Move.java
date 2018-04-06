
public class Move {
	public int score;
	public int[] pos;
	public boolean terminal;
	public char piece;
	public Move()
	{
		this.score = 0;
		this.terminal = false;
		this.pos = new int[2];
	}

}
