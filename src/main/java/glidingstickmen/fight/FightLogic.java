package glidingstickmen.fight;

import glidingstickmen.characters.Stickman;
import glidingstickmen.dao.Score;
import glidingstickmen.dao.ScoreDao;
import glidingstickmen.menu.UserInter;
import java.sql.SQLException;
import java.util.Map;
import javafx.scene.input.KeyCode;

/**
* Meant to contain much of the logic behind the game and by much I mean all.
*/
public class FightLogic {
    private UserInter scene;
    Map<KeyCode, Boolean> pressedButtons;
    ScoreDao scoreDao;
    
    /**
    *Meant to contain much of the logic behind the game and by much I mean all.
    * 
    * @param scene              an unser interface used in the game
    * @param pressedButtons     a map use for seeing what buttons are pressed
    * @param scoreDao           ScoreDao used for database funcions
    */
    public FightLogic(UserInter scene, Map<KeyCode, Boolean> pressedButtons, ScoreDao scoreDao) {
        this.scene = scene;
        this.pressedButtons = pressedButtons;
        this.scoreDao = scoreDao;
    }
    
    /**
     * checks if player 1 should be moving and how fast
     */
    public void player1Movement() {
        if (pressedButtons.getOrDefault(KeyCode.D, Boolean.FALSE)) {
            int x = 2;
            if (scene.getArea().getPlayer1().getStance() != 0) {
                x = 1;
            }
            moveRight(scene.getArea().getPlayer1(), x);
        }                
        if (pressedButtons.getOrDefault(KeyCode.A, Boolean.FALSE)) {
            int x = 2;
            if (scene.getArea().getPlayer1().getStance() != 0) {
                x = 1;
            }
            moveLeft(scene.getArea().getPlayer1(), x);
        }
    }
    
    /**
     * checks if player 2 should be moving and how fast
     */
    public void player2Movement() {
        if (pressedButtons.getOrDefault(KeyCode.RIGHT, Boolean.FALSE)) {
            int x = 2;
            if (scene.getArea().getPlayer2().getStance() != 0) {
                x = 1;
            }
            moveRight(scene.getArea().getPlayer2(), x);
        }
        
        if (pressedButtons.getOrDefault(KeyCode.LEFT, Boolean.FALSE)) {
            int x = 2;
            if (scene.getArea().getPlayer2().getStance() != 0) {
                x = 1;
            }
            moveLeft(scene.getArea().getPlayer2(), x);
        }
    }
    
    /**
     * checks if a player 1 is attacking and checks the score
     * 
     * @throws SQLException 
     */
    public void player1Attack() throws SQLException {
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
        moveLeft(scene.getArea().getPlayer1(), 0);
    }
    
    /**
     * checks if a player 2 is attacking and checks the score
     * 
     * @throws SQLException 
     */
    public void player2Attack() throws SQLException {
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
        moveLeft(scene.getArea().getPlayer2(), 0);
    }
    
    /**
     * Moves a player to right
     * 
     * @param stickman  The player that will be moved
     * @param x         The amount the player is moved
     * @return false if player hits a wall
     */
    public boolean moveRight(Stickman stickman, int x) {
        int[] position = stickman.getPosition();
        if (position[0] + 50 + x < 1000 && x >= 0) {
            position[0] = position[0] + x;
            if (scene.getArea().getPlayer1() != stickman) {
                stickman.setPosition(position, scene.getArea().getArea(), stickman.getPosition()[0] - scene.getArea().getPlayer1().getPosition()[0]);
            } else {
                stickman.setPosition(position, scene.getArea().getArea(), stickman.getPosition()[0] - scene.getArea().getPlayer2().getPosition()[0]);
            }
            
            return true;
        }
        return false;
    }
    
    /**
     * Moves a player to left
     * 
     * @param stickman  The player that will be moved
     * @param x         The amount the player is moved
     * @return false if player hits a wall
     */
    public boolean moveLeft(Stickman stickman, int x) {
        int[] position = stickman.getPosition();
        if (position[0] - 50 - x > 0 && x >= 0) {
            position[0] = position[0] - x;
            if (scene.getArea().getPlayer1() != stickman) {
                stickman.setPosition(position, scene.getArea().getArea(), stickman.getPosition()[0] - scene.getArea().getPlayer1().getPosition()[0]);
            } else {
                stickman.setPosition(position, scene.getArea().getArea(), stickman.getPosition()[0] - scene.getArea().getPlayer2().getPosition()[0]);
            }
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the first given player hits the other one and changes the score
     * 
     * @param stickman1 character of player 1
     * @param stickman2 character of player 2
     * @return 0 if out of range, -1 if hit and the players number if the game is won
     * @throws SQLException 
     */
    public int scoreOrWin(Stickman stickman1, Stickman stickman2) throws SQLException {
        if (Math.abs(stickman2.getPosition()[0] - stickman1.getPosition()[0]) < 180) {
            if (stickman1.getStance() - stickman2.getStance() == -1 
                    || stickman1.getStance() - stickman2.getStance() == stickman1.getStance() 
                    || stickman1.getStance() - stickman2.getStance() == 2) {
                int player = stickman1.getPlayer();                
                scene.getArea().getScore()[player - 1] = scene.getArea().getScore()[player - 1] + 1;

                if (scene.getArea().getScore()[player - 1] == 3) {
                    Score score = new Score(scene.getArea().getPlayer1().getName(), 
                            scene.getArea().getPlayer2().getName(), 
                            scene.getArea().getScore()[0], scene.getArea().getScore()[1]);
                    
                    scoreDao.addScore(score);
                    
                    return player;
                }
                return -1;
            }        
        }
        return 0;
            
    }
}
