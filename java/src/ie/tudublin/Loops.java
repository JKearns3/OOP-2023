package ie.tudublin;

import processing.core.PApplet;
import java.lang.Math;

public class Loops extends PApplet {

	int mode = 0;
	int color = 0;
	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB, 360, 100, 100); 
	}



	public void keyPressed() {
		
		mode = key - '0';
		println(mode);
	}

	public void draw() {
		background(0, 0, 100);

		for(int i = 0; i<5; i++)
		{
			int x1 = 250;
			int y1 = 250;
			double x2 = x1 + (Math.cos((i+1)*108)*100);
			double y2 = y1 + (Math.sin((i+1)*108)*100);

			line(x1, y1, (int)x2, (int)y2);

		}
	}
}
