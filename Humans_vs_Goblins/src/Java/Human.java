public class Human {
    int health;
    int strength;
    int position;
    int move;
    boolean isAlive;

    public Human() {

    }

    public Human(int position, int strength, int health) {
        this.position = position;
        this.strength = strength;
        this.health = health;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attackGoblin(Goblin goblin) {
        if(this.strength >= goblin.getHealth()) {
            goblin.setHealth(0);
        } else {
            int damageTaken = (int)(Math.random() * 10);
            goblin.setHealth(goblin.getHealth() - this.strength);
            this.setHealth(this.getHealth() - damageTaken);
        }
    }

    @Override
    public String toString() {
        return "Human {strength=" + strength + " health=" + health + "}";
    }
}
