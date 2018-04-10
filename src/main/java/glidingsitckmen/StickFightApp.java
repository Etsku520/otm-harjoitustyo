package glidingsitckmen;

import glidingsitckmen.menu.UserInter;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class StickFightApp extends Application{
    public static int WIDTH = 1000;
    public static int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Gliding Stickmen");
        UserInter scene = new UserInter(WIDTH, HEIGHT, primaryStage);
        scene.createMenu();
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        
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
                //player 1 movement
                if(pressedButtons.getOrDefault(KeyCode.D, Boolean.FALSE)) {
                    scene.movePlayer1Right();
                }                
                if(pressedButtons.getOrDefault(KeyCode.A, Boolean.FALSE)) {
                    scene.movePlayer1Left();
                }
                
                //player 2 movement
                if(pressedButtons.getOrDefault(KeyCode.RIGHT, Boolean.FALSE)) {
                    scene.movePlayer2Right();
                }                
                if(pressedButtons.getOrDefault(KeyCode.LEFT, Boolean.FALSE)) {
                    scene.movePlayer2Left();
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
