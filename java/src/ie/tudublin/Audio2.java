package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 750);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; //mix of left and right channels

        lerpedBuffer = new float[1024];
        colorMode(HSB);

        fft = new FFT(ai.bufferSize(), ai.sampleRate());
     
    }

    float off = 0;
    float[]  lerpedBuffer;

    public void draw()
    {
        background(0);
        stroke(255);
        float half = height/2;
        for(int i = 0; i < ab.size(); i++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            float f = abs(lerpedBuffer[i] * half * 2.0f);
            line(i, half + f, i, half - f);
        }

        fft.forward(ab);
        stroke(255);
        int highestIndex = 0;
        for(int i=0; i< fft.specSize() / 2; i++)
        {
            line(i, height, i, height - fft.getBand(i) * 5.0f);
            if(fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);

        fill(255);
        text("Freq: " + freq, 50, 50);

        float y = map(freq, 1000.0f, 2500.0f, height, 0);

        ellipse(200, y, 50, 50);
        ellipse(300, y, 50, 50);

        //which has the highest peak

        //println(map(5, 2, 10, 1000, 2000)); //5 is 50% between 0 and 10, maps 50% between 1000 and 2000
        //println(map1(5, 2, 10, 1000, 2000));

    }        

    float map1(float a, float b, float c, float d, float e)
    {
        float percent = (a - b)/(c - b);
        float mapped = d + ((e - d) * percent);

        return mapped;

    }
}
