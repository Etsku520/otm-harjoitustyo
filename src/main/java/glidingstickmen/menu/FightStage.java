package glidingstickmen.menu;

import glidingstickmen.characters.Stickman;
import javafx.scene.layout.Pane;


public class FightStage {
    Pane area;
    private int widht;
    private int heigth;
    int[] score;
    Stickman player1;
    Stickman player2;

    public FightStage(int widht, int heigth, String p1Name, String p2Name) {
        this.widht = widht;
        this.heigth = heigth;
        area = new Pane();
        score = new int[2];
        player1 = new Stickman(new int[]{100, 225}, 1, p1Name);
        player2 = new Stickman(new int[]{900, 225}, 2, p2Name);
        
    }
    
    public void createArea() {
        player1.putSickmanToPane(area);
        player2.putSickmanToPane(area);
        player1.position1M(area);
    }

    public Pane getArea() {
        return area;
    }

    public Stickman getPlayer1() {
        return player1;
    }

    public Stickman getPlayer2() {
        return player2;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
    
    public void resetPositions() {
        player1.setPosition(new int[] {100, 225}, area, 0);
        player2.setPosition(new int[] {900, 225}, area, 0);
    }
}
