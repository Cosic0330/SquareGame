package SquareGame;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;

public class LifeBooster extends GameObject {
    private Handler handler;
    private BufferedImage health_img;


    public LifeBooster(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet);
        health_img=ss.grabimage(1, 4, 16, 16);
        velX=0; 
        velY=0;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(health_img, (int)x,(int)y,null);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,10,10);
    }
    
}
