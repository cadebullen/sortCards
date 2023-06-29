package Sorting114;

public class Card implements Comparable<Card>{
	public Rank rank;
	public Suit suit;
	
	public Card(Rank r, Suit s) {
		this.rank = r;
		this.suit = s;
	}
	@Override
	public String toString() {
		return rank.toString() + suit.toString();
		
	}
	@Override

   public int compareTo(Card other){
      int RankCompar = this.rank.compareTo(other.rank);
         if (RankCompar != 0){
            return RankCompar;
         }
         else{
            return this.rank.compareTo(other.rank);
         }
	}
}

