package gui;

import java.awt.Graphics2D;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

public class Menu extends GameObject {
	
	private Frame menuFrame;
	private Frame logo;

	public Menu(GameEngine parent) {
		super(parent);
	}

	@Override
	public void initResources() {
		menuFrame = new Frame(getImage(ResPath.MENU_BG, false), 0, 0);
		logo = new Frame(getImage(ResPath.LOGO), 200, 50);
	}

	@Override
	public void render(Graphics2D g) {
		menuFrame.render(g);
		logo.render(g);
		
	}

	@Override
	public void update(long arg0) {
		if(click()) {
			if(logo.click(getMouseX(), getMouseY())) {
				parent.nextGameID = 1;
				finish();
			}
		}
	}

}
