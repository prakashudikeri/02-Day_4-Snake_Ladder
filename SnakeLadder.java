import java.util.Random;

public class SnakeLadder {
 
	final int noPlay = 0;
	final int climbLadder = 1;
	final int snakeBite = 2;

    int playerPosition = 0;
    int newPosition = 0;

    Random randomNo = new Random();

    void showPosition() {
    		System.out.println("Player Starting Position : "+ playerPosition);
    	}

    int rolldice() {
    		int diceNo = randomNo.nextInt(6)+1;
    		return diceNo;
    	}

    private void optionPlay(int diceNo) {
        int optionNo = randomNo.nextInt(2)+1;
        System.out.println("Option No is : "+ optionNo);

        switch (optionNo) {
            case noPlay:
                System.out.println("Player got NO PLAY");
                break;
            case climbLadder:
                System.out.println("Player got Ladder to climb");
                playerPosition += diceNo;
                if(playerPosition > 100) {
                    System.out.println("Sorry The Position is Out of Board.");
                    playerPosition -= diceNo;
                } break;
            case snakeBite:
                System.out.println("Player got Snake Bite");
                playerPosition -= diceNo;
                if (playerPosition < 0) {
                    playerPosition = 0;
                } break;
        }
    }

    public static void main(String[] args) {
        	SnakeLadder player1 = new SnakeLadder();
        	player1.showPosition();
        	
        while( player1.playerPosition != 100) {
            int diceNo = player1.rolldice();
            System.out.println("Dice Number for Player : "+ diceNo);
            player1.optionPlay(diceNo);
            player1.showPosition();
        }
    }
}