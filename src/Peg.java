public class Peg {
    private int position;
    private String name;

    public Peg(String name) {
        position = 0;
        this.name = name;
    }

    public void moveUp() {
        position++;
    }

    public void moveToStart() {
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void info() {
        System.out.print(getName() + ", you are at the " + getPosition() + " mark. ");
        if (getPosition() + 1 == 11) {
            System.out.println("You need to move up to the 11 mark and win!");
        }
        else {
            System.out.println("You need to move up to the " + (getPosition() + 1) + " mark.");
        }
    }
}
