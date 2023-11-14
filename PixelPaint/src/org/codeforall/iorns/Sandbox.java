package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Sandbox {

    public static void main(String[] args) {



            Grid grid = new Grid(0,0, 500,500);

            grid.createCells();
            Player player = new Player(Color.BLACK);

            EventHandler event = new EventHandler(grid,player);
            event.init();
    }



    
}
