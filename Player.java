import java.util.Random;

public class Player {
	
	private double balance;
	private Hand h = new Hand();
	public Player(double balance)
	{
	this.balance = balance;
	this.h = new Hand();
	}

	public void deal(Card c)
	{
	h.addCard(c);
	}

	
	public Card[] discard()
	{
	System.out.println("How many cards would you like to discard? ");
	int unwantedC = discardAmount();
	Card [] discard = new Card[unwantedC];
	System.out.println("Which cards would you like to discard? ");
	for(int i = 0; i < unwantedC; i++) 
	{
	Card unwanted = h.getCard(i);
	h.removeCard(unwanted);
	discard[i] = unwanted;
	}
	return discard;
	}

	public double wager(double min)
	{
	System.out.println(min);
	System.out.println("How much money are you willing to wage? ");
	double bet = theWage(min,balance);
	if(balance == 0 || balance < min) 
	{
	return -1.0;
	}
	if(bet >= min && bet < balance) 
	{
	this.balance = balance - bet;
	return bet;
	}
	this.balance = balance - bet;
	return bet;
	}
	public Hand showHand()
	{
	return h;
	}

	public double getBalance()
	{
	return this.balance;
	}

	public void winnings(double amount)
	{
	this.balance = balance + amount;
	h.clear();
	}

	public static int discardAmount() 
	{
	Random d = new Random();
	return d.nextInt(6);
	}

	public static double theWage(double min, double balance) 
	{
	Random w = new Random();
	double money = min + (balance - min) * w.nextDouble();
	return money;
	}
}
