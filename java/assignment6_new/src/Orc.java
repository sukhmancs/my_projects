import java.util.Arrays;

/**
 * A subclass of Monster representing a Orc
 *
 * Inheritance:
 *   Monster
 *
 * @author Sukhmanjeet Singh, 000838215
 * @author Anh Kiet Chau, 000893462
 */
public class Orc extends Monster {
    private boolean isWarlord;
    private Orc[] infantryUnits = new Orc[5];
    private int leadershipRating;

    /**
     * Constructor that sets the orc's name and clan.
     *
     * @param name The name of the orc.
     * @param clan The clan of the orc.
     * @param isWarlord Whether the orc is a warlord or not.
     */
    public Orc(String name, String clan, boolean isWarlord) {
        super(name, clan);
        this.isWarlord = isWarlord;
        if (isWarlord) this.leadershipRating = betterRandom(1, 5); // If warlord then Orc can have leadership
    }

    /**
     * Constructor that sets all instance variables.
     *
     * @param name The name of the orc.
     * @param clan The clan of the orc.
     * @param health The health of the orc.
     * @param ferocity The ferocity of the orc.
     * @param defense The defense of the orc.
     * @param magic The magic of the orc.
     * @param treasure The treasure of the orc.
     * @param isWarlord Whether the orc is a warlord or not.
     */
    public Orc(String name, String clan, double health, int ferocity, int defense, int magic, int treasure, boolean isWarlord) {
        super(name, clan, health, ferocity, defense, magic, treasure);
        this.isWarlord = isWarlord;
        if (isWarlord) this.leadershipRating = betterRandom(1, 5);
    }

    /**
     * Sets the number of infantry units.
     *
     * @param infantryUnits The list of infantry units.
     */
    public void setInfantryUnits (Orc[] infantryUnits) {
        this.infantryUnits = infantryUnits;
    }

    /**
     * Gets the health of the orc's infantry units.
     *
     * @param infantryIndex the index of units
     * @return The health of the orc's infantry units.
     */
    public double getInfantryHealth(int infantryIndex) {
        if (!isWarlord) return 0;
        if (infantryUnits[infantryIndex] == null) return 0;
        return infantryUnits[infantryIndex].getHealth();
    }

    /**
     * Sets whether the orc is a warlord or not.
     *
     * @param warlord Whether the orc is a warlord or not.
     */
    public void setIsWarlord(boolean warlord) {
        this.isWarlord = warlord;
    }

    /**
     * Sets the orc's leadership rating.
     *
     * @param leadershipRating The orc's leadership rating.
     */
    public void setLeadershipRating(int leadershipRating) {
        this.leadershipRating = leadershipRating;
    }


    /**
     * Gets the number of infantry units.
     *
     * @return The number of infantry units.
     */
    public Orc[] getInfantryUnits () {
        return this.infantryUnits;
    }

    /**
     * Gets the orc's leadership rating.
     *
     * @return The orc's leadership rating.
     */
    public int getLeadershipRating() {
        return leadershipRating;
    }

    /**
     * Heals the orc's infantry units based on the orc's leadership rating.
     */
    public void healInfantry (int index) {
        if (!(infantryUnits[index] == null)) infantryUnits[index].addHealth(this.getLeadershipRating() * 5);
    }

    /**
     * Gets whether the orc is a warlord or not.
     *
     * @return Whether the orc is a warlord or not.
     */
    public boolean isWarlord() {
        return isWarlord;
    }

    /**
     * BattleCry will increase all InfantryUnits health
     */
    private void BattleCry() {
        if (!(isWarlord) || !(isAlive())) {return;} // Check if is warlord and still alive

        for (int i = 0; i < getInfantryUnits().length ; i++) {
            if (!(getInfantryUnits()[i] == null)) getInfantryUnits()[i].healInfantry(i);
        }
    }

    /**
     * Increase the amount of treasure this monster have
     * @param treasureNumber int amount of treasure to increase
     */
    @Override
    public void addTreasure(int treasureNumber) {
        if (!isAlive()) {return;} // check if this monster is alive before adding treasure

        super.addTreasure(treasureNumber); // Add treasure
        setLeadershipRating(getLeadershipRating() + (int) Math.floor(treasureNumber/10));// Increase the monster's leadership rating by 1 for each treasure

        if (getLeadershipRating() > 5) {setLeadershipRating(5);} // Make sure the Leadership is not more than 5
    }

    /**
     * Get the battle score for this monster based on average of its ferocity, defense, and magic power
     * @return the current battle score for this monster
     */
    @Override
    public int getBattleScore() {
        if (isWarlord) {return (int)(((this.getFerocity() + this.getDefense() + this.getMagic()) / 3.0) * 1.5);} // if warlord return * 3

        return super.getBattleScore();
    }

    /**
     * String representation of all instance variables of this class
     * @return String representation of this class
     */
    @Override
    public String toString() {
        String unit_String = "none";
        if (isWarlord) {unit_String = "\n" +Arrays.toString(getInfantryUnits());}

        return super.toString() + ", Orc { Warlord = " + isWarlord + ", leadership = "  + leadershipRating +
                ", infantry = " + unit_String + "}";
    }
}