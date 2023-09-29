package chess;

import chess.ReturnPiece.PieceType;

public class Bishop extends Piece {
    public Bishop(Color player,int  file,int rank){
        player=this.player;
        fileIndex=file;
        rankIndex =rank;

    }
    ReturnPiece getReturnPiece(){
        ReturnPiece tempPiece = new ReturnPiece();
        tempPiece.pieceFile=getFile(fileIndex);
        tempPiece.pieceRank=getrank(rankIndex);
        if(player.equals(Color.white)){
            tempPiece.pieceType=PieceType.WB;
        }else{
            tempPiece.pieceType=PieceType.BB;
        }
        return tempPiece;
    }


     boolean isLegal(int newFilefileIndex, int newRankIndex){
        
        return true;
    }
    
}
