import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class noise extends PApplet {

public void setup()
{
    colorMode(HSB, 0xff);
    size(512, 512);
}

float noiseVal;
float noiseScale = 0.02f;

public void draw()
{
    background(0xffffff);

    int lod = PApplet.parseInt(map(mouseX, 0, width, 0, 10));
    float falloff = map(mouseY, 0, height, 0, 1);
    println(lod,falloff);
    loadPixels();
    for (int y = 0; y < height; y++)
    {
        for (int x = 0; x < width; x++)
        {
            noiseDetail(lod, falloff);
            noiseVal = noise(x * noiseScale, y * noiseScale);
            pixels[x + y * width] = color((noiseVal * 255), 0xff, 0xff);
        }
    }
    updatePixels();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "noise" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
