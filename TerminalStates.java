
public class TerminalStates {
	
	public static State changeCurrentPlayer(State state) {
		State stat = state;
		if(stat.currentPlayer == "x")
			stat.currentPlayer = "o";
		else 
			stat.currentPlayer = "x";
		return stat;
	}
	
	public boolean terminalState(State state) {
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
		if(noEmptySlot || (!noEmptySlot && action.getActions(state).isEmpty() && action.getActions(changeCurrentPlayer(state)).isEmpty())) {
			return true;
		}
		return false;
	}

}
