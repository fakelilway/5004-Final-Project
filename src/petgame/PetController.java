package petgame;

/**
 * This interface functions as the controller of the pet game application.
 */
public interface PetController {
  /**
   * This method is used to start the game.
   */
  void startGame();

  /**
   * This method is used to tell the model to feed the pet.
   */
  void feedPet();

  /**
   * This method is used to tell the model to clean the pet.
   */
  void cleanPet();

  /**
   * This method is used to tell the model to socialize the pet.
   */
  void socializePet();

  /**
   * This method is used to tell the model to make the pet sleep.
   */
  void makePetSleep();

  /**
   * This method is used to tell the view to update the GUI base on  model changes.
   */
  void updateView();
}
