package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Grid {


    public Rectangle mainGrid;
    public int width;
    public int height;
    public static final int CELLSIZE = 20;

    private int colorCounter =0;

    public LinkedList<Cell> cellList = new LinkedList<>();


    public Grid(int posX, int posY, int width, int height) {

        this.width = width;
        this.height = height;
        mainGrid = new Rectangle(posX, posY, width, height);

    }



    //create and add the cells to the list
    public void createCells() {
        int posX = 0;
        int posY = 0;
        while (posY != height) {
            while (posX != width) {

                cellList.add( new Cell(posX, posY, Color.BLACK));
                posX = posX + CELLSIZE;

            }

            posY = posY + CELLSIZE;
            posX = 0;
        }

    }

    //clears all the painted cells
    public void clearGrid(){
        for (Cell cell: cellList) {
            cell.getCell().setColor(Color.BLACK);
            cell.getCell().draw();
            cell.setColorId(0);
        }
    }

    // paints the cell where the cursor is with the color of the cursor
    public void paintSquare(Color color, Player player, LinkedList<Cell> list) {
        for (Cell cell : list) {
            if (player.cursor.getX() == cell.getCell().getX() && player.cursor.getY() == cell.getCell().getY()) {
                if( cell.isPainted()) {

                    cell.getCell().setColor(Color.BLACK);
                    cell.getCell().draw();
                    cell.setPainted(false);
                    cell.setColorId(0);
                    return;
                }

                cell.getCell().setColor(color);
                cell.getCell().fill();
                cell.setPainted(true);
                cell.setColorId(colorCounter-1);
            }
        }
    }

    //defines how we want to pass the class to string so we can save inside a file
    @Override
    public String toString() {

    String result = "";
     for(Cell cell : cellList){
         result += cell.getCell().getX() + "/" + cell.getCell().getY() + "/" + cell.getColorId() + "/" + cell.isPainted() + ",";

     }
     return result;

    }

    //loads the saved grid from the file
    public void StringToGrid(String grid) {

        String[] cells = grid.split(",");

        for (String cell : cells) {
            String[] position = cell.split("/");
            for (Cell cell1 : cellList) {
                if(cell1.getCell().getX() == Integer.parseInt(position[0]) && cell1.getCell().getY() == Integer.parseInt(position[1]) && position[3].equals("true")){

                    loadColor(cell1,Integer.parseInt(position[2]));
                    cell1.setColorId(Integer.parseInt(position[2]));

                    break;
                }

            }
        }

    }

    //scrolls the cursor color
    public void scrollColor(Player player){
        player.cursor.delete();
        if(colorCounter == 13){
            colorCounter = 0;
        }
        switch (colorCounter){

            case 0:
                player.cursor.setColor(Color.BLACK);
                player.setColor(Color.BLACK);
                colorCounter++;
                break;
            case 1:
                player.cursor.setColor(Color.BLUE);
                player.setColor(Color.BLUE);
                colorCounter++;
                break;
            case 2:
                player.cursor.setColor(Color.RED);
                player.setColor(Color.RED);
                colorCounter++;
                break;
            case 3:
                player.cursor.setColor(Color.GREEN);
                player.setColor(Color.GREEN);
                colorCounter++;
                break;
            case 4:
                player.cursor.setColor(Color.PINK);
                player.setColor(Color.PINK);
                colorCounter++;
                break;
            case 5:
                player.cursor.setColor(Color.MAGENTA);
                player.setColor(Color.MAGENTA);
                colorCounter++;
                break;
            case 6:
                player.cursor.setColor(Color.ORANGE);
                player.setColor(Color.ORANGE);
                colorCounter++;
                break;
            case 7:
                player.cursor.setColor(Color.YELLOW);
                player.setColor(Color.YELLOW);
                colorCounter++;
                break;
            case 8:
                player.cursor.setColor(Color.WHITE);
                player.setColor(Color.WHITE);
                colorCounter++;
                break;
            case 9:
                player.cursor.setColor(Color.GRAY);
                player.setColor(Color.GRAY);
                colorCounter++;
                break;
            case 10:
                player.cursor.setColor(Color.LIGHT_GRAY);
                player.setColor(Color.LIGHT_GRAY);
                colorCounter++;
                break;
            case 11:
                player.cursor.setColor(Color.DARK_GRAY);
                player.setColor(Color.DARK_GRAY);
                colorCounter++;
                break;
            case 12:
                player.cursor.setColor(Color.CYAN);
                player.setColor(Color.CYAN);
                colorCounter++;
                break;
        }

        player.cursor.fill();

    }

    //Defines the color of the cells when loading the grid from the file
    public void loadColor(Cell cell, int colorId){

        switch (colorId){

            case 0:
                cell.getCell().setColor(Color.BLACK);
                break;
            case 1:
                cell.getCell().setColor(Color.BLUE);
                break;
            case 2:
                cell.getCell().setColor(Color.RED);
                break;
            case 3:
                cell.getCell().setColor(Color.GREEN);
                break;
            case 4:
                cell.getCell().setColor(Color.PINK);
                break;
            case 5:
                cell.getCell().setColor(Color.MAGENTA);
                break;
            case 6:
                cell.getCell().setColor(Color.ORANGE);
                break;
            case 7:
                cell.getCell().setColor(Color.YELLOW);
                break;
            case 8:
                cell.getCell().setColor(Color.WHITE);
                break;
            case 9:
                cell.getCell().setColor(Color.GRAY);
                break;
            case 10:
                cell.getCell().setColor(Color.LIGHT_GRAY);
                break;
            case 11:
                cell.getCell().setColor(Color.DARK_GRAY);
                break;
            case 12:
                cell.getCell().setColor(Color.CYAN);
                break;
        }

        cell.getCell().fill();

    }
}

