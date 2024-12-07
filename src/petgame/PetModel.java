package petgame;

/**
 * This interface is used to model the pet.
 */
public interface PetModel {
  /**
   * This method is used to feed the pet.
   */
  void feed();

  /**
   * This method is used to shower the pet.
   */
  void goShower();

  /**
   * This method is used to socialize the pet.
   */
  void socialize();

  /**
   * This method is used to make the pet go to sleep.
   */
  void goSleep();

  /**
   * This method is used to get the hunger stats of the pet.
   *
   * @return The hunger stats of the pet.
   */
  int getHungerStats();

  /**
   * This method is used to get the hygiene stats of the pet.
   *
   * @return The hygiene stats of the pet.
   */
  int getHygieneStats();

  /**
   * This method is used to get the social stats of the pet.
   *
   * @return The social stats of the pet.
   */
  int getSocialStats();

  /**
   * This method is used to get the sleep stats of the pet.
   *
   * @return The sleep stats of the pet.
   */
  int getSleepStats();

  /**
   * This method is used to get the health stats of the pet.
   *
   * @return The health stats of the pet.
   */
  int getHealthStats();

  /**
   * This method is used to get the life status of the pet.
   *
   * @return The life status of the pet.
   */
  boolean getLifeStatus();

  /**
   * This method is used to get the awake status of the pet.
   *
   * @return The awake status of the pet.
   */
  boolean getAwakeStatus();

  /**
   * This method is used to get the behaviour setting of the pet.
   *
   * @return The behaviour setting of the pet.
   */
  BehaviourSetting getBehaviourSetting();

  /**
   * This method is used to get the survival time of the pet.
   *
   * @return The survival time of the pet.
   */
  int getSurvivalTime();

  /**
   * This method is the natural decay mechanism of the stats of the pet over time.
   */
  void statsChangeOverTime();

  /**
   * This method is used to check if the game is over.
   *
   * @return True if the game is over, false otherwise.
   */
  boolean isGameOver();
}


