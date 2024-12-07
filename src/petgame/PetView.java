package petgame;

/**
 * This interface functions as the view of the pet game application.
 */
public interface PetView {
  /**
   * This method is used to display the pet stats.
   *
   * @param health    The health of the pet.
   * @param hunger    The hunger of the pet.
   * @param hygiene   The hygiene of the pet.
   * @param social    The social of the pet.
   * @param sleep     The sleep of the pet.
   * @param behavior  The behavior of the pet.
   * @param time      The survival time of the pet.
   */
  void displayPetStats(
      int health,
      int hunger,
      int hygiene,
      int social,
      int sleep,
      String behavior,
      int time
  );

  /**
   * This method is used to display the game over message.
   *
   * @param survivalTime The survival time of the pet.
   */
  void displayGameOver(int survivalTime);

  /**
   * This method is used to display a message based on scenarios.
   *
   * @param message The message to be displayed.
   */
  void displayMessage(String message);
}


