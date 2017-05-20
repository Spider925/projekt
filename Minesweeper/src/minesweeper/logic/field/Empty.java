package minesweeper.logic.field;

/**
 *
 * @author sanapci
 */
public class Empty extends Field{
    @Override
    public boolean isMine(){ return false; }
}
