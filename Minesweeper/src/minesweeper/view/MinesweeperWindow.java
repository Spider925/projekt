package minesweeper.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import minesweeper.logic.Logic;


/**
 * @author Kardos Gergő
 * @author Elek Dávid
 */

/**
 * Ez az osztály valósítja meg a felhasználói felületet. 
 * @author Kardos Gergő
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
    /**
     * Újra indítja a játékot ugyanazon a nehézségi fokozaton
     */
    private final AbstractAction restartGame = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae){
                newGame(x,y,c);
                Time.setText("0");
                timer.start();
            }
        };
    /**
     * Az ablak beállítása, menü sáv, játékmező, számlálók, újra indítás gomb elhelyezése
     */
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
        gamefield = new GameField(this,logic,1,0);
        add(gamefield, BorderLayout.CENTER);
        
        timer = new Timer(1000,this);
        
        setVisible(true);
    }
    /**
     * Menü pontok kiakalíkátsa. <br>
     * Új játék menüpont alatt 3 további lehetőség, ezekből választva a játék nehézségi szintje állítható, melyek a következők:<br>
     * Könnyű - 10x10-es játékmező, 10 darab bombával<br>
     * Közepes - 15x15-es játékmező, 50 darab bombával<br>
     * Nehéz - 20x20-as játékmező, 100 darab bombával
     */
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
        //menu.add(highscores);
        //menu.add(help);
        
        return menu;
    }
    /**
     * Ezen a felületen tároljuk a játékhoz szükséges funkciókat.
     * A MinesLeft label-ön a játékos által még nem megjelölt bombákat jelezzük.
     * Restart gomb segítségével újra indítható a játék ugyanazon a nehézségi fokozaton
     * A Time label-ön pedig az eltelt időt számoljuk, másodpercben számolva.  
     */
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
        restart.addActionListener(restartGame);
        
        infopanel.add(restart);

        Time = new JLabel("0");       
        Time.setFont(new Font("Serif", Font.BOLD, 30));
        infopanel.add(Time);
        
        return infopanel;
    }
    /**
     * A játékmező kialakítása
     * @see minesweeper.view.GameField
     */
    private JPanel GamePanel()
    {
        JPanel gamepanel = new JPanel(new GridLayout());
        
        
        return gamepanel;
    }
    /**
     * Beállítja a bomba számlálót
     * @param MineNumber A játék nehézségéhez tartozó bomba szám
     */
    private void InitMinesLeft (int MineNumber) {
        this.MinesLeft.setText(Integer.toString(MineNumber));
    }
    /**
     * A bombák számát csökkenti eggyel
     */
    private void MinesLeftDecrease () {
        int current = Integer.parseInt(this.MinesLeft.getText());
        this.MinesLeft.setText(Integer.toString(current-1));
    }
    /**
     * A bombák számát növeli eggyel
     */
    private void MinesLeftIncrease () {
        int current = Integer.parseInt(this.MinesLeft.getText());
        this.MinesLeft.setText(Integer.toString(current+1));
    }
    /**
     * A számláló elindítása
     */
    private void TimerStart() {
        timer.start();        
    }
    /**
     * A számláló leállítása
     */
    private void TimerStop() {
        timer.stop();
    }
    /**
     * A felhasználói felületen elhelyezett számláló frissítése másodpercenként
     */
    private void UpdateTime(){
        int current = Integer.parseInt(this.Time.getText());
        this.Time.setText(Integer.toString(current+1));
    }
    /**
     * Új játék esetén a nehézségnek megfelelően meghívjuk a logic és GameField játék inicializáló függvényeit.
     * @param x Sorok száma
     * @param y Oszlopok száma
     * @param c Bombák száma
     */
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
    }
}
