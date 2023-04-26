package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet {

    public ArrayList<Star> stars = new ArrayList<Star>();

    public void setup()
    {
        colorMode(RGB);
        loadData();
        printStars();
    }

    public void settings()
    {
        size(800, 800);
    }

    public void printStars()
    {
        for(Star s: stars)
        {
            System.out.println(s);
        }

    }

    public void loadData()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow r: table.rows())
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }
    int border = 50;
    public void drawGrid()
    {
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = -5; i<=5; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x,  border, x, height - border); //vertical
            line(border, x, width - border, x); //horizontal
        }
    }

    public void draw()
    {
        background(0);
        drawGrid();
    }

    
}