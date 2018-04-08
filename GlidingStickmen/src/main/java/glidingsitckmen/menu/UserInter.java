package glidingsitckmen.menu;

import glidingsitckmen.characters.Stickman;
import glidingsitckmen.fight.FightStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInter {
    private int width;
    private int height;
    private Scene menu;
    private BorderPane layout;
    private FightStage area;
    private Stage stage;
    

    public UserInter(int width, int height, Stage stage) {
        this.width = width;
        this.height = height;
        this.layout = new BorderPane();
        this.stage = stage;
        area = new FightStage(width, height);
        area.createArea();
    }
    
    
    public void createMenu() {
        Stickman player1 = area.getPlayer1();
        
        VBox vButtons = new VBox();
        Button menuButton = new Button("Menu");
        Button playButton = new Button("Play!");
        Button statisticsButton = new Button("Some statistics");
        Button exitButton = new Button("Exit");
        
        vButtons.getChildren().add(playButton);
        vButtons.getChildren().add(statisticsButton);
        
        //different button functions
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                area = new FightStage(width, height);
                area.createArea();
                layout.setCenter(area.getArea());
            }
            
        });
        
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
            
        });
        
        menuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(vButtons);
            }
            
        });
        
        statisticsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(new Label("There is none!"));
            }
            
        });
        
        layout.setTop(menuButton);
        layout.setCenter(vButtons);
        layout.setBottom(exitButton);
        vButtons.setAlignment(Pos.CENTER);
        
        menu = new Scene(layout, width, height);
    }

    public Scene getMenu() {
        return menu;
    }
    
    public void movePlayer1Right() {
        this.area.movePlayer1Right();
    }
    
    public void movePlayer1Left() {
        this.area.movePlayer1Left();
    }
    
    public void movePlayer2Right() {
        this.area.movePlayer2Right();
    }
    
    public void movePlayer2Left() {
        this.area.movePlayer2Left();
    }
}
