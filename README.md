# Virtual Pet Game

## About/Overview
The **Virtual Pet Game** is an interactive simulation that allows users to care for a virtual pet by managing its hunger, hygiene, social, and sleep needs. These stats influence the pet's health, which determines its overall well-being. The game challenges players to keep the pet happy and healthy as long as possible, with the pet's survival time being the final score.

The game includes an intuitive GUI for player interaction, automated behaviors based on the pet's mood, and dynamic stat changes over time. It serves as both a fun simulation and a programming demonstration of concepts like object-oriented design, MVC architecture, and behavioral design patterns.

---

## List of Features
1. **Pet Stats Management**:
   - Four primary stats: Hunger, Hygiene, Social, and Sleep, each ranging from 0 to 100.
   - Health stats influenced by the primary stats.
2. **Dynamic Health**:
   - Health decreases if certain conditions are met (e.g., high hunger, low hygiene, etc.).
   - Health regenerates by immunity over time.
3. **Behavioral Settings**:
   - Happy Setting: Pet socializes automatically every 1 seconds.
   - Sad Setting: Pet sleeps automatically every 1 seconds.
4. **User Actions**:
   - Feed: Resets hunger to 0.
   - Shower: Resets hygiene to 100.
   - Socialize: Resets social to 100.
   - Sleep: Resets sleep to 100 and puts the pet to sleep for 3 seconds.
5. **Interactive GUI**:
   - Real-time display of stats, mood, and survival time.
   - Buttons for player actions (Feed, Clean, Socialize, Sleep).
6. **Survival Timer**:
   - Tracks how long the pet survives.
7. **Game Over**:
   - Displays when health reaches 0.
   - Shows the pet's survival time.
8. **Automatic Stat Decay**:
   - Stats change naturally over time.

---

## How To Run
### Running the JAR File
To play the Virtual Pet Game:
1. Ensure you have **Java 8+** installed.
2. Download the `virtualPet.jar` file.
3. Open a terminal or command prompt.
4. Run the following command:
   ```sh
   java -jar virtualPet.jar
   ```
---

## How to Use the Program
1. **Start the Game**:
   - Launch the game using the provided JAR file.
   - The GUI will open, showing the pet's stats and action buttons.
2. **Perform Actions**:
   - Use the buttons to interact with the pet:
     - `Feed`: Reduces hunger.
     - `Clean`: Increases hygiene.
     - `Socialize`: Increases social.
     - `Sleep`: Puts the pet to sleep for 3 seconds, resetting sleep stats.
3. **Monitor Stats**:
   - Observe how stats decay over time and make timely decisions to keep the pet healthy.
4. **Automatic Behaviors**:
   - When health is above 50, the pet socializes automatically every 1 second.
   - When health is below 50, the pet sleeps automatically every 1 second.
5. **End the Game**:
   - The game ends when the pet's health reaches 0.
   - A "Game Over" message will display the survival time.

---

## Design/Model Changes
### Changes from the Initial Draft
1. **Improved Health Management**:
   - Added immunity regeneration for health.
   - Health adjustments are encapsulated in a dedicated `Health` class.
2. **Dynamic Behavioral Settings**:
   - Introduced the `BehaviourSetting` interface with `HappySetting` and `SadSetting` implementations for automatic behaviors.
3. **Stat Decay Logic**:
   - Encapsulated within `PetModelImpl` to ensure consistent and predictable changes.
   - Time interval designed for stats change over time change from 10 secs to 1 sec.
   - Added `SurvivalTime` class for robust time tracking.
   - Integrated survival time into the GUI.
5. **GUI Enhancements**:
   - Added labels and buttons for real-time interaction.
   - Improved layout using Swing's BorderLayout and GridLayout.

---

## Assumptions
1. Players will manually care for the pet while monitoring its stats.
2. Health decreases at a fixed rate based on unmet conditions.
3. Automated behaviors (socializing and sleeping) occur precisely every 1 second based on the pet's mood.
4. Sleep action renders the pet inactive for 3 seconds.
5. Players cannot interact with the pet while it is asleep.

---

## Limitations
1. **Single Pet Model**:
   - The game currently supports only one pet.
2. **Basic GUI**:
   - While functional, the GUI is not highly stylized or visually engaging.
3. **Fixed Decay Rates**:
   - The decay rates for stats are fixed and cannot be customized.
4. **Survival Time Tracker Inaccuracy**:
   - The survival time at the start sometimes may be off by 1 second, earlier or late than expected.

---
## Future Improvements
1. **Enhanced GUI**:
   - Add more visual elements to represent the pet's mood and status.
2. **Multiple Pets**:
   - Allow players to care for multiple pets simultaneously.
3. **Difficulty Levels**:
   - Introduce adjustable stat decay rates for different difficulty settings.
4. **Event System**:
   - Add random events that influence the pet's stats.
5. **Handle Survival Time Inaccuracy**
   - Use better measures or restructure design to handle the problem.

---
## Citations
OpenAI. (2024). ChatGPT o1 [Large language model]. Retrieved on December 2, 2024, for problem-solving assistance from https://www.chatgpt.com/
