import java.util.Scanner;

public class Logic {
    public Logic() {}

    public void runGame() {
        Board board = new Board();
        Dice dice = new Dice();
        Peg peg1 = new Peg("Player1");
        Peg peg2 = new Peg("Player2");
        Scanner scan = new Scanner(System.in);

        boolean peg1Win = false;
        boolean peg2Win = false;
        boolean peg1move = false;
        boolean peg2move = false;

        while (peg1Win != true || peg2Win != true) {
            peg1.info();
            peg2.info();

            System.out.print("\nPlayer 1's turn. Enter 'roll' to roll the dice: ");
            String userInput1 = scan.nextLine();
            if (userInput1.equals("roll") || userInput1.equals("Roll")) {
                int target = peg1.getPosition() + 1;
                if (peg1.getPosition() == 0) {
                    target = 5;
                }
                peg1move = dice.rollDice(target);
                if (peg1move == true) {
                    peg1.moveUp();
                }
                if (peg1.getPosition() == 11) {
                    peg1Win = true;
                    break;
                }
            }
            checkPegLand(peg1, peg2);

            System.out.print("\nPlayer 2's turn. Enter 'roll' to roll the dice: ");
            String userInput2 = scan.nextLine();
            if (userInput2.equals("roll") || userInput2.equals("Roll")) {
                int target = peg2.getPosition() + 1;
                if (peg2.getPosition() == 0) {
                    target = 5;
                }
                peg2move = dice.rollDice(target);
                if (peg2move == true) {
                    peg2.moveUp();
                }
                if (peg2.getPosition() == 11) {
                    peg2Win = true;
                    break;
                }
            }
            checkPegLand(peg2, peg1);
            System.out.println();


        }

        if (peg1Win == true) {
            System.out.println("Congratulations Player 1! You won the game!");
        }
        else if (peg2Win == true) {
            System.out.println("Congratulations Player 1! You won the game!");
        }


    }

    public void checkPegLand(Peg peg1, Peg peg2) {
        if (peg1.getPosition() == peg2.getPosition() && peg1.getPosition() != 0) {
            System.out.println(peg1.getName() + " has landed on " + peg2.getName() + "'s spot! " + peg2.getName() + " goes back to the start!");
            peg2.moveToStart();
        }
    }
}
