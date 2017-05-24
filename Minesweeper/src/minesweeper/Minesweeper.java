package minesweeper;


import minesweeper.logic.Logic;

import minesweeper.view.MinesweeperWindow;
import minesweeper.view.SettingsWindow;

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
    SettingsWindow SettingsWin;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Minesweeper().run();
    }
    
    void run(){
        MainWin = new MinesweeperWindow(new Logic());
        SettingsWin = new SettingsWindow();
        
    }
    
    
}
