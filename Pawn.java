public class Pawn extends Piece
{
	private int xBeforeMove, yBeforeMove;

	public Pawn(int x, int y, Side side, Board board)
	{
		// TODO: Call super constructor
		super(x, y, side, board);
		xBeforeMove=x;
		yBeforeMove=y;
	}

	@Override public boolean canMove(int destX, int destY)
	{
		//TODO: Check piecerules.md for the movement rule for this piece :)
		if (xBeforeMove==x && yBeforeMove==y)
		{
			if (this.getSide() == Side.WHITE)
			{
				int cy=destY-y;
				int cx=destX-x;
				//walk forward
				if(cx==0)
				{
					//walk one step
					if(cy==-1 && board.get(destX, destY)==null) return true;
					//walk two steps
					else if(cy==-2 && board.get(destX, destY+1)==null && board.get(destX, destY)==null) return true;
					else return false;
				}
				//kill top left or top right
				else if(Math.abs(cx)==1 && cy==-1)
				{
					if(board.get(destX, destY)!=null && board.get(destX, destY).getSide()==Side.BLACK) return true;
				}
				return false;
			}
			else if (this.getSide() == Side.BLACK)
			{
				int cy=destY-y;
				int cx=destX-x;
				//walk forward
				if(cx==0)
				{
					//walk one step
					if(cy==1 && board.get(destX, destY)==null) return true;
					//walk two steps
					else if(cy==2 && board.get(destX, destY-1)==null && board.get(destX, destY)==null) return true;
					else return false;
				}
				//kill bottom left or bottom right
				else if(Math.abs(cx)==1 && cy==1)
				{
					if(board.get(destX, destY)!=null && (board.get(destX, destY).getSide()==Side.WHITE)) return true;
				}
				return false;
			}
		}
		else
		{
			if (this.getSide() == Side.WHITE)
			{
				int cy=destY-y;
				int cx=destX-x;
				//walk forward
				if(cx==0)
				{
					//walk one step
					if(cy==-1 && board.get(destX, destY)==null) return true;
					else return false;
				}
				//kill top left or top right
				else if(Math.abs(cx)==1 && cy==-1)
				{
					if(board.get(destX, destY)!=null && (board.get(destX, destY).getSide()==Side.BLACK)) return true;
				}
				return false;
			}
			else if (this.getSide() == Side.BLACK)
			{
				int cy=destY-y;
				int cx=destX-x;
				//walk forward
				if(cx==0)
				{
					//walk one step
					if(cy==1 && board.get(destX, destY)==null) return true;
					else return false;
				}
				//kill bottom left or bottom right
				else if(Math.abs(cx)==1 && cy==1)
				{
					if(board.get(destX, destY)!=null && (board.get(destX, destY).getSide()==Side.WHITE)) return true;
				}
				return false;
			}
		}
		return false;
	}

	@Override public String getSymbol()
	{
		return this.getSide() == Side.BLACK ? "♟" : "♙";
	}
}