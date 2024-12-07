package petgame;

/**
 * This class is used to model the happy setting of the pet.
 */
public class HappySetting implements BehaviourSetting {
  @Override
  public void changeSetting(PetModel model) {
    model.socialize(); // Automatically make the pet socialize
  }

  /**
   * This method is used to return the string representation of the happy setting.
   *
   * @return The string representation of the happy setting.
   */
  @Override
  public String toString() {
    return "Happy Setting";
  }
}

