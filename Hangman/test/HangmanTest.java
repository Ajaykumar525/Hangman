import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HangmanTest {
    public HangmanTest() {
    } 
    @BeforeClass
    public static void setUpClass() {
    } 
    @AfterClass
    public static void tearDownClass() {
    } 
    @Before
    public void setUp() {
    } 
    @After
    public void tearDown() {
    }
    @Test
    public void testMain() {
        System.out.println("main method() testing");
        String[] args = null;
        Hangman.main(args);
        fail("Not yet implemented”);
    }
    @Test
    public void testCheckCharacter() {
        System.out.println("checkCharacter() method testing");
        String guess = "a";
        HangmanGame.checkCharacter(guess);
        fail("The test case is a prototype.");
    }
    @Test
    public void testDeductLife() {
        System.out.println("deductLife() method testing");
        HangmanGame.deductLife();
        fail("The test case is a prototype.");
    }
    @Test
    public void testMessage() {
        System.out.println("message() method testing");
        String message = "Please input a character";
        HangmanGame.message(message);
        fail(“Not yet implemented…”);
    } 
}
