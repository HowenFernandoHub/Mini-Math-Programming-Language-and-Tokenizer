/**
 *  Program # 4
 *  Abstract class for creating Token objects
 *  Each Token objects has a String tokenValue.
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */


public abstract class Token {

    protected Token leftNum;        // Will hold the left number of the mathematical expression
    protected Token rightNum;       // Will hold the right number of the mathematical expression
    protected String tokenValue;

    /**
     * Token constructor. Assigns private String tokenValue with String parameter
     * @param tokenValue - user input string for value of token
     */
    public Token(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    /**
     * Token constructor with 2 input parameters
     * @param leftNum - user input for leftNum
     * @param rightNum - user input for rightNum
     */
    public Token(Token leftNum, Token rightNum) {
        this.leftNum = leftNum;
        this.rightNum = rightNum;
    }

    abstract String evaluate();       // Abstract method, returns String

}
