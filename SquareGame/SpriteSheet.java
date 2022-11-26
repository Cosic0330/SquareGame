package SquareGame;
import java.awt.image.BufferedImage;


public class SpriteSheet {
    private BufferedImage sprite;

    public SpriteSheet(BufferedImage ss){
        this.sprite=ss;
    }

    public BufferedImage grabimage(int col, int row, int width, int height){
        BufferedImage img = sprite.getSubimage((row*32)-32, (col*32)-32, width, height);
       // col=1, row=4, 64 64
        return img;
    }

}
