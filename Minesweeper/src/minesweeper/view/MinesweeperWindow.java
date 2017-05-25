package minesweeper.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import minesweeper.logic.Logic;


/**
 * @author
 * 
 */
public class MinesweeperWindow extends JFrame implements ActionListener{
   
    // Menu elemek
    private JMenuBar menu;
    private JMenuItem easy,normal,hard;
    
    private JLabel MinesLeft,Time;
    private final Timer timer;
    
    private final Logic logic;
    private final GameField gamefield;
    private int x,y,c;
    private final AbstractAction restartGame = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae){
                newGame(x,y,c);
                Time.setText("0");
                timer.start();
            }
        };
    
    public MinesweeperWindow(Logic logic){
        this.logic = logic;
        
        // Az ablak beallitasai
        setTitle("Aknakereső");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Menü sáv beállítás
        setJMenuBar(menu());
        
        // Panel és megjelenítés
        setLayout(new BorderLayout());
        add(InfoPanel(), BorderLayout.NORTH);
        this.x = 1; this.y = 0; this.c = 0;
        gamefield = new GameField(1,0);
        add(gamefield, BorderLayout.CENTER);
        
        timer = new Timer(1000,this);
        
        setVisible(true);
    }
    
    private JMenuBar menu() {
        menu = new JMenuBar();
        
        JMenu newgame = new JMenu("Új Játék");
        
        easy = new JMenuItem("Könnyű"); //10 10 10
        normal = new JMenuItem("Közepes"); //15 15 50
        hard = new JMenuItem("Nehéz"); //20 20 100
        
        easy.addActionListener(this);
        normal.addActionListener(this);
        hard.addActionListener(this);
        
        newgame.add(easy);
        newgame.add(normal);
        newgame.add(hard);
        
        JMenu highscores = new JMenu("Top lista");
        JMenu help = new JMenu("Segítség");
        
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
        
        JButton restart = new JButton("Restart");
        //restart.setActionCommand("restart");
        restart.addActionListener(restartGame);
        
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
    
    private void InitMinesLeft (int MineNumber) {
        this.MinesLeft.setText(Integer.toString(MineNumber));
    }
    
    private void MinesLeftDecrease () {
        int current = Integer.parseInt(this.MinesLeft.getText());
        this.MinesLeft.setText(Integer.toString(current-1));
    }
    
    private void MinesLeftIncrease () {
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
    
    public void newGame(int x,int y,int c){
        this.x = x; this.y = y; this.c = c;
        logic.startGame(x,y,c);
        gamefield.setPanel(x,y);
        InitMinesLeft(c);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == easy) {
            this.newGame(10, 10, 10);
            Time.setText("0");
            timer.start();
        }
        
        if(e.getSource() == normal) {
            this.newGame(15, 15, 50);
            Time.setText("0");
            timer.start();
        }
        
        if(e.getSource() == hard) {
            this.newGame(20, 20, 100);
            Time.setText("0");
            timer.start();
        }
        
        if(e.getSource() == timer){
            UpdateTime();
        }
        /*if(e.getActionCommand().equals("restart")){
            this.newGame(x,y,c);
            this.Time.setText("0");
            timer.start();
        }*/
    }
}
