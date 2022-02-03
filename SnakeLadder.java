public class SnakeLadder {	

	int playerPosition = 0;
	
	void showPosition() {
		System.out.println("Player position is " + playerPosition);
	}
	
	public static void main(String[] args) {
		SnakeLadder player1 = new SnakeLadder();
		player1.showPosition();
	}

}
