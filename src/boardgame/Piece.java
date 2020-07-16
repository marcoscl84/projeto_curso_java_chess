package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //se n�o indicar essa posi��o, o compilador j� determina como valor nulo
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	//opera��o gen�rica de possibilidades de movimentos da pe�a
	
	public boolean possibleMove(Position position) {
		/* M�todo concreto utilizando m�todo abstrato. M�todo faz um gancho com 
		 * com a subclasse.
		 */
		return possibleMoves()[position.getRow()][position.getColumn()];
		//chama uma poss�vel implementa��o de alguma subclasse concreta da classe piece
	}
	
	public boolean isThereAnyPossibleMove() {
		//m�todo varre a matriz para ver se h� alguma posi��o da matriz verdadeira para a pe�a mover.
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
