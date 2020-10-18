import java.util.ArrayList;

public class Action {
	String move;
	
	public ArrayList<Action> getActions(State state){
		ArrayList<Action> possibleActions = new ArrayList<Action>();
		if(state.currentPlayer == "x") {
			for(int i = 0; i < state.board.length; i++) {
				for(int j = 0; j < state.board[0].length; j++) {
					if((state.board[i][j] == null)
							&& (((i - 1) >= 0 && (i - 1) < state.board.length && (state.board[i - 1][j] == "o")) || 
									((i + 1) >= 0 && (i + 1) < state.board.length && (state.board[i + 1][j] == "o")) ||
									((j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i][j + 1] == "o")) || 
									((j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i][j - 1] == "o")) || 
									((i + 1) >= 0 && (i + 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i + 1][j + 1] == "o")) || 
									((i - 1) >= 0 && (i - 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i - 1][j - 1] == "o")) || 
									((i + 1) >= 0 && (i + 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i + 1][j - 1] == "o")) || 
									((i - 1) >= 0 && (i - 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i - 1][j + 1] == "o")))) {
						innerloop:
						while(true) {
							if((i - 1) >= 0 && (i - 1) < state.board.length && (state.board[i - 1][j] == "o")) {
								int a = i - 2;
								innerloop2:
								while(a >= 0) {
									if(state.board[a][j] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][j] == null) {
										break innerloop2;
									}
									a--;
								}
							}
							if((i + 1) >= 0 && (i + 1) < state.board.length && (state.board[i + 1][j] == "o")) {
								int a = i + 2;
								innerloop2:
								while(a < state.board.length) {
									if(state.board[a][j] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][j] == null) {
										break innerloop2;
									}
									a++;
								}
							}
							if((j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i][j - 1] == "o")) {
								int b = j - 2;
								innerloop2:
								while(b >= 0) {
									if(state.board[i][b] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[i][b] == null) {
										break innerloop2;
									}
									b--;
								}
							}
							if((j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i][j + 1] == "o")) {
								int b = j + 2;
								innerloop2:
								while(b < state.board.length) {
									if(state.board[i][b] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[i][b] == null) {
										break innerloop2;
									}
									b++;
								}
							}
							if((i + 1) >= 0 && (i + 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i + 1][j + 1] == "o")) {
								int a = i + 2;
								int b = j + 2;
								innerloop2:
								while(a < state.board.length && b < state.board.length) {
									if(state.board[a][b] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a++;
									b++;
								}
							}
							if((i - 1) >= 0 && (i - 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i - 1][j - 1] == "o")) {
								int a = i - 2;
								int b = j - 2;
								innerloop2:
								while(a >= 0 && b >= 0) {
									if(state.board[a][b] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a--;
									b--;
								}
							}
							if((i + 1) >= 0 && (i + 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i + 1][j - 1] == "o")) {
								int a = i + 2;
								int b = j - 2;
								innerloop2:
								while(b >= 0 && a < state.board.length) {
									if(state.board[a][b] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a++;
									b--;
								}
							}
							if((i - 1) >= 0 && (i - 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i - 1][j + 1] == "o")) {
								int a = i - 2;
								int b = j + 2;
								innerloop2:
								while(a >= 0 && b < state.board.length) {
									if(state.board[a][b] == "x") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a--;
									b++;
								}
							}
							break innerloop;
						}
					}
				}
			}
		}
		if(state.currentPlayer == "o") {
			for(int i = 0; i < state.board.length; i++) {
				for(int j = 0; j < state.board[0].length; j++) {
					if((state.board[i][j] == null)
							&& (((i - 1) >= 0 && (i - 1) < state.board.length && (state.board[i - 1][j] == "x")) || 
									((i + 1) >= 0 && (i + 1) < state.board.length && (state.board[i + 1][j] == "x")) ||
									((j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i][j + 1] == "x")) || 
									((j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i][j - 1] == "x")) || 
									((i + 1) >= 0 && (i + 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i + 1][j + 1] == "x")) || 
									((i - 1) >= 0 && (i - 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i - 1][j - 1] == "x")) || 
									((i + 1) >= 0 && (i + 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i + 1][j - 1] == "x")) || 
									((i - 1) >= 0 && (i - 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i - 1][j + 1] == "x")))) {
						innerloop:
						while(true) {
							if((i - 1) >= 0 && (i - 1) < state.board.length && (state.board[i - 1][j] == "x")) {
								int a = i - 2;
								innerloop2:
								while(a >= 0) {
									if(state.board[a][j] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][j] == null) {
										break innerloop2;
									}
									a--;
								}
							}
							if((i + 1) >= 0 && (i + 1) < state.board.length && (state.board[i + 1][j] == "x")) {
								int a = i + 2;
								innerloop2:
								while(a < state.board.length) {
									if(state.board[a][j] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][j] == null) {
										break innerloop2;
									}
									a++;
								}
							}
							if((j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i][j - 1] == "x")) {
								int b = j - 2;
								innerloop2:
								while(b >= 0) {
									if(state.board[i][b] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[i][b] == null) {
										break innerloop2;
									}
									b--;
								}
							}
							if((j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i][j + 1] == "x")) {
								int b = j + 2;
								innerloop2:
								while(b < state.board.length) {
									if(state.board[i][b] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[i][b] == null) {
										break innerloop2;
									}
									b++;
								}
							}
							if((i + 1) >= 0 && (i + 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i + 1][j + 1] == "x")) {
								int a = i + 2;
								int b = j + 2;
								innerloop2:
								while(a < state.board.length && b < state.board.length) {
									if(state.board[a][b] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a++;
									b++;
								}
							}
							if((i - 1) >= 0 && (i - 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i - 1][j - 1] == "x")) {
								int a = i - 2;
								int b = j - 2;
								innerloop2:
								while(a >= 0 && b >= 0) {
									if(state.board[a][b] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a--;
									b--;
								}
							}
							if((i + 1) >= 0 && (i + 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i + 1][j - 1] == "x")) {
								int a = i + 2;
								int b = j - 2;
								innerloop2:
								while(b >= 0 && a < state.board.length) {
									if(state.board[a][b] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a++;
									b--;
								}
							}
							if((i - 1) >= 0 && (i - 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i - 1][j + 1] == "x")) {
								int a = i - 2;
								int b = j + 2;
								innerloop2:
								while(a >= 0 && b < state.board.length) {
									if(state.board[a][b] == "o") {
										Action action = new Action();
										action.move = "" + (char)('a' + j) + "" + (i + 1);
										possibleActions.add(action);
										break innerloop;
									}
									if(state.board[a][b] == null) {
										break innerloop2;
									}
									a--;
									b++;
								}
							}
							break innerloop;
						}
					}
				}
			}
		}
		return possibleActions;
	}
	
	public boolean checkActions(State state, Action action){
		Action act = new Action();
		for(int i = 0; i < act.getActions(state).size(); i++) {
			if(act.getActions(state).get(i).move.contentEquals(action.move)) {
				return true;
			}
		}
		return false;
		
	}
}
