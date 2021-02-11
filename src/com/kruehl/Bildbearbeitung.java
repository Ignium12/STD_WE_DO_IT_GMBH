package com.kruehl;

import java.util.Scanner;
import bildanalyse.Bildwerkzeug;
import bildanalyse.Farbbild;
import bildanalyse.Pixel;

public class Bildbearbeitung {

    private Bildwerkzeug bildwerkzeug;

    public Bildbearbeitung() {
        bildwerkzeug = new Bildwerkzeug();
    }

    public void Kopiere()
    {
        Farbbild farbbild = bildwerkzeug.leseJPG("Bild.jpg");
        Pixel[] pixel = farbbild.gibAllePixel();

        // Arbeitskopie erstellen
        Pixel[] pixelneu = new Pixel[pixel.length];

        for (int i=0; i<pixelneu.length; i++)
        {
            pixelneu[i] = pixel[i];
        }
        farbbild.setzeAllePixel(pixelneu);
        bildwerkzeug.schreibeJPG("Bild-neu.jpg", farbbild);
    }


}
