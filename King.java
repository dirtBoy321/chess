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
        //check for castle
        if(moved==false&&Chess.checkFlag==false){//white 
            if(player==Color.white){
                
                if(Chess.bored[7][7]!=null&&newRankIndex==7&&newFileIndex==6){//right castle
                    if(Chess.bored[7][7].moved==false&&Chess.bored[7][6]==null&&Chess.bored[7][5]==null){
                        Chess.bored[7][7].movePiece(5,7);
                        return true;
                        

                    }

                }
                if(Chess.bored[7][0]!=null&&newRankIndex==7&&newFileIndex==1){//left castle
                    if(Chess.bored[7][0].moved==false&&Chess.bored[7][1]==null&&Chess.bored[7][2]==null&&Chess.bored[7][3]==null){
                        Chess.bored[7][0].movePiece(2,7);
                        return true;
                    }
                }
            }else if(player==Color.black){
                if(Chess.bored[0][7]!=null&&newRankIndex==0&&newFileIndex==6){//right castle
                    if(Chess.bored[0][7].moved==false&&Chess.bored[0][6]==null&&Chess.bored[0][5]==null){
                        Chess.bored[0][7].movePiece(5,0);
                        return true;
                    }
                }
                if(Chess.bored[0][0]!=null&&newRankIndex==0&&newFileIndex==1){//left castle
                    if(Chess.bored[0][0].moved==false&&Chess.bored[0][1]==null&&Chess.bored[0][2]==null&&Chess.bored[0][3]==null){
                        Chess.bored[0][0].movePiece(2,0);
                        return true;
                    }

                }
            }
        }
      ///////////////////////////////////////////////////////////////////////  


        if((newRankIndex==rankIndex+1)||(newRankIndex==rankIndex-1)||(newFileIndex==fileIndex-1)||(newFileIndex==fileIndex+1)){
            if(Chess.bored[newRankIndex][newFileIndex]!=null){
                if(Chess.bored[newRankIndex][newFileIndex].player == Chess.bored[rankIndex][fileIndex].player){
                    return false;
                }
                return true;
                
            }else{
                
                return true;
            }
        }
        
        return false;
    }
    
}
