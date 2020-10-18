
public class AlphaBetaMiniMax {
	
	static Action action = new Action();
	static Utility utility = new Utility();
	static Result result = new Result();
	
	public Action alphaBetaMiniMaxSearch(State s, int depthCutoff) {
		Action maxAction = null;
		int currentDepth = 0;
		int max = Integer.MIN_VALUE;
		for(Action act: action.getActions(s)) {
			int minValue = abMinValue(result.getResult(s, act), Integer.MIN_VALUE, Integer.MAX_VALUE, currentDepth++, depthCutoff);
			if(minValue >= max) {
				maxAction = act;
				max = minValue;
			}
		}
		return maxAction;
	}
	
	public int abMaxValue(State state, int alpha, int beta, int currentDepth, int depthCutoff) {
		int max = Integer.MIN_VALUE;
		if(utility.terminalTest(state)) {
			return utility.getUtility(state);
		}
		else if(currentDepth == depthCutoff){
			return 0;
		}
		
		else {
			for(Action act: action.getActions(state)) {
				max = Math.max(max, abMinValue(result.getResult(state, act), alpha, beta, currentDepth++, depthCutoff));
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
	
	public int abMinValue(State state, int alpha, int beta, int currentDepth, int depthCutoff) {
		int min = Integer.MAX_VALUE;
		if(utility.terminalTest(state)) {
			return utility.getUtility(state);
		}
		else if(currentDepth == depthCutoff) {
			return 0;
		}
		else {
			for(Action act: action.getActions(state)) {
				min = Math.min(min, abMaxValue(result.getResult(state, act), alpha, beta, currentDepth++, depthCutoff));
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

}
