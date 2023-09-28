package chess;

import java.util.ArrayList;

import chess.ReturnPiece.PieceFile;
import chess.ReturnPlay.Message;

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
	 boolean isLegal(PieceFile newFile, int newRank) {
		//should never reach this
		return false;
	}
	void movePeice(PieceFile newFile, int newRank){
		// remove peace if one was located on new position  
		//change peices location in bored
		//remove peice from previous location on bored
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

	
	public static ReturnPlay play(String move) {
		ReturnPlay play=new ReturnPlay();
		//check for resign and draw

	
		//else  get  values for files and ranks
		int prevFileIndex=getFileIndex(move.charAt(0)); 
		int prevRankIndex=getRankIndex(move.charAt(1));
		PieceFile newFile= PieceFile.valueOf(move.substring(3, 4));
		int newRank= move.charAt(4)-48;

		//check for check and check mate
		//check if move is legal(stillneeds to check for turn)
		if(bored[prevRankIndex][prevFileIndex]!=null){//check there is a peace at  location 
			
			
			if(bored[prevRankIndex][prevFileIndex].isLegal(newFile,newRank)){
				bored[prevRankIndex][prevFileIndex].movePeice(newFile, newRank);
			}
		}else{
			//player picked a location with no peice on it
			play.message=Message.ILLEGAL_MOVE;
		}
		
		//put all peices still on bored in array list for return statment, message will be set earlier in function
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				play.piecesOnBoard.add(bored[i][j]);
			}
		}

		return play;
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
	private static int  getFileIndex(char x){
		
		//converts a-0, b-1, etc
		return x-97;
	}
	private static int getRankIndex(char x){
		if(x=='1'){
			return 7;
		}
		else if(x=='2'){
			return 6;
		}
		else if(x=='3'){
			return 5;
		}
		else if(x=='4'){
			return 4;
		}
		else if(x=='5'){
			return 3;
		}
		else if(x=='6'){
			return 2;
		}
		else if(x=='7'){
			return 1;
		}
		else if(x=='8'){
			return 0;
		}else{
			System.out.println("invled input entered");
			return 20;//should never reach this lines
		}
	}
	
}
