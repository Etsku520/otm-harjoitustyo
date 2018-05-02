package glidingstickmen.characters;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 * A character in the game, it's a stickman
 * 
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
    
    /**
     * A character in the game, it's a stickman
     * 
     * @param position  The vocal point the stickman is build around
     * @param player    The player number. at least now it's 1 or 2
     * @param name      The name the player has chosen for himself
     */
    public Stickman(int[] position, int player, String name) {
        this.position = position;
        this.player = player;
        this.stance = 0;
        if (name.trim().isEmpty()) {
            this.name = "player " + player;
        } else {
            this.name = name;
        }
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
    
    /**
     * the mothod puts the stickman to the pane that is iin ithe GUI
     * 
     * @param area the Pane used in the game
     */
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
    
    /**
     * This method sets a new position and changes the stance if needed
     * 
     * @param position  The new focal point
     * @param area      the pane the stickman is in
     * @param x         The amount moved 
     */
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
    
    /**
     * Puts the stickman to the normal standing position
     * 
     * @param area the pane used in the game
     */
    public void position0 (Pane area) {
        head.setTranslateY(position[1]);
        head.setTranslateX(position[0]);
        
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
    
    /**
     * Puts the stickman to the low attack position
     * 
     * @param area the pane used in the game
     */
    public void position1(Pane area) {
        position0(area);
        head.setTranslateY(position[1] + 75);
        
        body.setTranslateY(position[1] + 150);
        
        arm1.setTranslateY(position[1] + 150 + 20);
        
        arm2.setTranslateY(position[1] + 150 + 20);
        
        area.getChildren().remove(leg1);
        leg1 = new Polygon(0, 0, 85, 0, 85, 20, 0, 20);
        area.getChildren().add(leg1);
        leg1.setRotate(-70);
        leg1.setTranslateY(position[1] + 250);
        leg1.setTranslateX(position[0] - 55);

        leg2.setRotate(20);
        leg2.setTranslateY(position[1] + 250);
        leg2.setTranslateX(position[0] - 15);
    }
    
    /**
     * Puts the stickman to the mirrored low attack position
     * 
     * @param area the pane used in the game
     */
    public void position1M(Pane area) {
        position0(area);
        head.setTranslateY(position[1] + 75);
        
        body.setTranslateY(position[1] + 150);

        arm1.setTranslateY(position[1] + 150 + 20);
        
        arm2.setTranslateY(position[1] + 150 + 20);
        
        area.getChildren().remove(leg2);
        leg2 = new Polygon(0, 0, 85, 0, 85, 20, 0, 20);
        area.getChildren().add(leg2);
        leg2.setRotate(70);
        leg2.setTranslateY(position[1] + 250);
        leg2.setTranslateX(position[0] - 25);

        leg1.setRotate(-20);
        leg1.setTranslateY(position[1] + 250);
        leg1.setTranslateX(position[0] - 150);
    }
    
    /**
     * Puts the stickman to the mirrored high attack position
     * 
     * @param area the pane used in the game
     */
    public void position2M (Pane area) {
        position0(area);

        leg1.setTranslateY(position[1] + 220);
        leg1.setTranslateX(position[0] - 55);
        
        leg2.setRotate(35);
        leg2.setTranslateY(position[1] + 105);
        leg2.setTranslateX(position[0] - 155);
    }
    
    /**
     * Puts the stickman to the high attack position
     * 
     * @param area the pane used in the game
     */
    public void position2 (Pane area) {
        position0(area);
        
        leg1.setRotate(-35);
        leg1.setTranslateY(position[1] + 105);
        leg1.setTranslateX(position[0] - 15);
        
        leg2.setTranslateY(position[1] + 220);//220
        leg2.setTranslateX(position[0] - 115);//-55
    }
    
    /**
     * Puts the stickman to the medium attack position
     * 
     * @param area the pane used in the game
     */
    public void position3 (Pane area) {
        position0(area);
        head.setTranslateX(position[0] - 25);
        
        body.setTranslateX(position[0] - 150 / 2 - 25);
        
        arm1.setTranslateX(position[0] - 150 / 2 + 15);
        
        arm2.setTranslateY(position[1] + 150 / 2 + 20);
        arm2.setTranslateX(position[0] - 150 / 2 - 65);
        
        leg1.setRotate(5);
        leg1.setTranslateY(position[1] + 170);
        leg1.setTranslateX(position[0] - 30);
        
        leg2.setRotate(-85);
        leg2.setTranslateY(position[1] + 220);
        leg2.setTranslateX(position[0] - 115);
    }
    
    /**
     * Puts the stickman to the mirrored medium attack position
     * 
     * @param area the pane used in the game
     */
    public void position3M (Pane area) {
        position0(area);
        head.setTranslateX(position[0] + 25);
        
        body.setTranslateX(position[0] - 150 / 2 + 25);
        
        arm1.setTranslateX(position[0] - 150 / 2 + 65);
        
        arm2.setTranslateX(position[0] - 150 / 2 - 15);
        
        leg1.setRotate(85);
        leg1.setTranslateY(position[1] + 220);
        leg1.setTranslateX(position[0] - 55);
        
        leg2.setRotate(-5);
        leg2.setTranslateY(position[1] + 170);
        leg2.setTranslateX(position[0] - 140);
    }
}
