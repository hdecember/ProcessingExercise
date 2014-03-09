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

public class color extends PApplet {

public void setup()
{
    size(1024, 100);
    colorMode(HSB,0xff);
}

public void draw()
{
    int colorStep = 1;
    int ccolor = 0x0;
    loadPixels();


    for (int x = 0; x < 1024; ++x)
    {
        for (int y = 0; y < 100; ++y)
        {
        	pixels[x+y*1024] = color(ccolor,0xff,0xff);
        }
       	ccolor+=colorStep;

    }
    updatePixels();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "color" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
