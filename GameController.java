
/**
 * Author:			Jarryd Goodman
 * Date:			3/25/16
 * Class:			GameController
 * Description:		Main class for controller, takes in a list of arguments containing filenames
 * 					of files that will have a board setup and a player whose turn it is (white/black).
 * 					If no input file is specified, uses initial chess setup and white player turn.
 * 					For each file specified, program will print a list of possible moves for given
 * 					player, the number of possible moves, and the number of unique pieces that can be
 * 					moved.
 */

import Model.Color;
import Model.Player;
import Pieces.Board;
import Pieces.GameSquare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameController {

	public static void main(String[] args) throws IOException {

		Player white = new Player(Color.WHITE);
		Player black = new Player(Color.BLACK);

		// if arguments passed in
		// generate output based on files
		if (args.length > 0) {
			File file = new File(args[0]);
			BufferedReader buffer = new BufferedReader(new FileReader(file));

			// read the board setup
			StringBuffer inputBuffer = new StringBuffer();
			for (int j = 0; j < 8; j++)
				inputBuffer.append(buffer.readLine() + '\n');
			String boardInput = inputBuffer.toString();
			
			//read the player input
			String playerInput = buffer.readLine();
			Player playerSelection;
			//set player choice based on input file
			if (playerInput.toLowerCase().trim().equals("white"))
				playerSelection = white;
			else
				playerSelection = black;

			// for initial board setup, use default constructor
			// otherwise, modify inputBoard file to edit
			Board game = new Board(boardInput, white, black);

			// print out the input file name
			System.out.println(args[0]);
			// print the board setup
			System.out.print(game.toString());

			// get a list of valid moves and print them out
			// choose which player who's moves you would like to see
			// with the first actual parameter
			getMoves(playerSelection, game.gameBoard);
			System.out.println();
			buffer.close();
		}
		// if no arguments, do initial chess setup/white player's turn
		else {
			Pieces.Board game = new Board();
			// give players a list of pieces they have
			for (int i = 0; i < 8; i++) {
				white.addSquare(game.gameBoard[i][0]);
				white.addSquare(game.gameBoard[i][1]);
				black.addSquare(game.gameBoard[i][6]);
				black.addSquare(game.gameBoard[i][7]);
			}
			//print the game board
			//then get & print list of possible moves
			System.out.println(game.toString());
			getMoves(white, game.gameBoard);
		}

	}

	/**
	 * Function: getMoves(p, board) Description: Prints out a list of possible
	 * moves, number of moves, and unique pieces that can be moved
	 * 
	 * @param p
	 *            The Player whose turn it is
	 * @param board
	 *            The GameSquare[][] representing the chess board setup
	 * 
	 * @return None
	 */
	public static void getMoves(Player p, GameSquare[][] board) {
		// keep track of the number of possible moves
		// and number of unique pieces you could move
		int moveCount = 0;
		int uniquePieceCount = 0;

		ArrayList<GameSquare> playerSpotsWithPieces = p.places;
		ArrayList<GameSquare> validMoves;

		// for each square with a piece on it
		// find out where you can move that piece
		for (GameSquare currentSquare : playerSpotsWithPieces) {
			validMoves = new ArrayList<GameSquare>();

			// grab all valid moves from
			validMoves.addAll(currentSquare.getValidMoves(board));
			if (validMoves.size() > 0)
				uniquePieceCount++;
			for (GameSquare move : validMoves) {
				System.out.printf("%s at <%d:%d> can move to <%d:%d>\n", currentSquare.pieceType(), currentSquare.x,
						currentSquare.y, move.x, move.y);
				moveCount++;
			}
		}

		// print the number of possible moves and number of unique pieces that
		// can be moved
		System.out.printf("%d legal moves (%d unique pieces) for %s player", moveCount, uniquePieceCount,
				p.color.toString().toLowerCase());

	}

}
