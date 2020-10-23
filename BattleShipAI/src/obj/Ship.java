package obj;

public class Ship {
	public int size, sx, sy, ex, ey;
	public char orientation;
	//public Image [] sprites;
	
	public Ship(int size, int x, int y, char orientation) {
		this.size = size;
		this.sx = x;
		this.sy = y;
		this.orientation = orientation;
		calculateEndPoint();
	}
	
	private void calculateEndPoint() {
		switch (this.orientation) {
		case 'N':
			this.ex = this.sx;
			this.ey = this.sy - this.size;
			break;
		case 'S':
			this.ex = this.sx;
			this.ey = this.sy + this.size;
			break;
		case 'W':
			this.ex = this.sx - this.size ;
			this.ey = this.sy;
			break;
		case 'E':
			this.ex = this.sx + this.size ;
			this.ey = this.sy;
			break;
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		return "Barco de tamaño: " + this.size + ", coordenadas: (" + this.sx + ", " + this.sy + ") y orientacion: " + this.orientation;
	}
	
}
