package Pieces;

import java.util.LinkedList;

import Model.Color;

public class King implements Piece {
	public Color color;

	// constructor
	public King(Color color) {
		this.color = color;
	}

	public String getType() {
		return "King";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		int x = spot.x, y = spot.y;
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();

		// 8 directions:
		// up
		if (y < 7) {
			int i = y + 1;
			if (board[x][i].isAvailable()) {
				output.add(board[x][i]);
			} else if (board[x][i].piece.getColor() != this.color) {
				output.add(board[x][i]);
			}
		}

		// down
		if (y > 0) {
			int i = y - 1;
			if (board[x][i].isAvailable()) {
				output.add(board[x][i]);
			} else if (board[x][i].piece.getColor() != this.color) {
				output.add(board[x][i]);
			}
		}
		// right
		if (x < 7) {
			int i = x + 1;
			if (board[i][y].isAvailable()) {
				output.add(board[i][y]);
			} else if (board[i][y].piece.getColor() != this.color) {
				output.add(board[i][y]);
			}

		}
		// left
		if (x > 0) {
			int i = x - 1;
			if (board[i][y].isAvailable()) {
				output.add(board[i][y]);
			} else if (board[i][y].piece.getColor() != this.color) {
				output.add(board[i][y]);
			}
		}
		// up right
		if (x < 7 && y < 7) {
			int i = 1;
			if (board[x + i][y + i].isAvailable())
				output.add(board[x + i][y + i]);
			else {
				if (board[x + i][y + i].piece.getColor() != this.color)
					output.add(board[x + i][y + i]);
			}
		}

		// down right
		if (x < 7 && y > 0) {
			int i = 1;
			if (board[x + i][y - i].isAvailable())
				output.add(board[x + i][y - i]);
			else {
				if (board[x + i][y - i].piece.getColor() != this.color)
					output.add(board[x + i][y - i]);
			}
			i++;
		}

		// up left
		if (x > 0 && y < 7) {
			int i = 1;
			if (board[x - i][y + i].isAvailable())
				output.add(board[x - i][y + i]);
			else {
				if (board[x - i][y + i].piece.getColor() != this.color)
					output.add(board[x - i][y + i]);
			}
			i++;
		}

		// up right
		if (x > 0 && y > 0) {
			int i = 1;
			if (board[x - i][y - i].isAvailable())
				output.add(board[x - i][y - i]);
			else {
				if (board[x - i][y - i].piece.getColor() != this.color)
					output.add(board[x - i][y - i]);
			}
			i++;

		}
		return output;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}