package glidingstickmen.menu;

import glidingstickmen.characters.Stickman;
import glidingstickmen.dao.Score;
import glidingstickmen.dao.ScoreDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        area = new FightStage(width, height, "palyer 1", "player 2");
        area.createArea();
    }
    
    
    public void createMenu(Stage stage, ScoreDao scoredao) {
        Stickman player1 = area.getPlayer1();
        
        VBox vButtons = makeVBox(scoredao);
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
                VBox vButtons = makeVBox(scoredao);
                vButtons.setAlignment(Pos.CENTER);
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
        Label text = new Label("nobody won!");
        if (player == 1) {
            text = new Label(area.player1.getName() + " won!");
        } else {
            text = new Label(area.player2.getName() + " won!");
        }
        Label score = new Label(getArea().getScore()[0] + " - " + getArea().getScore()[1]);
        win.getChildren().add(text);
        win.getChildren().add(score);
        win.setAlignment(Pos.CENTER);
        
        layout.setCenter(win);
    }

    public FightStage getArea() {
        return area;
    }
    
    public VBox makeVBox(ScoreDao scoredao) {
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
                GridPane naming = playerNaming();
                naming.setAlignment(Pos.CENTER);
                layout.setCenter(naming);
            }
            
        });
        
        statisticsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Score> scores = new ArrayList<>();
                try {
                    scores = (ArrayList<Score>) scoredao.getScores();
                } catch (SQLException ex) {
                    Logger.getLogger(UserInter.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String text = "";
                for (Score score : scores) {
                    text += score.getPlayer1() + " | " + score.getScore1() + "-" + score.getScore2() + " | " + score.getPlayer2() + "\n";
                }
                
                if(scores.isEmpty()) {
                    text = "Go make stats";
                }
                
                Label score = new Label(text);
                
                layout.setCenter(score);
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
                        + "it's best of five\nand one hit gives you a round");
                
                commands.getChildren().add(player1);
                commands.getChildren().add(player2);
                commands.getChildren().add(help);
                commands.setAlignment(Pos.CENTER);
                layout.setCenter(commands);
            }
        });
        
        return vButtons;
    }
    
    public GridPane playerNaming() {
        GridPane naming = new GridPane();
        naming.setVgap(5);
        naming.setHgap(5);
        
        TextField p1Name = new TextField();
        p1Name.setPromptText("Player 1");
        GridPane.setConstraints(p1Name, 0, 0);
        naming.getChildren().add(p1Name);
        
        TextField p2Name = new TextField();
        p2Name.setPromptText("Player 2");
        GridPane.setConstraints(p2Name, 2, 0);
        naming.getChildren().add(p2Name);
        
        Button ready = new Button("Ready!");
        GridPane.setConstraints(ready, 1, 1);
        naming.getChildren().add(ready);
        
        ready.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                area = new FightStage(width, height, p1Name.getText(), p2Name.getText());
                area.createArea();
                layout.setCenter(area.getArea());
            }
        });
        
        return naming;
    }

    public void setArea(FightStage area) {
        this.area = area;
    }
    
}
