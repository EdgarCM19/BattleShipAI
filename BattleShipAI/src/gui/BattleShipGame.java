package gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

public class BattleShipGame extends GameEngine {

	@Override
	public GameObject getGame(int gameID) {
		switch (gameID) {
		case 0:
			return new Menu(this);
		case 1:
			return new MainGame(this);
		default:
			break;
		}
		return null;
	}

	

}
