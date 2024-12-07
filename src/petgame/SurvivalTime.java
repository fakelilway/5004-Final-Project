package petgame;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is used to track the survival time of the pet.
 */
public class SurvivalTime {
  private int timeElapsed; // Survival time in seconds
  private final Timer timer;

  /**
   * This constructor is used to initialize the survival time.
   */
  public SurvivalTime() {
    this.timeElapsed = 0;
    this.timer = new Timer(true); // Run as a daemon thread
  }

  /**
   * This method is used to start tracking time.
   */
  public void start() {
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        timeElapsed++;
      }
    }, 0, 1000); // Increment every 1 second
  }

  /**
   * This method is used to stop tracking time.
   */
  public void stop() {
    timer.cancel();
  }

  /**
   * This method is used to return the elapsed time.
   *
   * @return The elapsed time.
   */
  public int getElapsedTime() {
    return timeElapsed;
  }

  /**
   * This method is used to reset the survival time.
   */
  public void reset() {
    stop();
    timeElapsed = 0;
  }

  /**
   * This method is used to return the string representation of the survival time.
   *
   * @return The string representation of the survival time.
   */
  @Override
  public String toString() {
    return "Survival Time: " + timeElapsed + " seconds";
  }
}

