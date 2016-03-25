package Pieces;

import java.util.LinkedList;

import Model.Color;

public class Queen implements Piece {
	public Color color;

	// constructor
	public Queen(Color color) {
		this.color = color;
	}

	public String getType() {
		return "Queen";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		int x = spot.x, y = spot.y;
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();

		// 8 directions:
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
		// up right
		if (x < 7 && y < 7) {
			int i = 1;
			while (x + i < 8 && y + i < 8) {
				if (board[x + i][y + i].isAvailable())
					output.add(board[x + i][y + i]);
				else {
					if (board[x + i][y + i].piece.getColor() != this.color)
						output.add(board[x + i][y + i]);
					break;
				}
				i++;
			}
		}

		// down right
		if (x < 7 && y > 0) {
			int i = 1;
			while (x + i < 8 && y - i >= 0) {
				if (board[x + i][y - i].isAvailable())
					output.add(board[x + i][y - i]);
				else {
					if (board[x + i][y - i].piece.getColor() != this.color)
						output.add(board[x + i][y - i]);
					break;
				}
				i++;
			}
		}

		// up left
		if (x > 0 && y < 7) {
			int i = 1;
			while (x - i >= 0 && y + i < 8) {
				if (board[x - i][y + i].isAvailable())
					output.add(board[x - i][y + i]);
				else {
					if (board[x - i][y + i].piece.getColor() != this.color)
						output.add(board[x - i][y + i]);
					break;
				}
				i++;
			}
		}

		// up right
		if (x > 0 && y > 0) {
			int i = 1;
			while (x - i >= 0 && y - i >= 0) {
				if (board[x - i][y - i].isAvailable())
					output.add(board[x - i][y - i]);
				else {
					if (board[x - i][y - i].piece.getColor() != this.color)
						output.add(board[x - i][y - i]);
					break;
				}
				i++;
			}
		}
		return output;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}