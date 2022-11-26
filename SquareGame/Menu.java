package SquareGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Game game, Handler handler, HUD hud){
        this.game=game;
        this.handler=handler;
        this.hud=hud;
    }

    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        //PLAYBUTTON
        if(game.gameState==STATE.Menu){
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                game.gameState=STATE.Game;
                handler.clearEnemies(0);
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
                AudioPlayer.getSound("click").play();
            }
        //QUITBUTTON
            if(mouseOver(mx, my, 210, 240, 200, 64)){
                AudioPlayer.getSound("click").play();
                System.exit(1);
            }
        }else if(game.gameState==STATE.End){
            if(mouseOver(mx, my, 100, 270, 250, 64)){
            game.gameState=STATE.Menu;
            hud.setLvl(0);
            hud.setScore(0);
            AudioPlayer.getSound("click").play();
            }
        }

    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx>x && mx<x+width){
            if(my>y && my<y+height){
                return true;
            }
        }
        return false;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if(game.gameState==STATE.Menu){
            Font fnt = new Font("aerial", 1, 50);
            Font fnt2 = new Font("aerial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Menu",240, 70);

            g.setFont(fnt2);
            g.drawString("Play", 275, 190);
            g.drawString("Quit", 275, 280);

            g.drawRect(210, 150, 200, 64);
            g.drawRect(210, 240, 200, 64);
        }else if(game.gameState==STATE.End){
            g.setColor(Color.WHITE);
            Font fnt = new Font("aerial", 1, 50);
            g.setFont(fnt);
            g.drawString("Game Over",170, 100);

            Font fnt2 = new Font("aerial", 1, 30);
            g.setFont(fnt2);
            g.drawString("Final Score: " + hud.getScore(), 100, 220);
            g.drawString("Reached Level: " + hud.getLvl(), 100, 260);

            g.drawRect(100, 270, 250, 64);
            g.drawString("Back To Menu", 120, 310);
            
        }
    }
    
}
