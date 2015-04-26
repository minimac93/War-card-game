public class Card {

    // declare suit values as public static ints so they can be accessed outside of the class
    public static final int CLUBS = 1, DIAMONDS = 2, HEARTS = 3, SPADES = 4;
    // declare values for face cards as public static ints so they can be accessed outside of the class
    public static final int JACK = 11, QUEEN = 12, KING = 13, ACE = 1;
    // declare values for suit and rank
    private int suit, rank;
    // declare public constants for number of suits and ranks in a deck
    public static final int SUITS = 4, RANKS = 13;

    /**
        constructor takes suit and rank to create Card
        @param suit Integer value of suit
        @param rank Integer value of rank
    */
    public Card(int suit, int rank) {
        // throw exception if the suit is outside possible ranks, otherwise set suit
        if (suit < 1 || suit > SUITS)
            throw new IllegalArgumentException("Invalid suit integer");
        else
            this.suit = suit;

        // throw exception if the rank is outside possible ranks, otherwise set rank
        if (rank < 1 || rank > RANKS)
            throw new IllegalArgumentException("Invalid rank integer");
        else
            this.rank = rank;
    }

    /**
        copy constructor takes another Card to produce new one
        @param otherCard Card object to be copied
    */
    public Card(Card otherCard) {
        suit = otherCard.suit;
        rank = otherCard.rank;
    }

    /**
        accessor to get suit as integer
        @return Suit as integer
    */
    public int getSuit() {
        return suit;
    }

    /**
        accessor to get rank as integer
        @return Rank as integer
    */
    public int getRank() {
        return rank;
    }

    /**
        toString method provides text info on card (i.e. King of Clubs, etc.)
        @return String of card information
    */
    public String toString() {
        // declare strings for suit and rank
        String suitString, rankString;

        // switch suit and set suitString based on value
        switch (suit) {
            case CLUBS:
                suitString = "Clubs";
                break;
            case DIAMONDS:
                suitString = "Diamonds";
                break;
            case HEARTS:
                suitString = "Hearts";
                break;
            default: // only when case is SPADES
                suitString = "Spades";
                break;
        }

        // switch rank and set rankString based on value
        switch (rank) {
            case 1:
                rankString = "Ace";
                break;
            case 11:
                rankString = "Jack";
                break;
            case 12:
                rankString = "Queen";
                break;
            case 13:
                rankString = "King";
                break;
            default: // if the rank is 2-10
                rankString = String.valueOf(rank);
                break;
        }

        // return the concatenation of the two strings with "of"
        return rankString + " of " + suitString;
    }

    /**
        tests if two cards are equal and returns true or false
        @param that Card object to be compared to
        @return Boolean of whether the two cards are equal
    */
    public boolean equals(Card that) {
        return (this.suit == that.suit && this.rank == that.rank);
    }

    /**
        compares to cards by their rank
        @param card1 First Card object
        @param card2 Second Card object
        @return > 0 if card1 is higher, < 0 if card2 is higher, and 0 if equal
    */
    public static int compare(Card card1, Card card2) {
        // see if they are equal
        if (card1.rank == card2.rank)
            return 0;
        // then see if one is an ace
        else if (card1.rank == ACE)
            return 1;
        else if (card2.rank == ACE)
            return -1;
        // then see which one is higher otherwise
        else if (card1.rank > card2.rank)
            return 1;
        else
            return -1;
    }

    /**
        takes an integer from 0 to 51 and returns the corresponding card
        @param n Integer value for card
        @return Correponding card
    */
    public static Card intToCard(int n) {
        return new Card((n/13) + 1,(n%13) + 1);
    }
}
