import Exceptions.NotCorrectResultException;

import java.util.ArrayList;

//public class Nerdle {
//
//    private static final String VALID_EXPRESSION_REGEX = "^([-+*/()]\\d+)*([-+*/()]\\d+={1}[-+*/()=]\\d+)+$";
//    SymbolHint correct = SymbolHint.CORRECT;
//    SymbolHint misplaced = SymbolHint.MISPLACED;
//    SymbolHint useless = SymbolHint.USELESS;
//
//    public SymbolHint[] getHints(String guess, String solution, boolean isMini) throws Exception {
//        ArrayList<SymbolHint> symbolHints = new ArrayList<>();
//        char[] guessChars = guess.toCharArray();
//        char[] solutionChars = solution.toCharArray();
//        int length = 0;
//
//        if (isMini) {
//            length = 6;
//        } else { length = 8; }
//
//
//        for (int i = 0; i < length; i++) {
//            if (guessChars[i] == solutionChars[i]) {
//                symbolHints.add(correct);
//                continue;
//            }
//            if ()
//        }
//
//        return symbolHints.toArray(new SymbolHint[0]);
//    }
//
//    private boolean validateExpression(String solution) {
//        int equals = 0;
//        for(char c : solution.toCharArray()) {
//            if ('=' == c){
//                equals++;
//            }
//             if(equals == 1 && (c == '%' || c == '/' || c == '*' || c == '+' || c == '-')){
//                 return false;
//            }
//        }
//        if (equals != 1) return false;
//
//
//        return solution.matches(VALID_EXPRESSION_REGEX);
//    }
//}
public class Nerdle {
    public static final int NORMAL_LENGTH = 8;
    public static final int MINI_LENGTH = 6;

    public enum SymbolHint {
        USELESS,
        MISPLACED,
        CORRECT
    }

    public boolean validateExpression(String expression) {
        // Given a string, it returns whether or not it follows the syntax
        // ArithmeticExpression "=" Result
        // with ints, "+", "-", "*" and "/" as operators and
        // without parentheses or spaces AND
        // the value of ArithmeticExpression equals Result
        // Not yet implemented...
        return false;
    }

    public SymbolHint[] getHints(String guess, String solution, boolean isMini) {
        // Not yet implemented...
        return null;
    }
}