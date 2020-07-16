package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
		}//cria o tabuleiro com linhas e colunas igual ou maior que 1. Caso contr�rio gera erro.
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	//quantidade de linhas e colunas n�o pode ser alterados, portanto n�o h� o m�todo "setRows" e "setColumns"
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {	
		if(!positionExists(row, column)) {
			//testa ao acessar uma pe�a se a posi��o N�O existe e lan�a o erro.
			throw new BoardException("Position doesn't exists");
		} 
		//esse m�todo retorna uma pe�a
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position doesn't exists");
		}
		//esse m�todo � uma sobrecarga do m�todo anterior e retorna uma posi��o
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			//Exce��o lan�ada caso haja uma pe�a na posi��o.
			throw new BoardException("There is already a piece on position " + position);
		} 
		//m�todo para colocar uma pe�a em uma posi��o da matriz de pe�as
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; //pe�a n�o est� mais em posi��o nula, mas sim nessa definida.
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
		//m�todo auxiliar ao de baixo criado para testar a exist�ncia da posi��o por linha e coluna.
		return row >= 0 && row < rows && column >= 0 && column < columns;
	} 
	
	public boolean positionExists(Position position) {
		//reaproveita o m�todo de cima para testar se existe a posi��o.
		return positionExists(position.getRow(), position.getColumn());
	} 
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			//testa se a posi��o existe antes de testar se tem uma pe�a nessa posi��o.
			throw new BoardException("There is already a piece on position " + position);
		} 
		//se posi��o N�O for nula, existe uma pe�a nessa posi��o
		return piece(position) != null;
	}
}
