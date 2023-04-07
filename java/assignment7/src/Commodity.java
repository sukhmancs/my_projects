/**
 * The Commodity interface defines methods for objects that can be bought and sold as commodities.
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public interface Commodity {

    /**
     * Returns the cost to produce one unit of this commodity.
     * @return the production cost as a double
     */
    double getProductionCost();

    /**
     * Returns the price at which one unit of this commodity is sold to consumers.
     * @return the retail price as a double
     */
    double getRetailPrice();
}
