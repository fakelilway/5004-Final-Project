package petgame;

/**
 * This class is used to model the health of the pet.
 */
public class Health {
  private int value;
  private final int maxValue = 100;
  private final int minValue = 0;

  /**
   * This constructor is used to initialize the health of the pet.
   *
   * @param initialValue The initial value of the health.
   */
  public Health(int initialValue) {
    this.value = Math.min(maxValue, Math.max(minValue, initialValue));
  }

  /**
   * This method is used to decrease the health of the pet by a certain amount.
   *
   * @param amount The amount by which the health should be decreased.
   */
  public void decrease(int amount) {
    value = Math.max(minValue, value - amount);
  }

  /**
   * This method is used to increase the health of the pet by immunity.
   */
  public void increaseByImmunity() {
    value = Math.min(maxValue, value + 1);
  }

  /**
   * This method is used to check if the pet is alive.
   *
   * @return True if the pet is alive, false otherwise.
   */
  public boolean isAlive() {
    return value > 0;
  }

  /**
   * This method is used to evaluate the setting of the pet based on the health status.
   *
   * @return The setting of the pet.
   */
  public BehaviourSetting evaluateSetting() {
    return value >= 50 ? new HappySetting() : new SadSetting();
  }

  /**
   * This method is used to get the value of the health.
   *
   * @return The value of the health.
   */
  public int getValue() {
    return value;
  }

  /**
   * This method is used to reset the health of the pet.
   */
  public void reset() {
    value = 100;
  }

  /**
   * This method is used to return the string representation of the health.
   *
   * @return The string representation of the health.
   */
  @Override
  public String toString() {
    return "Health: " + value;
  }
}

