/**
 * Class to represent a parrot
 */
public class Parrot {
    private String name;
    private int health;
    private double seedAmount;
    private boolean flying;
    private boolean isAlive;
    private boolean isTamed;
    private double tamedPercentage;

    /**
     * Constructor of the class parrot
     * @param name String the name of the parrot
     * @param isTamed boolean whether the parrot is tamed or not
     * @param seedAmount double the amount of seed to be fed to the parrot
     * @param health int health of the parrot
     * @param flying boolean whether the parrot is flying or staying
     * @param isAlive boolean check if parrot is alive
     */
    public Parrot(String name, boolean isTamed, double seedAmount, int health, boolean flying, boolean isAlive) {
        this.name = name;
        this.health = health;
        this.seedAmount = seedAmount;
        this.flying = flying;
        this.isAlive = isAlive;
        this.isTamed = isTamed;
    }

    /**
     * Prints out all the variables inside our Parrot class
     * @return String private variables of this class
     */
    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", seedAmount=" + seedAmount +
                ", flying=" + flying +
                ", isAlive=" + isAlive +
                ", isTamed=" + isTamed +
                ", tamedPercentage=" + tamedPercentage +
                '}';
    }

    /**
     * Get the name of the parrot
     * @return String the name of the parrot
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the health of the parrot
     * @return int the health of the parrot
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Get the seed amount
     * @return double the seed amount to be fed to the parrot
     */
    public double getSeedAmount() {
        return this.seedAmount;
    }

    /**
     * Check if parrot is flying
     * @return boolean true if parrot is flying, false otherwise
     */
    public boolean isFlying() {
        return this.flying;
    }

    /**
     * Check if parrot is alive
     * @return boolean whether the parrot is alive or not
     */
    public boolean isAlive() {
        return this.isAlive;
    }

    /**
     * Check if the parrot is tamed
     * @return boolean true if the parrot is tamed, false otherwise
     */
    public boolean isTamed() {
        return this.isTamed;
    }

    /**
     * Get the percentage of the parrot being tamed
     * @return double the percentage of the parrot being tamed
     */
    public double getTamedPercentage() {
        return this.tamedPercentage;
    }

    /**
     * Set the name of the parrot
     * @param name the new name of the parrot
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the health of the parrot
     * @param health the new health of the parrot
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Set the amount of seeds the parrot has
     * @param seedAmount the new amount of seeds the parrot has
     */
    public void setSeedAmount(double seedAmount) {
        this.seedAmount = seedAmount;
    }

    /**
     * Set the flying status of the parrot
     * @param flying boolean indicating if the parrot is flying or not
     */
    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    /**
     * Set the alive status of the parrot
     * @param alive indicating whether parrot is alive or not
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Set the tamed status of the parrot
     * @param tamed boolean indicating if the parrot is tamed or not
     */
    public void setTamed(boolean tamed) {
        isTamed = tamed;
    }

    /**
     * Set the tamed percentage of the parrot
     * @param seedAmount double indicating the tamed percentage of the parrot
     */
    public void setTamedPercentage(double seedAmount) {
        this.tamedPercentage = 20 * seedAmount;
    }

    /**
     * Feed the parrot with the given food and the seed amount
     * @param food String food to be fed to the parrot
     * @param seedAmount int the amount of food to be fed to the parrot
     */
    public String feed(String food, double seedAmount) {

        // set the seedAmount to users value
        this.seedAmount = seedAmount;

        // make it lowercase
        food = food.toLowerCase();

        // make parrot dead if other than seeds are fed
        if (food.equals("cookie")) {
            this.health = 0;
            this.isAlive = false;
            this.isTamed = false;
            this.tamedPercentage = 0;
            return "Parrot is dead now.\n";
        } else if (food.equals("seed")) {

            // as long as parrot is not dead or health is not zero
            if (this.health != 0) {

                // make it alive everytime it is fed seeds
                this.isAlive = true;

                // percentage that parrot will become tamed
                this.tamedPercentage = 20 * seedAmount;

                // check if health is less than 3
                if (this.health < 3) {
                    this.health += 1;
                }
                return "Seed increased: " + this.seedAmount + "\n";
            }
        }

        // otherwise set the alive status to false
        this.isAlive = false;

        // if the user enters value other 'seed' or 'cookie'
        return "Invalid input. Please enter 'seed' or 'cookie'.\n";
    }

    /**
     * Get command from user and respond accordingly
     * @param command String describing the command provided to the parrot
     * @return String a message representing the state of parrot
     */
    public String getCommand(String command) {

        // make it lowercase to avoid unnecessary errors
        command = command.toLowerCase();

        // check if the value is 'fly' or 'stay'
        if (command.equals("fly")) {
            this.isTamed = false;
            this.flying = true;
            return "I am flying. You have untamed the parrot: " + this.name;
        } else if (command.equals("stay")) {
            this.flying = false;
            this.isTamed = true;

            // make the tamed percentage 100
            this.tamedPercentage = 100;
            return "I am staying. You have tamed the parrot: " + this.name;
        }

        // if user enters value other than 'fly' or 'stay'
        return "Invalid input. Please enter 'fly' or 'stay'.";
    }

    /**
     * Decreases the health and make it untamed everytime player hit the parrot
     * @return String a message representing the outcome of parrot being hit
     */
    public String hit() {

        // decrease the health if parrot is not dead yet
        if (this.health != 0) {
            this.health -= 1;
            this.isAlive = true;
            if (this.health == 0) {
                this.isAlive = false;
                return "Parrot is dead. Health: " + this.health;
            }
            return "Ouch. Health decreased and is not tamed anymore.";
        }

        // otherwise declare that it is already dead
        this.isTamed = false;
        this.isAlive = false;
        return "parrot is dead. Health: " + this.health;
    }

}
