package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Cell {

    private Color color;
    private int colorId;
    private Rectangle cell;
    private boolean isPainted;

    public static final int CELLSIZE = 20;

    public Cell(int posX, int posY, Color color){
        this.isPainted = false;
        this.color = color;
        cell = new Rectangle(posX, posY, CELLSIZE,CELLSIZE);
        cell.setColor(color);
        cell.fill();
        cell.draw();

    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getColorId() {
        return colorId;
    }


    public Rectangle getCell() {
        return cell;
    }


    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
