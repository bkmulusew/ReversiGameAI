Name: Beakal Lemeneh
Net ID: 31390484
Project Number: 01

I did not collaborate with anyone in this assignment.



What I did for this project is write a separate class for the necessary elements to describe an adversarial search space as discussed on the lecture, and combine them to build the game in the Game.java class.

The codes are found in Reversi->src.


Here are the classes with their descriptions:



State.java - Describes the current state of the game. It holds information such as who the current player is, whose player color is black, whose player color is white, and prints the state.

TerminalState.java - Describes the terminal state of the game. It checks if the board is filled or if there are no more moves to be made.

Utility.java - Describes the utility of a given state in the game. The given utility values are 1 in favor of the current player, 0 if it neither favor nor disfavor the current player, and -1 if it disfavors the current player.

Result.java - Transitional Model of the game. It returns a state for a given state and action fed to it as an input. The Transitional Model of this game first checks if the action given to it as an input is a valid action, and also changes the state of the current player after an action has been made.

InitialState.java - Describes the initial state of the game.

Action.java - Describes the actions a given state can take. Specifically, where the board pieces can be placed by a certain player.

AlphaBetaMiniMax.java - Describes the MINIMAX with alpha-beta pruning algorithm.

AlphaBetaHeuristicMiniMax.java - Describes the H-MINIMAX with a fixed depth cutoff and a-b pruning algorithm. Depth cutoff is asked form the user as an input. The heuristic function is found in this class. The value of the heuristic function used for this game is the difference between the the number black pieces and white pieces at the cutoff depth. Meaning, it chooses the state with the greatest number of black pieces or white pieces, depending on the current player, as the one with the highest utility.

MiniMax.java - Describes the MINIMAX algorithm.

ReversiAlgorithm.java - This is the class that holds all the search algorithm needed for the game. The algorithm that selects random actions is found here.

Game.java - Describes the frontend of the game. The board setup is described in this class. The main function is also found here.

