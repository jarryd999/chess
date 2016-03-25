import Model.Color;
import Model.Player;
import Pieces.Board;
import Pieces.GameSquare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameController {

	public static void main(String[] args) throws IOException {

		Player white = new Player(Color.WHITE);
		Player black = new Player(Color.BLACK);
		
		//for initial board setup, use default constructor
		//otherwise, modify inputBoard file to edit
		Board game = new Board("inputBoard", white, black);

		// print out the board
		System.out.print(game.toString());

		// get a list of valid moves and print them out
		//choose which player who's moves you would like to see
		//with the first actual parameter
		getMoves(white, game.gameBoard);
	}

	public static void getMoves(Player p, GameSquare[][] board) {
		ArrayList<GameSquare> places = p.places;
		ArrayList<GameSquare> validMoves;
		// for each square with a piece on it
		// find out where you can move that piece
		int moveCount = 0;
		int uniquePieceCount = 0;
		for (GameSquare currentSquare : places) {
			validMoves = new ArrayList<GameSquare>();
			validMoves.addAll(currentSquare.getValidMoves(board));
			if (validMoves.size() > 0)
				uniquePieceCount++;
			for (GameSquare move : validMoves) {
				System.out.printf("%s at <%d:%d> can move to <%d:%d>\n", currentSquare.pieceType(),
						currentSquare.x, currentSquare.y, move.x, move.y);
				moveCount++;
			}
		}
		System.out.printf("%d legal moves (%d unique pieces) for %s player", moveCount, uniquePieceCount,
				p.color.toString().toLowerCase());

	}

}
