package SquareGame;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1Enemy extends GameObject {
    private Handler handler;
    private int timer=30;
    private int timer2=50;
    private BufferedImage bigEn_img;
    Random r = new Random();

    public Boss1Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet);
        bigEn_img=ss.grabimage(3, 1, 64, 64);
        velX=0; 
        velY=2;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if(timer<=0){
            velY=0;
            timer2--;
            if(timer2<=0){
                if(velX==0){
                    velX=2;
                }
                int spawn=r.nextInt(10);
                if(spawn==0){
                    handler.addObject(new Boss1Bullet((int)x, (int)y+48, ID.BasicEnemy, handler));
                    handler.addObject(new Boss1Bullet((int)x, (int)y+48, ID.BasicEnemy, handler));
                }
            }
        }else{
            timer--;
        }

        if(x<=0 || x>=Game.WIDTH-92){velX*=-1;}


        //handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.RED,80,80,0.1f,handler));

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bigEn_img, (int)x,(int)y,null);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,80,80);
    }
    
}
