package com.thehartbusiness.unittest;

import java.util.Scanner;

public class Core {

	private CheckerBoard board;
	private Scanner scanner;
	
	private boolean redPlayerTurn = true;
	
	public Core ()  {
		board = new CheckerBoard();
		board.printBoard();
		
		scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Make a move between 0 - 63");
			int move = scanner.nextInt();
				
			if (board.getBoard()[move] == TileType.WHITE.getType()) {
				board.printBoard();
			} else {
				board.makeMove(move, (redPlayerTurn) ? TileType.RED_PLAYER : TileType.WHITE_PLAYER);
				board.printBoard();
				redPlayerTurn = !redPlayerTurn;
			}
		}
	}
	
	public static void main(String[] args) {
		new Core();
	}

}
