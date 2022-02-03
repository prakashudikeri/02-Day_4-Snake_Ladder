public class SnakeLadder {	

int playerPosition = 0;
	
	void showPosition() {
		System.out.println("Player position is " + playerPosition);
	}
	
	int rolldice() {
		int diceNo = (int) Math.floor(Math.random() * 10) %6 + 1;
		return diceNo;
	}
	
	public static void main(String[] args) {
		SnakeLadder player1 = new SnakeLadder();
		player1.showPosition();
		System.out.println("Dice number for player is " + player1.rolldice());
	}	

}
