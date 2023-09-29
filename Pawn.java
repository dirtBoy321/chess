package chess;

import chess.ReturnPiece.PieceType;

public class Pawn extends Piece {
    public Pawn(Color player,int  file,int rank){
        player=this.player;
        fileIndex=file;
        rankIndex =rank;

    }
    ReturnPiece getReturnPiece(){
        ReturnPiece tempPiece = new ReturnPiece();
        tempPiece.pieceFile=getFile(fileIndex);
        tempPiece.pieceRank=getrank(rankIndex);
        if(player.equals(Color.white)){
            tempPiece.pieceType=PieceType.WP;
        }else{
            tempPiece.pieceType=PieceType.BP;
        }
        return tempPiece;
    }


     boolean isLegal(int newFilefileIndex, int newRankIndex){
        
        return true;
    }
    
}
