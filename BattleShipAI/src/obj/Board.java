package obj;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	
	//o => Ocean
	//# => Own ship
	//x => Ship hit
	//- => Miss hit
	
	public final int size = 10;
	public ArrayList<Ship> ships, destroyed;
	public char [][] matrix;
	public int movs;
	
	public Board() {
		this.matrix = new char[this.size][this.size];
		this.movs = 0;
		this.ships = new ArrayList<Ship>();
		this.destroyed = new ArrayList<Ship>();
		fillEmptyMatrix();
		initShips();
	}
	
	public void createRandomBoard() {
		fillEmptyMatrix();
		boolean control = false;
		char [] orien = {'N', 'S', 'E', 'W'};
		Random rnd = new Random();
		int x, y;
		char c;
		for (Ship ship : ships) {
			control = false;
			while(!control) {
				c = orien[rnd.nextInt(orien.length)];
				x = rnd.nextInt(size);
				y = rnd.nextInt(size);
				if(validPosition(ship.size, x, y, c)) {
					ship.sx = x;
					ship.sy = y;
					ship.orientation = c;
					registerPosition(ship.size, x, y, c);
					control = true;
				}
			}
		}
		/*for (Ship ship : ships) {
			System.out.println(ship);
		}*/
	}
	
	private boolean validPosition(int size, int x, int y, char o) {
		switch (o) {
		case 'N':
			if(y - size < 0 ) return false;
			for(int i = y, a = 0; a < size; i--, a++) {
				if(matrix[i][x] != 'o') return false;
			}
			break;
		case 'S':
			if(y + size > this.size) return false;
			for(int i = y, a = 0; a < size; i++, a++) {
				if(matrix[i][x] != 'o') return false;
			}
			break;
		case 'W':
			if(x - size < 0 ) return false;
			for(int i = x, a = 0; a < size; i--, a++) {
				if(matrix[y][i] != 'o') return false;
			}
			break;
		case 'E':
			if(x + size > this.size ) return false;
			for(int i = x, a = 0; a < size; i++, a++) {
				if(matrix[y][i] != 'o') return false;
			}
			break;
		default:
			break;
		}
		return true;
	}
	
	private void registerPosition(int size, int x, int y, char o) {
		switch (o) {
		case 'N':
			for(int i = y, a = 0; a < size; i--, a++) {
					matrix[i][x] = '#';
			}
			break;
		case 'S':
			for(int i = y, a = 0; a < size; i++, a++) {
					matrix[i][x] = '#';
			}
			break;
		case 'W':
			for(int i = x, a = 0; a < size; i--, a++) {
					matrix[y][i] = '#';
			}
			break;
		case 'E':
			for(int i = x, a = 0; a < size; i++, a++) {
					matrix[y][i] = '#';
			}
			break;
		default:
			break;
		}
	}
	
	public void createBoard() {
		
	}

	private void fillEmptyMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = 'o';
			}
		}
	}
	
	public void initShips() {
		ships.add(new Ship(4, -1, -1, '-'));
		ships.add(new Ship(3, -1, -1, '-'));
		ships.add(new Ship(3, -1, -1, '-'));
		ships.add(new Ship(3, -1, -1, '-'));
		ships.add(new Ship(2, -1, -1, '-'));
		ships.add(new Ship(2, -1, -1, '-'));
		ships.add(new Ship(2, -1, -1, '-'));
		ships.add(new Ship(1, -1, -1, '-'));
	}
	
	public boolean confirmShoot(int x, int y) {
		if(this.matrix[y][x] == '#') {
			this.matrix[y][x] = 'x';
			checkShipsAlive();
			return true;
		}
		return false;
	}
	
	private void checkShipsAlive() {
		for (Ship ship : ships) {
			switch (ship.orientation) {
			case 'N':
				for (int i = ship.sy, a = 0; a < matrix.length; i--, a++)
					if(matrix[i][ship.sx] != 'x')
						return;
				System.out.println("Holas");
				destroyed.add(ship);
				ships.remove(ship);
				return;
			case 'S':
				for (int i = ship.sy, a = 0; a < matrix.length; i++, a++)
					if(matrix[i][ship.sx] != 'x')
						return;
				destroyed.add(ship);
				ships.remove(ship);
				return;
			case 'W':
				for (int i = ship.sx, a = 0; a < matrix.length; i--, a++)
					if(matrix[ship.sy][i] != 'x')
						return;
				destroyed.add(ship);
				ships.remove(ship);
				return;
			case 'E':
				for (int i = ship.sx, a = 0; a < matrix.length; i++, a++)
					if(matrix[ship.sy][i] != 'x')
						return;
				destroyed.add(ship);
				ships.remove(ship);
				return;
			default:
				return;
			}
		}
	}
	

	public void printBoard() {
		TermUtils.printBoard(matrix);
	}
	
	public boolean checkBoard() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == '#')
					return false;
			}
		}
		return true;
	}
}
