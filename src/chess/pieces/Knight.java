package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		return getBoard().piece(position) == null || isThereOpponentPiece(position);
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
				//above left
				p.setValues(position.getRow() - 2, position.getColumn() - 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above right
				p.setValues(position.getRow() - 2, position.getColumn() + 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//down left
				p.setValues(position.getRow() + 2, position.getColumn() - 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//down right
				p.setValues(position.getRow() + 2, position.getColumn() + 1);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left above
				p.setValues(position.getRow() - 1, position.getColumn() - 2);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left down
				p.setValues(position.getRow() + 1, position.getColumn() - 2);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right above
				p.setValues(position.getRow() - 1, position.getColumn() + 2);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
		
				
				//right down
				p.setValues(position.getRow() + 1, position.getColumn() + 2);
				if (getBoard().positionExists(p)&& canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
		return mat;
	}

}
