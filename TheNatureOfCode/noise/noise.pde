void setup()
{
    colorMode(HSB, 0xff);
    size(512, 512);
}

void draw()
{
    loadPixels();
    // Start xoff at 0.
    float xoff = 0.0; //[bold]

    for (int x = 0; x < width; x++)
    {
        // For every xoff, start yoff at 0.
        float yoff = 0.0; //[bold]

        for (int y = 0; y < height; y++)
        {
            // Use xoff and yoff for noise().
            float bright = map(noise(xoff, yoff), 0, 1, 0, 0xff); //[bold]
            // Use x and y for pixel location.
            pixels[x + y * width] = color(bright, 0xff, 0xff);
            // Increment yoff.
            yoff += 0.01; //[bold]
        }
        // Increment xoff.
        xoff += 0.01;  //[bold]
    }
    updatePixels();

}
