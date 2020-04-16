package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;
import boardgame.Board;

public class King extends ChessPiece {

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
	    this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		return getBoard().piece(position) == null || isThereOpponentPiece(position);
	}
	
	private boolean testRookCastling(Position position) {
	    ChessPiece p = (ChessPiece)getBoard().piece(position);
	    return p != null && p instanceof Rook && p.getMoveCount() == 0 && p.getColor() == getColor(); 
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
				//above
				p.setValues(position.getRow()- 1, position.getColumn());
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//down
				p.setValues(position.getRow()+ 1, position.getColumn());
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above left
				p.setValues(position.getRow()- 1, position.getColumn()- 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above right
				p.setValues(position.getRow()- 1, position.getColumn() + 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//down left
				p.setValues(position.getRow() + 1, position.getColumn() - 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
		
				
				//down right
				p.setValues(position.getRow() + 1, position.getColumn() + 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
		
				//special move castling
				if (getMoveCount() == 0 && !chessMatch.getCheck()) {
					//castling kingside rook
				    Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
				    if (testRookCastling(posT1)) {
				    	Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				    	Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				    	if(!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2)) {
				    		mat[position.getRow()][position.getColumn() + 2] = true;
				    	}
				    }
				    //castling queenside rook
				    Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
				    if (testRookCastling(posT1)) {
				    	Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				    	Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				    	Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				    	if(!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2) && !getBoard().thereIsAPiece(p3)) {
				    		mat[position.getRow()][position.getColumn() - 2] = true;
				    	}
				    }
				}
			
		return mat;
	}
}
