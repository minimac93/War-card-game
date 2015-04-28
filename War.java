import java.util.Arrays;
import java.util.Collections;

/** runs the actual war game, keeping track of players and cards */
public class War {

    public static int DECK_SIZE = 52, SUIT_SIZE = 13, SUITS = 4;

    private CardImagePile pile1, pile2, p1plays, p2plays;
    private CardImage card1, card2;

    /** no-arg constructor disperses the cards */
    public War() {
        // create the piles for the
        pile1 = new CardImagePile();
        pile2 = new CardImagePile();
        // create the piles for the in play cards
        p1plays = new CardImagePile();
        p2plays = new CardImagePile();
        // create array going from 0 to DECK_SIZE - 1
        Integer[] numbers = new Integer[DECK_SIZE];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i;
        // shuffle the numbers array
        Collections.shuffle(Arrays.asList(numbers));

        // add the every other card to pile1 or pile2
        for (int n = 0; n < numbers.length; n += 2)
            pile1.add(new CardImage(Card.intToCard(numbers[n])));
        for (int n = 1; n < numbers.length; n += 2)
            pile2.add(new CardImage(Card.intToCard(numbers[n])));
    }

    /**
        determines and returns round winner
        @return 0 for tie, 1 for player 1 win, 2 for player 2 win
    */
    public int roundWinner() {
        if (Card.compare(card1,card2) == 0)
            return 0;
        else if (Card.compare(card1,card2) > 0)
            return 1;
        else
            return 2;
    }

    /**
        getter for CardImage of current player 1 card
        @return CardImage of current player 1 card
    */
    public CardImage getCard1() {
        return card1;
    }

    /**
        getter for CardImage of current player 2 card
        @return CardImage of current player 2 card
    */
    public CardImage getCard2() {
        return card2;
    }

    /**
        determines whether the game is finished or if more turns are available
        @return true if no turns remain, false if turns are possible
    */
    public boolean finished() {
        if (card1 != null && card2 != null)
            updatePiles();
        return (pile1.size() == 0 || pile2.size() == 0);
    }

    /**
        getter for size of player 1's pile
        @return size of player 1's pile
    */
    public int pile1size() {
        return pile1.size();
    }

    /**
        getter for size of player 2's pile
        @return size of player 2's pile
    */
    public int pile2size() {
        return pile2.size();
    }

    /**
        determines the number of cards "in play" (especially in case of tie)
        @return number of cards in play
    */
    public int cardsInPlay() {
        return p1plays.size() + p2plays.size();
    }

    /** draws new cards for each player */
    public void draw() {
        // update the piles before drawing
        if (card1 != null && card2 != null)
            updatePiles();
        // if neither deck is empty, draw a card from each and update card1 and card2
        if (pile1.size() != 0 && pile2.size() != 0) {
            card1 = pile1.draw();
            p1plays.add(card1);
            card2 = pile2.draw();
            p2plays.add(card2);
        }
    }

    /** updates each player's piles based on the most recent round */
    public void updatePiles() {
        // player 1 gets the current card "buffer" if they win or player 2 runs out on a tie
        if (roundWinner() == 1 || (roundWinner() == 0 && pile2.size() == 0)) {
            // add their own plays first
            while (p1plays.size() > 0)
                pile1.add(p1plays.draw());
            while (p2plays.size() > 0)
                pile1.add(p2plays.draw());
        }
        // player 2 gets the current card "buffer" if they win or player 1 runs out on a tie
        else if (roundWinner() == 2 || (roundWinner() == 0 && pile1.size() == 0)) {
            // add their own plays first
            while (p2plays.size() > 0)
                pile2.add(p2plays.draw());
            while (p1plays.size() > 0)
                pile2.add(p1plays.draw());
        }
    }
}
