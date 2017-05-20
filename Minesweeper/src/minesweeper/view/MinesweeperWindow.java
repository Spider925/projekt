package minesweeper.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


/**
 * @author
 * 
 */
public class MinesweeperWindow extends JFrame
                                implements ActionListener{
   
    // Menu elemek
    private JMenuBar menu;
    private JMenu newgame,highscores,help;    
    
    private JButton restart;
    
    private JLabel MinesLeft,Time;
    private Timer timer;
    
    public MinesweeperWindow(){
        
        // Az ablak beallitasai
        setTitle("Aknakereső");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Menü sáv beállítás
        setJMenuBar(menu());
        
        // Panel és megjelenítés
        setLayout(new BorderLayout());
        add(InfoPanel(), BorderLayout.NORTH);
        add(GamePanel(), BorderLayout.SOUTH);
        
        timer = new Timer(1000,this);
        TimerStart();
        
        setVisible(true);
    }
    
    private JMenuBar menu() {
        menu = new JMenuBar();
        
        newgame = new JMenu("Új Játék");
        highscores = new JMenu("Top lista");
        help = new JMenu("Segítség");
        
        menu.add(newgame);
        menu.add(highscores);
        menu.add(help);
        
        return menu;
    }
    
    private JPanel InfoPanel()
    {
        JPanel infopanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        
        MinesLeft = new JLabel("NUM");
        MinesLeft.setFont(new Font("Serif", Font.BOLD, 30));
        MinesLeft.setForeground(Color.red);
        
        JLabel MinesLeftInfo = new JLabel("Akna maradt");
        MinesLeft.setBorder(null);
        
        infopanel.add(MinesLeft);
        infopanel.add(MinesLeftInfo);
        
        restart = new JButton("Restart");
        restart.addActionListener(this);
        
        infopanel.add(restart);

        Time = new JLabel("0");       
        Time.setFont(new Font("Serif", Font.BOLD, 30));
        infopanel.add(Time);
        
        return infopanel;
    }
    
    private JPanel GamePanel()
    {
        JPanel gamepanel = new JPanel(new GridLayout());
        
        
        return gamepanel;
    }
    
    public void InitMinesLeft (int MineNumber) {
        this.MinesLeft.setText(Integer.toString(MineNumber));
    }
    
    public void MinesLeftDecrease () {
        int current = Integer.parseInt(this.MinesLeft.getText());
        this.MinesLeft.setText(Integer.toString(current-1));
    }
    
    public void MinesLeftIncrease () {
        int current = Integer.parseInt(this.MinesLeft.getText());
        this.MinesLeft.setText(Integer.toString(current+1));
    }
    
    private void TimerStart() {
        timer.start();        
    }
    
    private void TimerStop() {
        timer.stop();
    }
    
    private void UpdateTime(){
        int current = Integer.parseInt(this.Time.getText());
        this.Time.setText(Integer.toString(current+1));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){
            UpdateTime();
        }
        if(e.getSource() == restart) {
            InitMinesLeft(60);
        }
    }
}