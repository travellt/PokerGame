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
		
		TestHand hand = new TestHand("newstraight");
		
		int rank = HandEvaluator.assessHand(hand);
		
		assertEquals("it went wrong", rank, 4);
			
	}

}