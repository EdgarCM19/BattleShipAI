package gui;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

public class Frame extends Sprite {
	
	public Frame(BufferedImage img, int x, int y) {
		super(img, x, y);
	}
	
	public boolean click(int x, int y) {
		if(x < getX())
			return false;
		if(x > getX() + width)
			return false;
		if(y < getY())
			return false;
		if(y > getY() + height)
			return false;
		return true;
	}

	
	
}
