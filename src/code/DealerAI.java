package code;

import java.util.Vector;

public class DealerAI {
	
	Hand hand;
	Vector<Card> swapcardsonecard;
	Vector<Card> swapcardstwocards;
	Vector<Card> swapcardsthreecards;
	Vector<Card> swapcardsnocards = new Vector<Card>();
	int currentrank;
	
	public DealerAI(Hand myhand) {
		this.hand = new Hand();
		for (int k = 0; k < myhand.size(); k++)
			hand.add(myhand.get(k));
		this.swapcardsonecard = new Vector<Card>();
		this.swapcardstwocards = new Vector<Card>();
		this.swapcardsthreecards = new Vector<Card>();
		this.currentrank = HandEvaluator.assessHand(hand);
	}

	public Vector<Card> whichCardsShouldISwap() {
		
		if (currentrank >= 4)
			return swapcardsnocards;
		
		
		Double bestrankdiffonecard = rankDiffSwapOneCard();
		
		Double bestrankdifftwocards = rankDiffSwapTwoCards();
		
		Double bestrankdiffthreecards = rankDiffSwapThreeCards();
		
		
		
		
		
		if ((bestrankdiffonecard > bestrankdifftwocards) && (bestrankdiffonecard > bestrankdiffthreecards))
			return swapcardsonecard;
		else if (bestrankdifftwocards > bestrankdiffthreecards)
			return swapcardstwocards;
		else if (bestrankdiffthreecards != 0)
				return swapcardsthreecards;
		else return swapcardsnocards;
		
	}
	
	private Double rankDiffSwapOneCard() {
	
    Double rankdiffonecard = 0.0;
	Card bestcardtoswap = null;
	

	for (int i = 0; i < hand.getSize(); i++){
		Double temprankdiff = rankDiffIfSwapped(i);
		if (rankdiffonecard < temprankdiff){
			rankdiffonecard = temprankdiff;
			bestcardtoswap = hand.getCard(i);
			}
				
		}
		
		
		
		swapcardsonecard.add(bestcardtoswap);
		return rankdiffonecard;
	}
		
	private Double rankDiffSwapTwoCards() {
		
		Double rankdiff = 0.0;
		int bestcardoneindex = 0;
		int bestcardtwoindex = 0;
		Card bestcardtoswapcardone;
		Card bestcardtoswapcardtwo;
		

		for (int i = 0; i < hand.getSize() - 1 ; i++)
			for (int j = i + 1 ; j < hand.getSize() ; j++ ){
				Double temprankdiff = rankDiffIfSwapped(i, j);
				if (rankdiff < temprankdiff){
				rankdiff = temprankdiff;
				bestcardoneindex = i;
				bestcardtwoindex = j;
				}
			}
		
		bestcardtoswapcardone = hand.getCard(bestcardoneindex);
		bestcardtoswapcardtwo = hand.getCard(bestcardtwoindex);
		
		swapcardstwocards.add(bestcardtoswapcardone);
		swapcardstwocards.add(bestcardtoswapcardtwo);
		
		
		return rankdiff;
	}
			
			
	private Double rankDiffSwapThreeCards() {
		
		Double rankdiff = 0.0;
		int bestcardoneindex = 0;
		int bestcardtwoindex = 0;
		int bestcardthreeindex = 0;
		Card bestcardtoswapcardone;
		Card bestcardtoswapcardtwo;
		Card bestcardtoswapcardthree;
		

		for (int i = 0; i < hand.getSize() - 2 ; i++)
			for (int j = i+1; j < hand.getSize() - 1 ; j++ )
				for (int k = j+1; k < hand.getSize(); k++){
					Double temprankdiff = rankDiffIfSwapped(i, j, k);
					if (rankdiff < temprankdiff){
						rankdiff = temprankdiff;
						bestcardoneindex = i;
						bestcardtwoindex = j;
						bestcardthreeindex = k;
				}
			}
		
		bestcardtoswapcardone = hand.getCard(bestcardoneindex);
		bestcardtoswapcardtwo = hand.getCard(bestcardtwoindex);
		bestcardtoswapcardthree = hand.getCard(bestcardthreeindex);
		
		
		swapcardsthreecards.add(bestcardtoswapcardone);
		swapcardsthreecards.add(bestcardtoswapcardtwo);
		swapcardsthreecards.add(bestcardtoswapcardthree);
		
		 
		return rankdiff;
	}

	private Double rankDiffIfSwapped(int cardi) {
	
		Double rankdiffifswapped = 0.0;
		
		for (int j = 0; j < 47 ; j++){
			SpecialDeck tempdeck = new SpecialDeck(hand);
			Hand temphand = new Hand();
			for (int k = 0; k < hand.size(); k++){
				if (k == cardi)
					temphand.add(tempdeck.getCard(j));
				else temphand.add(hand.getCard(k));
				}
			
			
			int temphandrank = HandEvaluator.assessHand(temphand);
			
			
			int temprankdiff =  temphandrank - currentrank;
			rankdiffifswapped = rankdiffifswapped + temprankdiff;
			
			}
		
		rankdiffifswapped = rankdiffifswapped / 47;
		return rankdiffifswapped;
	}	
	
	private Double rankDiffIfSwapped(int cardi, int cardm) {
		
		Double rankdiffifswapped = 0.0;
		
		for (int j = 0; j < 47 ; j++){
			SpecialDeck tempdeck = new SpecialDeck(hand);
			Hand temphand = new Hand();
			for (int k = 0; k < hand.size(); k++){
				if (k == cardi)
					temphand.add(tempdeck.getCard(j));
				else temphand.add(hand.getCard(k));
				}
			Hand temphand2 = new Hand();
			for (int z = 0; z < hand.size(); z++)
				temphand2.add(temphand.getCard(z));
			temphand2.add(hand.getCard(cardi));
			SpecialDeck tempdeck2 = new SpecialDeck(temphand2);
			
				for (int l = 0; l < 46; l++){
					
				temphand.setElementAt(tempdeck2.getCard(l), cardm);
				int temphandrank = HandEvaluator.assessHand(temphand);
				int temprankdiff = temphandrank - currentrank;
				rankdiffifswapped = rankdiffifswapped + temprankdiff;
				}	
		}		
		rankdiffifswapped = rankdiffifswapped / (47*46);			
		return rankdiffifswapped;
	}	
	
	
	private Double rankDiffIfSwapped(int cardi, int cardm, int cardn) {
			
		Double rankdiffifswapped = 0.0;
		
		SpecialDeck tempdeck = new SpecialDeck(hand);
			for (int j = 0; j < 47 ; j++){
				Hand temphand = new Hand();
				for (int k = 0; k < hand.size(); k++){
					if (k == cardi)
						temphand.add(tempdeck.getCard(j));
					else temphand.add(hand.getCard(k));
					}
				Hand temphand2 = new Hand();
				for (int z = 0; z < hand.size(); z++)
					temphand2.add(temphand.getCard(z));
				temphand2.add(hand.getCard(cardi));
				SpecialDeck tempdeck2 = new SpecialDeck(temphand2);
				for (int l = 0; l < 46; l++){
					temphand.setElementAt(tempdeck2.getCard(l), cardm);
				Hand temphand3 = new Hand();
				for (int z = 0; z < hand.size(); z++)
					temphand3.add(hand.getCard(z));
					temphand3.add(hand.getCard(cardi));
					temphand3.add(hand.getCard(cardm));
					SpecialDeck tempdeck3 = new SpecialDeck(temphand3);
				for (int m = 0; m < 45; m ++){
					
					temphand.setElementAt(tempdeck3.getCard(m), cardn);
					int temphandrank = HandEvaluator.assessHand(temphand);
					int temprankdiff = temphandrank - currentrank;
					rankdiffifswapped = rankdiffifswapped + temprankdiff;
					
					}
				}	
			}
			rankdiffifswapped = rankdiffifswapped / (47*46*45);
			
		return rankdiffifswapped;
	}
	
}
