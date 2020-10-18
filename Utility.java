
public class Utility {
	
	public static State changePlayer(State state) {
		State stat = state;
		if(stat.currentPlayer == "x")
			stat.currentPlayer = "o";
		else 
			stat.currentPlayer = "x";
		return stat;
	}
	
	
	public int getUtility(State state) {
		if(terminalTest(state)) {
			if((state.currentPlayer == "x" && state.countBlack() > state.countWhite()) || (state.currentPlayer == "o" && state.countWhite() > state.countBlack())) {
				return 1;
			}
			if((state.currentPlayer == "o" && state.countBlack() > state.countWhite()) || (state.currentPlayer == "x" && state.countWhite() > state.countBlack())) {
				return -1;
			}
		}
		return 0;
	}
	
	public boolean terminalTest(State state) {
		Action action = new Action();
		boolean noEmptySlot = true;
		outerloop:
		for(int i = 0; i < state.board.length; i++) {
			for(int j = 0; j < state.board[0].length; j++) {
				if(state.board[i][j] == null){
					noEmptySlot = false;
					break outerloop;
				}
			}
		}
		if(noEmptySlot || (!noEmptySlot && action.getActions(state).isEmpty() && action.getActions(changePlayer(state)).isEmpty())) {
			return true;
		}
		return false;
	}

}
