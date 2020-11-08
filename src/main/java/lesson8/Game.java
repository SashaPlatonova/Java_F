package lesson8;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{
    private  static final ImageIcon ICON_X = new ImageIcon(Game.class.getResource("x.png"));
    private  static final ImageIcon ICON_O = new ImageIcon(Game.class.getResource("o.png"));
    private  static final ImageIcon ICON_DEFAULT = new ImageIcon(Game.class.getResource("def.png"));

    private final JButton[][] map = new JButton[3][3];
    private static int clickCount = 0;

    public void initMap(JPanel panel) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = new JButton();
                JButton btn = map[i][j];
                btn.setIcon(ICON_DEFAULT);
                btn.setDisabledIcon(ICON_DEFAULT);
                btn.addActionListener(a -> {
                    btn.setIcon(ICON_X);
                    btn.setDisabledIcon(ICON_X);
                    btn.setEnabled(false);
                    clickCount++;
                    if (clickCount == 9) {

                        stopGame("Ничья");
                    }
                    // TODO: 05.11.2020 move PC
                    // TODO: 05.11.2020 check victory
                    moveAI(map);
                    clickCount++;
                    if (isVictory(ICON_X, map)){
                        stopGame("Победа");
                    }
                    if (isVictory(ICON_O, map)){
                        stopGame("Поражение");
                    }
                });
                panel.add(btn);
            }
        }

    }
    private void moveAI (JButton[][] button){
        boolean isWinMove;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (button[i][j].getIcon()==ICON_DEFAULT){
                    button[i][j].setIcon(ICON_X);
                    isWinMove=isVictory(ICON_X, map);
                    if (isWinMove){
                        button[i][j].setIcon(ICON_O);
                        return;
                    }
                    button[i][j].setIcon(ICON_DEFAULT);
                }
            }
        }
        while (true) {
            int x = (int) (Math.random() * (3 - 1));
            int y = (int) (Math.random() * (3 - 1));
            if (button[x][y].getIcon()==ICON_DEFAULT) {
                button[x][y].setIcon(ICON_O);
                return;
            }
        }

    }
    private void stopGame(String name) {
        JFrame frame = new JFrame(name);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel p = new JPanel();
        JButton close = new JButton("CLOSE");
        close.addActionListener(e -> {
            dispose();
            frame.dispose();
        });
        JButton newGame = new JButton("NEW GAME");
        newGame.addActionListener(e -> {
            clickCount = 0;
            new Game();
            dispose();
            frame.dispose();
        });
        p.add(close);
        p.add(newGame);
        frame.add(p);
        frame.setVisible(true);
    }

    private boolean isVictory(ImageIcon imageIcon, JButton[][] button) {
        int checkRow=0, checkCol=0, checkDiag1=0, checkDiag2=0;

        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){

                if (button[i][j].getIcon()==imageIcon){
                    checkRow++;
                    if (i==j){
                        checkDiag1++;

                    }
                    if (i+j==2)
                        checkDiag2++;
                }

                if (button[j][i].getIcon()==imageIcon){
                    checkCol++;
                }

                if (checkRow==3||checkCol==3||checkDiag1==3||checkDiag2==3)
                    return true;
            }
            checkRow=0;
            checkCol=0;
        }
        return false;
    }

    public Game() throws HeadlessException {
        setSize(300, 300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,3));
        initMap(panel);
        add(panel);
        setResizable(false);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Game();
    }
}
