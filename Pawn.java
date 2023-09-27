package chess;

public class Pawn extends ReturnPiece {
    public Pawn(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }
    boolean isLegal(int file,int rank){
        
        return false;
    }
}
