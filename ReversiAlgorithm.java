import java.util.Random;

public class ReversiAlgorithm {
	
	public Action random(State state) {
		Action action = new Action();
		Random random = new Random();
		if(action.getActions(state).isEmpty()) {
			return null;
		}
		int index = random.nextInt(action.getActions(state).size());
		return action.getActions(state).get(index);
	}
	
	public Action minMax(State state, int depthCutoff) {
		
		State s = new State();
		s.initialState(state.board.length);
		for(int i = 0; i < state.board.length; i++) {
			for(int j = 0; j < state.board[0].length; j++) {
				s.board[i][j] = state.board[i][j];
			}
		}
		s.currentPlayer = state.currentPlayer;
		s.human = state.human;
		s.AI = state.AI;
		MinMax minmax = new MinMax();
		return minmax.minMaxSearch(s, depthCutoff);
	}
	
	public Action aBMiniMaxSearch(State state, int depthCutoff) {
		
		State s = new State();
		s.initialState(state.board.length);
		for(int i = 0; i < state.board.length; i++) {
			for(int j = 0; j < state.board[0].length; j++) {
				s.board[i][j] = state.board[i][j];
			}
		}
		s.currentPlayer = state.currentPlayer;
		s.human = state.human;
		s.AI = state.AI;
		AlphaBetaMiniMax abminmax = new AlphaBetaMiniMax();
		return abminmax.alphaBetaMiniMaxSearch(s, depthCutoff);
	}
	
	public Action aBHMinMaxSearch(State state, int cutoff) {
		State s = new State();
		s.initialState(state.board.length);
		for(int i = 0; i < state.board.length; i++) {
			for(int j = 0; j < state.board[0].length; j++) {
				s.board[i][j] = state.board[i][j];
			}
		}
		s.currentPlayer = state.currentPlayer;
		s.human = state.human;
		s.AI = state.AI;
		AlphaBetaHeuristicMiniMax abhminimax = new AlphaBetaHeuristicMiniMax();
		return abhminimax.alphaBetaHeuristicMinMaxSearch(s, cutoff);
	}

}
