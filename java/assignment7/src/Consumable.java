/**
 * The Consumable interface defines methods for objects that can be consumed.
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public interface Consumable {

    /**
     * Returns the number of calories in this consumable item.
     * @return the calorie count as an integer
     */
    int getCalorieCount();

    /**
     * Returns the method by which this consumable item should be consumed.
     * @return a String describing the consumption method
     */
    String getConsumptionMethod();
}
