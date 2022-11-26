package SquareGame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.image.BufferedImage;
import java.io.File;






public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;
    private Handler handler;
    private HUD hud;
    private Random r;
    private Spawn spawner;
    private Menu menu;
    


    public STATE gameState = STATE.Menu;

    public static BufferedImage sprite_sheet;

    public Game (){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet=loader.loadImage(new File("SquareGame/sprite_sheet.png"));

        
        handler = new Handler();
        hud=new HUD();
        menu=new Menu(this,handler,hud);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        AudioPlayer.load();
        AudioPlayer.getMusic("Zelda").loop();
        new Window(WIDTH, HEIGHT, "SquareGame", this);



        

        
        
        spawner=new Spawn(handler, hud);

        r=new Random();

        if(gameState==STATE.Game){
            handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
        }else{
            for(int i=0; i<50; i++){
                handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.MenuParticle, handler));
            }
        }
    }
    
    public synchronized void start(){
        running=true;
        thread=new Thread(this);
        thread.start();

    }

    public synchronized void stop(){
        try {
            thread.join();
            running=false;
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks=60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0 ; 
        long timer = System.currentTimeMillis();
        int frames = 0 ; 
        while(running){

            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer+=1000;
                //System.out.println("FPS: "+frames);
                frames=0;
            }
        }
        stop();
        
    }  

    private void tick(){
        if(!paused){
            handler.tick();
            if(gameState==STATE.Game){
                hud.tick();
                spawner.tick();

                if(HUD.HEALTH<=0){
                    HUD.HEALTH=100;
                    handler.clearEnemies(0);
                    gameState=STATE.End;
                    for(int i=0; i<50; i++){
                        handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.MenuParticle, handler));
                    }
                }
            }else if(gameState==STATE.Menu || gameState==STATE.End){
                menu.tick();
            }
        }
    }

    private void render(){
        BufferStrategy bs= this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Image img = Toolkit.getDefaultToolkit().getImage("C:/Users/ada10/Desktop/SpelUtveckling/SquareGame/test.jpg");
        Graphics g = bs.getDrawGraphics();
        g.drawImage(img, 0, 0, null);
        
        handler.render(g);

        if(paused){
            Graphics2D g2 = (Graphics2D) g;
            Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f);
            g2.setComposite(c);
            g2.setPaint(Color.WHITE);
            Font fnt = new Font("aerial", 1, 50);
            g2.setFont(fnt);
            g2.drawString("PAUSED", 100,100);
            g2.dispose();
        }
        if(gameState==STATE.Game){
            hud.render(g);
        }else if(gameState==STATE.Menu || gameState==STATE.End){
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max){
        if(var>=max){
            return var=max;
        }else if(var <= min){
            return var=min;
        }else{
            return var;
        }
    }
    
    public static void main(String args[]) {
        new Game();
    }
}
