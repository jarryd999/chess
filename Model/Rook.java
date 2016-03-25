package Model;

import java.util.LinkedList;

public class Rook implements Piece {
	public Color color;

	// constructor
	public Rook(Color color) {
		this.color = color;
	}

	public String getType() {
		return "rook";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		int x = spot.x, y = spot.y;
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();

		// 4 directions to move,
		// can keep going until a piece is in the way

		// up
		if (y < 7) {
			for (int i = y + 1; i < 8; i++) {
				if (board[x][i].isAvailable()) {
					output.add(board[x][i]);
				} else if (board[x][i].piece.getColor() != this.color) {
					output.add(board[x][i]);
					break;
				} else
					break;
			}
		}

		// down
		if (y > 0) {
			for (int i = y - 1; i >= 0; i--) {
				if (board[x][i].isAvailable()) {
					output.add(board[x][i]);
				} else if (board[x][i].piece.getColor() != this.color) {
					output.add(board[x][i]);
					break;
				} else
					break;
			}
		}
		// left
		if (x < 7) {
			for (int i = x + 1; i < 8; i++) {
				if (board[i][y].isAvailable()) {
					output.add(board[i][y]);
				} else if (board[i][y].piece.getColor() != this.color) {
					output.add(board[i][y]);
					break;
				} else
					break;
			}
		}
		// right
		if (x > 0) {
			for (int i = x - 1; i >= 0; i--) {
				if (board[i][y].isAvailable()) {
					output.add(board[i][y]);
				} else if (board[i][y].piece.getColor() != this.color) {
					output.add(board[i][y]);
					break;
				} else
					break;
			}
		}
		return output;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}