package Sorting114;

public enum Suit {
	CLUBS("-clubs") , DIAMONDS("-diamonds"), HEARTS("-hearts"), SPADES("-spades");
	
	private String symb;
	
	Suit(String s){
		symb = s;
	}
	
	@Override
	public String toString() {
		return symb;
	}
}
