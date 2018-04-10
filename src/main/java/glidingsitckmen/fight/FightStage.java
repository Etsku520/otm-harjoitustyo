package glidingsitckmen.fight;

import glidingsitckmen.characters.Stickman;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class FightStage {
    Pane area;
    private int widht;
    private int heigth;
    int[] score;
    Stickman player1;
    Stickman player2;

    public FightStage(int widht, int heigth) {
        this.widht = widht;
        this.heigth = heigth;
        area = new Pane();
        score = new int[2];
        player1 = new Stickman(new int[]{100, 225}, 1);
        player2 = new Stickman(new int[]{900, 225}, 2);
    }
    
    public void createArea() {
        player1.putSickmanToPane(area);
        player2.putSickmanToPane(area);
    }

    public Pane getArea() {
        return area;
    }

    public Stickman getPlayer1() {
        return player1;
    }
    
    public void movePlayer1Right() {
        int[] position = player1.getPosition();
        if(position[0] + 50 < 1000) {
            position[0] = position[0] + 2;
        }
        player1.setPosition(position);
    }
    
    public void movePlayer1Left() {
        int[] position = player1.getPosition();
        if(position[0]-50 > 0) {
            position[0] = position[0] - 2;
        }
        player1.setPosition(position);
    }
    
    public void movePlayer2Right() {
        int[] position = player2.getPosition();
        if(position[0] + 50 < 1000) {
            position[0] = position[0] + 2;
        }
        player2.setPosition(position);
    }
    
    public void movePlayer2Left() {
        int[] position = player2.getPosition();
        if(position[0]-50 > 0) {
            position[0] = position[0] - 2;
        }
        player2.setPosition(position);
    }
}
