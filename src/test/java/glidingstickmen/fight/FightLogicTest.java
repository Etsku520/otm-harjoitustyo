package glidingstickmen.fight;

import glidingstickmen.menu.FightStage;
import glidingstickmen.characters.Stickman;
import glidingstickmen.menu.UserInter;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FightLogicTest {
    FightLogic logic;
    Map<KeyCode, Boolean> pressedButtons;
    UserInter scene = new UserInter(1, 1);
    
    public FightLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pressedButtons = new HashMap<>();
        FightStage area = new FightStage(1500, 900);
        area.createArea();
        scene.setArea(area);
        logic = new FightLogic(scene, pressedButtons);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void p1Movement() {
        int place = scene.getArea().getPlayer1().getPosition()[0] +2;
        pressedButtons.put(KeyCode.D, Boolean.TRUE);
        logic.player1Movement();
        pressedButtons.put(KeyCode.D, Boolean.FALSE);
        assertEquals(place, scene.getArea().getPlayer1().getPosition()[0]);
        
        place = scene.getArea().getPlayer1().getPosition()[0] -2;
        pressedButtons.put(KeyCode.A, Boolean.TRUE);
        logic.player1Movement();
        assertEquals(place, scene.getArea().getPlayer1().getPosition()[0]);
    }
    
    @Test
    public void p2Movement() {
        int place = scene.getArea().getPlayer2().getPosition()[0] +2;
        pressedButtons.put(KeyCode.RIGHT, Boolean.TRUE);
        logic.player2Movement();
        pressedButtons.put(KeyCode.RIGHT, Boolean.FALSE);
        assertEquals(place, scene.getArea().getPlayer2().getPosition()[0]);
        
        place = scene.getArea().getPlayer2().getPosition()[0] -2;
        pressedButtons.put(KeyCode.LEFT, Boolean.TRUE);
        logic.player2Movement();
        assertEquals(place, scene.getArea().getPlayer2().getPosition()[0]);
    }
    
    @Test
    public void attackHitOrMiss() {
        assertEquals(0, logic.scoreOrWin(scene.getArea().getPlayer1(), scene.getArea().getPlayer2()));
        
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer1().setStance(1);
        
        assertEquals(-1, logic.scoreOrWin(scene.getArea().getPlayer1(), scene.getArea().getPlayer2()));
    }
    
    @Test
    public void stanceCounters() {
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        //stance 1
        pressedButtons.put(KeyCode.R, Boolean.TRUE);
        pressedButtons.put(KeyCode.COMMA, Boolean.TRUE);
        logic.player1Attack();
        scene.getArea().getPlayer2().setStance(2);
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.R, Boolean.FALSE);
        pressedButtons.put(KeyCode.COMMA, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.R, Boolean.TRUE);
        pressedButtons.put(KeyCode.PERIOD, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(3);
        logic.player1Attack();
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.R, Boolean.FALSE);
        pressedButtons.put(KeyCode.PERIOD, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.R, Boolean.TRUE);
        pressedButtons.put(KeyCode.MINUS, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(1);
        logic.player1Attack();
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.R, Boolean.FALSE);
        pressedButtons.put(KeyCode.MINUS, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        //stance 2
        pressedButtons.put(KeyCode.T, Boolean.TRUE);
        pressedButtons.put(KeyCode.COMMA, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(2);
        logic.player1Attack();
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.T, Boolean.FALSE);
        pressedButtons.put(KeyCode.COMMA, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.T, Boolean.TRUE);
        pressedButtons.put(KeyCode.PERIOD, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(3);
        logic.player1Attack();
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.T, Boolean.FALSE);
        pressedButtons.put(KeyCode.PERIOD, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.T, Boolean.TRUE);
        pressedButtons.put(KeyCode.MINUS, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(1);
        logic.player1Attack();
        assertEquals(2, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.T, Boolean.FALSE);
        pressedButtons.put(KeyCode.MINUS, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        //stance 3
        pressedButtons.put(KeyCode.Y, Boolean.TRUE);
        pressedButtons.put(KeyCode.COMMA, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(2);
        logic.player1Attack();
        assertEquals(2, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.Y, Boolean.FALSE);
        pressedButtons.put(KeyCode.COMMA, Boolean.FALSE);
        FightStage area = new FightStage(1500, 900);
        area.createArea();
        scene.setArea(area);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.Y, Boolean.TRUE);
        pressedButtons.put(KeyCode.PERIOD, Boolean.TRUE);;
        scene.getArea().getPlayer2().setStance(3);
        logic.player1Attack();
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.Y, Boolean.FALSE);
        pressedButtons.put(KeyCode.PERIOD, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.Y, Boolean.TRUE);
        pressedButtons.put(KeyCode.MINUS, Boolean.TRUE);
        scene.getArea().getPlayer2().setStance(1);
        logic.player1Attack();
        assertEquals(1, scene.getArea().getScore()[0]);
        pressedButtons.put(KeyCode.Y, Boolean.FALSE);
        pressedButtons.put(KeyCode.MINUS, Boolean.FALSE);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
    }
    
    @Test
    public void quickP2Attack() {
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        
        pressedButtons.put(KeyCode.COMMA, Boolean.TRUE);
        pressedButtons.put(KeyCode.R, Boolean.TRUE);
        scene.getArea().getPlayer1().setStance(1);
        
        //stance 1
        logic.player2Attack();
        assertEquals(0, scene.getArea().getScore()[1]);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
        pressedButtons.put(KeyCode.COMMA, Boolean.FALSE);
        
        pressedButtons.put(KeyCode.PERIOD, Boolean.TRUE);
        logic.player2Attack();
        assertEquals(1, scene.getArea().getScore()[1]);
        scene.getArea().getPlayer1().setPosition(new int[]{150, 225});
        scene.getArea().getPlayer2().setPosition(new int[]{150, 225});
    }
}
