import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	private int height = 4;
	private int width = 4;
	
	//////////////y x
	private String[][] bord = new String[height][width];{
	bord[0][0] = "a";
	bord[1][0] = "b";
	bord[2][0] = "c";
	
	bord[3][0] = " ";
	bord[3][1] = "1";
	bord[3][2] = "2";
	bord[3][3] = "3";
	
	}
	

	public void printBoard() {
		for (int height = 0; height < bord.length; height++) {
			for (int width = 0; width < bord.length; width++) {
				if(bord[height][width] == null) {
					bord[height][width] = ".";
				}
				System.out.print(bord[height][width] + " ");
			}
		System.out.println("");	
		}
	}
	
	public void resetBoard() {
		for (int height = 0; height < bord.length - 1; height++) {
			for (int width = 0; width < bord.length; width++) {
				if(bord[height][width].equals("X") || bord[height][width].equals("O")) {
					bord[height][width] = ".";
				}
			}
		}
	}
	
	public boolean checkFullBoard() {
		int countBoard = 0;
		
		for (int height = 0; height < bord.length; height++) {
			for (int width = 0; width < bord.length; width++) {
				if(!bord[height][width].equals(".")) {
					countBoard++;
					if(countBoard == (height * width)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void setOnBoard(Player player1, Player player2) {
		String coordinates = sc.nextLine();
		int col = coordinates.toCharArray()[0] ;
		int row = coordinates.toCharArray()[1];
		
		int coord = col - 97; //a, b, c
		int coordRow = row - 48; // 1, 2, 3
		
		if(coord > 3 || coord < 0 || coordRow > 3 || coordRow < 0) {
			System.out.println("Wrong coordinates turn is over");
			return;
		}
		
		for (int height = 0; height < bord.length; height++) {
			for (int width = 0; width < bord.length; width++) {
				if(bord[coord][coordRow].equals(player2.getShape())) {
					System.out.println("coordinates already taken turn is over");
					return;
				}
				else {
					bord[coord][coordRow] = player1.getShape();
					return;
				}
			}
		}	
	}	
	
	public boolean checkCol(Player player) {
		String current = player.getShape();
		
		int height = 0;
		boolean isColComplete = false;
		width = 1;
		
		while (height < bord.length) {
			
			isColComplete = true;
			if(!bord[height][width].equals(current)) {
				isColComplete = false;
				break;
			}
			height++;
			if(height == bord.length - 1 && !isColComplete) {
				while (width < bord.length)
					height = 0;
					width =+ 1;
				}
			if(isColComplete && height == bord.length - 1) {
				return true;
			}
		}
		return false;
	}
			
//			for (int width = 1; width < bord.length; width++) {
//				height =- bord.length;
//				if(!bord[height][width].equals(current)) {
//					isColComplete = false;
//					break;
//				}
//			}
			
	
	public boolean checkRow(Player player) {
		String current = player.getShape();
		
		for (int height = 0; height < bord.length; height++) {
			boolean isRowComplete = true;
			for (int width = 1; width < bord.length; width++) {
				//als niet juiste char!
				if(!bord[height][width].equals(current)) {
					isRowComplete = false;
					break;
				}	
			}
		
			if(isRowComplete)
			{
				return true;
			}
			
		}
		return false;
//		for (int i = 1; i < bord.length; i++) {
//			if(bord[0][i].equals(player.getShape()) ) {
//				for (int j = 0; j < bord.length; j++) {
//					if(bord[i][j].equals(player.getShape())) {
////						System.out.println(player.getName() + " heeft gewonnen");
//						return true;
//					}
//				}
//			}
//		}
//		return false;	
	}
	
	

	
	public boolean checkDiagonal(Player player) {
		if(bord[0][1].equals(player.getShape()) && bord[1][2].equals(player.getShape()) && bord[2][3].equals(player.getShape())) {
			return true;
		}
		else if(bord[2][1].equals(player.getShape()) && bord[1][2].equals(player.getShape()) && bord[0][3].equals(player.getShape())) {
			return true;
		}
		else {
			return false;	
		}
	}


}

