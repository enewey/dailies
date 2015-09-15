import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class Dealer 
{
	static final char[] _SUITS = {'C', 'S', 'D', 'H'};
	static final int[] _VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	
	private PrintStream _print;
	
	private Card[] _deck;
	private Stack<Card> _deckStack;
	private Card[][] _players;
	
	private Card[] _flop;
	private Card _turn;
	private Card _river;
	
	public Dealer(int players, PrintStream p)
	{
		if (players < 2) players = 2;
		if (players > 8) players = 8;
		_players = new Card[players][];
		for (int i=0; i<players; i++)
			_players[i] = new Card[2];
		
		if (p == null) p = System.out;
		_print = p;
		
		int counter = 0;
		this._deck = new Card[52];
		for (int i=0; i<_SUITS.length; i++)
			for (int j=0; j<_VALUES.length; j++)
				_deck[counter++] = new Card(_SUITS[i], _VALUES[j]);
		
		this.shuffleDeck();
	}
	
	public void shuffleDeck()
	{
		for (int i=_deck.length-1; i>=0; i--)
		{
			Card temp = _deck[i];
			int rand = (int)Math.floor(Math.random()*_deck.length);
			_deck[i] = _deck[rand];
			_deck[rand] = temp;
		}
	}
	
	public void deal()
	{
		_deckStack = new Stack<Card>();
		
		//move the _deck into the _deckStack
		for (int i=_deck.length-1; i>=0; i--)
			_deckStack.push(_deck[i]);
		
		//deal each player a hand
		for (int i=0; i<_players.length; i++)
			for (int j=0; j<2; j++)
				_players[i][j] = _deckStack.pop();
	}
	
	public void doFlop()
	{
		if (_deckStack == null)
			return;
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nFlop: ");
		
		this._flop = new Card[3];
		for (int i=0; i<3; i++)
		{
			_flop[i] = _deckStack.pop();
			sb.append(_flop[i].toString() + ", ");
		}
		sb.trimToSize();
		
		_print.println(sb.toString());
	}
	
	public void doTurn()
	{
		if (_deckStack == null)
			return;
		
		_turn = _deckStack.pop();
		_print.println("Turn: " + _turn.toString());
	}
	
	public void doRiver()
	{
		if (_deckStack == null)
			return;
		
		_river = _deckStack.pop();
		_print.println("River: " + _river.toString());
	}
	
	public void printHands()
	{
		_print.println("Your hand: " + _players[0][0].toString() + 
							  ", " + _players[0][1].toString());
		for (int i=1; i<_players.length; i++)
		{
			_print.println("CPU "+i+" Hand: " + _players[i][0].toString() + 
					  ", " + _players[i][1].toString());
		}
	}
	
	public static void main(String[] args) 
	{
		int players = 0;
		Scanner scanner = new Scanner(System.in);
		while (players < 2 || players > 8)
		{
			System.out.print("How many players (2-8) ? ");
			players = scanner.nextInt();
		}
		scanner.close();
		
		Dealer dealer = new Dealer(players, System.out);
		dealer.deal();
		dealer.printHands();
		dealer.doFlop();
		dealer.doTurn();
		dealer.doRiver();
	}
}

class Card
{
	char suit;
	int value;
	
	public Card(char s, int v)
	{
		this.suit = Character.toUpperCase(s);
		this.value = v;
	}
	
	public String getValueString()
	{
		String ret = "";
		if (this.value == 1) ret += "Ace";
		else if (this.value == 2) ret += "Two";
		else if (this.value == 3) ret += "Three";
		else if (this.value == 4) ret += "Four";
		else if (this.value == 5) ret += "Five";
		else if (this.value == 6) ret += "Six";
		else if (this.value == 7) ret += "Seven";
		else if (this.value == 8) ret += "Eight";
		else if (this.value == 9) ret += "Nine";
		else if (this.value == 10) ret += "Ten";
		else if (this.value == 11) ret += "Jack";
		else if (this.value == 12) ret += "Queen";
		else if (this.value == 13) ret += "King";
		else 
			ret = null;
		
		return ret;
	}
	
	public String getSuitString()
	{
		String ret = "";
		if (this.suit == 'C') ret += "Clubs";
		else if (this.suit == 'H') ret += "Hearts";
		else if (this.suit == 'S') ret += "Spades";
		else if (this.suit == 'D') ret += "Diamonds";
		else
			ret = null;
		
		return ret;
	}
	
	public String toString()
	{
		return "" + this.getValueString() + " of " + this.getSuitString();
	}
}