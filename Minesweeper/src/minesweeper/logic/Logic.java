package minesweeper.logic;

/**
 *
 * @author sanapci
 */
public class Logic {
    private final Table table;
    
    public Logic(){
        table = new Table();
    }
    
    public void startGame(int a,int b, int c){
        table.newGame(a,b,c);
    }
    
    public String clickAction(int a,int b){
        String result;
        
        if( table.getField(a,b).isMine() ) result = "-1";
        else if( checkWin() ) result = "won";
        else{
            result = Integer.toString(getMinesCountAround(a,b));
            table.getField(a, b).click();
        }
        
        return result;
    }
    
    private boolean checkWin(){
        int bc = 0;
        Position size = table.getSize();
        
        for(int i=0;i<size.x;i++) for(int j=0;j<size.y;j++) if( !table.getField(i,j).isClicked() ){
            boolean isBomb = false;
            int k = 0;
            
            while( !isBomb && k<table.getBombsNum() ){
                isBomb = table.getField(i,j).isMine();
                k++;
            }
            
            if( isBomb ) bc++;
        }
        
        return (bc == table.getBombsNum());
    }
    
    private int getMinesCountAround(int a,int b){
        int c = 0;
        
        for(int i=a-1;i<=a+1;i++) for(int j=b-1;j<=+1;j++){
            if( i == a && j == b ) continue;
            
            if( table.getField(i,j).isMine() ) c++;
        }
        
        return c;
    }
}
