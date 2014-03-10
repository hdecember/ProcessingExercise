float noiseVal = 0.0;
int len;
int stepSize;
int mapSize;
void setup()
{
    size(512, 512, P3D);
    float x = 0.0;
    stepSize = 10;
    mapSize = 100;
    len = width / stepSize;
}


void draw()
{
    // point(0,0,0);
    // translate(200, 200);
    background(0xffffff);

    float noiseStepX = 0.1;
    float noiseStepY = 0.1;
    float noiseX = 0;
    float noiseY = 0;
    translate(width/2, height/2);
    rotateY(map(mouseX, 0, width, -PI, PI));
    rotateX(map(mouseY, 0, height, -PI, PI));
    translate(-width/2, -height/2);
    for (int i = 0; i < len-1; ++i) {
        for (int k = 0; k < len-1; ++k) {
            beginShape(QUADS);
            noiseVal = noise(i*noiseStepX, k*noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, mapSize);
            vertex(i*stepSize, k*stepSize, noiseVal);
            noiseVal = noise(i*noiseStepX, (k+1)*noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, mapSize);
            vertex(i*stepSize, (k+1)*stepSize,noiseVal);
            noiseVal = noise((i+1)*noiseStepX, (k+1)*noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, mapSize);
            vertex((i+1)*stepSize, (k+1)*stepSize,noiseVal);
            noiseVal = noise((i+1)*noiseStepX, (k)*noiseStepY);
            noiseVal = map(noiseVal, 0, 1, 0, mapSize);
            vertex((i+1)*stepSize, k*stepSize,noiseVal);
            endShape();
        }
    }

}
