package chess;

public class King extends ReturnPiece {
    public King(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }

    boolean isLegal(int file,int rank){
        
        return false;
    }
}
