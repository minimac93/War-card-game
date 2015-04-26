import java.util.ArrayList;

/** queue front-end specifically for Card objects */
public class CardPile {
    private Queue cards;

    /** no-arg constructor */
    public CardPile() {
        cards = new Queue();
    }

    /**
        copy constructor takes CardPile as input
        @param other CardPile to be copied
    */
    public CardPile(CardPile other) {
        cards = new Queue(other.cards);
    }

    /**
        constructor that takes a Queue as input
        @param queue Queue to be converted to CardPile
    */
    public CardPile(Queue queue) {
        cards = new Queue(queue); // uses copy constructor of Queue class
    }

    /**
        constructor that takes a Card array as input
        @param array Card [] array to be converted to CardPile
    */
    public CardPile(Card [] array) {
        // initialize Queue
        cards = new Queue();
        // add each item in the array to the queue
        for (Card card : array)
            cards.enqueue(card);
    }

    /**
        constructor that takes a Card array as input
        @param array int [] array containing numbers representing cards
    */
    public CardPile(int [] array) {
        cards = new Queue();
        for (int n : array)
            cards.enqueue(Card.intToCard(n));
    }

    /**
        constructor that takes a Card ArrayList as input
        @param list ArrayList of Card objects to be converted to CardPile
    */
    public CardPile(ArrayList<Card> list) {
        this(list.toArray(new Card[list.size()])); // calls the array constructor
    }

    /**
        returns the top card (removing it)
        @return Top card from the deck
    */
    public Card draw() {
        return (Card) cards.dequeue();
    }

    /**
        returns the top card without removing it
        @return Top card from the deck
    */
    public Card look() {
        return (Card) cards.peek();
    }

    /**
        adds a card to the bottom of the deck
        @param newCard Card to be added (to bottom)
    */
    public void add(Card newCard) {
        cards.enqueue(newCard);
    }

    /** empties the deck */
    public void reset() {
        cards.dequeueAll();
    }

    /**
        determines and returns size of the pile
        @return number of elements in the pile
    */
    public int size() {
        return cards.size();
    }

    /**
        determines whether the pile is empty
        @return whether pile is empty
    */
    public boolean isEmpty() {
        return (cards.size() == 0);
    }

}
