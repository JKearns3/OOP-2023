package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet{

    ArrayList<Nematode> nems = new ArrayList<Nematode>();

    public void settings()
    {
        size(800, 800);        
    }
    public void setup()
    {
        colorMode(RGB);
        loadNematodes();
    }

    public void loadNematodes()
    {
        Table table = loadTable("nematodes.csv", "header");

        for(TableRow r: table.rows())
        {
            Nematode n = new Nematode(r);
            nems.add(n);
        }
    }
    
    public void drawNematodes()
    {
        /*for(Nematode n : nems)
       {
            n.render(this);
        }
        */

        nems.get(1).render(this);
    }

    public void draw()
    {
        background(0);
        drawNematodes();
    }
}
