import Exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import Nerdle.SymbolHint;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NerdleTest {

    Nerdle nerdle = new Nerdle();
    SymbolHint correct = SymbolHint.CORRECT;
    SymbolHint misplaced = SymbolHint.MISPLACED;
    SymbolHint useless = SymbolHint.USELESS;

    @ParameterizedTest
    @MethodSource("testCases")
    void testGetHints(String guess, String solution, boolean isMini, SymbolHint[] expectedHints) throws Exception {
        SymbolHint[] actualHints = nerdle.getHints(guess, solution, isMini);
        Assertions.assertArrayEquals(expectedHints, actualHints);
    }

    
    Object[][] testCases() {
        return new Object[][]{
            {
                "19+-18=1", "1-8+16=9", false,
                    new SymbolHint[]{correct, misplaced, misplaced, misplaced, correct, misplaced, correct, useless}
                    //C1
            },
            {
                "7+3=10", "8+2=10", true,
                    new SymbolHint[]{useless, correct, useless, correct, correct, correct}
                    //C9
            }
        };
    }

    @ParameterizedTest
    @MethodSource("exceptionCases")
    void testGetHintsExceptions(String guess, String solution, boolean isMini, Exception exception) throws Exception {
        try {
            nerdle.getHints(guess, solution, isMini);
            fail("");
        } catch (Exception e) {
            assertEquals(e, exception);
        }
    }

    Object[][] exceptionCases() {
        return  new Object[][] {
                {
                    "19+-18=2", "1-8+16=9", false, new NotCorrectResultException()
                        //C2
                },
                {
                    "19=18+1", "1-8+16=9", false, new OperationalResultException()
                        //C3
                },
                {
                    "19=18=1", "1-8+16=9", false, new IncorrectNumberEqualsException()
                        //C4
                },
                {
                    "19+-1A=1", "1-8+16=9", false, new NotValidSymbolException()
                        //C5
                },
                {
                    "19*/18=1", "1-8+16=9", false, new NotValidSymbolException()
                        //C6
                },
                {
                    "19++11=30", "1-8+16=9", false, new IncorrectNumberOfSymbolsException()
                        //C7
                },
                {
                    "8+02=10", "8+2=10", true, new IncorrectNumberOfSymbolsException()
                        //C8
                },
                {
                    "8+2=1", "8+2=10", true, new IncorrectNumberOfSymbolsException()
                        //C10
                },
                {
                    "19+1=30", "1-8+16=9", false, new IncorrectNumberOfSymbolsException()
                        //C11
                },
                {
                    "19+18-1", "1-8+16=9", false, new IncorrectNumberEqualsException()
                        //C12
                }
        };
    }
}
