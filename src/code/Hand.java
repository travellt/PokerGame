/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;
import java.util.Vector;
/**
 *
 * @author jameswillby
 */
public class Hand {
 
    protected Vector<Card> myhand = new Vector<Card>();
    
     
    public Hand() {
		
	}


	public int getSize() {
    	return myhand.size();
    }
	
	public int size() {
    	return myhand.size();
    }
	
	public Card getCard(int x) {
		// TODO Auto-generated method stub
		return myhand.get(x);
	}
    
	public Card get(int x) {
		// TODO Auto-generated method stub
		return myhand.get(x);
	}
	
	 public void setElementAt(Card c, int position)
	    {
	    myhand.setElementAt(c, position);
	    }
	 
	 public void add(Card e)
	    {
	        myhand.add(e);
	    }
	 public void printHand() {
		 for (int i = 0 ; i < 5; i++)
			 System.out.print(myhand.get(i).getSuite() + " " + myhand.get(i).getValue() + "\n");
	 }
}