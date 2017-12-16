
import java.util.Scanner;

public class Player {
	private String name;
	private String shape;
	Scanner sc = new Scanner(System.in);
	private int score;
	
	public void setScore() {
		this.score += 1;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String input) {
		this.name = sc.nextLine();
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public String getShape() {
		return shape;
	}
	
	
}
