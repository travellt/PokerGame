/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author jameswillby - first commit test
 */
public class Card {
    
    private String suite;
    private int value;
    
    public Card(String su, int x)
    {
        this.suite = su;
      
        this.value = x;
    }
    
       
    public void setSuite(String suite) {
        this.suite = suite;
    }

    
    public void setValue(int value) {
        this.value = value;
    }

    public String getSuite() {
        return suite;
    }

    
    public int getValue() {
        return value;
    }
    
    /*public boolean equals(Object obj) {
    	if (this.equals(obj))
    		return true;
    	else return false;
    }
    
 public boolean equals(Card card) {
    	if (this.getValue() == card.getValue() && this.getSuite().equals(card.getSuite()))
    		return true;
    	else return false;
    }*/
    
}
