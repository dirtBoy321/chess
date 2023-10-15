package chess;

import chess.ReturnPiece.PieceType;

public class Bishop extends Piece {
    public Bishop(Color player,int  file,int rank){
        this.player=player;
        fileIndex = file;
        rankIndex = rank;

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


     boolean isLegal(int newFileIndex, int newRankIndex){

        //y = rank, x = file
        int slope = Slope(newFileIndex,fileIndex,newRankIndex, rankIndex);
        // gives us the slope for the bishop ; legal moves are 1 or -1
        if((slope == 1) || (slope == -1)){//move diagonally 
            int rankincrement;
            int fileincremtnt;
            if(rankIndex<newRankIndex&&fileIndex<newFileIndex){//peice moved up and right
                //set file and rankincrementvalues to1 or-1
            }
            if(rankIndex>newRankIndex&&fileIndex<newFileIndex){ //peice moved down and right
                //set file and rankincrementvalues to1 or-1
            }
            if(rankIndex<newRankIndex&&fileIndex>newFileIndex){//peice moved up and left
                //set file and rankincrementvalues to1 or-1
            }
            if(rankIndex>newRankIndex&&fileIndex>newFileIndex){//peice moved down and left
                //set file and rankincrementvalues to1 or-1
            }
            // dubble for loop that incrents file and rank by the values above until at the new ones

            if(Chess.bored[newRankIndex][newFileIndex]!=null){//check not moving onto ally ; SHOULD ALWAYS BE THE SAME FOR EVERY CHESS PIECE
                 if(Chess.bored[newRankIndex][newFileIndex].player==Chess.bored[rankIndex][fileIndex].player){
                    return  false;
                }
             }
           
            return true;
        }

        return false;
    }


    //y = rank, x = file
    private int Slope(int y2, int y1, int x2, int x1){
        if(x2-x1==0){
            return 0;
        }
        return (y2 - y1) / (x2 - x1);
    }
    
}
