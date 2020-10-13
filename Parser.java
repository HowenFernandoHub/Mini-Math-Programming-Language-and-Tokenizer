import java.util.ArrayList;

public abstract class Parser {
    protected ArrayList<String> keywords;

    public Parser() {
        keywords = new ArrayList<>();
    }

    public Token parse(String[] tokens) {

        if (tokens.length != 3) {
            return new Token(null, null) {
                @Override
                String evaluate() {
                    return "ERROR: Invalid Expression";
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

        if (keywords.contains(tokens[2])) {
            return createToken(tokens);
        }

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

    abstract Token createToken(String[] tokens);
}
