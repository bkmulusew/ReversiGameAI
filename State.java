
class State {
	String board[][];
	String currentPlayer;
	String human;
	String AI;
	
	public State() {
	}
	
	public void initialState(int dimension) {
		this.board = new String[dimension][dimension];
		this.board[dimension / 2][dimension / 2] = "o";
		this.board[(dimension / 2)][(dimension / 2) - 1] = "x";
		this.board[(dimension / 2) - 1][(dimension / 2)] = "x";
		this.board[(dimension / 2) - 1][(dimension / 2) - 1] = "o";
	}
	
	public int countBlack() {
		int black = 0;
		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[0].length; j++) {
				if(this.board[i][j] == "x"){
					black++;
				}
			}
		}
		return black;
	}
	
	public int countWhite() {
		int white = 0;
		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[0].length; j++) {
				if(this.board[i][j] == "o"){
					white++;
				}
			}
		}
		return white;
	}
	
	public void printState() {
		System.out.print('\u0020' + " ");
		char ch = 'a';
		for(int i = 0; i < this.board.length; i++) {
			System.out.print((char)(ch + i) + " ");
		}
		System.out.println();
		for(int i = 0; i < this.board.length; i++) {
			System.out.print((i + 1) + " ");
			for(int j = 0; j < this.board[0].length; j++) {
				if(board[i][j] == null)
					System.out.print('\u0020' + " ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.print((i + 1));
			System.out.println();
		}
		System.out.print('\u0020' + " ");
		for(int i = 0; i < this.board.length; i++) {
			System.out.print((char)(ch + i) + " ");
		}
		System.out.println();
	}
}