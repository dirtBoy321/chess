package chess;


public class Bishop extends ReturnPiece {
    public Bishop(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }

     boolean isLegal(PieceFile file,int rank){
        
        return false;
    }
    
}
