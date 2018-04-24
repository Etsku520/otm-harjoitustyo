/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glidingstickmen.characters;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 *
 * @author hceetu
 */
public class Stickman {
    int[] position;
    int stance;
    int player;
    String name;
    Circle head;
    Polygon body;
    Polygon arm1;
    Polygon arm2;
    Polygon leg1;
    Polygon leg2;

    public Stickman(int[] position, int player, String name) {
        this.position = position;
        this.player = player;
        this.stance = 0;
        this.name = name;
        head = new Circle(0, 0, 30);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150 / 2);
        body.setTranslateX(position[0] - 150 / 2);
        
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150 / 2 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 40);
        
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 40);
        
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg1.setRotate(70);
        leg1.setTranslateY(position[1] + 220);
        leg1.setTranslateX(position[0] - 55);
        
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(-70);
        leg2.setTranslateY(position[1] + 220);
        leg2.setTranslateX(position[0] - 115);
    }

    public int[] getPosition() {
        return position;
    }

    public int getPlayer() {
        return player;
    }

    public int getStance() {
        return stance;
    }

    public String getName() {
        return name;
    }
    
    
    public void putSickmanToPane(Pane area) {
        area.getChildren().add(head);
        area.getChildren().add(body);
        area.getChildren().add(arm1);
        area.getChildren().add(arm2);
        area.getChildren().add(leg1);
        area.getChildren().add(leg2);
    }

    public void setStance(int stance) {
        this.stance = stance;
        
    }

    public void setPosition(int[] position, Pane area, int x) {
        this.position = position;
        
        if (this.stance == 0) {
            position0(area);
        }
        
        else if (this.stance == 1 && x < 0) {
            position1(area);
        } else if (this.stance == 1) {
            position1M(area);
        }
        
        else if (this.stance == 2 && x < 0) {
            position2(area);
        } else if (this.stance == 2) {
            position2M(area);
        }
        
        else if (this.stance == 3 && x < 0) {
            position3(area);
        } else {
            position3M(area);
        }
    }
    
    public void position0 (Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150 / 2);
        body.setTranslateX(position[0] - 150 / 2);
        
        area.getChildren().remove(arm1);
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm1);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150 / 2 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 40);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 40);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(70);
        leg1.setTranslateY(position[1] + 220);
        leg1.setTranslateX(position[0] - 55);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(-70);
        area.getChildren().add(leg2);
        leg2.setTranslateY(position[1] + 220);
        leg2.setTranslateX(position[0] - 115);
    }
    
    public void position1(Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1] + 75);
        head.setTranslateX(position[0]);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150);
        body.setTranslateX(position[0] - 150 / 2);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(70);
        arm1.setTranslateY(position[1] + 150 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 40);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 40);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 85, 0, 85, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(-70);
        leg1.setTranslateY(position[1] + 250);
        leg1.setTranslateX(position[0] - 55);

        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg2);
        leg2.setRotate(20);
        leg2.setTranslateY(position[1] + 250);
        leg2.setTranslateX(position[0] - 15);
    }
    
    public void position1M(Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1] + 75);
        head.setTranslateX(position[0]);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150);
        body.setTranslateX(position[0] - 150 / 2);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(70);
        arm1.setTranslateY(position[1] + 150 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 40);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 40);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 85, 0, 85, 20, 0, 20);
        area.getChildren().add(leg2);
        leg2.setRotate(70);
        leg2.setTranslateY(position[1] + 250);
        leg2.setTranslateX(position[0] - 25);

        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(-20);
        leg1.setTranslateY(position[1] + 250);
        leg1.setTranslateX(position[0] - 150);
    }
    
    public void position2M (Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150 / 2);
        body.setTranslateX(position[0] - 150 / 2);
        
        area.getChildren().remove(arm1);
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm1);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150 / 2 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 40);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 40);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(70);
        leg1.setTranslateY(position[1] + 220);
        leg1.setTranslateX(position[0] - 55);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(35);
        area.getChildren().add(leg2);
        leg2.setTranslateY(position[1] + 105);
        leg2.setTranslateX(position[0] - 155);
    }
    
    public void position2 (Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150 / 2);
        body.setTranslateX(position[0] - 150 / 2);
        
        area.getChildren().remove(arm1);
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm1);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150 / 2 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 40);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 40);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(-35);
        leg1.setTranslateY(position[1] + 105);
        leg1.setTranslateX(position[0] - 15);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(-70);
        area.getChildren().add(leg2);
        leg2.setTranslateY(position[1] + 220);//220
        leg2.setTranslateX(position[0] - 115);//-55
    }
    
    public void position3 (Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0] - 25);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150 / 2);
        body.setTranslateX(position[0] - 150 / 2 - 25);
        
        area.getChildren().remove(arm1);
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm1);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150 / 2 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 15);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 65);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(5);
        leg1.setTranslateY(position[1] + 170);
        leg1.setTranslateX(position[0] - 30);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(-85);
        area.getChildren().add(leg2);
        leg2.setTranslateY(position[1] + 220);
        leg2.setTranslateX(position[0] - 115);
    }
    
    public void position3M (Pane area) {
        area.getChildren().remove(head);
        head = new Circle(0, 0, 30);
        area.getChildren().add(head);
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0] + 25);
        
        area.getChildren().remove(body);
        body = new Polygon(0, 0, 150, 0, 150, 25, 0, 25);
        area.getChildren().add(body);
        body.setRotate(90);
        body.setTranslateY(position[1] + 150 / 2);
        body.setTranslateX(position[0] - 150 / 2 + 25);
        
        area.getChildren().remove(arm1);
        arm1 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm1);
        arm1.setRotate(60);
        arm1.setTranslateY(position[1] + 150 / 2 + 20);
        arm1.setTranslateX(position[0] - 150 / 2 + 65);
        
        area.getChildren().remove(arm2);
        arm2 = new Polygon(0, 0, 150, 0, 150, 15, 0, 15);
        area.getChildren().add(arm2);
        arm2.setRotate(-60);
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 15);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(85);
        leg1.setTranslateY(position[1] + 220);
        leg1.setTranslateX(position[0] - 55);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 170, 0, 170, 20, 0, 20);
        leg2.setRotate(-5);
        area.getChildren().add(leg2);
        leg2.setTranslateY(position[1] + 170);
        leg2.setTranslateX(position[0] - 140);
    }
}
