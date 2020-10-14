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
		//analisa possíveis posições para a peça deslocar
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		//analisa valores NW
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está ocupada e marca como verdadeiro (true)
			//esse movimento será a ocupação do lugar da peça adversária
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		//analisa valores para NE
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está ocupada e marca como verdadeiro (true)
			//esse movimento será a ocupação do lugar da peça adversária
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		//analisa valores para SE
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está ocupada e marca como verdadeiro (true)
			//esse movimento será a ocupação do lugar da peça adversária
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		//analisa valores SW
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posição existente está ocupada e marca como verdadeiro (true)
			//esse movimento será a ocupação do lugar da peça adversária
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
