package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //se não indicar essa posição, o compilador já determina como valor nulo
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	//operação genérica de possibilidades de movimentos da peça
	
	public boolean possibleMove(Position position) {
		/* Método concreto utilizando método abstrato. Método faz um gancho com 
		 * com a subclasse.
		 */
		return possibleMoves()[position.getRow()][position.getColumn()];
		//chama uma possível implementação de alguma subclasse concreta da classe piece
	}
	
	public boolean isThereAnyPossibleMove() {
		//método varre a matriz para ver se há alguma posição da matriz verdadeira para a peça mover.
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
