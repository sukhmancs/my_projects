/**
 * A subclass of Monster representing a Goblin
 *
 * Inheritance:
 *   Monster
 *
 * @author Sukhmanjeet Singh, 000838215
 * @author Anh Kiet Chau, 000893462
 */
public class Goblin extends Monster {

    private Goblin swornEnemy;

    /**
     * Constructors that sets clan and name the rest will be random or the default constructor
     *
     * @param name the name of this monster
     * @param clan clan it belongs to
     */
    public Goblin(String name, String clan) {
        super(name, clan);
    }

    /**
     * Constructors that sets all instance variables
     *
     * @param health health of this monster
     * @param ferocity ferocity level of this monster
     * @param defense defense of this monster
     * @param magic magic level of this monster
     * @param treasure treasure this monster have
     */
    public Goblin(String name, String clan, double health, int ferocity, int defense, int magic, int treasure, Goblin swornEnemy) {
        super(name , clan, health, ferocity, defense, magic, treasure);
        this.swornEnemy = swornEnemy;
    }

    public String getSwornEnemy() {
        if (swornEnemy == null) return "No enemy yet";
        return swornEnemy.toString();
    }

    public void setSwornEnemy(Goblin swornEnemy) {
        if (this.swornEnemy == null) this.swornEnemy = swornEnemy;
    }

    /**
     * String representation of all instance variables of this class
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Goblin{" +
                "swornEnemy=" + swornEnemy.getName() +
                "} " + super.toString();
    }
}
