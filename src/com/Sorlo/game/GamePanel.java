package com.Sorlo.game;
import com.Sorlo.game.states.GameStateManager;
import com.Sorlo.game.util.Camera;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;

import javax.sound.sampled.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.sql.SQLException;

/**
 * Clasa care se ocupa cu rularea jocului initializand game loop-ul cu ajutorul
 * interfetei Runnable
 */
public class GamePanel extends JPanel implements Runnable {
    public static int width; ///lungimea ferestrei
    public static int height; ///inaltimea ei
    public static int oldFrameCount;  ///pentru calcularea frame-urilor
    public static int oldTickCount;
    public static int tickCount;

    private Thread thread; ///firul de executie al jocului
    private boolean running=false; ///flag-ul pentru rularea jocului



    private BufferedImage img;
    private Graphics2D g;///instrumentul ce ne ajuta sa desenam pe ecran

    private MouseHandler mouse; ///mouse- permite input-ul de la mouse

    private KeyHandler key; ///permite input de la tastatura

    private GameStateManager gsm; ///gamestatemanager-ul care va gestiona starile programului

    /**
     * constructorul care seteaza lungimea si inaltimea ferestrei in functie de parametrii width si height
     * @param width
     * @param height
     */
    public GamePanel(int width, int height){
        this.height=height;
        this.width=width;
        setPreferredSize(new Dimension(width,height));///putem selecta dimensiunea pe care o prferam folosindu-ne de parametrii primiti
        setFocusable(true);///Permite JPanel-ului sa aiba puterea de a isi da focus. Nu o seteaza totusi sa fie asa initial
        requestFocus();///ne da voie sa avem input
    }


    /**
     * addNotify face un JFrame afișabil conectându-l la o resursă de
     * ecran nativă. A face un cadru afișabil va face ca oricare dintre copiii săi să fie afișat.
     */
    public void addNotify()
    {
        super.addNotify();
        if(thread==null){///daca thread-ul este null
        thread=new Thread( this,"GameThread");///cream un nou thread
        thread.start();
    }
    }

    /**
     * prin getGraphics obtinem imaginea care ne va permite sa ,,desenam''
     * vom initializa si MouseHandler, KeyHandler , GameStateManager care se va ocupa de starea in care se afla jocul momentan
     * setam si running pe true care ne va ajuta la game loop
     * @throws SQLException
     */
    public void init() throws SQLException {

        running=true;
        img=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        g=(Graphics2D) img.getGraphics();
        mouse=new MouseHandler(this);
        key=new KeyHandler(this);


        gsm=new GameStateManager(g);
    }

    /**
     * este functia care va rula jocul
     */
    public void run(){
        try {
            init();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        final double GAME_HERTZ=64.0;
        final double TBU=1000000000/GAME_HERTZ;//=time before update
        final int MUBR=3; //=must update before render

        double lastUpdateTime=System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS=1000;
        final double TTBR=1000000000/TARGET_FPS;//total time before render

        int frameCount=0;
        int lastSecondTime=(int)(lastUpdateTime/1000000000);
       oldFrameCount=0;

        tickCount = 0;
        oldTickCount = 0;



        while(running)
        {
            double now=System.nanoTime();
            int updateCount=0;
            while(((now-lastUpdateTime)>TBU)&& (updateCount<MUBR))
            {
                try {
                    update();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    input(mouse,key);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                lastUpdateTime+=TBU;
                updateCount++;
            }
            if(now-lastUpdateTime>TBU)
            {
                lastUpdateTime=now-TBU;
            }
            try {
                input(mouse,key);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                render();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            draw();
            lastRenderTime=now;
            frameCount++;
            int thisSecond=(int) (lastUpdateTime/1000000000);
            if(thisSecond>lastSecondTime)
            {
                if(frameCount!=oldFrameCount)
                {
                    //System.out.println("NEW SECOND"+thisSecond+" "+frameCount);
                    oldFrameCount=frameCount;

                }
                frameCount=0;
                lastSecondTime=thisSecond;
            }
            while(now-lastRenderTime<TTBR && now-lastUpdateTime<TBU) {
                Thread.yield();
                try {
                    Thread.sleep(1);

                }catch(Exception e)
                {
                    System.out.println("EROOR: yielding thread");
                }
                now=System.nanoTime();
            }

        }




    }
    private int x=0;

    /**
     * aceasta functie da update  la GameState
     * @throws IOException
     * @throws InterruptedException
     * @throws SQLException
     */
    public void update() throws IOException, InterruptedException, SQLException {
        gsm.update();


    };

    /**
     * permite input-ul de la tastatura si posibilitatea de a da click pe ecran
     * @param mouse
     * @param key
     * @throws SQLException
     */
    public void input(MouseHandler mouse, KeyHandler key) throws SQLException {
        gsm.input(mouse,key);

    }

    /**
     * va afisa fereastra pe care se va desfasura jocul
     * @throws InterruptedException
     * @throws IOException
     */
    public void render() throws InterruptedException, IOException {
        if(g!=null)
        {
            g.setColor(new Color(66,134,244));
            g.fillRect(0,0,width,height);//creeaza un rectangle cu x si y parametrii
            gsm.render(g);

        }

    };

    /**
     * Cu aceasta metoda incepem sa desenam imaginea cu ajutorul Graphics
     */
    public void draw(){
        Graphics g2=(Graphics) this.getGraphics();//metoda din JPanel, cu asta incepem sa desenam the bufferedimage
        g2.drawImage(img,3,26,width+10,height+10,null);
        g2.dispose();

    };
}
