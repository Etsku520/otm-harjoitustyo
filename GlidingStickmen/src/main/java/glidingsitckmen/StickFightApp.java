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
        UserInter menu = new UserInter(WIDTH, HEIGHT, primaryStage);
        menu.createMenu();
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        
        //function for setting keys to be pressed
        menu.getMenu().setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        menu.getMenu().setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long moment) {
                //player 1 movement
                if(pressedButtons.getOrDefault(KeyCode.D, Boolean.FALSE)) {
                    menu.movePlayer1Right();
                }                
                if(pressedButtons.getOrDefault(KeyCode.A, Boolean.FALSE)) {
                    menu.movePlayer1Left();
                }
                
                //player 2 movement
                if(pressedButtons.getOrDefault(KeyCode.RIGHT, Boolean.FALSE)) {
                    menu.movePlayer2Right();
                }                
                if(pressedButtons.getOrDefault(KeyCode.LEFT, Boolean.FALSE)) {
                    menu.movePlayer2Left();
                }
            }
        }.start();
        
        primaryStage.setScene(menu.getMenu());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(StickFightApp.class);
    }
}
