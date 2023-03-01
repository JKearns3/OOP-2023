package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class psAudio extends PApplet{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
    }

    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];

        fft = new FFT(width, 44100);
        colorMode(HSB, 360, 100, 100);
    }

    float[] lerpedBuffer;
    public void draw()
    {
        background(0);

        fft.forward(ab);
        stroke(255);

        int highestIndex = 0;
        for(int i = 0 ;i < fft.specSize() / 2 ; i ++)
        {
            //line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 5.0f);

            if (fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
                        
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255);
        textSize(20);
        text("Freq: " + freq, 100, 100);
        PitchSpeller p = new PitchSpeller();
        //System.out.println(p.spell(freq));
        text("Note: " + p.spell(freq), 100, 150);

        float r = map(freq, 100.0f, 2500.0f, height, 0);
        lerpedR = lerp(lerpedR, r, 0.1f);
        float c = map(freq, 0, ab.size(), 0, 255);
        fill(c, 100, 100);
        circle(width/4, height/2, r/5);
        circle(width - width/4, height/2, lerpedR/5);
 

    }

    float lerpedR = 0;
 
}
