package SquareGame;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss2Enemy extends GameObject {
    private Handler handler;
    private int timer=30;
    private int timer2=50;
    Random r = new Random();

    public Boss2Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
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
                    velX=4;
                }
                int spawn=r.nextInt(10);
                if(spawn==0){
                    handler.addObject(new Boss1Bullet((int)x, (int)y, ID.BasicEnemy, handler));
                    handler.addObject(new Boss1Bullet((int)x, (int)y, ID.BasicEnemy, handler));
                    handler.addObject(new Boss2Bullet((int)x, (int)y, ID.FastEnemy, handler));
                }
            }
        }else{
            timer--;
        }

        if(x<=0 || x>=Game.WIDTH-92){velX*=-1;}


        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.CYAN,80,80,0.1f,handler));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 80, 80);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,80,80);
    }
    
}
