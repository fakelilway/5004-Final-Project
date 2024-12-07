package petgame;

/**
 * This interface is used to change the setting of the pet based on the health stats.
 */
public interface BehaviourSetting {
  /**
   * This method is used to change the setting of the pet based on the health status.
   * Also, it will change the behaviour of the pet accordingly.
   *
   * @param model The model of the pet.
   */
  void changeSetting(PetModel model);
}

