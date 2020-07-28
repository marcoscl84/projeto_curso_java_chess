package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error. Valid values: a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	//para o toString, orientações abaixo
	//matrix_row = 8 - chess_row
	/*para colunas que são referenciadas por caractere, utiliza-se código unicode
	 * unicode 'a'-'a'= 0
	 * unicode 'b'-'a'= 1
	 * unicode 'c'-'a'= 2
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		//retorna formula inversa do método toPosition
		return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
		// "" (string vazio) macete para o compilador a entender que é uma concateção de strings 
	}
}
