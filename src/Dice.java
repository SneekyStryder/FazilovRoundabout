import java.util.ArrayList;

public class Dice {

    public Dice() {}

    public ArrayList<Integer> diceRoll() {
        ArrayList<Integer> rollSet = new ArrayList();
        int die1Roll = (int) (Math.random() * 6) + 1;
        int die2Roll = (int) (Math.random() * 6) + 1;
        int sum = die1Roll + die2Roll;
        rollSet.add(die1Roll);
        rollSet.add(die2Roll);
        rollSet.add(sum);
        return rollSet;
    }

    public boolean rollDice(int target) {
        ArrayList<Integer> rollSet = new ArrayList();
        rollSet = diceRoll();
        System.out.println("You rolled a " + rollSet.get(0) + " and a " + rollSet.get(1) + "\nThat adds up to " + rollSet.get(2));
        if (rollSet.get(2) == target && rollSet.get(2) == 11) {
            System.out.println("The sum of the dice is " + target + "! You win!");
            return true;
        }
        if (rollSet.get(2) == target) {
            System.out.println("The sum of the dice is " + target + "! You move up!");
            return true;
        }
        else if (rollSet.get(0) == target || rollSet.get(1) == target) {
            System.out.println("You rolled a " + target + "! You move up!");
            return true;
        }
        else {
            System.out.println("You did not roll a " + target);
            return false;
        }
    }
}
