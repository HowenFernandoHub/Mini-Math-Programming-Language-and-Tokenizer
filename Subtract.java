/**
 *  Program # 4
 *  Subtract inherits from Token class.
 *  Has additional evaluate method which determines if tokenValue of its leftNum
 *  and rightNum variables represents an int
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */

public class Subtract extends Token {

    /**
     * Passes 2 Token parameters to superclass Token's constructor
     * @param leftNum
     * @param rightNum
     */
    public Subtract(Token leftNum, Token rightNum) {
        super(leftNum,rightNum);
    }

    /**
     * Subtracts leftNum and rightNum
     * @return - result of subtracting the int representations of leftNum and rightNum
     */
    @Override
    String evaluate() {

        // Checking if leftNum is a number or not
        try {
            Integer.parseInt(leftNum.evaluate());       // throws NumFormException if leftNum.evaluate() is not a number
        }
        catch (NumberFormatException exception) {
            return "ERROR: Invalid number: " + leftNum.tokenValue;
        }

        // Checking if rightNum is a number or not
        try {
            Integer.parseInt(rightNum.evaluate());     // throws NumFormException if rightNum.evaluate() is not a number
        }
        catch (NumberFormatException exception) {
            return "ERROR: Invalid number: " + rightNum.tokenValue;
        }


        int leftInt = Integer.parseInt(leftNum.evaluate());     // int representation of leftNum
        int rightInt = Integer.parseInt(rightNum.evaluate());   // int representation of rightNum

        int result = leftInt - rightInt;

        return Integer.toString(result);
    }

    @Override
    public String toString() {
        return leftNum.tokenValue + " " + rightNum.tokenValue + " " + "-";
    }
}
