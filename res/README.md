# CS 5010 Semester Project

This repo represents the coursework for CS 5010, the Fall 2022 Edition!

**Name:** Siddharth Lalit Chakravorty ; Prajwal Vijaykumar Chinchmalatpure

**Email:** chakravorty.s@northeastern.edu ; chinchmalatpure.p@northeastern.edu

**Preferred Name:** Siddharth Lalit Chakravorty ; Prajwal Vijaykumar Chinchmalatpure


### About/Overview

Give a general overview of the problem and how your program solves the problem.

-> Problem Statement: Implement a board game supporting all the features as per the requirements using MVC design pattern. 


For the first milestone, the expectation is to build the model part of the MVC architecture based on mentioned requirements. The World should consist of non-overlapping spaces ( constraint is that student should create more than 20 spaces) and items( students should create atleast 20 items in their version of the world) which can have attributes such as damage and the room they are present in so as to inflict damage on the target character. Neighbors of a room can see each other. There should also be functionality developed to get to know the neighbors of a room, get the list of items present in the room, the target character can move 1 space in 1 move as per the indeices of the rooms declared in the room list.
We are supposed to retrieve all the World information from a text file thorugh command line arguements and instantiate a world in memory.


For the second milestone, the expectation is to add more functinalities to the model and build a controller which leverages the use of command design pattern to make operations on the model. After the initial setup of the world as in the milestone 1, we are required to take inputs from the user using a controller and pass to appropriate functions in the model, retireve the result and relay it back to the appendable passed to the controller by the Main/driver class. Apart from having the World in memory, we are supposed to print an image of the world (where we can use libraries like BufferedImage) and also create a jar file which takes the name of the input specs files as command line input, instantiates the world in memory, draws the image graph, and give the above mentioned functionalities. Also, we need to use command design pattern when calling functionalities on the model.


For the third milestone; we implemented features such as attacking on the target to decrease its health, updating the look around functionality to give more information about where a player is in the world which includes  player's current space, other players in the room, items in the space as well as similar information about its neighboring spaces. Also, for the purpose of a successful attack by a player on the target, we checked if any players  can see the attacking player, if so the attempt fails and the item being used for attack is discarded from the game as evidence. The amount of information to be displayed before each turn to the user has increased which also includes now detials about where player is in the world and some other useful infromation such as target's location and pet's location. The pet's superpower is that it can make the players in the same room as it is in invisible to other players in the neighboring rooms. The pet can be moved by a player to any room in the world. Also, as an additional credit task, pet's movement around the world in Depth First manner where after each turn it moves to the next room in a DFS manner was implemented.


For Milestone 4 we build the view for the entire gameplay. 
We build three frames with single or multiple panels in them. The first frame implements the Welcome Screen. The second frame implements the Add Player Screen and the third panel implements the GamePlay screen. We start by showing an about screen that welcomes the user to the game and provides credits to those who worked on the assignment. We provide an option for starting a new game with a new world specification, starting a new game with the current world specification, option to review game rules and quitting the game through a JMenu.

When the game begins, 75% of the program's screen show the graphical representation of the world along with a graphical representation of the the target character (but not the pet) and any players that have been added to the game. Each of these graphical representations are overlaid on top of the graphical representation of the world in such a way to show their current location. 

The program should support graphical representations of the target, and up to 10 players (in any combination of human and computer).

Any world that is bigger than the area allocated to it on the screen provide the ability to scroll the view.

We clearly indicate whose turn it is on the screen along with any information about where they are in the world.
We provide an option for getting the player's description by clicking on the player's graphical representation.
We provide an option for moving the player though the world using a mouse click. A player should not be able to make invalid moves.
We provide an option for the player to pick up an item in the world by pressing a key on the keyboard.
We provide an option for the player to look around the world by pressing a key on the keyboard.
We provide an option for the player to make an attempt on the target character's life by pressing a key on the keyboard.
We provide a clear indication of the results of each action a player takes.


-> Overview of our solution:
  -> Create a Main class that instantiates the model, the view and the controller objects and passed the model object to the view and the controller.
  -> The controller then sets the view and the view will render the game screen.
  -> The controller then reads input from the user using the Readable passed by the main when constructing the controller and calls appropriate functions from the model using command design pattern.
  -> The view reads input from the user using a GUI and relays it to the controller. The controller will fetch output from the model and relay it back to the view. 
  

1. Main class: This is the driver class that instantiates the model, the view and the controller objects and passed the model object to controller and the view.

2. Controller classes/ interfaces:
	1. Controller: This represents an interface that contains functionalities that a Controller for the game must possess.
	2. ControllerImpl: This represents a class that contains functionalities that a Controller for the game must possess.
	3. Features: This interface is used by the view to communicate with controller. Features is how the view looks at the controller. 
	4. AddPlayerPiece: This class represents the command construct that will add the players to the game model.
	5. CreateGraphicalWorld: This class represents the command construct that will create the image representation of the world.
	6. DisplayPlayerDescription: This class represents the command construct that will display the information regarding a player.
	7. GetRoomInformation: This class represents the command construct that will get the room information from the world model.
	8. Command: This interface represents set of functions that are expected to be performed by any command in the controller on the model.
	9. PlayerLookAround: This class represents the command construct that will display the detailed information regarding neighboring spaces.
	10. PlayerMove: This class represents the command construct that will make the player move and display information regarding the move.
	11. PlayerPickItem: This class represents the command construct that will make the player pick an item and display information regarding that action.
	12. MovePet: This class represents the command construct that will make the pet move form one room/space to another and display information regarding the move.
	13. Attack: This class represents the command construct that enables the player to attack the target.

3. Model classes/interfaces:
   	1. World: Interace that represents a common functionality exposed to controller to play the game.
	2. GenerateRandom: A utility class that represents a class to get random numbers which can be generated truly randomly or in a predictable way.
	3. Player: Interface that represents a set of functionalities that are expected of all kinds of players playing this game.
	4. Target: Interface that represents a set of functionalities for the target component of the game.
	5. ItemImpl: Represents the Items in the world that can be used to attack.
	6. PlayerImpl: Represents the player piece i.e. the pieces on the board other than the target.
	7. RoomImpl: Represents the state of a room which is a space in the game.
	8. TargetImpl: Represents the target piece on the board and contains various functionalities to decide the state of a target object.
	9. WorldImpl: This class represents the complete game board.
	10. WorldInitializer: This singleton class represents a utility class that helps parse the input file and generate data that can be understood by the World for construction of other components.
	11. Room: This interface represents a room i.e. space in the world model.
	12. Item: This represents the state of an item in the world that can be used by a player to attack the target.
	13. Pet:Represents set of functionalities that are expected from the target character's pet in the game.
	14. PetImpl: Represents the state of the target's pet in the game and a set of functionalities so as to emulate the behaviour that is expected from the target's pet.
	15. ImageDisplayer: This class represents a set of functionality to generate a graphical representation of the world.
	16. ReadOnlyWorld: This class represents a common set of functionalities for read only operations exposed to the view.
	
	
4. View classes/ interfaces:
	1. AddPlayerFrame: Interface represents set of functionalities that are expected from the add player screen view of the world.
	2. AddPlayerFrameImpl: Class represents the state and the set of functionalities that are expected from the AddPlayer Frame of the view of the game.
	3. GamePlayFrame: This interface represents the set of functionalities that will enable a user to interact with the game play.
	4. GamePlayFrameImpl: This class represents the frame, its state and set of functionalities that will enable a user to interact with the the game play.
	5. GraphicalWorldPanel: This class represents the panel that contains the graphical representation of the world.
	6. TurnInfoAndResultPanel: This class represents the functionalities and the state of a panel that is responsible for displaying the pre-turn information as well ar results of a turn.
	7. TurnInfoPanel: This class represents the panel that displays the pre-turn information.
	8. TurnResultPanel: This class represents the panel that display the information related to a turn's result.
	9. ValueChooser: This class represents a set of functionalities that will enable the user to choose from a dropdown menu.
	10. View: This interface represents set of functionalities that are expected from a view of the world game.
	11. ViewImpl: This class represents the set of functionalities that represent the functioning of a view of the world and defines the state of the view.
	12. WelcomeFrame: This interface represents set of functionalities that are expected from the welcome screen view of the world game.
	13. WelcomeFrameImpl: This class represents the state and the set of functionalities that are expected from the Welcome Frame of the view of the game.
	14. WelcomeTextPanel: This class represents the state of the panel that will display the welcome message and the developers that contribute to this project.
	

5. The input text file name is taken from command line arguments along with number of turns of the game in the WorldDriver class ( the client facing class ), passed onto the WorldInitializer instance (it s asingleton class as it is just a utility here) in the model which parses the input and initilizaes the list of rooms, list of items and the World object which can then be used to call the play method() which will start the game.

6. The WorldImpl object is used to initialize the state of the whole game and interacts with all the components to make progress in the game and get status of each of the components of the game.

7. The World interface acts as a Facade for the components of the model and acts as a gateway for the controller to intereact with the model.

8. The Features interface acts as a point of contact for components of controller(which are the commands and the controller class itself) and acts as a gateway for the view to interact with the controller.


### List of Features

List all features that are present in your program.

-> Features present in the program:

1. Get graphical representation of the live game state with the world and all the overlay pieces in real time. 

2. Get a detailed feed back for every move made by the user. This tells user if move was sucessful or not.

3. A welome screen with options to use existing specification, add a new specification, review game rules and to exit the game.  

4. Move the target around the world by incrementing by 1 in each move and moves as per the indices of the list of rooms and in the same order as in the rooms list starting from 0th index and looping to the same after it has traversed all the rooms.

5. Automatically move the target character around the world. The target character moves during every turn of the game. 

6. Add a human-controlled player to the game.

7. Add a computer-controlled player to the game.

8. Move a player to a neighboring space.

9. Allow a player to pick up an item.

10. Allow a player to look around and get detailed information about the neighboring spaces.

11. Display a description of a specific player including where they are in the world and what they are carrying.

12. Limit the maximum number of turns allowed suing command line args as input from the user.

13. Move the pet to a different room as specified by the user.

14. Attack the target to decrease its health.

15. Game ending if max turns are over or target is killed and winner is declared.

16. [EXTRA CREDIT] The pet moves with every turn following a depth-first traversal of the spaces in the world following the same order of the rooms in the world specification.

17. For the user, get enhanced information in the beginning of every turn to make informed decisions on which move to play next.

18. The pet's superpower is that it can make the players in the same room as it is in invisible to other players in the neighboring rooms. The pet can be moved by a player to any room in the world.

19. Also, for the purpose of a successful attack by a player on the target, we are suppoed to check if any players can see the attacking player, if so the attempt fails and the item being used for attack is discarded from the game as evidence. Player A can see player B only when they both are in the same room or playerB is in one of the neighbors of player A if there is no pet in the playerB's room. If there is a pet in the player B's room, then no one can see playerB.

20. An automatic computer player can be added to room of any choice and it plays automatically in the sense it always tries to attack the target if the target is in the same room and the computer player cannot be seen by other players.
Otherwise, it chooses randomly to perform either playerLookAround or playerMove or playerPickItem.

21. Even in the absence of an item in the player's item bag be it human player or computer player, they can always choose to poke the target if target and player are in the same room and th eplayer cannot be seen by other players.

22. Move Player: Mouse click on neighbour room

23. Attack: Press a

24. Move Pet: Press m

25. Player Info: Mouse Click on current player

26. Pick Item: Press i key

27. Look Around: Press l key


### How to Run

Describe how to run your program from the JAR file. Describe what arguments are needed (if any) and what they mean.

Go to terminal and type in:

java -jar path1 path2 arg1


where, 
path1: This represent the path to the mentioned .jar file. <path of the cs5010-final-project-siddharthprajwalteam.jar file>.
path2: This represents the path to the input specification of the world text file. <path of the InputSpecs text file>.
arg1: This represents the number of max turns allowed in the game.


### How to Use the Program

Provide instructions on how to use the functionality in your program. If it is interactive, describe how to interact with your program. Pay particular attention to the parts that are not part of the example runs that you provide.

To run
---------
Just pass the text file containing the specification of the world as command line argument to the .jar file in the /res directory as well as the max number of turns in the game as:

Command> java -jar path1 path2 arg1

where, 
path1: This represent the path to the mentioned .jar file. <path of the cs5010-project-TitaniumBlade11.jar file>.
path2: This represents the path to the input specification of the world text file. <path of the InputSpecs text file>.
arg1: This represents the number of max turns allowed in the game.

Introduction
---------------
Objective: Kill the Alien!
Alien will move through the facility following certain path.
Good to Know: You can add 10 players in the game who can be human or computer player.
You may select one of following moves when its your turn.
1. Pick Item: Pick up any item from the room.
2. Look Around: Get complete information about your neighbouring rooms.
3. Move Player: Move to one of your neighbours.
4. Attack: Attack the target using weapon available with you.
5. You may move target's pet to any desired location.

More info:
1. You can get description of player who has current turn.
This does not counts as a move.
2. If someone was watching you when you made an attempt on target's life your attack will fail and you will loose your weapon as well.
3. Presence of a pet will make a room and its contents invisible to everyone outside the room.
4. The pet will keep moving through the facility in a certain path.
5. Player who successfully kills the target wins the game.
6.If no one could kill target; the target escapes and nobody wins.
7.Program supports at most 10 players as stated in requirements.

Screen 1: Welcome Screen
------------------------
You have 4 options to choose from :
1. Use existing world specification: Use existing world specification as was provided in the command line arguments.
2. Use custom world specification: Select path to custom world specification file.
3. View game rules: The purpose of the game and rules to operate in the game.
4. Exit: Exit the game.

Screen 2: Add Player Screen
-----------------------------
Player Name: Name of the player.
Room Name:A dropdown menu to select the name of the room where the player wants to start in the game.
Bag Limit: Item bag limit of the player.
Player Type: A radio button to select whether the player is human or computer.
Submit button: To add the specific player to the world
Start Game: To start the gameplay.

Screen 3: Game play Screen
---------------------------
Game Controls:
1. Pick Item: i (Keyboard key press)
2. Look Around: l (Keyboard key press)
3. Move Player: Mouse click on a neighbour room
4. Attack: a (Keyboard key press)
5. Move Pet: m (Keyboard key press)
6. Player Info: Mouse Click on current player

Turn Information displays the pre-turn information which will help the player to make an educated attempt towards its turn.

It also displays the move the computer player took before the current player's turn.

Turn Result displays the result of the particular turn made by the player.

The game goes on until the maximum number of turns is reached and the alien(target) escapes OR when the alien(target) is killed.


### Example Runs

List any example runs that you have in res/ directory and provide a description of what each example represents or does. Make sure that your example runs are provided as *plain text files*.

Video submission of the game run is made as a separate assignment. Since no text based interaction is present in this milestone, no text example runs are provided.


### Design/Model Changes

Document what changes you have made from earlier designs. Why did you make those changes? Keep an on-going list using some form of versioning so it is clear when these changes occurred.

 Milestone 1
-------------
1. Added WorldDriver class(controller/client facing class) for hiding the internal implementation of the model. I made it so that it just takes the input text file containing the specs for the world and passes it
to another intermediate class in the model that parses that data. With this, the client just have to call the functionality (in this milestone 1 case, it is to make a dry run of the program).
Commit hash: 2c4f41b3b225ac1364a4f8b0cef091d67b965dd6

2. Added WorldInitialzer class. This class is the component that the controller class talks to. This class is responsible for parsing the input file, instantiating the list of rooms, list of items and more importantly it initilizes the World object and calls the play method to start the game.
 It also has a function to move target across all spaces in the world which is eventually called by the controller class. It is also responsible for drawing the image of the World map onto a png file.
Commit hash: 2c4f41b3b225ac1364a4f8b0cef091d67b965dd6

3. Added ImageDisplayer as a separate class that creates a buffered image of the world and saves it as a .png file in /res directory under the name of "world.png".
Commit hash: eacffe60f72505df79ec79ebd2193690ca8eeff7

Milestone 2
-----------
1. Removed separate computer player and human player classes and made them into 1 player class as they have the same functionality.
Commit hash:ed17af84abf7fcca70240bad9f54372d0fe2211b

2. Separated the target player from the abstract player as now after milestone 2 requirements, it became clear that target should be a separate class of its own.
Commit hash:ed17af84abf7fcca70240bad9f54372d0fe2211b

Milestone 3
------------
1. Modified the constructor of PetImpl to take in currentRoom(RoomImpl object) and roomsList(List of rooms) to define its state appropriately and implement the movePet DFS in appropriate manner.
Since in my assumptions, the target's pet is having knowledge of the whole world, I changes the constructor of the PetImpl to define its state accurately and help it move in DFS manner in the world where the WorldImpl only instructs the 
pet to move in DFS manner and the pet does it on its own and returns the result appropriately.
Commit hash:5ca987e2dec39815344ef51214b7a57c7dc8e40c


Milestone 4
------------
1. Removed the text based controller and used just the model from the previous milestone. New repo created by professor: https://github.com/khoury-22sp-cs5010-jump/cs5010-final-project-siddharthprajwalteam
Commit hash: 2a44298ac6eab534490c6cd06e2377eac1c0de9f

2. Segregated Model Interface into- World Interface and ReadOnlyWorld Interface where World Interface will extend ReadOnlyWorld interface. 
The interfaces are used by :
World interface by controller
ReadOnlyWorld interface by view

This was done so that view can directly get 'some' read only data from the model without going through the controller for speed of execution. This was done carefully so that the view does not start behaving like the controller.

Commit hash: 415edac24241b31e6c80327122bca204b263f6a9

3. Refactored the previous controller to behave in an asynchronous way as compared to the former synchronous controller. This was done by making it have functions that get notification from the view and as per use case, it tells the 
view to get inputs from the user and then passes the input and eventually calls the appropriate method in the model using the data from the view, gets the result and relays it back to the view.
The major functionalities are done by the commands of the controller, the ControllerImpl class will now just call the right commands based on notification from the view.

The commands are also refactored in the sense that now they have information about the view and the model, they accrordingly get the inputs from the view and call the right methods in the model with inputs from the view, relay back the result to the ControllerImpl object which in turn relays back the result to the view.

Commit hash: 314ae149ff9984850565a0cddcc9437199f70bc2

4. The controller now implements Controller interface which in turn extends the Features interface. Needed to segregate the previous Controller functions into two so that Features' functionalities are used by the View. These include mostly 
notification functions to controller which are called when corresponding triggers are fired in the view and they call the appropriate function in the controller using the Features interface.

Commit hash: c84751ed1ed58db96e8378f39a57c1ae3e133fdf

5. Added the new Driver class that now initializes model, view and the controller and facilitates forming necessary links between them. The view is now being initialized in the driver as this project requires us to build a full blown MVC application.

Commit hash:c4ae421e7dab37aec167a88c50e30ed49d741e0b

6. Created a separate package structure for the view which constitutes the components of the GUI which uses Swing. This helps in proper code segregation.

Commit hash:c4ae421e7dab37aec167a88c50e30ed49d741e0b

7. Introduced classes that form the view whose major parts are the View class (acts as the point of contact for the controller for single link of communication and simplifying communication betwwen the controller and the view), the Welcome screen, the AddPlayer screen and the Gameplay screen.
This was done for a proper structured View of the MVC pattern.

Commit hash: 44350a41dde0cb5a0eac9009a72d6c4c615832ac ; 60384a20ed6d512d3c40b34f999f539464056873 ; bcd04080aaa8cc6d458dd905ceec439323370484


### Assumptions

List any assumptions that you made during program development and implementations. Be sure that these do not conflict with the requirements of the project.
1. The target has full visiblity of the world even if pet is in the same room.
2. There can be a world with no items.
3. A world needs atleast 1 room to exist.
4. A player can move to room which has pet in it.


### Limitations

None

### Citations

Be sure to cite your sources. A good guideline is if you take more than three lines of code from some source, you must include the information on where it came from. Citations should use proper [IEEE citation guidelines](https://ieee-dataport.org/sites/default/files/analysis/27/IEEE Citation Guidelines.pdf) and should include references (websites, papers, books, or other) for ***any site that you used to research a solution***. For websites, this includes name of website, title of the article, the url, and the date of retrieval**.** Citations should also include a qualitative description of what you used, and what you changed/contributed.

1. Name of website: Oracle docs
   Title of article: Class BufferedImage
   URL: https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
   Date of retrieval: 02-11-2022
   
2. Name of website: https://web.mit.edu/
   Title of article: A Visual Guide to Swing Components
   URL: https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
   Date of retrieval: 04-07-2022
   
3. Name of website: Oracle docs
   Title of article: A Visual Guide to Layout Managers
   URL: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
   Date of retrieval: 04-07-2022
   
4. Name of website: Oracle docs
   Title of article: Writing Event Listeners
   URL: https://docs.oracle.com/javase/tutorial/uiswing/events/index.html
   Date of retrieval: 04-07-2022
   
5. Name of website: Stack Overflow
   Title of article: How to reference a resource file correctly for JAR and Debugging?
   URL: https://stackoverflow.com/questions/6192661/how-to-reference-a-resource-file-correctly-for-jar-and-debugging
   Date of retrieval: 04-22-2022
	

