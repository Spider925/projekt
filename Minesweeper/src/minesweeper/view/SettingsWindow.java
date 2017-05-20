
package minesweeper.view;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;


public class SettingsWindow extends JFrame
                           implements ActionListener{
    
    
    private JButton startgame;
    private ButtonGroup difficulty;
    
    public SettingsWindow() {
        
        // Az ablak beallitasai
        setTitle("Aknakereső - Új játék");
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        // Panel és megjelenítés
        setLayout(new BorderLayout());
        
        JRadioButton easybutton = new JRadioButton("Könnyű");
        JRadioButton normalbutton = new JRadioButton("Közepes");
        JRadioButton hardbutton = new JRadioButton("Nehéz");
        
        difficulty = new ButtonGroup();
        difficulty.add(easybutton);
        difficulty.add(normalbutton);
        difficulty.add(hardbutton);
        
        
        add(easybutton, BorderLayout.NORTH);
        
        startgame = new JButton("OK");
        startgame.addActionListener(this);
        add(startgame, BorderLayout.SOUTH);        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startgame) {
            
        }
    }
}
