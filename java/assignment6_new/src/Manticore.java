/**
 * A subclass of Monster representing a Manticore
 *
 * Inheritance:
 *   Monster
 *
 * @author Sukhmanjeet Singh, 000838215
 * @author Anh Kiet Chau, 000893462
 */
public class Manticore extends Monster {

    /**
     * Constructors that sets clan and name the rest will be random / or the default constructor
     *
     * @param name the name of this monster
     * @param clan clan it belongs to
     */
    public Manticore(String name, String clan) {
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
    public Manticore(String name, String clan, double health, int ferocity, int defense, int magic, int treasure) {
        super(name, clan, health, ferocity, defense, magic, treasure);
    }

    /**
     * Get the battle score for this monster based on average of its ferocity, defense, and magic power
     * @return the current battle score for this monster
     */
    @Override
    public int getBattleScore() {
        return (int)(((this.getFerocity() + this.getDefense() + this.getMagic()) / 3.0) * 1.5);
    }

    /**
     * String representation of all instance variables of this class
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Manticore{} " + super.toString();
    }
}
