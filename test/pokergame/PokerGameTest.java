/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jameswillby
 */
public class PokerGameTest {
    
    public PokerGameTest() {
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

    /**
     * Test of main method, of class PokerGame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PokerGamePerson.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
