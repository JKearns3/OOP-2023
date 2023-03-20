package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private PVector forward;
    PApplet p;

    private float rot;
    private float size;
    private int c;
    private float halfSize;

    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = -PApplet.cos(rot);

        if(p.keyPressed)
        {
            if (p.keyCode == PApplet.LEFT)
            {
                rot -= 0.1f;
            }
            else if (p.keyCode == PApplet.RIGHT)
            {
                rot += 0.1f;
            }
            else if (p.keyCode == PApplet.UP)
            {
                pos.x += forward.x;
                pos.y += forward.y;
            }
            else if (p.keyCode == PApplet.DOWN)
            {
                pos.x -= forward.x;
                pos.y -= forward.y;
            }
        }
    }

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        pos = new PVector(x,y);
        this.size = size;
        this.c = c;
        this.p = p;
        this.halfSize = size/2;
    }

    public PVector getPos() {
        return pos;
    }

    public void setPos(PVector pos) {
        this.pos = pos;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    

    public void render()
    {
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.stroke(c, 255, 255);
        p.line(0 - halfSize, 0 + halfSize, 0, 0 - halfSize);
        p.line(0, 0 - halfSize, 0 + halfSize, 0 + halfSize);
        p.line(0 + halfSize, 0 + halfSize, 0, 0);
        p.line(0, 0, 0 - halfSize, 0 + halfSize);
    }


}
