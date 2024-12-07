package petgame;

/**
 * This class is used to model the sad setting of the pet.
 */
public class SadSetting implements BehaviourSetting {
  @Override
  public void changeSetting(PetModel model) {
    model.goSleep(); // Automatically make the pet go to sleep
  }

  /**
   * This method is used to return the string representation of the sad setting.
   *
   * @return The string representation of the sad setting.
   */
  @Override
  public String toString() {
    return "Sad Setting";
  }
}

