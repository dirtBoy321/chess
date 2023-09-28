package chess;

public class Pawn extends ReturnPiece {
    public Pawn(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }
    boolean isLegal(PieceFile file,int rank){
        //still need to account for moving 2 tiles first move
        if(rank==pieceRank+1){
            
            return true;
            //still need to account for diagnal  move
        }else{
           
            return false;
        }
    }
}
