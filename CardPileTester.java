import java.util.Random;

public class CardPileTester {
    public static void main(String [] args) {
        Random rand = new Random();

        Card [] array = new Card[26];
        for (int n = 0; n < 26; n++) {
            Card add = new Card((rand.nextInt(4) + 1),(rand.nextInt(13) + 1));
            array[n] = add;
            System.out.println(add);
        }

        // for (Card card : array)
        //     System.out.println(card);

        CardPile cards = new CardPile(array);
        System.out.println("Deck size: " + cards.getSize());
        while (!cards.isEmpty())
            System.out.println(cards.draw());
    }
}
