package glidingstickmen.menu;

import glidingstickmen.characters.Stickman;
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
    private Scene scene;
    private BorderPane layout;
    private FightStage area;
    

    public UserInter(int width, int height) {
        this.width = width;
        this.height = height;
        this.layout = new BorderPane();
        area = new FightStage(width, height);
        area.createArea();
    }
    
    
    public void createMenu(Stage stage) {
        Stickman player1 = area.getPlayer1();
        
        VBox vButtons = makeVBox();
        Button menuButton = new Button("Menu");
        Button exitButton = new Button("Exit");
        
        //different button functions
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
        
        layout.setTop(menuButton);
        layout.setCenter(vButtons);
        layout.setBottom(exitButton);
        vButtons.setAlignment(Pos.CENTER);
        
        scene = new Scene(layout, width, height);
    }

    public Scene getScene() {
        return scene;
    }
    
    public void winScreen(int player) {
        VBox win = new VBox();
        Label text = new Label("Player " + player + " won!");
        Label score = new Label(getArea().getScore()[0] + " - " + getArea().getScore()[1]);
        win.getChildren().add(text);
        win.getChildren().add(score);
        win.setAlignment(Pos.CENTER);
        
        layout.setCenter(win);
    }

    public FightStage getArea() {
        return area;
    }
    
    public VBox makeVBox() {
        VBox vButtons = new VBox();
        Button playButton = new Button("Play!");
        Button statisticsButton = new Button("Some statistics");
        Button helpButton = new Button("Help");
        
        vButtons.getChildren().add(playButton);
        vButtons.getChildren().add(statisticsButton);
        vButtons.getChildren().add(helpButton);
        
        //different button functions
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                area = new FightStage(width, height);
                area.createArea();
                layout.setCenter(area.getArea());
            }
            
        });
        
        statisticsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(new Label("There is none!"));
            }
        });
        
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox commands = new VBox();
                Label player1 = new Label("Player 1:\n"
                        + "a    - move left\n"
                        + "d    - move right\n"
                        + "r    - low attack\n"
                        + "t    - medium attack\n"
                        + "y    - high attack\n\n\n\n");
                Label player2 = new Label("PLayer 2:\n"
                        + "left arrow - move left\n"
                        + "right arrow - move right\n"
                        + "-   - low attack\n"
                        + ".   - medium attack\n"
                        + ",   - high attack\n\n\n\n");
                Label help = new Label("it's basically rock-paper-scissors.\n"
                        + "- low wins high\n"
                        + "- medium wins low\n"
                        + "- high wins medium\n\n"
                        + "and no there is no animations yet.\n"
                        + "you have to guess what's going on.\n\n"
                        + "Also it's best of five\nand one hit gives you a round");
                
                commands.getChildren().add(player1);
                commands.getChildren().add(player2);
                commands.getChildren().add(help);
                commands.setAlignment(Pos.CENTER);
                layout.setCenter(commands);
            }
        });
        
        return vButtons;
    }

    public void setArea(FightStage area) {
        this.area = area;
    }
    
}
