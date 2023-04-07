/**
 * This class represents a TimsProduct, which is a commodity that can be bought and sold.
 * It implements the Commodity interface, which means it must define the methods getProductionCost() and getRetailPrice().
 */
public class TimsProduct implements Commodity {

    // These private variables represent the name, cost, and price of a TimsProduct.
    private String name;
    private double cost;
    private double price;

    /**
     * This is the constructor for a TimsProduct object.
     *
     * @param name  the name of the TimsProduct
     * @param cost  the cost to produce the TimsProduct
     * @param price the retail price of the TimsProduct
     */
    public TimsProduct(String name, double cost, double price) {
        this.name = name;
        this.cost = cost;
        this.price = price;
    }

    /**
     * This method returns the name of the TimsProduct.
     *
     * @return the name of the TimsProduct
     */
    public String getName() {
        return name;
    }

    /**
     * This method overrides the getProductionCost() method from the Commodity interface.
     * It returns the production cost of the TimsProduct.
     *
     * @return the production cost of the TimsProduct
     */
    @Override
    public double getProductionCost() {
        return this.cost;
    }

    /**
     * This method overrides the getRetailPrice() method from the Commodity interface.
     * It returns the retail price of the TimsProduct.
     *
     * @return the retail price of the TimsProduct
     */
    @Override
    public double getRetailPrice() {
        return this.price;
    }

    /**
     * This method overrides the default toString() method and returns a String representation
     * of the TimsProduct object.
     *
     * @return a String representation of the TimsProduct object
     */
    @Override
    public String toString() {
        return "TimsProduct{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", price=" + price +
                '}';
    }
}
