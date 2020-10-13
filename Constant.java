/**
 *  Program # 4
 *  Inherits from Token class
 *  Has additional evaluate method which determines if tokenValue String field
 *  represents an int
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */

public class Constant extends Token {

    public Constant(String tokenValue) {
        super(tokenValue);
    }

    /**
     * Determines if tokenValue represents an int
     * @return - String tokenValue if tokenValue represents an int
     */
    @Override
    String evaluate() throws NumberFormatException {

        // Check if tokenValue is null before proceeding
        if (tokenValue != null) {
            try {
                Integer.parseInt(tokenValue);       //Throws exception if tokenValue does NOT represent an int
            }
            catch (NumberFormatException exception) {
                return "ERROR: Invalid number: " + tokenValue;
            }

            return tokenValue;
        }

        else {
            return "For some reason constant with null tokenValue is going here";
        }

    }

    @Override
    public String toString() {
        return tokenValue;
    }
}
