package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ColoredGrid {


    public Rectangle grid;
    public final int CELLSIZE= 20;


    public ColoredGrid(Rectangle grid){

        this.grid = grid;
    }


    public void creatColoredGrid(){

        for( int i = 0; i< grid.getWidth(); i += CELLSIZE ){
            Rectangle rectangle = new Rectangle (grid.getWidth(),i,CELLSIZE,CELLSIZE);
            rectangle.draw();
            //rectangle.setColor(Color.GREEN);
            rectangle.fill();
        }

    }


        public enum Color{





    }






}
