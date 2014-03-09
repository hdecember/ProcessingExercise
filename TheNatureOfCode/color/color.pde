void setup()
{
    size(1024, 100);
    colorMode(HSB, 0xff);
}

void draw()
{
    int colorStep = 1;
    int ccolor = 0x0;
    loadPixels();


    for (int x = 0; x < 1024; ++x)
    {
        for (int y = 0; y < 100; ++y)
        {
            pixels[x + y * 1024] = color(ccolor, 0xff, 0xff);
        }
        ccolor += colorStep;
        

    }
    updatePixels();
}