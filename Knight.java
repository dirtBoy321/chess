package chess;

public class Knight extends ReturnPiece {
    public Knight(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }

    boolean isLegal(int file,int rank){
        
        return false;
    }
}
