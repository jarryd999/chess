package Model;

import java.util.LinkedList;

public class Knight implements Piece {
	public Color color;

	// constructor
	public Knight(Color color) {
		this.color = color;
	}

	public String getType() {
		return "knight";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();
		int x = spot.x, y = spot.y;
		// 8 moves to be made:
		// 1 up, 2 left
		if (y < 7 && x > 1) {
			if (board[x - 2][y + 1].isAvailable() || board[x - 2][y + 1].piece.getColor() != this.color) {
				output.add(board[x - 2][y + 1]);
			}
		}
		// 2up, 1 left
		if (y < 6 && x > 0) {
			if (board[x - 1][y + 2].isAvailable() || board[x - 1][y + 2].piece.getColor() != this.color) {
				output.add(board[x - 1][y + 2]);
			}
		}
		// 1 down, 2 left
		if (y > 0 && x > 1) {
			if (board[x - 2][y - 1].isAvailable() || board[x - 2][y - 1].piece.getColor() != this.color) {
				output.add(board[x - 2][y - 1]);
			}
		}
		// 2 down, 1 left
		if (y > 1 && x > 0) {
			if (board[x - 1][y - 2].isAvailable() || board[x - 1][y - 2].piece.getColor() != this.color) {
				output.add(board[x - 1][y - 2]);
			}
		}
		// 1 up, 2 right
		if (y < 7 && x < 6) {
			if (board[x + 2][y + 1].isAvailable() || board[x + 2][y + 1].piece.getColor() != this.color) {
				output.add(board[x + 2][y + 1]);
			}
		}
		// 2up, 1 right
		if (y < 6 && x < 7) {
			if (board[x + 1][y + 2].isAvailable() || board[x + 1][y + 2].piece.getColor() != this.color) {
				output.add(board[x + 1][y + 2]);
			}
		}
		// 1 down, 2 right
		if (y > 0 && x < 6) {
			if (board[x + 2][y - 1].isAvailable() || board[x + 2][y - 1].piece.getColor() != this.color) {
				output.add(board[x + 2][y - 1]);
			}
		}
		// 2 down, 1 right
		if (y > 1 && x < 7) {
			if (board[x + 1][y - 2].isAvailable() || board[x + 1][y - 2].piece.getColor() != this.color) {
				output.add(board[x + 1][y - 2]);
			}
		}

		return output;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}