package petgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the Health class.
 */
public class HealthTest {
  private Health health;

  @Before
  public void setUp() {
    health = new Health(50); // Initialize with a mid-range value
  }

  @Test
  public void testConstructorWithinRange() {
    Health health = new Health(50);
    assertEquals(50, health.getValue());
  }

  @Test
  public void testConstructorBelowMinValue() {
    Health health = new Health(-10);
    assertEquals(0, health.getValue());
  }

  @Test
  public void testConstructorAboveMaxValue() {
    Health health = new Health(150);
    assertEquals(100, health.getValue());
  }

  @Test
  public void testDecreaseWithinRange() {
    health.decrease(10);
    assertEquals(40, health.getValue());
  }

  @Test
  public void testDecreaseBelowMinValue() {
    health.decrease(60);
    assertEquals(0, health.getValue());
  }

  @Test
  public void testIncreaseByImmunityWithinRange() {
    health.increaseByImmunity();
    assertEquals(51, health.getValue());
  }

  @Test
  public void testIncreaseByImmunityAboveMaxValue() {
    Health maxHealth = new Health(100);
    maxHealth.increaseByImmunity();
    assertEquals(100, maxHealth.getValue());
  }

  @Test
  public void testIsAliveTrue() {
    assertTrue(health.isAlive());
  }

  @Test
  public void testIsAliveFalse() {
    health.decrease(50);
    assertFalse(health.isAlive());
  }

  @Test
  public void testEvaluateSettingHappy() {
    BehaviourSetting setting = health.evaluateSetting();
    assertTrue(setting instanceof HappySetting);
  }

  @Test
  public void testEvaluateSettingSad() {
    health.decrease(30);
    BehaviourSetting setting = health.evaluateSetting();
    assertTrue(setting instanceof SadSetting);
  }

  @Test
  public void testGetValue() {
    assertEquals(50, health.getValue());
  }

  @Test
  public void testReset() {
    health.decrease(30);
    health.reset();
    assertEquals(100, health.getValue());
  }

  @Test
  public void testToString() {
    assertEquals("Health: 50", health.toString());
  }
}
