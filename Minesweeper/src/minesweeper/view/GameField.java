package minesweeper.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author yakno
 */
public final class GameField extends JPanel {

    private JButton[][] buttons;

    public GameField(int x, int y, int bomb){
        setPanel(x,y,bomb);
    }
    
    public void setPanel(int x,int y,int bomb){
        this.buttons = new JButton[x][y];
        this.removeAll();
        setPanelProperties(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.buttons[i][j] = new JButton();
                this.add(buttons[i][j]);
            }
        }
        
        this.validate();
        this.repaint();
    }

    private void setPanelProperties(int x, int y) {
        this.setVisible(true);
        this.setLayout(new GridLayout(x, y));
        this.setSize(x * 20 + 25, y * 20 + 25);
    }
}
