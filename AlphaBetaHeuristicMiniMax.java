public class AlphaBetaHeuristicMiniMax {
	
	static Utility utility = new Utility();
	static Result result = new Result();
	static Action action = new Action();
	
	public Action alphaBetaHeuristicMinMaxSearch(State state, int depthCutoff) {
		Action maxAction = null;
		int currentDepth = 0;
		int max = Integer.MIN_VALUE;
		for(Action act: action.getActions(state)) {
			int minValue = abHFindMinValue(result.getResult(state, act), Integer.MIN_VALUE, Integer.MAX_VALUE, currentDepth++, depthCutoff);
			if(minValue >= max) {
				maxAction = act;
				max = minValue;
			}
		}
		return maxAction;
		
	}
	
	public int abHFindMaxValue(State state, int alpha, int beta, int currentDepth, int depthCutoff) {		
		int max = Integer.MIN_VALUE;
		if(utility.terminalTest(state)) {
			return utility.getUtility(state);
		}
		else if(currentDepth == depthCutoff){
			return heuristicFunction(state);
		}
		
		else {
			for(Action act: action.getActions(state)) {
				max = Math.max(max, abHFindMinValue(result.getResult(state, act), alpha, beta, currentDepth++, depthCutoff));
				if(max >= beta) {
					return max;
				}
				else {
					alpha = Math.max(alpha, max);
				}
			}
			return max;
		}
	}
	
	public int abHFindMinValue(State state, int alpha, int beta, int currentDepth, int depthCutoff) {
		int min = Integer.MAX_VALUE;
		
		if(utility.terminalTest(state)) {
			return utility.getUtility(state);
		}
		else if(currentDepth == depthCutoff) {
			return heuristicFunction(state);
		}
		else {
			for(Action act: action.getActions(state)) {
				min = Math.min(min, abHFindMaxValue(result.getResult(state, act), alpha, beta, currentDepth++, depthCutoff));
				if(min <= alpha) {
					return min;
				}
				else {
					beta = Math.min(beta, min);
				}
			}
			return min;
		}
	}
	
	
	
	public static int heuristicFunction(State state) {
		
		if((state.AI == "x" && state.countBlack() > state.countWhite()) || (state.AI == "o" && state.countWhite() > state.countBlack())) {
			if(state.countBlack() > state.countWhite()) {
				return state.countBlack() - state.countWhite();
			}
			else if(state.countBlack() < state.countWhite()) {
				return state.countWhite() - state.countBlack();
			}
		}
		if((state.AI == "o" && state.countBlack() > state.countWhite()) || (state.AI == "x" && state.countWhite() > state.countBlack())) {
			if(state.countBlack() > state.countWhite()) {
				return state.countWhite() - state.countBlack();
			}
			else if(state.countBlack() < state.countWhite()) {
				return state.countBlack() - state.countWhite();
			}
		}
		return 0;
	}
}
