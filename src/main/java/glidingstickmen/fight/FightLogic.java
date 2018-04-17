package glidingstickmen.fight;

import glidingstickmen.characters.Stickman;
import glidingstickmen.menu.UserInter;
import java.util.Map;
import javafx.scene.input.KeyCode;

public class FightLogic {
    private UserInter scene;
    Map<KeyCode, Boolean> pressedButtons;
    
    public FightLogic(UserInter scene, Map<KeyCode, Boolean> pressedButtons) {
        this.scene = scene;
        this.pressedButtons = pressedButtons;
    }
    
    public void checkPressedButtons() {
        player1Movement();
        player2Movement();

        player1Attack();
        player2Attack();
    }
    
    public void player1Movement() {
        if (pressedButtons.getOrDefault(KeyCode.D, Boolean.FALSE)) {
            moveRight(scene.getArea().getPlayer1(), 2);
        }                
        if (pressedButtons.getOrDefault(KeyCode.A, Boolean.FALSE)) {
            moveLeft(scene.getArea().getPlayer1(), 2);
        }
    }
    
    public void player2Movement() {
        if (pressedButtons.getOrDefault(KeyCode.RIGHT, Boolean.FALSE)) {
            moveRight(scene.getArea().getPlayer2(), 2);
        }                
        if (pressedButtons.getOrDefault(KeyCode.LEFT, Boolean.FALSE)) {
            moveLeft(scene.getArea().getPlayer2(), 2);
        }
    }
    
    public void player1Attack() {
        boolean attack = false;
        if (pressedButtons.getOrDefault(KeyCode.R, Boolean.FALSE)) {
            scene.getArea().getPlayer1().setStance(1);            
        }


        if (pressedButtons.getOrDefault(KeyCode.T, Boolean.FALSE)) {
            scene.getArea().getPlayer1().setStance(3);
        }

        if (pressedButtons.getOrDefault(KeyCode.Y, Boolean.FALSE)) {
            scene.getArea().getPlayer1().setStance(2);
        }

        if (!pressedButtons.getOrDefault(KeyCode.R, Boolean.FALSE) && !pressedButtons.getOrDefault(KeyCode.T, Boolean.FALSE) 
                && !pressedButtons.getOrDefault(KeyCode.Y, Boolean.FALSE)) {
            scene.getArea().getPlayer1().setStance(0);
        } else {
            int hit = scoreOrWin(scene.getArea().getPlayer1(), 
                    scene.getArea().getPlayer2());

            if (hit < 0) {
                scene.getArea().resetPositions();
            }
            if (hit > 0) {
                scene.winScreen(hit);
            }
        }
    }
    
    public void player2Attack() {
        if (pressedButtons.getOrDefault(KeyCode.MINUS, Boolean.FALSE)) {
            scene.getArea().getPlayer2().setStance(1);
        }

        if (pressedButtons.getOrDefault(KeyCode.PERIOD, Boolean.FALSE)) {
            scene.getArea().getPlayer2().setStance(3);
        }

        if (pressedButtons.getOrDefault(KeyCode.COMMA, Boolean.FALSE)) {
            scene.getArea().getPlayer2().setStance(2);
        }

        if (!pressedButtons.getOrDefault(KeyCode.MINUS, Boolean.FALSE) && !pressedButtons.getOrDefault(KeyCode.PERIOD, Boolean.FALSE) 
                && !pressedButtons.getOrDefault(KeyCode.COMMA, Boolean.FALSE)) {
            scene.getArea().getPlayer2().setStance(0);
        } else {
            int hit = scoreOrWin(scene.getArea().getPlayer2(), 
                    scene.getArea().getPlayer1());

            if (hit < 0) {
                scene.getArea().resetPositions();
            }
            if (hit > 0) {
                scene.winScreen(hit);
            }
        }
    }
    
    public boolean moveRight(Stickman stickman, int x) {
        int[] position = stickman.getPosition();
        if (position[0] + 50 + x < 1000 && x > 0) {
            position[0] = position[0] + x;
            stickman.setPosition(position);
            return true;
        }
        return false;
    }
    
    public boolean moveLeft(Stickman stickman, int x) {
        int[] position = stickman.getPosition();
        if (position[0] - 50 - x > 0 && x > 0) {
            position[0] = position[0] - x;
            stickman.setPosition(position);
            return true;
        }
        return false;
    }
    
    public int scoreOrWin(Stickman stickman1, Stickman stickman2) {
        if (Math.abs(stickman2.getPosition()[0] - stickman1.getPosition()[0]) < 300) {
            if (stickman1.getStance() - stickman2.getStance() == -1 
                    || stickman1.getStance() - stickman2.getStance() == stickman1.getStance() 
                    || stickman1.getStance() - stickman2.getStance() == 2) {
                int player = stickman1.getPlayer();                
                scene.getArea().getScore()[player - 1] = scene.getArea().getScore()[player - 1] + 1;

                if (scene.getArea().getScore()[player - 1] == 3) {
                    return player;
                }
                return -1;
            }        
        }
        return 0;
            
    }
}
