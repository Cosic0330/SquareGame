package SquareGame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class HUD {
    


    public static float HEALTH=100;
    private int greenValue = 255;
    private int redValue = 0; 
    private int score=0;
    private int lvl=1;

    public void tick(){
        HEALTH=Game.clamp(HEALTH, 0, 100);
        greenValue=(int) Game.clamp((float)greenValue,0,255);
        redValue = (int) Game.clamp((float)redValue,0,255);
        greenValue=(int) (HEALTH*2);
        redValue=255-greenValue;
        score++;
    }

    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRoundRect(15, 15, 200, 32, 16, 16);
        g.setColor(new Color(redValue,greenValue,0));
        g.fillRoundRect(15, 15,(int) HEALTH*2, 32, 16, 16);
        g.setColor(Color.WHITE);
        g.drawRoundRect(15, 15, 200, 32, 16, 16);
        g.drawString("Score: "+score, 15, 64);
        g.drawString("Level: "+lvl, 15, 80);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Microsoft Helvetica", Font.BOLD|Font.ITALIC,28));
        g2d.drawString("HP: " + HEALTH,65, 42);

    }

    public int getScore(){
        return score;
    }

    public void setScore(int val){
        score=val;  
    }

    public int getLvl(){
        return lvl;
    }

    public void setLvl(int val){
        lvl=val;
    }
}
