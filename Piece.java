package chess;

import chess.ReturnPiece.PieceFile;

public abstract class Piece {
    enum Color{white,black};
    int rankIndex;
    int fileIndex;
    Color player;

    boolean isLegal(int newFilefileIndex, int newRankIndex ){
        return false;

    }
    boolean checkPath(int newFilefileIndex, int newRankIndex){
        return false;
    }
    void movePiece(int newFilefileIndex, int newRankIndex){}

    ReturnPiece getReturnPiece(){
        return null;
    }

    int getrank(int rankIndex){
        if(rankIndex==0){
            return 8;
        }else if(rankIndex==1){
            return 7;
        }else if(rankIndex==2){
            return 6;
        }else if(rankIndex==3){
            return 5;
        }else if(rankIndex==4){
            return 4;
        }else if(rankIndex==5){
            return 3;
        }else if(rankIndex==6){
            return 2;
        }else if(rankIndex==7){
            return 1;
        }else{
            //handle error
            System.out.println("something went wrong in getrank()");
            return rankIndex;
        }
       
    }

    PieceFile getFile(int fileIndex){
        if(fileIndex==0){
            return PieceFile.a;
        }else if(fileIndex==1){
            return PieceFile.b;
        }else if(fileIndex==2){
            return PieceFile.c;
        }else if(fileIndex==3){
            return PieceFile.d;
        }else if(fileIndex==4){
            return PieceFile.e;
        }else if(fileIndex==5){
            return PieceFile.f;
        }else if(fileIndex==6){
            return PieceFile.g;
        }else if(fileIndex==7){
            return PieceFile.h;
        }else{
        System.out.println("error with getfile()");
        return null;
        }
    }
}
