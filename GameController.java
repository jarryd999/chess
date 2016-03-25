import Model.Color;
import Model.GameSquare;
import Model.Player;

import java.util.ArrayList;
import java.util.LinkedList;

import Model.Board;

public class GameController {

	public static void main(String[] args) {
		Board game = new Board();
		Player white = new Player(Color.WHITE);
		Player black = new Player(Color.BLACK);

		// let the players keep a list of what square they
		// have pieces on
		for (int i = 0; i < 8; i++) {
			white.addSquare(game.gameBoard[i][0]);
			// white.addSquare(game.gameBoard[i][1]);
			// black.addSquare(game.gameBoard[i][6]);
			black.addSquare(game.gameBoard[i][7]);
		}

		System.out.print(game.toString());
		Color color = Color.WHITE;
		getMoves(white, game.gameBoard);
	}

	public static void getMoves(Player p, GameSquare[][] board) {
		ArrayList<GameSquare> places = p.places;
		ArrayList<GameSquare> validMoves;
		// for each square with a piece on it
		// find out where you can move that piece
		for (GameSquare currentSquare : places) {
			validMoves = new ArrayList<GameSquare>();
			validMoves.addAll(currentSquare.getValidMoves(board));
			for (GameSquare move : validMoves) {
				System.out.printf("%s on %d %d move to %d %d\n", currentSquare.pieceType(), currentSquare.x,
						currentSquare.y, move.x, move.y);
			}
		}
	}

}
