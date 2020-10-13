/**
 *  Program # 4
 *  Tokenizer Scans in strings one line at a time and generates Token objects out of them
 *  It stores the Tokens into an ArrayList to be used to write out to a file
 *  CS108-4
 *  @date 4/24/2020
 *  @author Howen Anthony Fernando
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer {
    private ArrayList<Token> tokenList;
    private ArrayList<String> mathOperations;
    private TokenBuilder theBuilder;

    /**
     * Default constructor: Initializes the ArrayList tokenList
     * Initializes the ArrayList mathOperations and adds all the math operators
     * Initializes the TokenBuilder theBuilder with delimiter " " and mathOperations
     */
    public Tokenizer() {
        tokenList = new ArrayList<>();

        mathOperations = new ArrayList<>(5);
        mathOperations.add("+");
        mathOperations.add("-");
        mathOperations.add("*");
        mathOperations.add("/");
        mathOperations.add("%");
        theBuilder = new TokenBuilder("\\s+", mathOperations);
    }

    /**
     * Opens a file and scans in using a Scanner. Parses into tokens and adds them to tokenList
     * @param filePath - name of file to be read
     * @throws - IOException
     */
    public void tokenizeFile (String filePath) throws IOException {
        tokenList.clear();

        FileInputStream fInStream = new FileInputStream(filePath);
        Scanner inFS = new Scanner(fInStream);

        while (inFS.hasNextLine()) {
            String nextStr = inFS.nextLine();

            if (!nextStr.isEmpty()) {
                tokenList.add(theBuilder.build(nextStr));
            }
        }

        fInStream.close();
        inFS.close();
    }

    /**
     * Converts tokenList from ArrayList to an Array
     * @return Token[] tokenArr
     */
    public Token[] getTokens() {
        Token[] tokenArr = new Token[tokenList.size()];

        for (int i = 0; i < tokenList.size(); i++) {
            tokenArr[i] = tokenList.get(i);
        }

        return tokenArr;
    }

    /**
     * Prints the result of each token on individual lines in a file "output.txt"
     * @throws IOException
     */
    public void writeTokens() throws IOException {
        FileOutputStream fOutStream = new FileOutputStream("output.txt");
        PrintStream outFS = new PrintStream(fOutStream);

        for (int i = 0; i < tokenList.size(); i++) {
            outFS.println(tokenList.get(i).evaluate());
        }
        fOutStream.close();
        outFS.close();
    }

    @Override
    public String toString() {
        return tokenList.toString();
    }



}
