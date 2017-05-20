package minesweeper;


import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

import minesweeper.view.MinesweeperWindow;

/**
 *
 * @author:
 * Kardos Gergo - FM7AUC
 * Kilyen Attila - JGWVK9
 * Elek David - DEG8I6
 */
public class Minesweeper{

    /**
     * @param args the command line arguments
     */
    MinesweeperWindow MainWin;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Minesweeper().run();
    }
    
    void run(){
        MainWin = new MinesweeperWindow();
    }
    
    
}
