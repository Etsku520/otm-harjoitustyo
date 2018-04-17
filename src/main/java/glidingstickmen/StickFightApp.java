package glidingstickmen;

import glidingstickmen.characters.Stickman;
import glidingstickmen.fight.FightLogic;
import glidingstickmen.menu.UserInter;
import java.util.HashMap;
import java.util.Map;
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
        primaryStage.setTitle("Gliding Stickmen");
        UserInter scene = new UserInter(width, height);
        scene.createMenu(primaryStage);
        FightLogic logic = new FightLogic(scene, pressedButtons);
        
        //function for setting keys to be pressed
        scene.getScene().setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.getScene().setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long moment) {
                logic.player1Movement();
                logic.player2Movement();

                logic.player1Attack();
                logic.player2Attack();
            }
        }.start();
        
        
        primaryStage.setScene(scene.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(StickFightApp.class);
    }
}
