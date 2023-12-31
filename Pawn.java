package chess;

import chess.ReturnPiece.PieceType;

public class Pawn extends Piece {
    

    public Pawn(Color player,int  file,int rank){
        this.player=player;
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

    //still need tocheck path for all ifs in method
     boolean isLegal(int newFileIndex, int newRankIndex){
        if(player==Color.white){
            //first move of two  for white
            if((rankIndex==6)&&(newRankIndex==4)&&(fileIndex==newFileIndex)){
                if(Chess.bored[5][fileIndex]==null&&Chess.bored[4][fileIndex]==null){
                    Chess.enpasantablPiece=Chess.bored[rankIndex][fileIndex];
                    return true;
                }
            }
            //if check for one ahead
            if((newRankIndex==rankIndex-1)&&(fileIndex==newFileIndex)){
                if(Chess.bored[newRankIndex][newFileIndex]==null){
                    
                    return true;
                }
            }
            //if check for  diagnal attack
            if((newRankIndex==rankIndex-1)&&(newFileIndex==fileIndex+1||newFileIndex==fileIndex-1)){
                if(Chess.bored[newRankIndex][newFileIndex]!=null){
                    if(Chess.bored[newRankIndex][newFileIndex].player==Color.black){
                        
                        return true;
                    }
                }
                
            }
            //enpassont white
            if(rankIndex==3&&newRankIndex==2){
                if(fileIndex+1==newFileIndex&&Chess.bored[rankIndex][fileIndex+1].equals(Chess.enpasantablPiece)){
                    Chess.bored[rankIndex][fileIndex+1]=null;
                    return true;
                }else if(fileIndex-1==newFileIndex&&Chess.bored[rankIndex][fileIndex-1].equals(Chess.enpasantablPiece)){
                    Chess.bored[rankIndex][fileIndex-1]=null;
                    return true;
                }
            }
            
            
            

        }else if(player==Color.black){//player is black 
            if((rankIndex==1)&&(newRankIndex==3)&&(fileIndex==newFileIndex)){ //move2 black
                if(Chess.bored[2][fileIndex]==null&&Chess.bored[3][fileIndex]==null){
                   Chess.enpasantablPiece=Chess.bored[rankIndex][fileIndex];
                    return true;
                }
            }
            //if check for one ahead 
            if((newRankIndex==rankIndex+1)&&(fileIndex==newFileIndex)){
               if(Chess.bored[newRankIndex][newFileIndex]==null){
                   
                    return true;
                }
            }
            //if check for  diagnal attack
            if((newRankIndex==rankIndex+1)&&(newFileIndex==fileIndex+1||newFileIndex==fileIndex-1)){
                if(Chess.bored[newRankIndex][newFileIndex]!=null){
                    if(Chess.bored[newRankIndex][newFileIndex].player==Color.white){
                       
                        return true;
                    }
                }
            }


            //enpassont black
            if(rankIndex==4&&newRankIndex==5){
                if(fileIndex+1==newFileIndex&&Chess.bored[rankIndex][fileIndex+1].equals(Chess.enpasantablPiece)){
                    Chess.bored[rankIndex][fileIndex+1]=null;
                    return true;
                }else if(fileIndex-1==newFileIndex&&Chess.bored[rankIndex][fileIndex-1].equals(Chess.enpasantablPiece)){
                    Chess.bored[rankIndex][fileIndex-1]=null;
                    return true;
                }
            }



        }
        return false;
    }
    
    
}
