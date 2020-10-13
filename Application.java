import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Tokenizer myTokenizer = new Tokenizer();

        try {
            myTokenizer.tokenizeFile("test.txt");
        }
        catch (IOException exception) {
            System.out.println("Something wrong with the file: " + exception.getMessage());
        }
        catch (Exception exception) {
            System.out.println("Exception encountered: " + exception.getMessage());
        }

        try {
            myTokenizer.writeTokens();
        }
        catch (IOException exception) {
            System.out.println("Something wrong with writing the file: " + exception.getMessage());
        }

    }
}
