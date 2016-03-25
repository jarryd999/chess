package Model;

public class Board {

	public GameSquare[][] gameBoard = new GameSquare[8][8];
	//default constrcutor, add in pieces at default locations
	public Board(){
		PieceFactory factory = new PieceFactory();
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				gameBoard[i][j] = new GameSquare(i,j);
			}
		}
		//fill in pawns
//		for (int i = 0; i < 8; i++){
//			gameBoard[i][1].addPiece(factory.getPiece("pawn", Color.WHITE));
//			gameBoard[i][6].addPiece(factory.getPiece("pawn", Color.BLACK));
//		}
		
		//fill in Rooks
		gameBoard[0][0].addPiece(factory.getPiece("rook", Color.WHITE));
		gameBoard[7][0].addPiece(factory.getPiece("rook", Color.WHITE));
		gameBoard[0][7].addPiece(factory.getPiece("rook", Color.BLACK));
		gameBoard[7][7].addPiece(factory.getPiece("rook", Color.BLACK));
		
		//add Knights
		gameBoard[1][0].addPiece(factory.getPiece("knight", Color.WHITE));
		gameBoard[6][0].addPiece(factory.getPiece("knight", Color.WHITE));
		gameBoard[1][7].addPiece(factory.getPiece("knight", Color.BLACK));
		gameBoard[6][7].addPiece(factory.getPiece("knight", Color.BLACK));
		
		//add Bishops
		gameBoard[2][0].addPiece(factory.getPiece("bishop", Color.WHITE));
		gameBoard[5][0].addPiece(factory.getPiece("bishop", Color.WHITE));
		gameBoard[2][7].addPiece(factory.getPiece("bishop", Color.WHITE));
		gameBoard[5][7].addPiece(factory.getPiece("bishop", Color.WHITE));
		
		//add Queens
		gameBoard[3][0].addPiece(factory.getPiece("queen", Color.WHITE));
		gameBoard[4][7].addPiece(factory.getPiece("queen", Color.BLACK));
		
		//add Kings
		gameBoard[4][0].addPiece(factory.getPiece("king", Color.WHITE));
		gameBoard[3][7].addPiece(factory.getPiece("king", Color.BLACK));
	}
	
	public String toString(){
		StringBuffer output = new StringBuffer();
		GameSquare current;
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				current = gameBoard[i][j];
				if (current.isAvailable()){
					output.append("_ ");
				}
				else{
					switch (gameBoard[i][j].piece.getType()){
					case "pawn":
						output.append("p ");
						break;
					case "rook":
						output.append("r ");
						break;
					case "knight":
						output.append("k ");
						break;
					case "bishop":
						output.append("b ");
						break;
					case "queen":
						output.append("q ");
						break;
					case "king":
						output.append("K ");
						break;
					}
				}
			}//end of inner for
			output.append("\n");
		}
		return output.toString();
	}

	//identify all legal moves given a certain player color
	public void getMoves(Color color) {
		Piece curr;
		//loop through the board 
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (!gameBoard[i][j].isAvailable()){
					//grab the piece
					curr = gameBoard[i][j].piece;
					if (curr.getColor() == color){
						
					}
				}
			}
		}
		
	}
}
