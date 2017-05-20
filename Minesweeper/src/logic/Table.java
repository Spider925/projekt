package logic;

import java.util.Random;
import logic.field.*;

/**
 *
 * @author sanapci
 */
public class Table{
    private int x,y,c;
    private Field field[][];
    
    class Position{ int x,y; Position(int x,int y){ this.x = x; this.y = y; } 
                    public boolean compareTo(Position o){ return (o.x == x && o.y == y);} }
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
            int a = rand.nextInt(x),b = rand.nextInt(y);
            boolean found = false;
            
            do{
                mines[i] = new Position(a,b);
                
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
}
