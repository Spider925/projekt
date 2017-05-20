/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.logic.field;

/**
 *
 * @author sanapci
 */
public abstract class Field {
    private boolean isClicked = false;
    
    public abstract boolean isMine();
    public void click(){ isClicked = true; }
    public boolean isClicked(){ return isClicked; }
}
