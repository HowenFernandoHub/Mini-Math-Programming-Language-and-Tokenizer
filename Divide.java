/**
 *  Program # 4
 *  Divide inherits from Token class.
 *  Has additional evaluate method which determines if tokenValue of its leftNum
 *  and rightNum variables represents an int
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */

public class Divide extends Token {

    /**
     * Passes 2 Token parameters to superclass Token's constructor
     * @param leftNum - a Token object with tokenValue of an int
     * @param rightNum - a Token object with tokenValue of an int
     */
    public Divide(Token leftNum, Token rightNum) {
        super(leftNum,rightNum);
    }

    /**
     * Divides leftNum and rightNum
     * Also ensures that leftNum and rightNum are in fact numbers
     * and that we're not dividing by zero
     * @return - quotient of the int representations of leftNum and rightNum
     */
    @Override
    String evaluate() {

        // Checking if leftNum is a number or not
        try {
            Integer.parseInt(leftNum.evaluate());   // Throws NumFormException if leftNum.evaluate isn't a number
        }
        catch (NumberFormatException exception) {
            return "ERROR: Invalid number: " + leftNum.tokenValue;
        }

        // Checking if rightNum is a number or not
        try {
            Integer.parseInt(rightNum.evaluate());      // Throws NumFormException if rightNum.evaluate isn't a number
        }
        catch (NumberFormatException exception) {
            return "ERROR: Invalid number: " + rightNum.tokenValue;
        }


        int leftInt = Integer.parseInt(leftNum.evaluate());     // int representation of leftNum
        int rightInt = Integer.parseInt(rightNum.evaluate());   //int representation of rightNum

        // Checking that not dividing by zero
        if (rightInt == 0) {
            return "ERROR: Cannot divide by zero";
        }

        int result = leftInt / rightInt;
        return Integer.toString(result);

    }

    @Override
    public String toString() {
        return leftNum.tokenValue + " " + rightNum.tokenValue + " " + "/";
    }
}
