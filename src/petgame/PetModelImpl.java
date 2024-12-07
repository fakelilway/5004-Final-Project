package petgame;

/**
 * This class is a concrete implementation of the PetModel interface.
 * It models the pet and its behavior.
 * It also keeps track of the pet's stats and health.
 * It also keeps track of the pet's survival time.
 * It also keeps track of the pet's behavior setting.
 * It also keeps track of the pet's life status.
 * It also keeps track of the pet's awake status.
 */

public class PetModelImpl implements PetModel {
  private int hunger;
  private int hygiene;
  private int social;
  private int sleep;
  private boolean awake = true;
  private boolean alive = true;
  private final Health health;
  private BehaviourSetting behaviour;
  private final SurvivalTime survivalTime;

  /**
   * This constructor is used to initialize the pet model.
   */
  public PetModelImpl() {
    this.hunger = 0;
    this.hygiene = 100;
    this.social = 100;
    this.sleep = 100;
    this.health = new Health(100);
    this.behaviour = new HappySetting();
    this.survivalTime = new SurvivalTime();
    this.survivalTime.start(); // Start the time tracking
  }

  @Override
  public void feed() {
    if (!alive) {
      return;
    }
    if (!awake) {
      return;
    }
    hunger = 0;
  }

  @Override
  public void goShower() {
    if (!alive) {
      return;
    }
    if (!awake) {
      return;
    }
    hygiene = 100;
  }

  @Override
  public void socialize() {
    if (!alive) {
      return;
    }
    if (!awake) {
      return;
    }
    social = 100;
  }

  @Override
  public void goSleep() {
    if (!alive) {
      return;
    }
    if (!awake) {
      return;
    }
    awake = false;
    sleep = 100;
    new java.util.Timer().schedule(new java.util.TimerTask() {
      @Override
      public void run() {
        awake = true;
      }
    }, 3000); // Sleep lasts for 3 seconds
  }

  @Override
  public int getHungerStats() {
    return hunger;
  }

  @Override
  public int getHygieneStats() {
    return hygiene;
  }

  @Override
  public int getSocialStats() {
    return social;
  }

  @Override
  public int getSleepStats() {
    return sleep;
  }

  @Override
  public int getHealthStats() {
    return health.getValue();
  }

  @Override
  public boolean getLifeStatus() {
    return alive;
  }

  @Override
  public boolean getAwakeStatus() {
    if (!alive) {
      awake = false;
    }
    return awake;
  }

  @Override
  public BehaviourSetting getBehaviourSetting() {
    return behaviour;
  }

  @Override
  public int getSurvivalTime() {
    int elapsedTime = survivalTime.getElapsedTime();
    int adjustedTime = elapsedTime;
    int expectedSurvivalTimeAtStart = 0;

    if (elapsedTime - expectedSurvivalTimeAtStart >= 2) {
      adjustedTime -= 2;
    } else if (elapsedTime - expectedSurvivalTimeAtStart == 1) {
      adjustedTime -= 1;
    }
    return adjustedTime;
  }


  @Override
  public void statsChangeOverTime() {
    // If the pet is dead, do nothing
    if (!alive) {
      return;
    }

    // Update stats with natural decay
    hunger = Math.min(100, hunger + 1);
    hygiene = Math.max(0, hygiene - 1);
    social = Math.max(0, social - 1);
    sleep = Math.max(0, sleep - 1);

    // Apply behavior-specific actions
    behaviour.changeSetting(this);

    // Adjust health dynamically
    adjustHealth();
  }

  @Override
  public boolean isGameOver() {
    return !alive; // The game is over if the pet is no longer alive
  }

  /**
   * This method is used to display the current stats of the pet.
   */
  @Override
  public String toString() {
    return "PetModelImpl{"
        + "hunger=" + hunger + ",\n"
        + "hygiene=" + hygiene + ",\n"
        + "social=" + social + ",\n"
        + "sleep=" + sleep + ",\n"
        + "awake=" + awake + ",\n"
        + "alive=" + alive + ",\n"
        + "health=" + health + ",\n"
        + "behaviour=" + behaviour + ",\n"
        + "survivalTime=" + survivalTime
        + '}';
  }

  /**
   * This method represents the change of health based on how other stats changed over time.
   */
  private void adjustHealth() {
    if (!alive) { // If the pet is dead, do nothing
      return;
    }

    int penalties = 0;

    // Check unmet conditions to calculate penalties
    if (hunger > 50) {
      penalties++;
    }
    if (hygiene < 50) {
      penalties++;
    }
    if (social < 50) {
      penalties++;
    }
    if (sleep < 50) {
      penalties++;
    }

    // Apply immunity recovery first
    health.increaseByImmunity();

    // Then apply penalties to decrease health
    health.decrease(penalties);

    // Check if the pet is alive
    if (!health.isAlive()) {
      alive = false;
      survivalTime.stop();
    } else {
      // Dynamically update behavior based on health
      behaviour = health.evaluateSetting();
    }
  }
}


