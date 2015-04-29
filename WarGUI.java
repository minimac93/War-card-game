import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WarGUI extends JFrame {

    private War war;

    // turn counter
    private int turns;
    // player names
    private String p1name, p2name;
    // GUI components
    private JLabel leftCard, leftCount, leftName, rightCard, rightCount, rightName, title, footer, result, p1cards, p2cards, turnCount;
    private JPanel topPanel, mainPanel, bottomPanel, leftPanel, centerPanel, rightPanel, resultPanel, turnPanel;
    private JButton action;

    /** no-arg constructor sets player names to "Player 1" and "Player 2" */
    public WarGUI() {
        this("Player 1","Player 2");
    }

    /**
        constructor that takes player names
        @param name1 Name of first player
        @param name2 Name of second player
    */
    public WarGUI(String name1, String name2) {
        // set names to inputted ones
        p1name = name1;
        p2name = name2;

        // set turns to 0
        turns = 0;

        // create War game object
        war = new War();

        // set layout of main frame to BorderLayout, and title of frame to War
        setLayout(new BorderLayout());
        setTitle("War");

        // TOP PANEL COMPONENTS
        topPanel = new JPanel(new GridLayout(1,3));
        topPanel.setBackground(Color.DARK_GRAY);

        // set left name to uppercase, centered, bold, 40 point, and white
        leftName = new JLabel(p1name.toUpperCase(),SwingConstants.CENTER);
        leftName.setFont(new Font("Helvetica",Font.BOLD,40));
        leftName.setForeground(Color.WHITE);

        // set title to uppercase, centered, bold, 40 point, and white
        title = new JLabel("WAR",SwingConstants.CENTER);
        title.setFont(new Font("Helvetica",Font.BOLD,40));
        title.setForeground(Color.WHITE);

        // set right name to uppercase, centered, bold, 40 point, and white
        rightName = new JLabel(p2name.toUpperCase(),SwingConstants.CENTER);
        rightName.setFont(new Font("Helvetica",Font.BOLD,40));
        rightName.setForeground(Color.WHITE);

        // add these to the top panel
        topPanel.add(leftName);
        topPanel.add(title);
        topPanel.add(rightName);

        // MAIN PANEL COMPONENTS
        mainPanel = new JPanel(new GridLayout(1,3));

        // left panel
        leftPanel = new JPanel(new BorderLayout());

        // default card at start is the card back
        leftCard = new JLabel(new ImageIcon("Card_images/Card_back.png"), SwingConstants.CENTER);

        // card count is centered, 25 point
        leftCount = new JLabel("Cards in hand: " + war.pile1size(), SwingConstants.CENTER);
        leftCount.setFont(new Font("Helvetica",Font.PLAIN,25));

        // add the leftCard and leftCount to the leftPanel
        leftPanel.add(leftCard,BorderLayout.CENTER);
        leftPanel.add(leftCount,BorderLayout.SOUTH);

        // center panel is 5 rows, 1 column
        centerPanel = new JPanel(new GridLayout(5,1));

        // result is blank to start, centered, 40 point
        result = new JLabel();
        result.setFont(new Font("Helvetica",Font.PLAIN,40));
        result.setHorizontalAlignment(SwingConstants.CENTER);

        // draw button is 40 point and uses ButtonListener (below)
        action = new JButton("Draw");
        action.setFont(new Font("Helvetica",Font.PLAIN,40));
        action.addActionListener(new ButtonListener());

        // turn count is empty to start, centered, and 20 point
        turnCount = new JLabel();
        turnCount.setFont(new Font("Helvetica",Font.PLAIN,20));
        turnCount.setHorizontalAlignment(SwingConstants.CENTER);

        // add result to second panel, button to fourth, and counter to fifth grid spot
        centerPanel.add(new JPanel());
        centerPanel.add(result);
        centerPanel.add(new JPanel());
        centerPanel.add(action);
        centerPanel.add(turnCount);

        // right panel
        rightPanel = new JPanel(new BorderLayout());

        // default card at start is the card back
        rightCard = new JLabel(new ImageIcon("Card_images/Card_back.png"), SwingConstants.CENTER);

        // card count is centered, 25 point
        rightCount = new JLabel("Cards in hand: " + war.pile2size(), SwingConstants.CENTER);
        rightCount.setFont(new Font("Helvetica",Font.PLAIN,25));

        // add rightCard and rightCount to rightPanel
        rightPanel.add(rightCard,BorderLayout.CENTER);
        rightPanel.add(rightCount,BorderLayout.SOUTH);

        // add to main panel
        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);

        // BOTTOM PANEL COMPONENTS
        bottomPanel = new JPanel();

        // footer material
        footer = new JLabel("War v1.0, created by Liam Kelley");
        footer.setForeground(Color.DARK_GRAY);
        bottomPanel.add(footer);

        // add the three panels to the frame
        add(topPanel,BorderLayout.NORTH);
        add(mainPanel,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);
    }

    /** action class for the draw button */
    private class ButtonListener implements ActionListener {
        /**
            response method for button press
            @param event ActionEvent produced by the button
        */
        public void actionPerformed(ActionEvent event) {
            // if not finished, draw a card from the deck, set the new cards, and update counter
            if (!war.finished()) {
                war.draw();
                leftCard.setIcon(war.getCard1().getImage());
                rightCard.setIcon(war.getCard2().getImage());
                turnCount.setText("Turn count: " + ++turns);
            }

            // update the piles and pile counts
            war.updatePiles();
            leftCount.setText("Cards in hand: " + war.pile1size());
            rightCount.setText("Cards in hand: " + war.pile2size());

            // if now finished, display GAME OVER in bold
            if (war.finished()) {
                result.setText("GAME OVER");
                result.setFont(new Font("Helvetica",Font.BOLD,40));
            }
            // else say it is a tie, player 1 wins, or player 2 wins
            else if (war.roundWinner() == 0)
                result.setText("Tie!");
            else if (war.roundWinner() == 1)
                result.setText(p1name + " wins!");
            else
                result.setText(p2name + " wins!");
        }
    }

    /**
        driver method
        @param args Command line arguments (ignored)
    */
    public static void main(String [] args) {
        // create insteance of the gui
        WarGUI gui = new WarGUI();
        // exit program upon window close
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack() makes default size
        gui.pack();
        // layout all subcomponents
        gui.validate();
        // set to visible
        gui.setVisible(true);
    }
}
