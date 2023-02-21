import java.util.stream.IntStream;

public class PrimeGenerator {
    /**
     * Calculate if the number is prime or not
     * @param x integer to check primality for
     */

    /** PSEUDOCODE
    * calculate the square root of x as value
    * create a range from 2 to value as r
    * loop over r and divide value by r
    * if value/r = zero
    * display value is not prime
    */
    public void getPrime(long x) {
        long xSquareRoot = (long)Math.sqrt(x);
        IntStream intstream = IntStream.range(2, (int)x);
        int[] mainstreamArray = intstream.toArray();
        int counter = 0;
        for (int digit : mainstreamArray) {
            long remainder = x % digit;
            counter++;
            if (remainder == 0) {
                System.out.println(x + " number is not prime");
                break;
            }else if (counter == mainstreamArray.length) {
                System.out.println(x + " number is prime");
            }
        }
    }
}
