package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		//analisa poss�veis posi��es para a pe�a deslocar
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getColumn());
		//analisa valores ACIMA
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			//faz andar uma linha pra cima e voltar ao in�cio do la�o while enquanto houver posi��es vazias
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow(), position.getColumn() - 1);
		//analisa valores para ESQUERDA
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
			//faz andar uma coluna pra esquerda e voltar ao in�cio do la�o while enquanto houver posi��es vazias
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow(), position.getColumn() + 1);
		//analisa valores para DIREITA
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
			//faz andar uma coluna pra direita e voltar ao in�cio do la�o while enquanto houver posi��es vazias
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn());
		//analisa valores ABAIXO
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� vaga e se positivo, marca como verdadeiro (true)
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			//faz andar uma linha pra baixo e voltar ao in�cio do la�o while enquanto houver posi��es vazias
		}
		if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
			//analisa se posi��o existente est� ocupada e marca como verdadeiro (true)
			//esse movimento ser� a ocupa��o do lugar da pe�a advers�ria
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
