/**
 *  Program # 4
 *  TokenBuilder inherits from Parser and implements Builder
 *  Has build method which builds Token objects from a String input
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */

import java.util.ArrayList;

public class TokenBuilder extends Parser implements Builder {

    private String delimiter;

    // Default constructor initializes delimiter to ","
    public TokenBuilder() {
        delimiter = ",";
    }

    /**
     * Constructor initializes delimiter and inherited keywords
     * @param delimiter - String used for parsing Strings
     * @param keywords - ArrayList<String> that will hold the mathematicl operators
     */
    public TokenBuilder(String delimiter, ArrayList<String> keywords) {
        this.delimiter = delimiter;
        super.keywords = keywords;

    }

    /**
     * Takes the String input and parses it by spaces
     * @param input - String that is turned into String[]
     * @return result of the parse method
     */
    @Override
    public Token build(String input) {
        input = input.trim();       // Gets rid of any trailing and leading spaces

        String[] tokens = input.split("\\s+");       //Holds the delimited strings from String input

        return parse(tokens);       // Calls inherited method from Parser class
    }

    /**
     * Generates Token object depending on third element of the String[] tokens
     * @param tokens - String[] created from the input String from the build method
     * @return - Token object
     */
    @Override
    Token createToken(String[] tokens) {

        Constant leftNum = new Constant(tokens[0]);
        Constant rightNum = new Constant(tokens[1]);

        switch(tokens[2]) {
            case "+":
                Add add = new Add(leftNum, rightNum);
                return add;
            case "-":
                Subtract subtract = new Subtract(leftNum, rightNum);
                return subtract;
            case "*":
                Multiply multiply = new Multiply(leftNum, rightNum);
                return multiply;
            case "/":
                Divide divide = new Divide(leftNum, rightNum);
                return divide;
            case "%":
                Modulo modulo = new Modulo(leftNum, rightNum);
                return modulo;
            default:
                return new Token(null, null) {
                    @Override
                    String evaluate() {
                        return "ERROR: Invalid Operator: " + tokens[2];
                    }

                    @Override
                    public String toString() {
                        String origExpression = "";
                        for (String token : tokens) {
                            origExpression += token + " ";
                        }
                        return origExpression;
                    }
                };
        }
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void setKeywords(ArrayList<String> keywords) {
        super.keywords = keywords;
    }
}
