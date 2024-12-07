package petgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the PetModelImpl class.
 */
public class PetModelImplTest {
  private PetModelImpl model;

  @Before
  public void setUp() {
    model = new PetModelImpl();
  }

  @Test
  public void testFeed() {
    model.statsChangeOverTime();
    model.feed();
    assertEquals(0, model.getHungerStats());
  }

  @Test
  public void testFeedSleepingPet() {
    model.statsChangeOverTime();
    model.goSleep();
    model.feed();
    assertEquals(1, model.getHungerStats());
  }

  @Test
  public void testGoShower() {
    model.statsChangeOverTime();
    model.goShower();
    assertEquals(100, model.getHygieneStats());
  }

  @Test
  public void testGoShowerSleepingPet() {
    model.statsChangeOverTime();
    model.goSleep();
    model.goShower();
    assertEquals(99, model.getHygieneStats());
  }

  @Test
  public void testSocialize() {
    for (int i = 0; i < 60; i++) {
      model.statsChangeOverTime();
    }
    model.socialize();
    assertEquals(100, model.getSocialStats());
  }

  @Test
  public void testSocializeSleepingPet() {
    model.statsChangeOverTime();
    model.goSleep();
    model.socialize();
    assertEquals(100, model.getSocialStats());
  }

  @Test
  public void testGoSleep() throws InterruptedException {
    model.statsChangeOverTime();
    model.goSleep();
    assertFalse(model.getAwakeStatus());
    assertEquals(100, model.getSleepStats());
    Thread.sleep(4000);
    assertTrue(model.getAwakeStatus());
  }

  @Test
  public void testGetHungerStats() {
    assertEquals(0, model.getHungerStats());
  }

  @Test
  public void testGetHygieneStats() {
    assertEquals(100, model.getHygieneStats());
  }

  @Test
  public void testGetSocialStats() {
    assertEquals(100, model.getSocialStats());
  }

  @Test
  public void testGetSleepStats() {
    assertEquals(100, model.getSleepStats());
  }

  @Test
  public void testGetHealthStats() {
    assertEquals(100, model.getHealthStats());
  }

  @Test
  public void testGetLifeStatusAlive() {
    assertTrue(model.getLifeStatus());
  }

  @Test
  public void testGetLifeStatusDead() {
    while (!model.isGameOver()) {
      model.statsChangeOverTime();
    }
    assertEquals(0, model.getHealthStats());
    assertFalse(model.getLifeStatus());
  }

  @Test
  public void testGetAwakeStatusDefault() {
    assertTrue(model.getAwakeStatus());
  }

  @Test
  public void testGetAwakeStatusSleeping() {
    model.goSleep();
    assertFalse(model.getAwakeStatus());
  }

  @Test
  public void testGetBehaviourSettingHappy() {
    assertEquals("Happy Setting", model.getBehaviourSetting().toString());
  }

  @Test
  public void testGetSurvivalTime() {
    assertEquals(1, model.getSurvivalTime()); // Timer automatically starts at 1
  }

  @Test
  public void testGetSurvivalTimeStraightToDeath() throws InterruptedException {
    while (!model.isGameOver()) {
      model.statsChangeOverTime();
      Thread.sleep(1000); // Wait 1 second between steps for speedy demonstration
    }
    assertEquals(124, model.getSurvivalTime());
  }

  @Test
  public void testStatsChangeOverTime() {
    model.statsChangeOverTime();
    assertEquals(1, model.getHungerStats());
    assertEquals(99, model.getHygieneStats());
    assertEquals(100, model.getSocialStats());
    assertEquals(99, model.getSleepStats());
  }

  @Test
  public void testStatsChangeOverTimeManyTimesIntoSadSetting() {
    assertEquals("Happy Setting", model.getBehaviourSetting().toString());
    for (int i = 0; i < 100; i++) {
      model.statsChangeOverTime();
    }
    assertEquals("Sad Setting", model.getBehaviourSetting().toString());
  }

  @Test
  public void testStatsChangeOverTimeManyTimesIntoDead() {
    while (!model.isGameOver()) {
      model.statsChangeOverTime();
    }
    assertFalse(model.getLifeStatus());
  }

  @Test
  public void testStatsChangeOverTimeManyTimesSoWeCanSeeSocialStatsChange() {
    for (int i = 0; i < 100; i++) {
      model.statsChangeOverTime();
    }
    assertEquals(75, model.getSocialStats());
  }

  @Test
  public void testHealthStatsWentBadWhenNotCaredTooLong() {
    assertEquals(100, model.getHealthStats());
    for (int i = 0; i < 100; i++) {
      model.statsChangeOverTime();
    }
    assertEquals(24, model.getHealthStats());
  }

  @Test
  public void testProperCareImprovesSettingAndHealth() {

    // Simulate stats decay to worsen the pet's health
    for (int i = 0; i < 75; i++) { // 75 seconds of decay
      model.statsChangeOverTime();
    }

    // Assert that health has dropped and mood is not happy
    assertEquals(49, model.getHealthStats());
    assertEquals("Sad Setting", model.getBehaviourSetting().toString());

    // Care for the pet
    model.feed();
    model.goShower();
    model.socialize();
    model.goSleep();
    model.statsChangeOverTime();
    model.statsChangeOverTime();

    // Assert that health has improved and mood is happy
    assertEquals(51, model.getHealthStats());
    assertEquals("Happy Setting", model.getBehaviourSetting().toString());
  }

  @Test
  public void testHowSettingsAffectStats() {
    // Display the stats at the start
    assertEquals(0, model.getHungerStats());
    assertEquals(100, model.getSleepStats());
    assertEquals(100, model.getHygieneStats());
    assertEquals(100, model.getSocialStats());

    // It's happy setting at the start
    assertEquals("Happy Setting", model.getBehaviourSetting().toString());

    // Stats change over time
    model.statsChangeOverTime();
    model.statsChangeOverTime();
    model.statsChangeOverTime();

    // After change, only social stats unchanged since happy setting auto socialize
    assertEquals(3, model.getHungerStats());
    assertEquals(97, model.getSleepStats());
    assertEquals(97, model.getHygieneStats());
    assertEquals(100, model.getSocialStats());

    // Now decay more in a loop to make it Sad Setting
    for (int i = 0; i < 73; i++) { // 75 seconds of decay
      model.statsChangeOverTime();
    }
    assertEquals("Sad Setting", model.getBehaviourSetting().toString());

    // After the loop, only sleep stats were set to 100 since sad setting auto goes to sleep
    assertEquals(76, model.getHungerStats());
    assertEquals(100, model.getSleepStats());
    assertEquals(24, model.getHygieneStats());
    assertEquals(99, model.getSocialStats());
  }

  @Test
  public void testIsGameOverAtTheStart() {
    assertFalse(model.isGameOver());
  }

  @Test
  public void testIsGameOverAtTheEnd() {
    while (!model.isGameOver()) {
      model.statsChangeOverTime();
    }
    assertTrue(model.isGameOver());
  }

  @Test
  public void testToString() {
    assertEquals("PetModelImpl{"
        + "hunger=0,\n"
        + "hygiene=100,\n"
        + "social=100,\n"
        + "sleep=100,\n"
        + "awake=true,\n"
        + "alive=true,\n"
        + "health=Health: 100,\n"
        + "behaviour=Happy Setting,\n"
        + "survivalTime=Survival Time: 1 seconds"
        + '}', model.toString());
  }
}
