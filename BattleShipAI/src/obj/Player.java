package obj;

public class Player {
	
	public Board board, enemy;
	public String name;
	public int score;
	public Player rival;
	
	
	public Player(String name, Board own) {
		this.name = name;
		this.board = own;
		this.enemy = new Board();
	}
	
	public void shoot(int x, int y) {
		enemy.matrix[x][y] = (rival.board.confirmShoot(x, y)) ? 'x' : '-';
	}
	
	
	
	
}
