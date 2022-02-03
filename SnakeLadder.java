import java.util.Random;

public class SnakeLadder {
	final int noPlay = 0;
	final int climbLadder = 1;
	final int snakeBite = 2;
	
    int playerPosition = 0;
    int diceCount = 0;

    Random randomNo = new Random();

    private void showPosition() {
        System.out.println("Player Starting Position : "+ playerPosition);
    }

    private int rollDie() {
        int dieNo = randomNo.nextInt(6)+1;
        diceCount++;
        System.out.println("Dice Count : "+ diceCount);
        return dieNo;
    }

    private void optionPlay(int dieNo) {
        int optionNo = randomNo.nextInt(2) + 1;
        System.out.println("Option No is "+ optionNo);

        switch (optionNo) {
            case noPlay:
                System.out.println("Player got NO PLAY");
                break;
            case climbLadder:
                System.out.println("Player got Ladder to Climb");
                playerPosition += dieNo;
                	if(playerPosition > 100) {
                    System.out.println("Sorry The Position is Out of Board.");
                    playerPosition -= dieNo;
                } break;
            case snakeBite:
                System.out.println("Player got Snake Bite");
                playerPosition -= dieNo;
                if (playerPosition < 0) {
                    playerPosition = 0;
                } break;
        }
    }

    public static void main(String[] args) {
        SnakeLadder player1 = new SnakeLadder();
        player1.showPosition();
        while( player1.playerPosition != 100) {
            int dieNo = player1.rollDie();
            System.out.println("Die Number for Player : "+ dieNo);
            player1.optionPlay(dieNo);
            player1.showPosition();
        }
    }
}