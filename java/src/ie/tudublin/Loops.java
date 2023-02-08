package ie.tudublin;

import processing.core.PApplet;

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
		noStroke();

		for(int i=0; i < 10; i++)
		{
			//fill((i * 25), 100, 100);
			for(int k=0; k < 10; k++)
			{
				fill((i * 13 + k * 13), 100, 100);
				ellipse(width/20 + i*width/10, height/20 + k*height/10, width/10, height/10); //(center x, center y, width, height)
			}
			//ellipse(width/20 + i*width/10, height/10, width/10, height/10);

		}		

	}
}
