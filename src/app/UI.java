package app;

import chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			//cria numeração ao lado esquerdo do tabuleiro
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
				//cria toda linha e pula pra proxima no comando a seguir
			}
			System.out.println();
			// quebra a linha
		}
		System.out.println("  a b c d e f g h");
		// ultima linha da matriz (tabuleiro)
	}
	
	private static void printPiece(ChessPiece piece) {
		//imprime uma única peça ou "-"
		if (piece == null) {
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
