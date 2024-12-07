package petgame;

/**
 * This class is used to control the pet game application.
 */
public class PetControllerImpl implements PetController {
  private final PetModel model;
  private PetView view;

  /**
   * This constructor is used to create a new controller with the given model and view.
   *
   * @param model The model of the pet.
   * @param view  The view of the pet.
   */
  public PetControllerImpl(PetModel model, PetView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * This method is used to set the view of the controller.
   *
   * @param view The view of the controller.
   */
  public void setView(PetView view) {
    this.view = view;
  }

  @Override
  public void startGame() {
    updateView();
    startStatDecay();
  }

  @Override
  public void feedPet() {
    if (!model.getLifeStatus()) {
      view.displayMessage("The pet is dead and cannot be fed.");
      return;
    }
    if (!model.getAwakeStatus()) {
      view.displayMessage("The pet is asleep and cannot be fed.");
      return;
    }
    model.feed();
    updateView();
  }

  @Override
  public void cleanPet() {
    if (!model.getLifeStatus()) {
      view.displayMessage("The pet is dead and cannot be cleaned.");
      return;
    }
    if (!model.getAwakeStatus()) {
      view.displayMessage("The pet is asleep and cannot be cleaned.");
      return;
    }
    model.goShower();
    updateView();
  }

  @Override
  public void socializePet() {
    if (!model.getLifeStatus()) {
      view.displayMessage("The pet is dead and cannot socialize.");
      return;
    }
    if (!model.getAwakeStatus()) {
      view.displayMessage("The pet is asleep and cannot socialize.");
      return;
    }
    model.socialize();
    updateView();
  }

  @Override
  public void makePetSleep() {
    if (!model.getLifeStatus()) {
      view.displayMessage("The pet is dead and cannot sleep.");
      return;
    }
    if (!model.getAwakeStatus()) {
      view.displayMessage("The pet is already asleep.");
      return;
    }
    model.goSleep();
    updateView();
  }

  @Override
  public void updateView() {
    if (view != null) {
      view.displayPetStats(
          model.getHealthStats(),
          model.getHungerStats(),
          model.getHygieneStats(),
          model.getSocialStats(),
          model.getSleepStats(),
          model.getBehaviourSetting().toString(),
          model.getSurvivalTime()
      );
      if (model.isGameOver()) {
        view.displayGameOver(model.getSurvivalTime());
      }
    }
  }

  /**
   * This method is used to start the stat decay of the pet.
   */
  private void startStatDecay() {
    new java.util.Timer().scheduleAtFixedRate(new java.util.TimerTask() {
      @Override
      public void run() {
        if (!model.isGameOver()) {
          updateView();
          model.statsChangeOverTime();
        } else {
          cancel();
        }
      }
    }, 0, 1000); // Every 1 seconds
  }
}



