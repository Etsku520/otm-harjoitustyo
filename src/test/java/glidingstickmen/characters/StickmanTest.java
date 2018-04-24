package glidingstickmen.characters;

import javafx.scene.layout.Pane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StickmanTest {
    Stickman stickman;
    
    public StickmanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stickman = new Stickman(new int[]{100, 200} ,1, "rick");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getPosition() {
        assertEquals(100, stickman.getPosition()[0]);
        assertEquals(200, stickman.getPosition()[1]);
    }

    @Test
    public void setPosition() {
        int[] place = new int[]{145, 111};
        stickman.setPosition(place, new Pane(), 2);
        
        assertEquals(place, stickman.getPosition());
    }
}
