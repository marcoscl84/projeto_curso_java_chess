package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //se não indicar essa posição, o compilador já determina como valor nulo
	}

	protected Board getBoard() {
		return board;
	}
}
