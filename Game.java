import java.util.Random;
import java.util.Scanner;

public class Game {
	Board board = new Board();
	Player player1 = new Player();
	Player player2 = new Player();
	Scanner sc = new Scanner(System.in);
	
	public Game() {
		System.out.println("***** Start *****");
		System.out.println("Enter name player 1");
		player1.setName(null);
		
		System.out.println("Enter name player 2");
		player2.setName(null);
		
		setShapes();
		
		System.out.println();
		
		Play();
		
		board.resetBoard();
		
		playAigan();
	}
	
	public void Play() {
		boolean winner = false;
		
		int turn = setFirstTurn();
			
		System.out.println();
		while(!winner) {
		
		board.printBoard();
		
			if (turn == 0) {
				System.out.println(player1.getName() + " enter coordinates");
					if(board.checkFullBoard() == true) {
						winner = true;
					};
					board.setOnBoard(player1, player2);
				System.out.println();
					board.checkDiagonal(player1);
					if (board.checkDiagonal(player1) == true) {
						System.out.println(player1.getName() + " heeft gewonnen");
						winner = true;
						board.printBoard();
						player1.setScore();
						System.out.println("score speler 1: " + player1.getScore());
						System.out.println("score speler 2: " + player2.getScore());
						return;
					}
					board.checkRow(player1);
					if (board.checkRow(player1) == true) {
						winner = true;
						board.printBoard();
						player1.setScore();
						System.out.println("score speler 1: " + player1.getScore());
						System.out.println("score speler 2: " + player2.getScore());
						return;
					}
					if (board.checkCol(player1) == true) {
						winner = true;
						board.printBoard();
						player2.setScore();
						System.out.println("score speler 1: " + player1.getScore());
						System.out.println("score speler 2: " + player2.getScore());
						return;
					}
					System.out.println();
					
					turn = 1;
				winner = false;
			}
			else {
				System.out.println(player2.getName() + " enter coordinates");;
					if(board.checkFullBoard() == true) {
						winner = true;
					};
					board.setOnBoard(player2, player1);
				System.out.println();
					board.checkDiagonal(player2);
					if (board.checkDiagonal(player2) == true) {
						System.out.println(player2.getName() + " heeft gewonnen");
						winner = true;
						board.printBoard();
						player2.setScore();
						System.out.println("score speler 1: " + player1.getScore());
						System.out.println("score speler 2: " + player2.getScore());
						return;
					}
					board.checkRow(player2);
					if (board.checkRow(player2) == true) {
						winner = true;
						board.printBoard();
						player2.setScore();
						System.out.println("score speler 1: " + player1.getScore());
						System.out.println("score speler 2: " + player2.getScore());
						return;
					}
					if (board.checkCol(player2) == true) {
						winner = true;
						board.printBoard();
						player2.setScore();
						System.out.println("score speler 1: " + player1.getScore());
						System.out.println("score speler 2: " + player2.getScore());
						return;
					}
					turn = 0;
				winner = false;
			}
		}
		System.out.println();
	}
	
	
	
	public void setShapes() {
		Random r = new Random();
		
		int random = r.nextInt(2);
		
		if(random == 0) {
			player1.setShape("X");
			player2.setShape("O");
			System.out.println(player1.getName() + " is " + player1.getShape());
			System.out.println(player2.getName() + " is " + player2.getShape());
		}
		else {
			player1.setShape("O");
			player2.setShape("X");
			System.out.println(player1.getName() + " is " + player1.getShape());
			System.out.println(player2.getName() + " is " + player2.getShape());
			}
		}
	
	public int setFirstTurn() {
		Random r = new Random();
		
		int random = r.nextInt(2);
			if(random == 0) {
				System.out.println(player1.getName() + " goes first");
			}
			if(random == 1) {
				System.out.println(player2.getName() + " goes first");
			}
		return random;
	}
	
	public void playAigan() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Do you want to play aigan? Type yes for to play aigan.");
		String input = sc.nextLine();
		if(input.equals("yes")) {
			System.out.println("-------------------------------------------------------");
			System.out.println();
			Play();
		}
		else {
			return;
		}
	}
		
	
}
