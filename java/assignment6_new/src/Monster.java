/**
 * This class represents a monster
 *
 * @author Sukhmanjeet Singh, 000838215
 * @author Anh Kiet Chau, 000893462
 */
public class Monster {
    private String name;
    private String clan;
    private double health;
    private int ferocity;
    private int defense;
    private int magic;
    private int treasure;

    /**
     * Constructors that sets all instance variables
     * @param name the name of this monster
     * @param clan the clan this monster belong to
     * @param health health amount of this monster
     * @param ferocity ferocity level of this monster
     * @param defense defense capabilities of this monster
     * @param magic magic level for this monster
     * @param treasure treasure amount this monster have
     */
    public Monster(String name, String clan, double health, int ferocity,int defense, int magic, int treasure) {
        this.name = name;
        this.clan = clan;
        this.health = health;
        this.ferocity = ferocity;
        this.defense = defense;
        this.magic = magic;
        this.treasure = treasure;
    }

    /**
     * Constructors that sets clan and name the rest will be random / default constructor
     * @param name the name of this monster
     * @param clan the clan this monster belong to
     */
    public Monster(String name, String clan) {
        this(name, clan, betterRandom(10, 100), betterRandom(0, 20), betterRandom(0, 20), betterRandom(0, 20), betterRandom(0, 999));
    }

    /**
     * Better randomization
     * @param min minimum number
     * @param max maximum number
     * @return the random number
     */
    public static int betterRandom(double min, double max){
        return (int)((Math.random()*(max - min)) + min); // Calculate and round it up
    }

    /**
     * Get the name of your monster
     * @return String the name of this monster
     */
    public String getName() {
        return name;
    }

    /**
     * Get the battles score for this monster
     * @return int battle score for this monster
     */

    public int getBattleScore() {
        return (int)((this.getFerocity() + this.getDefense() + this.getMagic()) / 3.0);
    }

    /**
     * Get the clan this monster belongs to
     * @return String the clan of this monster
     */
    public String getClan() {
        return clan;
    }

    /**
     * Get the current health of this monster
     * @return double health of this monster
     */
    public double getHealth() {
        return health;
    }


    /**
     * Get the ferocity level of this monster
     * @return int the level of ferocity
     */
    public int getFerocity() {
        return ferocity;
    }

    /**
     * Get the defense level of this monster
     * @return int defense level of this monster
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Get the magic strength of this monster
     * @return int the magic strength of this monster
     */
    public int getMagic() {
        return magic;
    }

    /**
     * Get the treasure for this monster
     * @return int treasure amount
     */
    public int getTreasure() {
        return treasure;
    }

    /**
     * Set the name of this monster
     * @param name the name of this monster
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the clan of the monster.
     * @param clan The name of the clan.
     */
    public void setClan(String clan) {
        this.clan = clan;
    }

    /**
     * Sets the health of the monster.
     * @param health The new health value.
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Sets the ferocity of the monster.
     * @param ferocity The new ferocity value.
     */
    public void setFerocity(int ferocity) {
        this.ferocity = ferocity;
    }

    /**
     * Sets the defense of the monster.
     * @param defense The new defense value.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Sets the magic of the monster.
     * @param magic The new magic value.
     */
    public void setMagic(int magic) {
        this.magic = magic;
    }

    /**
     * Sets the amount of treasure the monster has.
     * @param treasure The new treasure value.
     */
    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }

    /**
     * Method for a character to take damage
     * @param damage double the damage to inflict
     */
    public void takeDamage(double damage){
        if (isAlive()){ setHealth(damage - getBattleScore());} // If character is alive, subtract damage from health
    }

    /**
     * Method to check if a character is alive
     *
     * @return boolean if the monster is alive
     */
    public boolean isAlive(){
        return !(health <= 0); // Returns true if health is greater than 0, false otherwise
    }

    /**
     * Method for a character to add treasure
     *
     * @param treasureNumber int amount of treasure to increase
     */
    public void addTreasure(int treasureNumber){
        if (isAlive()) {treasure += treasureNumber;} // If character is alive, add treasure
    }

    public void addHealth (double health) {
        if (isAlive()) {this.health +=health;} // if alive add health
    }

    /**
     * Method for a character to attack another character
     *
     * @param other Monster opponent to attack
     */
    public void attack(Monster other) {
        if (!this.isAlive()) {return;} // If this character is dead, return
        double diff = this.getBattleScore() - other.getBattleScore(); // Calculate the difference in battle scores

        if (diff > 0) { // If this character has a higher battle score, it wins
            int damage = (int) Math.round(diff);
            other.takeDamage(damage); // The other character takes damage
            if (!other.isAlive()) { // If the other character dies, this character gains its treasure
                this.addTreasure(other.getTreasure());
                other.setTreasure(0);
            }
        } else if (diff < 0) { // If the other character has a higher battle score, it wins
            int damage = (int) Math.round(-diff);
            this.takeDamage(damage); // This character takes damage
            if (!this.isAlive()) { // If this character dies, the other character gains its treasure
                other.addTreasure(this.getTreasure());
                this.setTreasure(0);
            }
        }
    }

    /**
     * String representation of all instance variables of this class
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return " Monster{" +
                " name='" + name + '\'' +
                ", battleScore=" + getBattleScore() +
                ", clan='" + clan + '\'' +
                ", health=" + health +
                ", ferocity=" + ferocity +
                ", defense=" + defense +
                ", magic=" + magic +
                ", treasure=" + treasure + '}';
    }
}
