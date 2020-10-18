
public class InitialState {
	State state = new State();
	
	public State initialializeState(int dimension) {
		state.board = new String[dimension][dimension];
		state.board[dimension / 2][dimension / 2] = "o";
		state.board[(dimension / 2)][(dimension / 2) - 1] = "x";
		state.board[(dimension / 2) - 1][(dimension / 2)] = "x";
		state.board[(dimension / 2) - 1][(dimension / 2) - 1] = "o";
		return state;
	}

}
