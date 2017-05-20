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
    
    public String getMinesCountAround(int a,int b){
        int c = 0;
        
        for(int i=a-1;i<=a+1;i++) for(int j=b-1;j<=+1;j++){
            if( i == a && j == b ) continue;
            
            
        }
        
        return Integer.toString(c);
    }
}
