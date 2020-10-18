public class Result {
	
	public State getResult(State state, Action action){
		Action act = new Action();
		boolean booll = false;
		for(int i = 0; i < act.getActions(state).size(); i++) {
			if(act.getActions(state).get(i).move.contentEquals(action.move)) {
				booll = true;
			}
		}
		if(booll && state.currentPlayer.contentEquals("x")) {
			int[] ch = new int[action.move.length()]; 
			for (int i = 0; i < action.move.length(); i++) { 
	            ch[i] = (int)action.move.charAt(i);
	        }
			int j = ch[0] - 97;
			int i = ch[1] - 49;
			
			
			
			if((i - 1) >= 0 && (i - 1) < state.board.length && (state.board[i - 1][j] == "o")) {
				boolean bool = false;
				int a = i - 2;
				innerloop:
				while(a >= 0) {
					if(state.board[a][j] == "x") {
						bool = true;
						break innerloop;
					}
					a--;
				}
				if(bool) {
					a = i - 1;
					while(state.board[a][j] != "x") {
						state.board[a][j] = "x";
						a--;
					}
				}
			}
			if((i + 1) >= 0 && (i + 1) < state.board.length && (state.board[i + 1][j] == "o")) {
				boolean bool = false;
				int a = i + 2;
				innerloop:
				while(a < state.board.length) {
					if(state.board[a][j] == "x") {
						bool = true;
						break innerloop;
					}
					a++;
				}
				if(bool) {
					a = i + 1;
					while(state.board[a][j] != "x") {
						state.board[a][j] = "x";
						a++;
					}
				}
			}
			if((j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i][j - 1] == "o")) {
				boolean bool = false;
				int b = j - 2;
				innerloop:
				while(b >= 0) {
					if(state.board[i][b] == "x") {
						bool = true;
						break innerloop;
					}
					b--;
				}
				if(bool) {
					b = j - 1;
					while(state.board[i][b] != "x") {
						state.board[i][b] = "x";
						b--;
					}
				}
			}
			if((j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i][j + 1] == "o")) {
				boolean bool = false;
				int b = j + 2;
				innerloop:
				while(b < state.board.length) {
					if(state.board[i][b] == "x") {
						bool = true;
						break innerloop;
					}
					b++;
				}
				if(bool) {
					b = j + 1;
					while(state.board[i][b] != "x") {
						state.board[i][b] = "x";
						b++;
					}
				}
			}
			if((i + 1) >= 0 && (i + 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i + 1][j + 1] == "o")) {
				boolean bool = false;
				int a = i + 2;
				int b = j + 2;
				innerloop:
				while(a < state.board.length && b < state.board.length) {
					if(state.board[a][b] == "x") {
						bool = true;
						break innerloop;
					}
					a++;
					b++;
				}
				if(bool) {
					a = i + 1;
					b = j + 1;
					while(state.board[a][b] != "x") {
						state.board[a][b] = "x";
						a++;
						b++;
					}
				}
			}
			if((i - 1) >= 0 && (i - 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i - 1][j - 1] == "o")) {
				boolean bool = false;
				int a = i - 2;
				int b = j - 2;
				innerloop:
				while(a >= 0 && b >= 0) {
					if(state.board[a][b] == "x") {
						bool = true;
						break innerloop;
					}
					a--;
					b--;
				}
				if(bool) {
					a = i - 1;
					b = j - 1;
					while(state.board[a][b] != "x") {
						state.board[a][b] = "x";
						a--;
						b--;
					}
				}
			}
			if((i + 1) >= 0 && (i + 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i + 1][j - 1] == "o")) {
				boolean bool = false;
				int a = i + 2;
				int b = j - 2;
				innerloop:
				while(b >= 0 && a < state.board.length) {
					if(state.board[a][b] == "x") {
						bool = true;
						break innerloop;
					}
					a++;
					b--;
				}
				if(bool) {
					a = i + 1;
					b = j - 1;
					while(state.board[a][b] != "x") {
						state.board[a][b] = "x";
						a++;
						b--;
					}
				}
			}
			if((i - 1) >= 0 && (i - 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i - 1][j + 1] == "o")) {
				boolean bool = false;
				int a = i - 2;
				int b = j + 2;
				innerloop:
				while(a >= 0 && b < state.board.length) {
					if(state.board[a][b] == "x") {
						bool = true;
						break innerloop;
					}
					a--;
					b++;
				}
				if(bool) {
					a = i - 1;
					b = j + 1;
					while(state.board[a][b] != "x") {
						state.board[a][b] = "x";
						a--;
						b++;
					}
				}
			}
			state.board[i][j] = "x";
			state.currentPlayer = "o";
		}
		
		
		else if(booll && state.currentPlayer.contentEquals("o")) {
			int[] ch = new int[action.move.length()]; 
			for (int i = 0; i < action.move.length(); i++) { 
	            ch[i] = (int)action.move.charAt(i);
	        }
			int j = ch[0] - 97;
			int i = ch[1] - 49;
			
			
			
			if((i - 1) >= 0 && (i - 1) < state.board.length && (state.board[i - 1][j] == "x")) {
				boolean bool = false;
				int a = i - 2;
				innerloop:
				while(a >= 0) {
					if(state.board[a][j] == "o") {
						bool = true;
						break innerloop;
					}
					a--;
				}
				if(bool) {
					a = i - 1;
					while(state.board[a][j] != "o") {
						state.board[a][j] = "o";
						a--;
					}
				}
			}
			if((i + 1) >= 0 && (i + 1) < state.board.length && (state.board[i + 1][j] == "x")) {
				boolean bool = false;
				int a = i + 2;
				innerloop:
				while(a < state.board.length) {
					if(state.board[a][j] == "o") {
						bool = true;
						break innerloop;
					}
					a++;
				}
				if(bool) {
					a = i + 1;
					while(state.board[a][j] != "o") {
						state.board[a][j] = "o";
						a++;
					}
				}
			}
			if((j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i][j - 1] == "x")) {
				boolean bool = false;
				int b = j - 2;
				innerloop:
				while(b >= 0) {
					if(state.board[i][b] == "o") {
						bool = true;
						break innerloop;
					}
					b--;
				}
				if(bool) {
					b = j - 1;
					while(state.board[i][b] != "o") {
						state.board[i][b] = "o";
						b--;
					}
				}
			}
			if((j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i][j + 1] == "x")) {
				boolean bool = false;
				int b = j + 2;
				innerloop:
				while(b < state.board.length) {
					if(state.board[i][b] == "o") {
						bool = true;
						break innerloop;
					}
					b++;
				}
				if(bool) {
					b = j + 1;
					while(state.board[i][b] != "o") {
						state.board[i][b] = "o";
						b++;
					}
				}
			}
			if((i + 1) >= 0 && (i + 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i + 1][j + 1] == "x")) {
				boolean bool = false;
				int a = i + 2;
				int b = j + 2;
				innerloop:
				while(a < state.board.length && b < state.board.length) {
					if(state.board[a][b] == "o") {
						bool = true;
						break innerloop;
					}
					a++;
					b++;
				}
				if(bool) {
					a = i + 1;
					b = j + 1;
					while(state.board[a][b] != "o") {
						state.board[a][b] = "o";
						a++;
						b++;
					}
				}
			}
			if((i - 1) >= 0 && (i - 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i - 1][j - 1] == "x")) {
				boolean bool = false;
				int a = i - 2;
				int b = j - 2;
				innerloop:
				while(a >= 0 && b >= 0) {
					if(state.board[a][b] == "o") {
						bool = true;
						break innerloop;
					}
					a--;
					b--;
				}
				if(bool) {
					a = i - 1;
					b = j - 1;
					while(state.board[a][b] != "o") {
						state.board[a][b] = "o";
						a--;
						b--;
					}
				}
			}
			if((i + 1) >= 0 && (i + 1) < state.board.length && (j - 1) >= 0 && (j - 1) < state.board.length && (state.board[i + 1][j - 1] == "x")) {
				boolean bool = false;
				int a = i + 2;
				int b = j - 2;
				innerloop:
				while(b >= 0 && a < state.board.length) {
					if(state.board[a][b] == "o") {
						bool = true;
						break innerloop;
					}
					a++;
					b--;
				}
				if(bool) {
					a = i + 1;
					b = j - 1;
					while(state.board[a][b] != "o") {
						state.board[a][b] = "o";
						a++;
						b--;
					}
				}
			}
			if((i - 1) >= 0 && (i - 1) < state.board.length && (j + 1) >= 0 && (j + 1) < state.board.length && (state.board[i - 1][j + 1] == "x")) {
				boolean bool = false;
				int a = i - 2;
				int b = j + 2;
				innerloop:
				while(a >= 0 && b < state.board.length) {
					if(state.board[a][b] == "o") {
						bool = true;
						break innerloop;
					}
					a--;
					b++;
				}
				if(bool) {
					a = i - 1;
					b = j + 1;
					while(state.board[a][b] != "o") {
						state.board[a][b] = "o";
						a--;
						b++;
					}
				}
			}
			state.board[i][j] = "o";
			state.currentPlayer = "x";
		}
		return state;
	}
}







