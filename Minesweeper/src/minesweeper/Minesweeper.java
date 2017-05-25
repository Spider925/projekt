package minesweeper;


import minesweeper.logic.Logic;

import minesweeper.view.MinesweeperWindow;

/**
 * @author Kardos Gergo - FM7AUC
 * @author Elek David - DEG8I6
 * @author Kilyen Attila - JGWVK9 
 */
public class Minesweeper{


    MinesweeperWindow MainWin;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Minesweeper().run();
    }
    
    void run(){
        MainWin = new MinesweeperWindow(new Logic());
    }
    
    
}
