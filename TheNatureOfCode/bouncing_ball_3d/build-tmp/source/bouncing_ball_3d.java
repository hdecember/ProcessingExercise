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

public class bouncing_ball_3d extends PApplet {

PVector location;
PVector velocity;
int  r = 10;
int  boxSize = 300;
public void setup() {
  size(1000, 1000, P3D);
  noFill();
  smooth();
  location = new PVector(r,r,r);
  velocity = new PVector(3,1,1);

}

public void draw() {
  background(0);
  
  translate(width/2, height/2, -(width/2));
  rotateY(map(mouseX, 0, width, -PI, PI));
  rotateX(map(mouseY, 0, height, -PI, PI));
  stroke(100);
  box(boxSize);

  translate(-boxSize/2, -boxSize/2, -boxSize/2);

  location.add(velocity);
  translate(location.x, location.y, location.z);
  if( location.x < r || location.x > boxSize - r )
  {
    velocity.x*=-1;
  }
  if( location.y < r || location.y > boxSize - r )
  {
    velocity.y*=-1;
  }
  if( location.z < r || location.z > boxSize - r )
  {
    velocity.z*=-1;
  }
  sphere(r);
  
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "bouncing_ball_3d" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
