package Model;

import java.util.LinkedList;

public class Pawn implements Piece {
	public Color color;

	// constructor
	public Pawn(Color color) {
		this.color = color;
	}

	public String getType() {
		return "pawn";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();

		// for white pieces, check if there's any room to move
		if (this.color == Color.WHITE && spot.y < 7) {
			// if there's an open spot in front, or a black piece on the next
			// spot
			// add it to the output list
			if (board[spot.x][spot.y + 1].isAvailable() || board[spot.x][spot.y + 1].piece.getColor() == Color.BLACK) {
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
			if (board[spot.x][spot.y - 1].isAvailable() || board[spot.x][spot.y - 1].piece.getColor() == Color.WHITE) {
				output.add(board[spot.x][spot.y - 1]);
				// if on the starting pawn spot, see if it can move two
				if (spot.y == 6) {
					if (board[spot.x][spot.y - 2].isAvailable()
							|| board[spot.x][spot.y - 2].piece.getColor() == Color.WHITE)
						output.add(board[spot.x][spot.y - 2]);
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
