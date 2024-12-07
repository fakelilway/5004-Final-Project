package petgame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class create the GUI visualization of the pet game application.
 */
public class PetViewImpl extends JFrame implements PetView {
  private final JLabel healthLabel;
  private final JLabel hungerLabel;
  private final JLabel hygieneLabel;
  private final JLabel socialLabel;
  private final JLabel sleepLabel;
  private final JLabel behaviorLabel;
  private final JLabel survivalTimeLabel;

  /**
   * This constructor is used to create the GUI visualization of the pet game application.
   *
   * @param controller The controller of the pet game.
   */
  public PetViewImpl(PetController controller) {
    setTitle("Virtual Pet Game");
    setSize(500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Use a border layout for better organization
    setLayout(new BorderLayout());

    // Stats Panel
    JPanel statsPanel = new JPanel();
    // 8 rows, 2 columns, spacing of 5px
    statsPanel.setLayout(new GridLayout(8, 2, 5, 5));
    statsPanel.setBorder(BorderFactory.createTitledBorder("Pet Stats"));

    healthLabel = new JLabel();
    hungerLabel = new JLabel();
    hygieneLabel = new JLabel();
    socialLabel = new JLabel();
    sleepLabel = new JLabel();
    behaviorLabel = new JLabel();
    survivalTimeLabel = new JLabel();

    statsPanel.add(new JLabel("Health:"));
    statsPanel.add(healthLabel);
    statsPanel.add(new JLabel("Hunger:"));
    statsPanel.add(hungerLabel);
    statsPanel.add(new JLabel("Hygiene:"));
    statsPanel.add(hygieneLabel);
    statsPanel.add(new JLabel("Social:"));
    statsPanel.add(socialLabel);
    statsPanel.add(new JLabel("Sleep:"));
    statsPanel.add(sleepLabel);
    statsPanel.add(new JLabel("Behavior:"));
    statsPanel.add(behaviorLabel);
    statsPanel.add(new JLabel("Survival Time:"));
    statsPanel.add(survivalTimeLabel);

    // Action Buttons Panel
    JPanel buttonPanel = new JPanel();
    // 2 rows, 2 columns, spacing of 10px
    buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
    buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

    JButton feedButton = new JButton("Feed");
    JButton cleanButton = new JButton("Clean");
    JButton socializeButton = new JButton("Socialize");
    JButton sleepButton = new JButton("Sleep");

    buttonPanel.add(feedButton);
    buttonPanel.add(cleanButton);
    buttonPanel.add(socializeButton);
    buttonPanel.add(sleepButton);

    // Add Action Listeners
    feedButton.addActionListener(event -> controller.feedPet());
    cleanButton.addActionListener(event -> controller.cleanPet());
    socializeButton.addActionListener(event -> controller.socializePet());
    sleepButton.addActionListener(event -> controller.makePetSleep());

    // Add Panels to Frame
    add(statsPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // Set the frame to be visible
    setVisible(true);
  }

  @Override
  public void displayPetStats(
      int health,
      int hunger,
      int hygiene,
      int social,
      int sleep,
      String behavior,
      int time
  ) {
    healthLabel.setText(String.valueOf(health));
    hungerLabel.setText(String.valueOf(hunger));
    hygieneLabel.setText(String.valueOf(hygiene));
    socialLabel.setText(String.valueOf(social));
    sleepLabel.setText(String.valueOf(sleep));
    behaviorLabel.setText(behavior);
    survivalTimeLabel.setText(time + " seconds");
  }

  @Override
  public void displayGameOver(int survivalTime) {
    JOptionPane.showMessageDialog(this, "Game Over!"
        + "Your pet survived for " + survivalTime + " seconds.");
  }

  @Override
  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }
}



