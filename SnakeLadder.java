import java.util.Random;

public class SnakeLadder {
	
	final int noPlay = 0;
	final int climbLadder = 1;
	final int snakeBite = 2;
	
	int playerPosition = 0;
	int newPosition = 0;
	
	 private void showPosition() { 
		 System.out.println("Player position is " + playerPosition);
		 }
	
	Random randomNo = new Random();
	
	int rolldice() { 
		int diceNo = randomNo.nextInt(6) + 1; 
		return diceNo;
		}
	
	private void optionPlay(int diceNo) { 
		int optionNo = randomNo.nextInt(3); 
		System.out.println("Option number is " + optionNo);
	
		switch (optionNo) {
			case noPlay: 
				System.out.println("Player got No Play");
				newPosition = 0;
				break;
			case climbLadder: 
				System.out.println("Player got Ladder to climb"); 
				playerPosition += diceNo; 
				break;
			case snakeBite: 
				System.out.println("Player got Snake Bite"); 
				playerPosition -= diceNo;
					if (playerPosition<0){ 
						playerPosition = 0;
					} 
				break;
			}
	}
	
	public static void main(String[] args) { 
		SnakeLadder player1 = new SnakeLadder(); 
		player1.showPosition();
		
		int diceNo = player1.rolldice();
		System.out.println("dice number for player is " + player1.rolldice());
		
		player1.optionPlay(diceNo);
		player1.showPosition();
		player1.rolldice();
		
	}	
	
	
}

