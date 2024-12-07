package petgame;

/**
 * This class functions as the driver class of the pet game.
 */
public class PetGame {
  /**
   * This method is used to start the pet game.
   *
   * @param args The arguments passed to the program.
   */
  public static void main(String[] args) {
    // Create the model
    PetModel model = new PetModelImpl();

    // Create the controller with null as the view
    PetControllerImpl controller = new PetControllerImpl(model, null);

    // Create the view and pass the controller to it
    PetView view = new PetViewImpl(controller);

    // Set the view of the controller
    controller.setView(view);

    // Start the game
    controller.startGame();
  }
}

