
import java.util.Scanner;

public class Game {
	static int algoChoice;
	static int cutOffTree = 0;
	static int possibleMoves = 0;
	static double totalTimeDark = 0;
	static double totalTimeLight = 0;
	
	public static State PromptBoard() {
		State state = new State();
		System.out.println("Reversi by Beakal Lemeneh \nChoose your game:\n1. Small 4x4 Reversi\n2. Medium 6x6 Reversi\n3. Standard 8x8 Reversi\nYour choice? ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		System.out.println("Choose your opponent:\n1. An agent that plays randomly\n2. An agent that uses MINIMAX\n3. An agent that uses MINIMAX with alpha-beta pruning.\n4. An agent that uses H-MINIMAX with a fixed depth cutoff and a-b pruning.\nYour Choice? ");
		algoChoice = in.nextInt();
		if(algoChoice == 4) {
			if(choice == 1) {
				System.out.println("Max search depth = 12" );
			}
			else if(choice == 2) {
				System.out.println("Max search depth = 32" );
			}
			else if(choice == 3) {
				System.out.println("Max search depth = 60" );
			}
			System.out.println("Choose cutoff depth less than the max search depth: ");
			cutOffTree = in.nextInt();
		}
		System.out.println("Do you want to play BLACK (x) or WHITE (o)? ");
		String color= in.next();
		
		if(color.equalsIgnoreCase("o")) {
			state.human = "o";
			state.AI = "x";
			state.currentPlayer = "x";
		}
		if(color.equalsIgnoreCase("x")) {
			state.human = "x";
			state.AI = "o";
			state.currentPlayer = "x";
		}
		
		if(choice == 1) {
			possibleMoves = 12;
			state.initialState(4);
		} 
		if(choice == 2) {
			possibleMoves = 32;
			state.initialState(6);
		}
		if(choice == 3) {
			possibleMoves = 60;
			state.initialState(8);
		}
		return state;
	}
	
	public static void runGame() {

		Scanner in = new Scanner(System.in);
		State state = new State();
		Result result = new Result();
		ReversiAlgorithm algorithm = new ReversiAlgorithm();
		Utility utility = new Utility();
		state = PromptBoard();
		state.printState();
		boolean continueGame = true;
		
		if(state.human == "x") {
			
			while(continueGame == true) {
				
				if(utility.terminalTest(state)) {
					if(state.countBlack() == state.countWhite()) {
						System.out.println("Tie");
					}
					else if(state.countBlack() > state.countWhite()) {
						System.out.println("Winner: Black");
					}
					else {
						System.out.println("Winner: White");
					}
					System.out.println("Total Time:");
					System.out.println("\tDark: " + totalTimeDark + " secs");
					System.out.println("\tLight: " + totalTimeLight + " secs");
					continueGame = false;
					break;
				}
				state.currentPlayer = "x";
				
				Action act = new Action();
				Action action = new Action();
				if(state.currentPlayer == "x") {
					System.out.println("Next to play: DARK\n");
				}
				else {
					System.out.println("Next to play: LIGHT\n");
				}
				if(act.getActions(state).isEmpty() == false) {
					long startTime = System.currentTimeMillis();
					System.out.println("Your move (? for help): ");
					action.move = in.next();
					long finishTime = System.currentTimeMillis();
					while(act.checkActions(state, action) == false) {
						System.out.println("Invalid move, please enter a valid move: ");
						action.move = in.next();
					}
					long reactionTime = finishTime - startTime;
					totalTimeDark = totalTimeDark + (((double)(reactionTime)) / 1000);
					System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
					System.out.println("x: " + action.move + "\n");
					state = result.getResult(state, action);
				}
				else {
					System.out.println("No possible move!!!\n");
				}
				state.printState();
				
				if(utility.terminalTest(state)) {
					if(state.countBlack() == state.countWhite()) {
						System.out.println("Tie");
					}
					else if(state.countBlack() > state.countWhite()) {
						System.out.println("Winner: Black");
					}
					else {
						System.out.println("Winner: White");
					}
					System.out.println("Total Time:");
					System.out.println("\tDark: " + totalTimeDark + " secs");
					System.out.println("\tLight: " + totalTimeLight + " secs");
					continueGame = false;
					break;
				}
				
				state.currentPlayer = "o";
				if(state.currentPlayer == "x") {
					System.out.println("Next to play: DARK\n");
				}
				else {
					System.out.println("Next to play: LIGHT\n");
				}
				
				if(algoChoice == 1) {
					Action a = algorithm.random(state);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeLight = totalTimeLight + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}
					state.printState();	
				}
				else if(algoChoice == 2) {
					Action a = algorithm.minMax(state, possibleMoves);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeLight = totalTimeLight + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}	
					state.printState();	
				}
				else if(algoChoice == 3) {
					Action a = algorithm.aBMiniMaxSearch(state, possibleMoves);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeLight = totalTimeLight + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}
					state.printState();
				}
				else if(algoChoice == 4) {
					Action a = algorithm.aBHMinMaxSearch(state, cutOffTree);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeLight = totalTimeLight + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}
					state.printState();
				}
			}
		}
		
		
		if(state.AI == "x") {
			
			while(continueGame == true) {
				
				if(utility.terminalTest(state)) {
					if(state.countBlack() == state.countWhite()) {
						System.out.println("Tie");
					}
					else if(state.countBlack() > state.countWhite()) {
						System.out.println("Winner: Black");
					}
					else {
						System.out.println("Winner: White");
					}
					System.out.println("Total Time:");
					System.out.println("\tDark: " + totalTimeDark + " secs");
					System.out.println("\tLight: " + totalTimeLight + " secs");
					continueGame = false;
					break;
				}
				state.currentPlayer = "x";
				
				if(state.currentPlayer == "x") {
					System.out.println("Next to play: DARK\n");
				}
				else {
					System.out.println("Next to play: LIGHT\n");
				}
				
				if(algoChoice == 1) {
					Action a = algorithm.random(state);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeDark = totalTimeDark + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}
					state.printState();	
				}
				else if(algoChoice == 2) {
					Action a = algorithm.minMax(state, possibleMoves);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeDark = totalTimeDark + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}	
					state.printState();	
				}
				else if(algoChoice == 3) {
					Action a = algorithm.aBMiniMaxSearch(state, possibleMoves);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeDark = totalTimeDark + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}
					state.printState();
				}
				else if(algoChoice == 4) {
					Action a = algorithm.aBHMinMaxSearch(state, cutOffTree);
					if(a == null) {
						System.out.println("No more moves possible!");
					}
					else {
						long startTime = System.currentTimeMillis();
						System.out.println("I'm picking moves randomly...");
						long finishTime = System.currentTimeMillis();
						long reactionTime = finishTime - startTime;
						totalTimeDark = totalTimeDark + (((double)(reactionTime)) / 1000);
						System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
						System.out.println(state.currentPlayer + ": " + a.move + "\n");
						state = result.getResult(state, a);
					}
					state.printState();
				}
				
				if(utility.terminalTest(state)) {
					if(state.countBlack() == state.countWhite()) {
						System.out.println("Tie");
					}
					else if(state.countBlack() > state.countWhite()) {
						System.out.println("Winner: Black");
					}
					else {
						System.out.println("Winner: White");
					}
					System.out.println("Total Time:");
					System.out.println("\tDark: " + totalTimeDark + " secs");
					System.out.println("\tLight: " + totalTimeLight + " secs");
					continueGame = false;
					break;
				}
				
				state.currentPlayer = "o";
				
				Action act = new Action();
				Action action = new Action();
				if(state.currentPlayer == "x") {
					System.out.println("Next to play: DARK\n");
				}
				else {
					System.out.println("Next to play: LIGHT\n");
				}
				if(act.getActions(state).isEmpty() == false) {
					long startTime = System.currentTimeMillis();
					System.out.println("Your move (? for help): ");
					action.move = in.next();
					long finishTime = System.currentTimeMillis();
					while(act.checkActions(state, action) == false) {
						System.out.println("Invalid move, please enter a valid move: ");
						action.move = in.next();
					}
					long reactionTime = finishTime - startTime;
					totalTimeLight = totalTimeLight + (((double)(reactionTime)) / 1000);
					System.out.println("Elapsed Time: " + (((double)(reactionTime)) / 1000) + " secs");
					System.out.println("x: " + action.move + "\n");
					state = result.getResult(state, action);
				}
				else {
					System.out.println("No possible move!!!\n");
				}
				state.printState();
			}
		}
	}

	public static void main(String[] args) {
		runGame();
	}
}



