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
		background(0);
		noStroke();

		for(int i=0; i < 10; i++)
		{
			fill(color + (i * 35), 100, 100);
			rect(i*(width/10), (i * height/10), width/10, height/10);
			rect(width-(i*(width/10)), (i * height/10), -width/10, height/10);

		}		


	}
}
