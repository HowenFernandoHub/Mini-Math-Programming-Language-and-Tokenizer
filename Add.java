/**
 *  Program # 4
 *  Inherits from Token Class. Has additional evaluate method
 *  which returns the result of adding leftNum and rightNum.
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */

public class Add extends Token {

    /**
     * Passes two input parameters as arguments
     * for the superclass Token's constructor
     * @param leftNum
     * @param rightNum
     */
    public Add(Token leftNum, Token rightNum) {
        super(leftNum, rightNum);
    }

    /**
     * Adds leftNum and rightNum
     * @return - result of adding the int representations of leftNum and rightNum
     */
    @Override
    String evaluate() {

        // Checking if leftNum is a number or not
        // Will return Error message if it is not
        try {
            Integer.parseInt(leftNum.evaluate());
        }
        catch (NumberFormatException exception) {
            return "ERROR: Invalid number: " + leftNum.tokenValue;
        }

        // Checking if rightNum is a number or not
        // Will return Error message if it is not
        try {
            Integer.parseInt(rightNum.evaluate());
        }
        catch (NumberFormatException exception) {
            return "ERROR: Invalid number: " + rightNum.tokenValue;
        }


        int leftInt = Integer.parseInt(leftNum.evaluate());     // int representation of leftNum
        int rightInt = Integer.parseInt(rightNum.evaluate());   // int representation of rightNum

        int result = leftInt + rightInt;

        return Integer.toString(result);
    }

    @Override
    public String toString() {
        return leftNum.tokenValue + " " + rightNum.tokenValue + " " + "+";
    }
}
