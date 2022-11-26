package SquareGame;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartFastEnemy extends GameObject {
    private Handler handler;
    private GameObject player;  

    public SmartFastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;

        for(int i=0; i<handler.object.size(); i++){
            if(handler.object.get(i).getID()==ID.Player){
                player=handler.object.get(i);
            }
        }
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        float diffX=2*(x-player.getX()-8);
        float diffY=2*(y-player.getY()-8);
        float distance=(float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        velX=(float) ((-1.0/distance)*diffX);
        velY=(float) ((-1.0/distance)*diffY); 
        if(y<=0 || y>=Game.HEIGHT-56){velY*=-1;}
        if(x<=0 || x>=Game.WIDTH-32){velX*=-1;}

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.CYAN,16,16,0.085f,handler));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    
}
