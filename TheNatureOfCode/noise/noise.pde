void setup()
{
    colorMode(HSB, 0xff);
    size(512, 512);
}

float noiseVal;
float noiseScale = 0.02;

void draw()
{
    background(0xffffff);

    int lod = int(map(mouseX, 0, width, 0, 10));
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