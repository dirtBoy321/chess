//Joshua Clayton
package chess;


import java.util.ArrayList;
import chess.Piece.Color;
import chess.ReturnPlay.Message;

class ReturnPiece {
	static enum PieceType {WP, WR, WN, WB, WQ, WK, 
		            BP, BR, BN, BB, BK, BQ};
	static enum PieceFile {a, b, c, d, e, f, g, h;}
	
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

	static Player turn=Player.white;

	static Piece[][] bored= new Piece[8][8];
	
	static Piece checkDst;

	static boolean checkFlag=false;

	static int checkCount=0;

	static Piece enpasantablPiece=null;
	


	

	
	public static ReturnPlay play(String move) {
		ReturnPlay play=new ReturnPlay();
		play.piecesOnBoard = new ArrayList<ReturnPiece>();
		move=move.trim();

		if(enpasantablPiece!=null){
			if(enpasantablPiece.player==Color.white&&turn==Player.white){
				enpasantablPiece=null;
			}else if(enpasantablPiece.player==Color.black&&turn==Player.black){
				enpasantablPiece=null;
			}
		}

		//check for resign
		if(move.equals("resign")){
			if(turn==Player.white){
				play.message=Message.RESIGN_BLACK_WINS;
			}else if(turn==Player.black){
				play.message=Message.RESIGN_WHITE_WINS;
			}
		}else{//read in move values
		//else  get  values for files and ranks
		int prevFileIndex=getFileIndex(move.charAt(0)); 
		int prevRankIndex=getRankIndex(move.charAt(1));
		int newFileIndex= getFileIndex(move.charAt(3));
		int newRankIndex= getRankIndex(move.charAt(4));
		if(checkFlag==true){//makecopy of bored
			
			checkDst=bored[newRankIndex][newFileIndex];
		}
		
		if(bored[prevRankIndex][prevFileIndex]!=null){//check there is a peace at  location 
			if((bored[prevRankIndex][prevFileIndex].player==Color.white&&turn==Player.white)||(bored[prevRankIndex][prevFileIndex].player==Color.black&&turn==Player.black)){
		
			if(bored[prevRankIndex][prevFileIndex].isLegal(newFileIndex,newRankIndex)){
				bored[prevRankIndex][prevFileIndex].movePiece(newFileIndex, newRankIndex);

				if((bored[newRankIndex][newFileIndex] instanceof Pawn) &&(newRankIndex==0||newRankIndex==7)){//handle pawnpramotion
					promotePawn(move,bored[newRankIndex][newFileIndex],turn);
					
				}
				switchturn();

			}else{
				//player made an illigal move
				play.message=Message.ILLEGAL_MOVE;
			}
		}else{
			//wrong turn
			play.message=Message.ILLEGAL_MOVE;
		}
		}else{
			//player picked a location with no peice on it
			play.message=Message.ILLEGAL_MOVE;
		}
		if(play.message!=Message.ILLEGAL_MOVE){//handles check senerios
			if(checkFlag==true){//if already in check
				switchturn();
				if(inCheck(turn)){//still in check
					play.message=Message.ILLEGAL_MOVE;
					//reset bored
					bored[newRankIndex][newFileIndex].movePiece(prevFileIndex,prevRankIndex);
					bored[newRankIndex][newFileIndex]=checkDst;
    				
				}else{
					checkFlag=false;
					checkCount=0;
					switchturn();
				}

			}else{
				
				if(inCheck(turn)){//check for check
					play.message=Message.CHECK;
					checkFlag=true;
				}	
			}
		}
		if(checkFlag==true){//check for check mate
			if(inCheckmate(turn)){
				if(turn==Player.white){
					play.message=Message.CHECKMATE_BLACK_WINS;
				}else if(turn==Player.black){
					play.message=Message.CHECKMATE_WHITE_WINS;
				}
		}
	}
	
		//check for draw
		if(play.message!=Message.ILLEGAL_MOVE){
			if("draw".equals(move.substring(move.length()-4,move.length()))){
				play.message=Message.DRAW;
			}
		}
	}
		
		//put all peices still on bored in array list 
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(bored[i][j]!=null){
					play.piecesOnBoard.add(bored[i][j].getReturnPiece());
				}
			}
		}

		

		return play;
	}
	
	private static void switchturn(){
		if(turn==Player.white){
			turn = Player.black;
		}else if(turn==Player.black){
			turn = Player.white;
		}
	}
	
	public static void start() {
	emptyBored();
	setBored();
	turn=Player.white;
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
		
		for(int i=0; i<8;i++){
			bored[1][i]=new Pawn(Color.black,i,1);
			bored[6][i]=new Pawn(Color.white,i,6);
			
		}
		
		

		//set rest
		//black
		bored[0][0]= new Rook(Color.black,0,0);
		bored[0][1]= new Knight(Color.black,1,0);
		bored[0][2]= new Bishop(Color.black,2,0);
		bored[0][3]= new Queen(Color.black,3,0);
		bored[0][4]= new King(Color.black,4,0);
		bored[0][5]= new Bishop(Color.black,5,0);
		bored[0][6]= new Knight(Color.black,6,0);
		bored[0][7]= new Rook(Color.black,7,0);

		//white
		bored[7][0]= new Rook(Color.white,0,7);
		bored[7][1]= new Knight(Color.white,1,7);
		bored[7][2]= new Bishop(Color.white,2,7);
		bored[7][3]= new Queen(Color.white,3,7);
		bored[7][4]= new King(Color.white,4,7);
		bored[7][5]= new Bishop(Color.white,5,7);
		bored[7][6]= new Knight(Color.white,6,7);
		bored[7][7]= new Rook(Color.white,7,7);

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

			return 20;//should never reach this lines
		}
	}
	private static void promotePawn(String move, Piece pawn,Player player){
		int rank=pawn.rankIndex;
		int file=pawn.fileIndex;
		Color color;
		char x='Q';
		if(player==Player.white){
			color=Color.white;
		}else{
			color=Color.black;
		}
		if(move.length()>=7){
		 	x=move.charAt(6);
		}
		if(x=='N'){
			bored[rank][file]= new Knight(color, file, rank);
		}else if(x=='B'){
			bored[rank][file]= new Bishop(color, file, rank);
		}else if(x=='Q'){
			bored[rank][file]= new Queen(color, file, rank);
		}else if(x=='R'){
			bored[rank][file]= new Rook(color, file, rank);
		}else{
			bored[rank][file]= new Queen(color, file, rank);
		}
		
	}
	private static boolean inCheck(Player turn){
			checkCount=0;
			boolean returnVal=false;
			Piece king=findKing(turn);
			if(king==null){
				return false;
			}
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(bored[i][j]!=null){
					if(bored[i][j].isLegal(king.fileIndex, king.rankIndex)){
						checkCount++;
						returnVal= true;
					}
				}
				}
			}
		
		return returnVal;
	}
	private static Piece findKing(Player turn){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(bored[i][j] instanceof King){
					if(turn==Player.white&&bored[i][j].player==Color.white){
						return bored[i][j];
					}else if(turn==Player.black&&bored[i][j].player==Color.black){
						return bored[i][j];
					}
				}
			}
		}
		return null;
	}
private static boolean inCheckmate(Player turn){
	Piece king=findKing(turn);
	Piece temp;
	int prevrank;
	int prevfile;
	if(checkCount==1){
		prevrank=king.rankIndex;
		prevfile=king.fileIndex;
		for(int i=king.rankIndex-1;i<2;i++){
			for(int j=king.fileIndex-1;j<2;j++){
				temp =bored[i][j];
				if(king.isLegal(j, i)){
					king.movePiece(j,i);
					if(inCheck(turn)){
						king.movePiece(prevfile,prevrank);
						bored[i][j]=temp;
					}else{
						return false;
					}
				}
			}
		}
		//check if there iss possible block
	}else if(checkCount>1){
		prevrank=king.rankIndex;
		prevfile=king.fileIndex;
		for(int i=king.rankIndex-1;i<2;i++){
			for(int j=king.fileIndex-1;j<2;j++){
				temp =bored[i][j];
				if(king.isLegal(j, i)){
					king.movePiece(j,i);
					if(inCheck(turn)){
						king.movePiece(prevfile,prevrank);
						bored[i][j]=temp;
					}else{
						return false;
					}
				}
			}
		}
	}else{
		return false;
	}
	return false;
}
}
