package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {

    private Color color;
   public Rectangle cursor;




    public Player(Color color){
         cursor = new Rectangle(0,0,Grid.CELLSIZE, Grid.CELLSIZE);
         this.color = color;
         cursor.setColor(color);
         cursor.fill();


    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
