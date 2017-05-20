package logic;

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
        else result = Integer.toString(getMinesCountAround(a,b));
        
        return result;
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
