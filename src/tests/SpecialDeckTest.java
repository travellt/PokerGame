package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tests.TestHand;
import code.SpecialDeck;

public class SpecialDeckTest {

	@Test
	public void test() {
		TestHand myhand = new TestHand("highcard");
		
		SpecialDeck classUnderTest = new SpecialDeck(myhand);
		classUnderTest.printDeck();
		assertEquals("not the right size", 47, classUnderTest.cardsInDeck());
		
	}
	
	

}
