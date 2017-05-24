
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
        setSize(50,180);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
                
        // Panel és megjelenítés
        setLayout(new BorderLayout());
        
        JLabel info = new JLabel("Válassz nehézséget");
        info.setHorizontalAlignment(JLabel.CENTER);
        add(info, BorderLayout.PAGE_START);
        
        JPanel diff = new JPanel();
        
        JRadioButton easybutton = new JRadioButton("Könnyű");
        JRadioButton normalbutton = new JRadioButton("Közepes");
        JRadioButton hardbutton = new JRadioButton("Nehéz");
        
        easybutton.setActionCommand("easy");
        normalbutton.setActionCommand("normal");
        hardbutton.setActionCommand("hard");
        
        difficulty = new ButtonGroup();
        difficulty.add(easybutton);
        difficulty.add(normalbutton);
        difficulty.add(hardbutton);
        
        diff.add(easybutton);
        diff.add(normalbutton);
        diff.add(hardbutton);
        
        add(diff);
        
        startgame = new JButton("OK");
        startgame.addActionListener(this);
        add(startgame, BorderLayout.SOUTH);       

        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startgame) {
            try {
            String selection = difficulty.getSelection().getActionCommand();
            switch (selection) {
                case "easy":
                    break;
                case "normal":
                    break;
                case "hard":
                    break;
            }
            }
            catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Nincs kiválasztva nehézség!");
            }
            
        }
    }
}
