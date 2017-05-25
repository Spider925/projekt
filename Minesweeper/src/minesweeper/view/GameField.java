package minesweeper.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import minesweeper.logic.Logic;

/**
 *
 * @author yakno
 */
public final class GameField extends JPanel {

    private JButton[][] buttons;
    private final Logic logic;
    private final MinesweeperWindow sup;

    public GameField(MinesweeperWindow sup, Logic logic,int x, int y){
        this.sup = sup;
        this.logic = logic;
        setPanel(x,y);
    }
    
    public void setPanel(int x,int y){
        this.buttons = new JButton[x][y];
        this.removeAll();
        setPanelProperties(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.buttons[i][j] = new JButton();
                final int a = i,b = j;
                buttons[i][j].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        buttons[a][b].setText(logic.clickAction(a,b));
                        if(buttons[a][b].getText().equals("won"))
                            JOptionPane.showMessageDialog(sup,"You have won!");
                    }
                });
                this.add(buttons[i][j]);
            }
        }
        
        this.validate();
        this.repaint();
    }

    private void setPanelProperties(int x, int y) {
        this.setVisible(true);
        this.setLayout(new GridLayout(x, y));
        //this.setSize(x * 20 + 25, y * 20 + 25);
    }
}
