package minesweeper.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import minesweeper.logic.Logic;


/**
 * @author
 * 
 */
public class MinesweeperWindow extends JFrame implements ActionListener, MenuListener{
   
    // Menu elemek
    private JMenuBar menu;
    private JMenu newgame,highscores,help;    
    
    private JButton restart;
    
    private JLabel MinesLeft,Time;
    private final Timer timer;
    
    private final Logic logic;
    private final AbstractAction restartGame = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        };
    
    public MinesweeperWindow(Logic logic){
        this.logic = logic;
        
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
        
        setVisible(true);
    }
    
    private JMenuBar menu() {
        menu = new JMenuBar();
        
        newgame = new JMenu("Új Játék");
        newgame.addMenuListener(this);
        highscores = new JMenu("Top lista");
        highscores.addMenuListener(this);
        help = new JMenu("Segítség");
        help.addMenuListener(this);
        
        menu.add(newgame);
        menu.add(highscores);
        menu.add(help);
        
        return menu;
    }
    
    private JPanel InfoPanel()
    {
        JPanel infopanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,0));
        MinesLeft = new JLabel("    ");
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
    public void menuSelected(MenuEvent e) {
        if(e.getSource() == newgame) {
            new SettingsWindow().setVisible(true);
        }
    }
    // Ezek itt kellenek a menulistenerhez...
    @Override
    public void menuCanceled(MenuEvent e) {
        
    }    
    @Override
    public void menuDeselected(MenuEvent e) {
        
    }
    // Ne töröld ki
    // Kardos
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){
            UpdateTime();
        }
        if(e.getSource() == restart) {
            /*
            ******************************************
            TODO
            ******************************************
            */
            logic.startGame(10, 10, 10);
            InitMinesLeft(logic.getMinesCount()); // Függvénnyel lekérdezni az aktuális nehézséghez tartozó akna számokat!!!
            this.Time.setText("0");
            timer.start();
        }
    }
}
