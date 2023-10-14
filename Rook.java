package chess;

import chess.ReturnPiece.PieceType;

public class Rook extends Piece {
    public Rook(Color player,int  file,int rank){
        this.player=player;
        fileIndex=file;
        rankIndex =rank;

    }

   ReturnPiece getReturnPiece(){
        ReturnPiece tempPiece = new ReturnPiece();
        tempPiece.pieceFile=getFile(fileIndex);
        tempPiece.pieceRank=getrank(rankIndex);
        if(player.equals(Color.white)){
            tempPiece.pieceType=PieceType.WR;
        }else{
            tempPiece.pieceType=PieceType.BR;
        }
        return tempPiece;
    }

     boolean isLegal(int newFileIndex, int newRankIndex){
        int big;
        if(newRankIndex==rankIndex&&newFileIndex!=fileIndex){//move  horisontily
        
             big =getLarger(fileIndex,newFileIndex);

             for(int i=getSmaller(fileIndex,newFileIndex)+1;i<big;i++){//check if path is blocked
                if(Chess.bored[rankIndex][i]!=null){
                    return false;
                }

             }
             if(Chess.bored[newRankIndex][newFileIndex]!=null){//check not moving onto ally
                if(Chess.bored[newRankIndex][newFileIndex].player==Chess.bored[rankIndex][fileIndex].player){
                    return  false;
                }
                
             }
             return true;
        }
        else if(newFileIndex==fileIndex&&newRankIndex!=rankIndex){//move vertically
        
            big =getLarger(newRankIndex, rankIndex);

             for(int i=getSmaller(newRankIndex, rankIndex)+1;i<big;i++){//check if path is blocked
                if(Chess.bored[i][fileIndex]!=null){
                    return false;
                }

             }
             if(Chess.bored[newRankIndex][newFileIndex]!=null){//check not moving onto ally
                if(Chess.bored[newRankIndex][newFileIndex].player==Chess.bored[rankIndex][fileIndex].player){
                    return  false;
                }
                
             }
             return true;
        }
        return false;
    }
    private int getSmaller(int x,int y){
        if(x<y){
            return x;
        }else{
            return y;
        }
    }
private int getLarger(int x,int y){
        if(x>y){
            return x;
        }else{
            return y;
        }
    }

}
