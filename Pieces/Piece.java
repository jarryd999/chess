package Pieces;

import java.util.LinkedList;

import Model.Color;

public interface Piece {
	public String getType();

	public LinkedList<GameSquare> getValidMoves(GameSquare spot, GameSquare[][] board);

	public Color getColor();
}

class PieceFactory {
	public Piece getPiece(String pieceType, Color color) {
		switch (pieceType) {
		case "pawn":
			return new Pawn(color);
		case "knight":
			return new Knight(color);
		case "rook":
			return new Rook(color);
		case "bishop":
			return new Bishop(color);
		case "queen":
			return new Queen(color);
		case "king":
			return new King(color);
		}
		return null;
	}
}