package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //se n�o indicar essa posi��o, o compilador j� determina como valor nulo
	}

	protected Board getBoard() {
		return board;
	}
}
