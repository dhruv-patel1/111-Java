/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */

import java.util.ArrayList;

public class Hand {

   private Card[] hand;   // The cards in the hand.
   private int count; 
   
   /**
    * Create a hand that is initially empty.
    */
   public Hand() {
      hand = new Card[5];
	  count = 0;
   }
   
   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
	  count = 0;
   }
   
   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {
      
	  for(int i=0 ; i<hand.length; i++){ 
		if (hand[i] == null){
			hand[i] = c;
			count = count + 1;
			break;
		}
	 }

	  
   }
   
   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

	for(int i=0 ; i<hand.length; i++){ 
		if (hand[i].equals(c)){
			hand[i] = null;
			count = count-1;
		}
	}

   }
   
   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
   public void removeCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
      hand[position] = null;
   }

   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }
   
   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
			if (c1 != null){
				if ( c1.getSuit() < c.getSuit() ||
						(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            
			Card c1 = hand[i];
            if (c1 != null){
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   public void printHand(){
	   
	   for(int i=0; i<hand.length; i++){
		   if (hand[i] != null){
			   System.out.println(hand[i]);
		   }
	   }
	   System.out.println();
   }
   
   //**************************************************************************************************************************************************//

	public int numPairs() 
	{
		int cnt = 0;
		int prev = 0;
		this.sortByValue();
		if (this.hasFourOfAKind()) 
		{
			return 2;
		} else {
			for (int i = 0; i < hand.length - 1; i++) 
			{
				for (int j = i + 1; j < hand.length; j++) 
				{
					if (hand[i].getValue() == hand[j].getValue() && prev != hand[j].getValue()) 
					{ 
						cnt++;
						prev = hand[j].getValue();
					}
				}
			}
			return cnt;
		}
	}


	public boolean hasTriplet() 
	{
		int cnt = 0;
		for (int i = 0; i < hand.length; i++) 
		{
			cnt = 0;
			for (int j = 0; j < hand.length; j++) 
			{
				if (hand[i].getValue() == hand[j].getValue()) 
				{
					cnt++;
				}
			}
			if (cnt == 3) {
				return true;
			}
		}
		return false;
	}

	
	public boolean hasFlush() 
	{
		for (int i = 0; i < hand.length; i++) 
		{
			for (int j = 0; j < hand.length; j++) 
			{
				if (hand[i].getSuit() != hand[j].getSuit()) 
				{
					return false;
				}
			}
		}
		return true;
	}


	public boolean hasStraight() 
	{
		sortByValue();
		int min = hand[0].getValue();
		if (hand[0].getValue() == 1 && hand[1].getValue() == 10 && hand[2].getValue() == 11 && hand[3].getValue() == 12 && hand[4].getValue() == 13) 
		{
			return true;
		}
		for (int i = 0; i < hand.length; i++) 
		{
			if (hand[i].getValue() == min) 
			{
				min++;
			} 
			else 
			{
				return false;
			}

		}
		return true;
	}


	public boolean hasFullHouse() 
	{
		if (this.hasTriplet() && this.numPairs() == 2) 
		{
			return true;
		}
		return false;
	}


	public boolean hasFourOfAKind() 
	{
		int cnt = 0;
		for (int i = 0; i < hand.length; i++) 
		{
			cnt = 0;
			for (int j = 0; j < hand.length; j++) 
			{
				if (hand[i].getValue() == hand[j].getValue()) 
				{
					cnt++;
				}
			}
			if (cnt == 4) 
			{
				return true;
			}
		}
		return false;
	}


	public Card highestValue() 
	{ 
		this.sortByValue();
		if (hasStraight() == true && hand[hand.length - 1].getValue() == 5) 
		{
			return hand[hand.length - 1];
		} 
		else if (hand[0].getValue() == 1) 
		{
			return hand[0];
		} 
		else 
		{
			return hand[hand.length - 1];
		}
	}

	
	public Card highestDuplicate() 
	{
		int index = 0;
		int highestDup = 0;
		if (this.numPairs() > 0) 
		{
			for (int i = 0; i < hand.length; i++) 
			{
				for (int j = i; j < hand.length; j++) 
				{
					if (hand[i].getValue() == hand[j].getValue()) 
					{
						if (hand[i].getValue() == 1) 
						{
							return hand[i];
						} 
						else if (hand[i].getValue() > highestDup) 
						{
							highestDup = hand[i].getValue();
							index = i;
						}
					}
				}
			}
			return hand[index];
		} 
		else 
		{
			return null;
		}
	}

	
	public int compareTo(Hand h) 
	{
		int instance = 0;
		int parameter = 0;

		if (this.hasStraight() && this.hasFlush()) 
		{
			instance = 9;
		}
		else if (this.hasFourOfAKind()) 
		{
			instance = 8;
		}
		else if (this.hasFullHouse()) 
		{
			instance = 7;
		}
		else if (this.hasFlush())
		{
			instance = 6;
		}
		else if (this.hasStraight())
		{
			instance = 5;
		}
		else if (this.hasTriplet()) 
		{
			instance = 4;
		}
		else if (this.numPairs() == 2) 
		{
			instance = 3;
		}
		else if (this.numPairs() == 1)
		{
			instance= 2;
		}
		
	
		if (h.hasStraight() && h.hasFlush())
		{
			parameter = 9;
		}
		else if (h.hasFourOfAKind())
		{
			parameter = 8;
		}
		else if (h.hasFullHouse())
		{
			parameter = 7;
		}
		else if (h.hasFlush())
		{
			parameter = 6;
		}
		else if (h.hasStraight())
		{
			parameter = 5;
		}
		else if (h.hasTriplet())
		{
			parameter = 4;
		}
		else if (h.numPairs() == 2)
		{
			parameter = 3;
		}
		else if (h.numPairs() == 1)
		{
			parameter = 2;
		}
		if (instance > parameter)
		{
			return 1;
		}
		else if (parameter > instance)
		{
			return -1;
		}
		else 
		{ 
			if (instance == 8 || instance == 4) 
			{
				if (aceVal(this.highestDuplicate()) > aceVal(h.highestDuplicate())) 
				{
					return 1;
				} 
				else if (aceVal(this.highestDuplicate()) < aceVal(h.highestDuplicate())) 
				{
					return -1;
				} 
				else 
				{ 
					return 0;
				}
			} 
			else if (instance == 3 || instance == 7) 
			{ 
				if (aceVal(this.highestDuplicate()) > aceVal(h.highestDuplicate())) 
				{
					return 1;
				} 
				else if (aceVal(this.highestDuplicate()) < aceVal(h.highestDuplicate()))
				{
					return -1;
				} 
				else 
				{ 
					if (this.secondHighestDup().getValue() > h.secondHighestDup().getValue()) 
					{
						return 1;
					}
					else if (this.secondHighestDup().getValue() < h.secondHighestDup().getValue()) 
					{
						return -1;
					} 
					else
					{ 
						if (aceVal(this.nonDuplicate()) > aceVal(h.nonDuplicate())) 
						{
							return 1;
						} 
						else if (aceVal(this.nonDuplicate()) < aceVal(h.nonDuplicate())) 
						{
							return -1;
						} 
						else 
						{
							return 0;
						}
					}
				}
			} 
			else if (instance == 9 || instance == 5) 
			{ 
				if (aceVal(this.highestValue()) > aceVal(h.highestValue())) 
				{
					return 1;
				} 
				else if (aceVal(this.highestValue()) < aceVal(h.highestValue())) 
				{
					return -1;
				} 
				else 
				{
					return 0;
				}
			} 
			else if (instance == 2) 
			{
				if (aceVal(this.highestDuplicate()) > aceVal(h.highestDuplicate())) 
				{
					return 1;
				} 
				else if (aceVal(this.highestDuplicate()) < aceVal(h.highestDuplicate())) 
				{
					return -1;
				} 
				else 
				{
					if (aceVal(this.highestDuplicate()) != aceVal(this.highestValue()) && aceVal(h.highestDuplicate()) == aceVal(h.highestValue())) 
					{
						return 1;
					} 
					else if (aceVal(this.highestDuplicate()) == aceVal(this.highestValue()) && aceVal(h.highestDuplicate()) != aceVal(h.highestValue()))
					{
						return -1;
					} 
					else 
					{
						if (this.secondHighest().getValue() > h.secondHighest().getValue()) 
						{
							return 1;
						}
						else if (this.secondHighest().getValue() < h.secondHighest().getValue()) 
						{
							return -1;
						} 
						else 
						{
							if (this.thirdHighest().getValue() > h.thirdHighest().getValue()) 
							{
								return 1;
							} 
							else if (this.thirdHighest().getValue() < h.thirdHighest().getValue()) 
							{
								return -1;
							} 
							else 
							{
								if (this.fourthHighest().getValue() > h.fourthHighest().getValue()) 
								{
									return 1;
								} 
								else if (this.fourthHighest().getValue() < h.fourthHighest().getValue()) 
								{
									return -1;
								} 
								else 
								{
									return 0;
								}

							}
						}
					}
				}
			} 
			else if (instance == 6 || instance == 0) 
			{ 
				if (aceVal(this.highestValue()) > aceVal(h.highestValue())) 
				{
					return 1;
				} 
				else if (aceVal(this.highestValue()) > aceVal(h.highestValue())) 
				{
					return -1;
				} 
				else 
				{
					if (this.secondHighest().getValue() > h.secondHighest().getValue()) 
					{
						return 1;
					} 
					else if (this.secondHighest().getValue() < h.secondHighest().getValue()) 
					{
						return -1;
					} 
					else 
					{
						if (this.thirdHighest().getValue() > h.thirdHighest().getValue()) 
						{
							return 1;
						} 
						else if (this.thirdHighest().getValue() < h.thirdHighest().getValue()) 
						{
							return -1;
						} 
						else 
						{
							if (this.fourthHighest().getValue() > h.fourthHighest().getValue()) 
							{
								return 1;
							} 
							else if (this.fourthHighest().getValue() < h.fourthHighest().getValue()) 
							{
								return -1;
							} 
							else 
							{
								if (this.fifthHighest().getValue() > h.fifthHighest().getValue()) 
								{
									return 1;
								} 
								else if (this.fifthHighest().getValue() < h.fifthHighest().getValue()) 
								{
									return -1;
								} 
								else
								{
									return 0;
								}
							}
						}
					}
				}
			}

		}
		return 0;
	}

	/********************************* Implement your methods here****************************************/

	public int aceVal(Card card) 
	{
		if (card.getValue() == 1) 
		{
			return 14;
		} 
		else 
		{
			return card.getValue();
		}
	}

	public Card secondHighestDup() 
	{
		this.sortByValue();
		if (hand[0].getValue() == 1 && hand[1].getValue() == 1) 
		{
			for (int i = 1; i <= hand.length - 1; i++) 
			{
				if (hand[hand.length - i].getValue() == hand[hand.length - i - 1].getValue()) 
				{
					return hand[hand.length - 1];
				}
			}
		} 
		else if (this.numPairs() == 2 && this.hasFourOfAKind() == false) 
		{
			return hand[1]; 
		}
		return null;
	}

	public Card nonDuplicate() 
	{
		this.sortByValue();
		int cnt = 0;
		if (this.numPairs() == 2 && this.hasFourOfAKind() == false) 
		{
			for (int i = 0; i < hand.length; i++) 
			{
				cnt = 0;
				for (int j = i; j < hand.length; j++) 
				{
					if (hand[i].getValue() == hand[j].getValue()) 
					{
						cnt++;
					}
				}
				if (count == 0) 
				{
					return hand[i];
				}
			}
		}
		return null;
	}

	public Card secondHighest() 
	{
		this.sortByValue();
		if (hand[0].getValue() == 1)
		{
			return hand[hand.length - 1];
		}
		for (int i = hand.length - 2; i >= 0; i--) 
		{
			if (hand[i].getValue() != hand[i + 1].getValue()) 
			{
				return hand[i];
			}
		}
		return null;
	}

	public Card thirdHighest() 
	{
		this.sortByValue();
		if (hand[0].getValue() == 1) 
		{
			return hand[hand.length - 2];
		}
		for (int i = hand.length - 3; i >= 0; i--) 
		{
			if (hand[i].getValue() != hand[i + 1].getValue()) 
			{
				return hand[i];
			}
		}
		return null;
	}

	public Card fourthHighest() 
	{
		this.sortByValue();
		if (hand[0].getValue() == 1) 
		{
			return hand[hand.length - 3];
		}
		for (int i = hand.length - 4; i >= 0; i--)
		{
			if (hand[i].getValue() != hand[i + 1].getValue()) 
			{
				return hand[i];
			}
		}
		return null;
	}

	public Card fifthHighest() 
	{
		this.sortByValue();
		if (hand[0].getValue() == 1) 
		{
			return hand[hand.length - 4];
		}
		for (int i = hand.length - 5; i >= 0; i--)
		{
			if (hand[i].getValue() != hand[i + 1].getValue()) 
			{
				return hand[i];
			}
		}
		return null;
	}
}
   
 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   