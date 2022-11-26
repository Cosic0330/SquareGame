package SquareGame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;




public class Player extends GameObject {

    private Handler handler;
    private BufferedImage player_image;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet);
        player_image=ss.grabimage(1, 1, 32, 32);
    }


    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        x=Game.clamp(x, 0, Game.WIDTH-46);
        y=Game.clamp(y, 0, Game.HEIGHT-68);

        collision();
        

    }

    private void collision(){
        for(int i =0 ; i<handler.object.size(); i++){
            GameObject temp = handler.object.get(i);

            if(temp.getID()==ID.BasicEnemy || temp.getID()==ID.FastEnemy || temp.getID()==ID.BigEnemy || temp.getID()==ID.SmartEnemy 
            || temp.getID()==ID.SmartFastEnemy){
                if(getBounds().intersects(temp.getBounds())){
                    HUD.HEALTH-=2;
                }
            }else if(temp.getID()==ID.LifeBooster){
                if(getBounds().intersects(temp.getBounds())){
                    HUD.HEALTH+=20;
                    handler.object.remove(temp);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(player_image, (int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);        
    }
    
}
