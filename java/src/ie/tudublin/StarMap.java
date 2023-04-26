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

    public void draw()
    {
        
    }

    
}