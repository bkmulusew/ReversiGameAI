public class MinMax {
	
	static Action action = new Action();
	static Utility utility = new Utility();
	static Result result = new Result();

	public Action minMaxSearch(State s, int maxDepth) {
		Action maxAction = null;
		int currentDepth = 0;
		int max = Integer.MIN_VALUE;
		for(Action act: action.getActions(s)) {
			int minValue = findMinValue(result.getResult(s, act), maxDepth, currentDepth++);
			if(minValue >= max) {
				maxAction = act;
				max = minValue;
			}
		}
		return maxAction;
		
	}
	
	public static int findMaxValue(State state, int maxDepth, int currentDepth) {
		int max = Integer.MIN_VALUE;
		if(utility.terminalTest(state)) {
			return utility.getUtility(state);
		}
		if(currentDepth == maxDepth) {
			return 0;
		}
		
		for(Action act: action.getActions(state)) {
			max = Math.max(max, findMinValue(result.getResult(state, act), maxDepth, currentDepth++));
		}
		
		return max;
	}
	
	public static int findMinValue(State state, int maxDepth, int currentDepth) {
		int min = Integer.MAX_VALUE;
		if(utility.terminalTest(state)) {
			return utility.getUtility(state);
		}
			
		if(currentDepth == maxDepth) {
			return 0;
		}
		
		for(Action act: action.getActions(state)) {
			min = Math.min(min, findMaxValue(result.getResult(state, act), maxDepth, currentDepth++));
		}
		
		return min;
	}
	
}
