package chess;

public class Queen extends ReturnPiece{
    public Queen(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }
    boolean isLegal(PieceFile file,int rank){
        
        return false;
    }
}
