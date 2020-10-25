package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

import obj.AIPlayer;
import obj.Board;
import obj.GameLogic;
import obj.Ship;

public class MainGame extends GameObject{


	private GameLogic game;
	
	private final int board_size = 300;
	private final int own_board_x = 50;
	private final int own_board_y = 50;
	private final int enemy_board_x = 400;
	private final int enemy_board_y = 50;
	
	
	//private Frame bg;
	private BufferedImage ship_n, ship_s, ship_e, ship_w, ship_c;
	
	private int pointer_x, pointer_y;
	
	private boolean moved;
	
	public MainGame(GameEngine parent) {
		super(parent);
		game = new GameLogic();
		pointer_x = pointer_y = -1;
	}

	@Override
	public void initResources() {
		ship_n = getImage(ResPath.S_N);
		ship_s = getImage(ResPath.S_S);
		ship_e = getImage(ResPath.S_E);
		ship_w = getImage(ResPath.S_W);
		ship_c = getImage(ResPath.S_C);
	}

	@Override
	public void render(Graphics2D g) {
		//bg.render(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
		drawPlayer(g, own_board_x, own_board_y, board_size);
		drawEnemy(g, enemy_board_x, enemy_board_y, board_size);
		if(pointer_x != -1) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(enemy_board_x + (pointer_x * (board_size / 10)), enemy_board_y + (pointer_y * (board_size / 10)), 30, 30);
		}
	}


	@Override
	public void update(long arg0) {
		// TODO Auto-generated method stub
		game.update();
		int x_coord = getMouseX();
		/*
		if(x_coord > own_board_x && x_coord < own_board_x + board_size) {
			int y_coord = getMouseY();
			if(y_coord > own_board_y && y_coord < own_board_y + board_size) {
				pointer_x = (int) (Math.ceil(x_coord / (board_size / 10) - 1) - 1);
				pointer_y = (int) (Math.ceil(y_coord / (board_size / 10) - 1) - 1);
			}
		}*/
		if(inRange(x_coord, enemy_board_x, enemy_board_y, board_size)) {
			if(click()) {
				if(game.player1.shoot(pointer_x, pointer_y)){
					
				}
				moved = true;
			}
		} else {
			pointer_x = pointer_y = -1;			
		}
		if(moved) {
			((AIPlayer)game.player2).randomShot();
			moved = false;
		}
	}
	
	private boolean inRange(int x_coord, int r_x, int r_y, int size) {
		if(x_coord > r_x && x_coord < r_x + size) {
			int y_coord = getMouseY();
			if(y_coord > r_y && y_coord < r_y + size) {
				pointer_x = (int) (Math.ceil((x_coord - r_x) / (size / 10)));
				pointer_y = (int) (Math.ceil((y_coord - r_y) / (size / 10)));
				return true;
			}
		}
		return false;
	}
	
	private void drawPlayer(Graphics2D g, int x, int y, int size) {
		g.setColor(Color.CYAN);
		int separation = size/10;
		for (int i = 0; i <= 10; i++) {
			g.drawLine(x + (separation * i), y, x + (separation * i), y + size);
			g.drawLine(x, y + (separation * i), x + size, y + (separation * i));
		}
		for(Ship ship : game.player1.board.ships) {
			switch (ship.orientation) {
			case 'N':
				for(int i = y + (ship.sy * separation), a = 0; a < ship.size; i-=separation, a++) {
					if(a < ship.size - 1)
						g.drawImage(ship_c, x + (ship.sx * separation) + 3, i + 3, null);
					else
						g.drawImage(ship_n, x + (ship.sx * separation) + 3, i + 3, null);
				}
				break;
			case 'S':
				for(int i = y + (ship.sy * separation), a = 0; a < ship.size; i+=separation, a++) {
					if(a < ship.size - 1)
						g.drawImage(ship_c, x + (ship.sx * separation) + 3, i + 3, null);
					else
						g.drawImage(ship_s, x + (ship.sx * separation) + 3, i + 3, null);
					//drawX(g, x + (ship.sx * separation), i, separation);
				}
				break;
			case 'W':
				for(int i = x + (ship.sx * separation), a = 0; a < ship.size; i-=separation, a++) {
					if(a < ship.size - 1)
						g.drawImage(ship_c, i + 3, y + (ship.sy * separation) + 3, null);
					else
						g.drawImage(ship_w, i + 3, y + (ship.sy * separation) + 3, null);
					//drawX(g, x + (ship.sx * separation), i, separation);
				}
				break;
			case 'E':
				for(int i = x + (ship.sx * separation), a = 0; a < ship.size; i+=separation, a++) {
					if(a < ship.size - 1)
						g.drawImage(ship_c, i + 3, y + (ship.sy * separation) + 3, null);
					else
						g.drawImage(ship_e, i + 3, y + (ship.sy * separation) + 3, null);
					//drawX(g, x + (ship.sx * separation), i, separation);
				}
				break;
			default:
				break;
			}
			
		}
		for (int i = 0; i < game.player2.enemy.matrix.length; i++) {
			for (int j = 0; j < game.player2.enemy.matrix.length; j++) {
				if(game.player2.enemy.matrix[i][j] == 'x') {
					g.setColor(Color.RED);
					drawX(g, x + (i * size / 10), y + (j * size / 10), 30);
				} else if(game.player2.enemy.matrix[i][j] == '-') {
					g.setColor(Color.WHITE);
					drawX(g, x + (i * size / 10), y + (j * size / 10), 30);
				}
			}
		}
		
	}
	
	
	private void drawEnemy(Graphics2D g, int x, int y, int size) {
		g.setColor(Color.CYAN);
		int separation = size/10;
		for (int i = 0; i <= 10; i++) {
			g.drawLine(x + (separation * i), y, x + (separation * i), y + size);
			g.drawLine(x, y + (separation * i), x + size, y + (separation * i));
		}
		for (int i = 0; i < game.player1.enemy.matrix.length; i++) {
			for (int j = 0; j < game.player1.enemy.matrix.length; j++) {
				if(game.player1.enemy.matrix[i][j] == 'x') {
					g.setColor(Color.RED);
					drawX(g, x + (i * size / 10), y + (j * size / 10), 30);
				} else if(game.player1.enemy.matrix[i][j] == '-') {
					g.setColor(Color.WHITE);
					drawX(g, x + (i * size / 10), y + (j * size / 10), 30);
				}
			}
		}
	}
	
	private void drawX(Graphics2D g, int x, int y, int size) {
		g.drawLine(x, y, x + size, y + size);
		g.drawLine(x, y + size, x + size, y);
	}
	

}
