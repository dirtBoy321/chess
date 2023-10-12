package chess;

import chess.ReturnPiece.PieceType;

public class King extends Piece {
    public King(Color player,int  file,int rank){
        this.player=player;
        fileIndex=file;
        rankIndex =rank;

    }

    ReturnPiece getReturnPiece(){
        ReturnPiece tempPiece = new ReturnPiece();
        tempPiece.pieceFile=getFile(fileIndex);
        tempPiece.pieceRank=getrank(rankIndex);
        if(player.equals(Color.white)){
            tempPiece.pieceType=PieceType.WK;
        }else{
            tempPiece.pieceType=PieceType.BK;
        }
        return tempPiece;
    }

     boolean isLegal(int newFileIndex, int newRankIndex){

        if((newRankIndex==rankIndex+1)||(newRankIndex==rankIndex-1)||(newFileIndex==fileIndex-1)||(newFileIndex==fileIndex+1)){
            if(Chess.bored[newRankIndex][newFileIndex]!=null){
                if(Chess.bored[newRankIndex][newFileIndex].player == Chess.bored[rankIndex][fileIndex].player){
                    return false;
                }
            }else{
                return true;
            }
        }
        
        return false;
    }
    
}
