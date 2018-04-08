/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glidingsitckmen.characters;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 *
 * @author hceetu
 */
public class Stickman {
    int[] position;
    int player;
    Circle head;
    Polygon body;
    Polygon arm1;
    Polygon arm2;
    Polygon leg1;
    Polygon leg2;

    public Stickman(int[] position, int player) {
        this.position = position;
        this.player = player;
        head = new Circle(0, 0, 30);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150/2);
        body.setTranslateX(position[0] - 150/2);
        
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150/2 + 20);
        arm1.setTranslateX(position[0] - 150/2 + 40);
        
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150/2 + 20);
        arm2.setTranslateX(position[0] - 150/2 - 40);
        
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg1.setRotate(70);
        leg1.setTranslateY(position[1]+220);
        leg1.setTranslateX(position[0]-55);
        
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(-70);
        leg2.setTranslateY(position[1]+220);
        leg2.setTranslateX(position[0]-115);
    }

    public int[] getPosition() {
        return position;
    }
    
    
    public void putSickmanToPane(Pane area) {
        area.getChildren().add(head);
        area.getChildren().add(body);
        area.getChildren().add(arm1);
        area.getChildren().add(arm2);
        area.getChildren().add(leg1);
        area.getChildren().add(leg2);
    }

    public void setPosition(int[] position) {
        this.position = position;
        
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
        body.setTranslateY(position[1] + 150/2);
        body.setTranslateX(position[0] - 150/2);
        
        arm1.setTranslateY(position[1] + 150/2 + 20);
        arm1.setTranslateX(position[0] - 150/2 + 40);
        
        arm2.setTranslateY(position[1] + 150/2 + 20);
        arm2.setTranslateX(position[0] - 150/2 - 40);
        
        leg1.setTranslateY(position[1]+220);
        leg1.setTranslateX(position[0]-55);
        
        leg2.setTranslateY(position[1]+220);
        leg2.setTranslateX(position[0]-115);
    }
    
    
    
    
}
