package obj;

public class GameLogic {
	
	public Player player1, player2;
	
	
	public GameLogic() {
		Board b_1 = new Board();
		Board b_2 = new Board();
		b_1.createRandomBoard();
		b_2.createRandomBoard();
		player1 = new Player("Prueba", b_1);
		player2 = new AIPlayer("AI", b_2, 0);
		player1.rival = player2;
		player2.rival = player1;
		
		
		TermUtils.printBoard(player1.board.matrix);
		/*
		for (Ship ship : player1.board.ships) {
			System.out.println(ship);
		}*/
		System.out.println("------------------------");
		TermUtils.printBoard(player2.board.matrix);
		
	}
	
	public void update() {
		if(checkForWin()) {
			System.out.println("Ganaste wey");
		}
		if(checkForLose()) {
			System.out.println("Perdiste wey");
		}
		
	}
	
	private boolean checkForWin() {
		return player2.board.checkBoard();
	}
	
	private boolean checkForLose() {
		return player1.board.checkBoard();
	}


}
