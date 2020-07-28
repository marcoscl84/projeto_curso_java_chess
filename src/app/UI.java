package app;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	//https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0); 
			int row = Integer.parseInt(s.substring(1));
			//recorta a string a partir da posição 1 e converte para inteiro
			return new ChessPosition(column, row);
			}
		catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values from 'a1' to 'h8'");
		}
	}

	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn : " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
		if(chessMatch.getCheck()) {
			System.out.println("CHECK!");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			//cria numeração ao lado esquerdo do tabuleiro
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j], false);
				//cria toda linha e pula pra proxima no comando a seguir. False indica que não há fundo colorido
			}
			System.out.println();
			// quebra a linha
		}
		System.out.println("  a b c d e f g h");
		// ultima linha da matriz (tabuleiro)
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			//cria numeração ao lado esquerdo do tabuleiro
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
				/*cria toda linha e pula pra proxima no comando a seguir.
				 * possibleMoves pinta fundo colorido dependendo dessa variável
				 */
			}
			System.out.println();
			// quebra a linha
		}
		System.out.println("  a b c d e f g h");
		// ultima linha da matriz (tabuleiro)
	}
	
	private static void printPiece(ChessPiece piece, boolean background) {
		//imprime uma única peça ou "-"
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece == null) {
			System.out.print("-" + ANSI_RESET);
		}
	    else {
	    	//imprime a peça já incluindo a cor referente
	    	if (piece.getColor() == Color.WHITE) {
	            System.out.print(ANSI_WHITE + piece + ANSI_RESET);
	        }
	        else {
	            System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
	        }
	    }
	    System.out.print(" ");
	}
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		
		//imprime a lista das peças de ambas as cores
		System.out.println("Captured pieces: ");
		System.out.println("White: ");
		System.out.println(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.println(ANSI_RESET);
		
		System.out.println("Black: ");
		System.out.println(ANSI_BLACK);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
	}
}
