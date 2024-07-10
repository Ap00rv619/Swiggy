package main;

public class MagicalArena {
    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        System.out.println("The match begins between " + playerA.name + " and " + playerB.name + "!\n");

        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() <= playerB.getHealth()) {
                playerA.attack(playerB);
                if (playerB.isAlive()) {
                    playerB.attack(playerA);
                }
            } else {
                playerB.attack(playerA);
                if (playerA.isAlive()) {
                    playerA.attack(playerB);
                }
            }
        }

        System.out.println("The match is over!");
        if (playerA.isAlive()) {
            System.out.println(playerA.name + " wins with " + playerA.getHealth() + " health remaining!");
        } else {
            System.out.println(playerB.name + " wins with " + playerB.getHealth() + " health remaining!");
        }
    }
}
