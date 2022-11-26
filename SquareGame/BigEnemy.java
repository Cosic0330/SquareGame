package SquareGame;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BigEnemy extends GameObject {
    private Handler handler;
    private BufferedImage enemy_img;

    public BigEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet);
        enemy_img=ss.grabimage(4, 4, 32, 32);
        velX=3; 
        velY=3;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        if(y<=-28 || y>=Game.HEIGHT-80){velY*=-1;}
        if(x<=-28 || x>=Game.WIDTH-60){velX*=-1;}

       // handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.ORANGE,40,40,0.1f,handler));

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemy_img, (int)x,(int)y,null);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
    
}
