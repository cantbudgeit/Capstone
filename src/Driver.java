import java.util.*;
public class Driver 
{

	public static void main(String[] args) 
	{
		Board gameBoard = new Board();
		Human player1 = new Human('x');
		Computer player2 = new Computer('o');

		boolean done = false;
		char lastMove = 'o';
		
		int x;
		int y;
		
		System.out.println("Welcome to tic tac toe, the first player is x the second is o");
		Scanner scan = new Scanner(System.in);
		while(done == false)
		{
			if(lastMove == 'o')
			{	
				System.out.println("Type in the coordinates in the form row, column.");
				x = scan.nextInt();
				y = scan.nextInt();
				String message = player1.move(gameBoard, x, y);
				if (message.equals("")) {lastMove = 'x';}
				else {System.out.print(message);}
			}
			else 
			{
				String message = player2.move(gameBoard, lastMove);
				if (message.equals("")) {lastMove = 'o';}
				else {System.out.print(message);}
			}	
			done = gameBoard.hasAnyoneWon();
			gameBoard.print();		
		}
		System.out.println("\n\nCongrats " + lastMove + ", you win!");
	}

}
