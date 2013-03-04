package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import code.HandEvaluator;
import tests.TestHand;

public class HandEvaluatorTest {

	@Test
	public void test() {
		
		TestHand hand = new TestHand("highcard");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 0);
			
	}

	@Test
	public void test2() {
		
		TestHand hand = new TestHand("pair");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 1);
			
	}
	
	@Test
	public void test3() {
		
		TestHand hand = new TestHand("twopair");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 2);
			
	}
	
	@Test
	public void test4() {
		
		TestHand hand = new TestHand("threeofakind");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 3);
			
	}
	
	@Test
	public void test5() {
		
		TestHand hand = new TestHand("straight");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 4);
			
	}
	
	@Test
	public void test6() {
		
		TestHand hand = new TestHand("flush");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 5);
			
	}
	
	@Test
	public void test7() {
		
		TestHand hand = new TestHand("fourofakind");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 6);
			
	}
	
	@Test
	public void test8() {
		
		TestHand hand = new TestHand("straight");
		
		TestHand otherhand = new TestHand("straight");
		
		HandEvaluator.assessHand(otherhand);
		
		assertEquals("wrong frist card", hand.get(0).getValue(), otherhand.get(0).getValue());
		assertEquals("wrong first card suite", hand.get(0).getSuite(), otherhand.get(0).getSuite()); 
		
		assertEquals("wrong second card", hand.get(1).getValue(), otherhand.get(1).getValue());
		assertEquals("wrong second card suite", hand.get(1).getSuite(), otherhand.get(1).getSuite());
		
		assertEquals("wrong third card", hand.get(2).getValue(), otherhand.get(2).getValue());
		assertEquals("wrong third card suite", hand.get(2).getSuite(), otherhand.get(2).getSuite());
		
		assertEquals("wrong fourth card", hand.get(3).getValue(), otherhand.get(3).getValue());
		assertEquals("wrong fourth card suite", hand.get(3).getSuite(), otherhand.get(3).getSuite());
	
		assertEquals("wrong fifth card", hand.get(4).getValue(), otherhand.get(4).getValue());
		assertEquals("wrong fifth card suite", hand.get(4).getSuite(), otherhand.get(4).getSuite());
	}

	

}