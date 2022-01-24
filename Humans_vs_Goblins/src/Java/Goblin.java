public class Goblin {
    int strength;
    int health;
    int position;
    int move;
    boolean isAlive;

    public Goblin() {

    }

    public Goblin(int position, int strength, int health) {
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

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void attackHuman(Human human) {
        if(this.strength >= human.getHealth()) {
            human.setHealth(0);
        } else {
            int damageTaken = (int)(Math.random() * 20);
            human.setHealth(human.getHealth() - this.strength);
            this.setHealth(this.getHealth() - damageTaken);
        }
    }

    @Override
    public String toString(){
        return "Goblin {strength=" + strength + " health=" + health + "}";
    }


}
