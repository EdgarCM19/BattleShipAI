package obj;

import java.awt.Dimension;
import java.util.Random;

import com.golden.gamedev.GameLoader;

import gui.BattleShipGame;

public class BattleShipMain {

	public static void main(String[] args) {
		
		GameLoader game = new GameLoader();
		game.setup(new BattleShipGame(), new Dimension(720, 480), false);
		game.start();
		
	}
	
	/*
	char [][] amt = {
			{'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
			{'#', '#', '#', 'o', 'o', '#', 'o', 'o', 'o', '#'},
			{'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', '#'},
			{'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', 'o', 'o'},
			{'o', 'o', 'o', 'o', 'o', '#', '#', '#', 'o', 'o'},
			{'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
			{'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '#'},
			{'o', '#', 'o', 'o', 'o', 'o', 'o', '#', 'o', '#'},
			{'o', '#', 'o', 'o', '#', 'o', 'o', '#', 'o', '#'},
			{'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
	};
	
	TermUtils.printBoard(amt);
	Board t = new Board();
	t.createRandomBoard();
	TermUtils.printBoard(t.matrix);
	System.out.println(t.confirmShoot(3, 3));
	Board enemy_b = new Board();
	Board player_b = new Board();
	enemy_b.createRandomBoard();
	Player enemy = new Player("Enemigo", enemy_b);
	Player player = new Player("Yo", player_b);
	enemy.rival = player;
	player.rival = enemy;
	Random rnd = new Random();
	
	//for (int i = 0; i < 10; i++) {
	while(enemy.board.destroyed.size() == 0) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				player.shoot(i, j);
			}
		}
	}
	TermUtils.printBoard(enemy.board.matrix);
	System.out.println("\n\n\n+-+-+-+-+-+-+-+-+-+-+-+-+--+");
	TermUtils.printBoard(player.enemy.matrix);
	*/
	
}
