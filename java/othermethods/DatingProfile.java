import java.util.Random;

public class DatingProfile {
    public int characteristic(String person, boolean isNerdy){
        Random rand = new Random();
        int rating = rand.nextInt(1,10);
        if (isNerdy) {
            String profile = "neardy";
        } else {
            String profile = "bookishes";
        }
        return rating;
    }
    public boolean isValid(int rating) {
        if (rating < 10 && rating > 0) {
            return true;
        }
        return false;
    }

    public int isMatch(int personOneRating, int personTwoRating) {
        int matchPercentage = 1 - (personOneRating-personTwoRating)^2/81;
        return matchPercentage;
    }

    /**
     * personOneRating = characterisitics(person, isNerdy)
     * personTwoRating = characteristics(person, false)
     * sout("there is a match: " + isMatch(personOneRating, personTwoRating)
     * **/
}
