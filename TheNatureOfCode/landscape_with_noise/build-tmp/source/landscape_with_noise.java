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

public class landscape_with_noise extends PApplet {

int len;
int cellSize;
int altitude;
float noiseStepX;
float noiseStepY;
public void setup()
{
    size(512, 512, P3D);
    cellSize = 10;
    altitude = 100;
    len = width / cellSize;
    noiseStepX = 0.1f;
    noiseStepY = 0.1f;
}


public void draw()
{
    background(0xffffff);
    float noiseVal = 0.0f; 
    translate(width / 2, height / 2);
    rotateY(map(mouseX, 0, width, -PI, PI));
    rotateX(map(mouseY, 0, height, -PI, PI));
    translate(-width / 2, -height / 2);
    for (int i = 0; i < len - 1; ++i)
    {
        for (int k = 0; k < len - 1; ++k)
        {
            beginShape(QUADS);
            noiseVal = noise(i * noiseStepX, k * noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, altitude);
            vertex(i * cellSize, k * cellSize, noiseVal);
            noiseVal = noise(i * noiseStepX, (k + 1) * noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, altitude);
            vertex(i * cellSize, (k + 1) * cellSize, noiseVal);
            noiseVal = noise((i + 1) * noiseStepX, (k + 1) * noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, altitude);
            vertex((i + 1) * cellSize, (k + 1) * cellSize, noiseVal);
            noiseVal = noise((i + 1) * noiseStepX, k * noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, altitude);
            vertex((i + 1) * cellSize, k * cellSize, noiseVal);
            endShape();
        }
    }

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "landscape_with_noise" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
