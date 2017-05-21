package minesweeper.logic;

import minesweeper.logic.field.Field;
import minesweeper.logic.field.Mine;
import minesweeper.logic.field.Empty;
import java.util.Random;

/**
 *
 * @author sanapci
 */
public class Table{
    private int x,y,c;
    private Field field[][];
    private Position mines[];
    
    public Table(){}
    public Table(int x, int y, int c){
        newTable(x,y,c);
    }
    
    public void newGame(int x,int y,int c){
        newTable(x,y,c);
    }
    
    private void generateMines(){
        mines = new Position[c];
        Random rand = new Random();
        
        for(int i=0;i<c;i++){
            boolean found;
            
            do{
                found = false;
                mines[i] = new Position(rand.nextInt(x),rand.nextInt(y));
                
                int j = 0;
                while( !found && j<i){
                    found = mines[i].compareTo(mines[j]);
                    j++;
                }
            }while(found);
        }
    }
    
    private void newTable(int x,int y,int c){
        this.x = x;
        this.y = y;
        this.c = c;
        generateMines();
        field = new Field[x][y];
        
        for(int i=0;i<x;i++) for(int j=0;j<y;j++){
            if( isMine(i,j) ) field[i][j] = new Mine();
            else field[i][j] = new Empty();
        }
    }
    
    private boolean isMine(int a,int b){
        boolean found = false;
        int i = 0;
        Position currentField = new Position(a,b);
        
        while( !found && i<c ){
            found = currentField.compareTo(mines[i]);
            i++;
        }
        
        return found;
    }
    
    public Field getField(int a,int b){ return field[a][b]; }
    Position getSize(){ return new Position(x,y); }
    public int getBombsNum(){ return c; }
}
