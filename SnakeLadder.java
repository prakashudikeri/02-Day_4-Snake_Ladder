import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {
	final int noPlay = 0;
	final int climbLadder = 1;
	final int snakeBite = 2;
	int playerPosition = 0;
    int diceCount = 0;
    int dieNo = 0;
    static int player1Play = 1;
	
    Scanner sc = new Scanner(System.in);
    Random randomNo = new Random();
    
    private void showPosition(int playerNo) {
        System.out.println("Player "+playerNo+" Position : "+ playerPosition);
    }

    private int rollDie() {
        int dieNo = randomNo.nextInt(6)+1;
        diceCount++;
        System.out.println("Dice Count : "+diceCount);
        return dieNo;
    }

    private void playGame(int playerNo) {
        System.out.println("Player "+playerNo+" Chance :\nPress 1 to Roll the Dice :");
        int choice = sc.nextInt();
        dieNo = rollDie();
        System.out.println("Die Number for Player "+playerNo+": "+ dieNo);
        optionPlay(dieNo);
        showPosition(playerNo);
    }

    private void optionPlay(int dieNo) {
        int optionNo = randomNo.nextInt(2)+1;
        System.out.println("Option No is "+ optionNo);

        switch (optionNo) {
            case noPlay:
                System.out.println("Player got NO PLAY");
                break;
            case climbLadder:
                System.out.println("Player got Ladder to climb");
                playerPosition += dieNo;
                //If Player Position greater than 100 then skip the Play
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

    private static void flipToss() {
        Random tossValue = new Random();
        int toss = tossValue.nextInt(2)+1;
        if(toss == 1) {
            player1Play = 1;
            System.out.println("Player 1 Won the Toss.");
        } else {
            player1Play = 0;
            System.out.println("Player 2 Won the Toss.");
        }
    }

    private static void playerChance() {
        if(player1Play == 1) {
            player1Play = 0;
        } else {
            player1Play = 1;
        }
    }

    private boolean checkWin() {
        if(playerPosition == 100) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int checkLadder =0;

        SnakeLadder player1 = new SnakeLadder();
        SnakeLadder player2 = new SnakeLadder();

        player2.showPosition(1);
        player1.showPosition(2);

        flipToss();

        while( !player1.checkWin() && !player2.checkWin()) {
            if(player1Play ==1) {
                player1.playGame(1);
            } else {
                player2.playGame(2);
            }
            playerChance();
        }
    }
}