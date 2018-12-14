package com.thehartbusiness.unittest;

class CheckerBoard {

	private int board[];

	public CheckerBoard() {
		if (board == null) {
			board = new int[64];
			initBoard();
		}
	}

	private void initBoard() {
		boolean isWhite = true;
		int col = 0;
		for (int i = 0; i < 64; i++) {
			board[i] = (isWhite) ? TileType.WHITE.getType() : TileType.BLACK.getType();
			isWhite = !isWhite;
			col++;
			if (col == 8) {
				col = 0;
				isWhite = !isWhite;
			}
		}
	}

	public void printBoard() {
		// ■
		int col = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == TileType.BLACK.getType()) {
				System.out.print("[B]");
			} else if (board[i] == TileType.WHITE.getType()) {
				System.out.print("[W]");
			} else if (board[i] == TileType.RED_PLAYER.getType()) {
				System.out.print("[R]");
			} else if (board[i] == TileType.WHITE_PLAYER.getType()) {
				System.out.print("[M]");
			}
			
			col++;
			if (col == 8) {
				col = 0;
				System.out.println("");
			}
		}
	}

	public boolean canMakeMove(int spot) {
		if (board[spot] == TileType.BLACK.getType()) {
			return true;
		}
		return false;
	}

	public void makeMove(int spot, TileType type) {
		board[spot] = type.getType();
	}

	public int[] getBoard() {
		return board;
	}
}
