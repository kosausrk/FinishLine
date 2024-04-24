import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Start");
        FinishLine game = new FinishLine();
        while (!game.win()) {
            game.diceRoll();
            game.move();
            System.out.println("Enter any key for next turn");
            String name = scan.nextLine();
        }
    }

    static class FinishLine {
        private int postion1;
        private int postion2;
        private int dice1;
        private int dice2;
        private int turns;

        public FinishLine() {
            postion1 = 1;
            postion2 = 1;
            turns = 0;
        }

        public void diceRoll() {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
            System.out.println("Dice one is = " + dice1 + " Dice two is = " + dice2);
        }

        public void move() {
            if (turns % 2 == 0) {
                if (postion1 == dice1 || postion1 == dice2 || postion1 == dice1 + dice2) {
                    postion1++;
                    System.out.println("Player 1 turn");
                }
            } else {
                if (postion2 == dice1 || postion2 == dice2 || postion2 == dice1 + dice2) {
                    postion2++;
                    System.out.println("Player 2 turn");
                }
            }
            System.out.println("Player one position is = " + postion1 + " Player two position is = " + postion2);
            turns++;
            System.out.println();
        }

        public boolean win() {
            if (postion1 == 10) {
                System.out.println("Player 1 has won");
                return true;
            }
            if (postion2 == 10) {
                System.out.println("Player 2 has won");
                return true;
            }
            return false;
        }
    }
}
