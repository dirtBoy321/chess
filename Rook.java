package chess;

public class Rook extends ReturnPiece{
    
    public Rook(PieceType type,PieceFile file,int rank){
        pieceType=type;
        pieceFile=file;
        pieceRank =rank;

    }
    boolean isLegal(int file,int rank){
        
        return false;
    }
}
