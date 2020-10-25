package obj;

import java.util.Random;

public class AIPlayer extends Player {

	private int dificultity;
	
	public AIPlayer(String name, Board own, int dificultity) {
		super(name, own);
		this.dificultity = dificultity;
	}
	
	public void randomShot() {
		Random rnd = new Random();
		boolean valid = false;
		int x = 0, y = 0;
		while(!valid) {
			x = rnd.nextInt(10);
			y = rnd.nextInt(10);
			if(enemy.matrix[x][y] == 'o')
				valid = true;
		}
		System.out.println("Disparo de la AI hacia x: " + x + " y: " + y);
		shoot(x, y);
	}
	
}
