package chess;

import java.util.ArrayList;

class ReturnPiece {
	static enum PieceType {WP, WR, WN, WB, WQ, WK, 
		            BP, BR, BN, BB, BK, BQ};
	static enum PieceFile {a, b, c, d, e, f, g, h};
	
	PieceType pieceType;
	PieceFile pieceFile;
	int pieceRank;  // 1..8
	public String toString() {
		return ""+pieceFile+pieceRank+":"+pieceType;
	}
	public boolean equals(Object other) {
		if (other == null || !(other instanceof ReturnPiece)) {
			return false;
		}
		ReturnPiece otherPiece = (ReturnPiece)other;
		return pieceType == otherPiece.pieceType &&
				pieceFile == otherPiece.pieceFile &&
				pieceRank == otherPiece.pieceRank;
	}
}

class ReturnPlay {
	enum Message {ILLEGAL_MOVE, DRAW, 
				  RESIGN_BLACK_WINS, RESIGN_WHITE_WINS, 
				  CHECK, CHECKMATE_BLACK_WINS,	CHECKMATE_WHITE_WINS, 
				  STALEMATE};
	
	ArrayList<ReturnPiece> piecesOnBoard;
	Message message;
}

public class Chess {
	
	enum Player { white, black }

	private  static ReturnPiece[][] bored= new ReturnPiece[8][8];
	int x;

	
	/**
	 * Plays the next move for whichever player has the turn.
	 * 
	 * @param move String for next move, e.g. "a2 a3"
	 * 
	 * @return A ReturnPlay instance that contains the result of the move.
	 *         See the section "The Chess class" in the assignment description for details of
	 *         the contents of the returned ReturnPlay instance.
	 */
	public static ReturnPlay play(String move) {
		

		/* FILL IN THIS METHOD */
		
		/* FOLLOWING LINE IS A PLACEHOLDER TO MAKE COMPILER HAPPY */
		/* WHEN YOU FILL IN THIS METHOD, YOU NEED TO RETURN A ReturnPlay OBJECT */
		return null;
	}
	
	
	/**
	 * This method should reset the game, and start from scratch.
	 */
	//empty the bored
	public static void start() {
	emptyBored();
	setBored();	
	}

	private static void emptyBored(){
		for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			bored[i][j]=null;
		}
	}
	}
	private static void setBored(){
		//set all pawns
		int rowVal=0;
		for(ReturnPiece.PieceFile x:ReturnPiece.PieceFile.values()){
			bored[1][rowVal]=new Pawn(ReturnPiece.PieceType.BP,x,7);
			rowVal++;
		}
		rowVal=0;
		for(ReturnPiece.PieceFile x:ReturnPiece.PieceFile.values()){
			bored[6][rowVal]=new Pawn(ReturnPiece.PieceType.WP,x,2);
			rowVal++;
		}

		//set rest
		//black
		bored[0][0]= new Rook(ReturnPiece.PieceType.BR,ReturnPiece.PieceFile.a,8);
		bored[0][1]= new Knight(ReturnPiece.PieceType.BN,ReturnPiece.PieceFile.b,8);
		bored[0][2]= new Bishop(ReturnPiece.PieceType.BB,ReturnPiece.PieceFile.c,8);
		bored[0][3]= new King(ReturnPiece.PieceType.BK,ReturnPiece.PieceFile.d,8);
		bored[0][4]= new Queen(ReturnPiece.PieceType.BQ,ReturnPiece.PieceFile.e,8);
		bored[0][5]= new Bishop(ReturnPiece.PieceType.BB,ReturnPiece.PieceFile.f,8);
		bored[0][6]= new Knight(ReturnPiece.PieceType.BK,ReturnPiece.PieceFile.g,8);
		bored[0][7]= new Rook(ReturnPiece.PieceType.BR,ReturnPiece.PieceFile.h,8);

		//white
		bored[7][0]= new Rook(ReturnPiece.PieceType.WR,ReturnPiece.PieceFile.a,1);
		bored[7][1]= new Knight(ReturnPiece.PieceType.WN,ReturnPiece.PieceFile.b,1);
		bored[7][2]= new Bishop(ReturnPiece.PieceType.WB,ReturnPiece.PieceFile.c,1);
		bored[7][3]= new King(ReturnPiece.PieceType.WK,ReturnPiece.PieceFile.d,1);
		bored[7][4]= new Queen(ReturnPiece.PieceType.WQ,ReturnPiece.PieceFile.e,1);
		bored[7][5]= new Bishop(ReturnPiece.PieceType.WB,ReturnPiece.PieceFile.f,1);
		bored[7][6]= new Knight(ReturnPiece.PieceType.WK,ReturnPiece.PieceFile.g,1);
		bored[7][7]= new Rook(ReturnPiece.PieceType.WR,ReturnPiece.PieceFile.h,1);

	}
 
	
}
