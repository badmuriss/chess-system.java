package boardgame;

public class Board {

	protected Position position;
	private Board board;
	
	public Board(Board board) {
		this.board = board;
        position = null;	
	}
	
	protected Board getBoard() { 
		return board;
	}
	
	
}
