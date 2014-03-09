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

public void draw()
{
    loadPixels();
    // Start xoff at 0.
    float xoff = 0.0f; //[bold]

    for (int x = 0; x < width; x++)
    {
        // For every xoff, start yoff at 0.
        float yoff = 0.0f; //[bold]

        for (int y = 0; y < height; y++)
        {
            // Use xoff and yoff for noise().
            float bright = map(noise(xoff, yoff), 0, 1, 0, 0xff); //[bold]
            // Use x and y for pixel location.
            pixels[x + y * width] = color(bright, 0xff, 0xff);
            // Increment yoff.
            yoff += 0.01f; //[bold]
        }
        // Increment xoff.
        xoff += 0.01f;  //[bold]
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
