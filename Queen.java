package chess;

import chess.ReturnPiece.PieceType;

public class Queen extends Piece {
    public Queen(Color player,int  file,int rank){
        this.player=player;
        fileIndex=file;
        rankIndex =rank;

    }
    ReturnPiece getReturnPiece(){
        ReturnPiece tempPiece = new ReturnPiece();
        tempPiece.pieceFile=getFile(fileIndex);
        tempPiece.pieceRank=getrank(rankIndex);
        if(player.equals(Color.white)){
            tempPiece.pieceType=PieceType.WQ;
        }else{
            tempPiece.pieceType=PieceType.BQ;
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
        
        int slope = Slope(newFileIndex,fileIndex,newRankIndex, rankIndex);
        // gives us the slope for the bishop ; legal moves are 1 or -1
        if((slope == 1) || (slope == -1)){//move diagonally 
            int rankincrement=1;
            int fileincremtnt=1;
            if(rankIndex<newRankIndex&&fileIndex<newFileIndex){//peice moved down and right
                fileincremtnt=1;
                rankincrement=1;
            }
            else if(rankIndex>newRankIndex&&fileIndex<newFileIndex){ //peice moved up and right
                fileincremtnt=1;
                rankincrement=-1;
            }
            else if(rankIndex<newRankIndex&&fileIndex>newFileIndex){//peice moved down and left
                fileincremtnt=-1;
                rankincrement=1;
            }
            else if(rankIndex>newRankIndex&&fileIndex>newFileIndex){//peice moved up and left
                fileincremtnt=-1;
                rankincrement=-1;
                
            }
            int j=fileIndex+fileincremtnt;;
            for(int i=rankIndex+rankincrement;i!=newRankIndex;i=i+rankincrement){ 
                if(Chess.bored[i][j]!=null){
                    return false; 
                }
                j=j+fileincremtnt;
            }

            if(Chess.bored[newRankIndex][newFileIndex]!=null){//check not moving onto ally ; SHOULD ALWAYS BE THE SAME FOR EVERY CHESS PIECE
                 if(Chess.bored[newRankIndex][newFileIndex].player==Chess.bored[rankIndex][fileIndex].player){
                    return  false;
                }
             }
           
            return true;
        }


        return false;
    }
    

    private int Slope(int y2, int y1, int x2, int x1){
        if(x2-x1==0){
            return 0;
        }
        return (y2 - y1) / (x2 - x1);
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
