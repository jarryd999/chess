package Pieces;

import java.util.LinkedList;

import Model.Color;

public class Bishop implements Piece {
	public Color color;

	// constructor
	public Bishop(Color color) {
		this.color = color;
	}

	public String getType() {
		return "Bishop";
	}

	@Override
	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board) {
		int x = spot.x, y = spot.y;
		LinkedList<GameSquare> output = new LinkedList<GameSquare>();

		// can move 4 directions:
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
