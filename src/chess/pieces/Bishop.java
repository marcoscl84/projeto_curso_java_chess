package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		//analisa poss�veis posi��es para a pe�a deslocar
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		//analisa valores NW
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		//analisa valores para NE
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		//analisa valores para SE
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		//analisa valores SW
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
