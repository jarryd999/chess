package Pieces;

import java.util.LinkedList;

import Model.Color;

public class Pawn implements Piece {
	public Color color;

	// constructor
	public Pawn(Color color) {
		this.color = color;
	}

	public String getType() {
		return "Pawn";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();

		// for white pieces, check if there's any room to move
		if (this.color == Color.WHITE && spot.y < 7) {
			// if there's an open spot in front
			// add it to the output list
			if (board[spot.x][spot.y + 1].isAvailable()) {
				output.add(board[spot.x][spot.y + 1]);
				// if on the starting pawn spot, see if it can move two
				if (spot.y == 1) {
					if (board[spot.x][spot.y + 2].isAvailable()
							|| board[spot.x][spot.y + 2].piece.getColor() == Color.BLACK)
						output.add(board[spot.x][spot.y + 2]);
				}
			}
		}
		
		// for black pieces, check if room to move
		if (this.color == Color.BLACK && spot.y > 0) {
			if (board[spot.x][spot.y - 1].isAvailable()) {
				output.add(board[spot.x][spot.y - 1]);
				// if on the starting pawn spot, see if it can move two
				if (spot.y == 6) {
					if (board[spot.x][spot.y - 2].isAvailable()
							|| board[spot.x][spot.y - 2].piece.getColor() == Color.WHITE)
						output.add(board[spot.x][spot.y - 2]);
				}
			}
		}
		
		//check if this Pawn can take a piece diagonally
		output.addAll(pawnKill(spot, board));
		return output;
	}
	/**
	 * Function: 	pawnKill
	 * Description:	check to see if a pawn can diagonally take another piece
	 * @param spot (GameSquare) The current space occupied by this Piece
	 * @param board (GameSquare[][]) The chess board
	 * @return
	 */
	public LinkedList<GameSquare> pawnKill(GameSquare spot, GameSquare[][] board) {
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();
		int x = spot.x, y = spot.y;
		
		//check not on left edge
		if (x > 0){
			//for white, check up
			if (spot.piece.getColor() == Color.WHITE){
				if (!board[x-1][y+1].isAvailable() && board[x-1][y+1].piece.getColor() == Color.BLACK){
					output.add(board[x-1][y+1]);
				}
			}
			//for black, check down
			else{
				if (!board[x-1][y-1].isAvailable() && board[x-1][y-1].piece.getColor() == Color.WHITE){
					output.add(board[x-1][y-1]);
				}
			}
		}
		//check not on right edge
		if (x < 7){
			//for white, check up
			if (spot.piece.getColor() == Color.WHITE){
				if (!board[x+1][y+1].isAvailable() && board[x+1][y+1].piece.getColor() == Color.BLACK){
					output.add(board[x+1][y+1]);
				}
			}
			//for black, check down
			else{
				if (!board[x+1][y-1].isAvailable() && board[x+1][y-1].piece.getColor() == Color.WHITE){
					output.add(board[x+1][y-1]);
				}
			}
		}
		
		
		return output;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}
