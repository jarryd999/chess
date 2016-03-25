package Pieces;

import java.util.LinkedList;

public class GameSquare {
	public int x, y;
	public Piece piece;
	
	public GameSquare(int x, int y){
		this.x = x;
		this.y = y;
		this.piece = null;
	}
	
	public boolean addPiece(Piece piece){
		//make sure it's not already occupied
		if (this.piece != null)
			return false;
		else{
			this.piece = piece;
			return true;
		}
	}
	
	public boolean isAvailable(){
		return this.piece == null;
	}
	
	public void clearSquare(){
		this.piece = null;
	}
	
	public String pieceType(){
		return this.piece.getType();
	}
	
	public LinkedList<GameSquare> getValidMoves(GameSquare[][] board){
		if (!this.isAvailable())
			return piece.getValidMoves(this, board);
		return new LinkedList<GameSquare>();
	}
}
