package main;
import java.util.Random;

public class Player {
    String name;
    private int health;
    int strength;
    int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.setHealth(health);
        this.strength = strength;
        this.attack = attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // Roll a 6-sided dice (values 1-6)
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        if (getHealth() < 0) {
            setHealth(0);
        }
    }

    public void attack(Player defender) {
        int attackRoll = rollDice();
        int defenseRoll = defender.rollDice();

        int attackDamage = attack * attackRoll;
        int defense = defender.strength * defenseRoll;

        int damage = attackDamage - defense;
        if (damage > 0) {
            defender.takeDamage(damage);
        }

        System.out.println(name + " attacks " + defender.name + "!");
        System.out.println(name + " rolls " + attackRoll + " (Attack Damage: " + attackDamage + ")");
        System.out.println(defender.name + " rolls " + defenseRoll + " (Defense: " + defense + ")");
        System.out.println(defender.name + " takes " + Math.max(damage, 0) + " damage, Health: " + defender.getHealth());
        System.out.println();
    }

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}