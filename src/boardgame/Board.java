package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
		}//cria o tabuleiro com linhas e colunas igual ou maior que 1. Caso contrário gera erro.
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	//quantidade de linhas e colunas não pode ser alterados, portanto não há o método "setRows" e "setColumns"
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {	
		if(!positionExists(row, column)) {
			//testa ao acessar uma peça se a posição NÃO existe e lança o erro.
			throw new BoardException("Position doesn't exists");
		} 
		//esse método retorna uma peça
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position doesn't exists");
		}
		//esse método é uma sobrecarga do método anterior e retorna uma posição
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			//Exceção lançada caso haja uma peça na posição.
			throw new BoardException("There is already a piece on position " + position);
		} 
		//método para colocar uma peça em uma posição da matriz de peças
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; //peça não está mais em posição nula, mas sim nessa definida.
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position doesn't exists");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		//método auxiliar ao de baixo criado para testar a existência da posição por linha e coluna.
		return row >= 0 && row < rows && column >= 0 && column < columns;
	} 
	
	public boolean positionExists(Position position) {
		//reaproveita o método de cima para testar se existe a posição.
		return positionExists(position.getRow(), position.getColumn());
	} 
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			//testa se a posição existe antes de testar se tem uma peça nessa posição.
			throw new BoardException("There is already a piece on position " + position);
		} 
		//se posição NÃO for nula, existe uma peça nessa posição
		return piece(position) != null;
	}
}
