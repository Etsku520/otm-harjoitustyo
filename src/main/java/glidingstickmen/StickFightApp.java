package glidingstickmen;

import glidingstickmen.characters.Stickman;
import glidingstickmen.dao.Database;
import glidingstickmen.dao.ScoreDao;
import glidingstickmen.fight.FightLogic;
import glidingstickmen.menu.UserInter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class StickFightApp extends Application {
    public int width = 1000;
    public int height = 600;
    public Map<KeyCode, Boolean> pressedButtons = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Database db = new Database();
        ScoreDao scoreDao = new ScoreDao(db.getConnection());
        primaryStage.setTitle("Gliding Stickmen");
        UserInter scene = new UserInter(width, height);
        scene.createMenu(primaryStage, scoreDao);
        FightLogic logic = new FightLogic(scene, pressedButtons, scoreDao);
        
        //function for setting keys to be pressed
        scene.getScene().setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.getScene().setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer()  {
            @Override
            public void handle(long moment) {
                logic.player1Movement();
                logic.player2Movement();

                try {
                    logic.player1Attack();
                } catch (SQLException ex) {
                    Logger.getLogger(StickFightApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    logic.player2Attack();
                } catch (SQLException ex) {
                    Logger.getLogger(StickFightApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        
        
        primaryStage.setScene(scene.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(StickFightApp.class);
    }
}
