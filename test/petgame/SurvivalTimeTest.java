package petgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the SurvivalTime class.
 */
public class SurvivalTimeTest {
  private SurvivalTime survivalTime;

  @Before
  public void setUp() {
    survivalTime = new SurvivalTime();
  }

  @After
  public void tearDown() {
    survivalTime.stop(); // Ensure the timer is stopped after each test
  }

  @Test
  public void testInitialization() {
    assertEquals(0, survivalTime.getElapsedTime());
  }

  @Test
  public void testStartAndIncrement() throws InterruptedException {
    survivalTime.start();
    Thread.sleep(1500); // Wait 1.5 seconds
    int elapsedTime = survivalTime.getElapsedTime();
    assertTrue("Elapsed time should be at least 1 second", elapsedTime >= 1);
  }

  @Test
  public void testStop() throws InterruptedException {
    survivalTime.start();
    Thread.sleep(1500); // Wait 1.5 seconds
    survivalTime.stop();
    int elapsedTimeAfterStop = survivalTime.getElapsedTime();

    Thread.sleep(1000); // Wait another second
    assertEquals("Elapsed time should not increase after stopping",
        elapsedTimeAfterStop, survivalTime.getElapsedTime());
  }

  @Test
  public void testToString() throws InterruptedException {
    survivalTime.start();
    Thread.sleep(1200); // Wait 1.2 seconds
    survivalTime.stop();
    assertTrue(survivalTime.toString().startsWith("Survival Time: "));
  }
}

