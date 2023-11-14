package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.HashSet;
import java.util.LinkedList;

public class EventHandler implements KeyboardHandler {

    public Grid gridMain;
    public Player player;
    
    public EventHandler (Grid grid, Player player){
        this.gridMain = grid;
        this.player = player;

    }


    public void init() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

        KeyboardEvent f = new KeyboardEvent();
        f.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        f.setKey(KeyboardEvent.KEY_F);
        kb.addEventListener(f);


        KeyboardEvent s = new KeyboardEvent();
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(s);


        KeyboardEvent q = new KeyboardEvent();
        q.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        q.setKey(KeyboardEvent.KEY_Q);
        kb.addEventListener(q);

        KeyboardEvent c = new KeyboardEvent();
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        c.setKey(KeyboardEvent.KEY_C);
        kb.addEventListener(c);

        KeyboardEvent x = new KeyboardEvent();
        x.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        x.setKey(KeyboardEvent.KEY_X);
        kb.addEventListener(x);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    if(player.cursor.getX()+Grid.CELLSIZE >= gridMain.mainGrid.getWidth()){
                        return;
                    }
                    player.cursor.translate(Grid.CELLSIZE, 0);
                    break;
                case KeyboardEvent.KEY_LEFT:
                    if(player.cursor.getX() < gridMain.mainGrid.getY()+Grid.CELLSIZE){
                        return;
                    }
                    player.cursor.translate(-Grid.CELLSIZE, 0);
                    break;
                case KeyboardEvent.KEY_UP:
                    if(player.cursor.getY() <= gridMain.mainGrid.getY()){
                        return;
                    }
                    player.cursor.translate(0, -Grid.CELLSIZE);
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if(player.cursor.getY() >= gridMain.mainGrid.getHeight()- Grid.CELLSIZE){
                        return;
                    }
                    player.cursor.translate(0, Grid.CELLSIZE);
                    break;
                case KeyboardEvent.KEY_SPACE:
                    gridMain.paintSquare(player.getColor(),player, gridMain.cellList);
                    break;
                case KeyboardEvent.KEY_S:
                   FileManager.writeFile(gridMain.toString());
                    break;
                case KeyboardEvent.KEY_Q:
                    //FileManager.writeFile(gridMain.toString());
                    System.exit(-1);
                    break;
                case KeyboardEvent.KEY_F:
                    gridMain.StringToGrid(FileManager.readFile());
                    break;
                case KeyboardEvent.KEY_C:
                    gridMain.scrollColor(player);
                    break;
                case KeyboardEvent.KEY_X:
                    gridMain.clearGrid();
                    break;
                default:
            }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }




}
