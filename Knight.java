package chess;

import chess.ReturnPiece.PieceType;

public class Knight extends Piece {
    public Knight(Color player,int  file,int rank){
        player=this.player;
        fileIndex=file;
        rankIndex =rank;

    }
    ReturnPiece getReturnPiece(){
        ReturnPiece tempPiece = new ReturnPiece();
        tempPiece.pieceFile=getFile(fileIndex);
        tempPiece.pieceRank=getrank(rankIndex);
        if(player.equals(Color.white)){
            tempPiece.pieceType=PieceType.WN;
        }else{
            tempPiece.pieceType=PieceType.BN;
        }
        return tempPiece;
    }


    boolean isLegal(int newFilefileIndex, int newRankIndex){
         if(((rankIndex+1==newRankIndex||rankIndex-1==newRankIndex)&&(fileIndex+2==newRankIndex||fileIndex-2==newRankIndex))||
            ((rankIndex+2==newRankIndex||rankIndex-2==newRankIndex)&&(fileIndex+1==newRankIndex||fileIndex-1==newRankIndex))){
             return true;
         }else{
             return false;
         }
        
       
    }
    
}

