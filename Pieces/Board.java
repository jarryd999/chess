package Pieces;

import java.io.IOException;
import java.util.Scanner;

import Model.Color;
import Model.Player;

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
		for (int i = 0; i < 8; i++){
			gameBoard[i][1].addPiece(factory.getPiece("pawn", Color.WHITE));
			gameBoard[i][6].addPiece(factory.getPiece("pawn", Color.BLACK));
		}
		
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
	
	//construct board from file
	public Board(String boardInput, Player p1, Player p2) throws IOException{
		//initialize board and piece factory
		PieceFactory factory = new PieceFactory();
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				gameBoard[i][j] = new GameSquare(i,j);
			}
		}
		
        Scanner scanner = new Scanner(boardInput);
        String line;
        for (int i = 0; i < 8; i++){
        	line = scanner.nextLine();
        	line = line.trim();
        	for (int j = 0; j < 8; j++){
        		switch (line.charAt(j)){
        		//for white (lowercase)
        		case 'p':
        			gameBoard[i][j].addPiece(factory.getPiece("pawn", Color.WHITE));
        			break;
        		case 'r':
        			gameBoard[i][j].addPiece(factory.getPiece("rook", Color.WHITE));
        			break;
        		case 'n':
        			gameBoard[i][j].addPiece(factory.getPiece("knight", Color.WHITE));
        			break;
        		case 'b':
        			gameBoard[i][j].addPiece(factory.getPiece("bishop", Color.WHITE));
        			break;
        		case 'q':
        			gameBoard[i][j].addPiece(factory.getPiece("queen", Color.WHITE));
        			break;
        		case 'k':
    				gameBoard[i][j].addPiece(factory.getPiece("king", Color.WHITE));
    				break;
    				
    			//for black (uppercase)
        		case 'P':
        			gameBoard[i][j].addPiece(factory.getPiece("pawn", Color.BLACK));
        			break;
        		case 'R':
        			gameBoard[i][j].addPiece(factory.getPiece("rook", Color.BLACK));
        			break;
        		case 'N':
        			gameBoard[i][j].addPiece(factory.getPiece("knight", Color.BLACK));
        			break;
        		case 'B':
        			gameBoard[i][j].addPiece(factory.getPiece("bishop", Color.BLACK));
        			break;
        		case 'Q':
        			gameBoard[i][j].addPiece(factory.getPiece("queen", Color.BLACK));
        			break;
        		case 'K':
        			gameBoard[i][j].addPiece(factory.getPiece("king", Color.BLACK));
        			break;
        		}
        		if (!gameBoard[i][j].isAvailable()){
	        		if (gameBoard[i][j].piece.getColor() == Color.WHITE)
	        			p1.addSquare(gameBoard[i][j]);
	        		else
	        			p2.addSquare(gameBoard[i][j]);
        		}
        	}
        }
        scanner.close();
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
					case "Pawn":
						output.append("p ");
						break;
					case "Rook":
						output.append("r ");
						break;
					case "Knight":
						output.append("k ");
						break;
					case "Bishop":
						output.append("b ");
						break;
					case "Queen":
						output.append("q ");
						break;
					case "King":
						output.append("K ");
						break;
					}
				}
			}//end of inner for
			output.append("\n");
		}
		return output.toString();
	}


}
