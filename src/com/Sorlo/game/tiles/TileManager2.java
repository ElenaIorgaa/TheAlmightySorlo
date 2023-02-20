package com.Sorlo.game.tiles;

import com.Sorlo.game.graphics.Sprites.SpriteSheet;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.io.File;

import com.Sorlo.game.util.Camera;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class TileManager2 {

    public static ArrayList<TileMap> tm;


    //private SpriteSheet spritesheet;
    private int blockWidth;
    private int blockHeight;
    //private MaterialManager mm;
    private int width;
    private int height;


    private String genMap;
    private String solid;
    private int chuckSize;
    private String file;
    private int columns;
    private String imagePathTSX;
    public Camera cam;
    private double t;

    public TileManager2() {
        tm = new ArrayList<TileMap>();


    }



    public TileManager2(String path,Camera cam) {
        this();
        tm=new ArrayList<TileMap>();
        this.cam=cam;

        addTileMap(path,16,16,cam);


    }

    public TileManager2(String path) {
        this();
        tm=new ArrayList<TileMap>();


        addTileMap(path,16,16);


    }
    //noul constructor pentru camera
    public TileManager2(String path, int blockWidth, int blockHeight,Camera cam)
    {
        tm=new ArrayList<TileMap>();
        this.cam=cam;
        addTileMap(path, 16, 16,cam);
    }



    public String getGenMap() { return genMap; }
    public String getSolid() { return solid; }
    public int getChunkSize() { return chuckSize; }
    public int getBlockWidth() { return blockWidth; }
    public int getBlockHeight() { return blockHeight; }
    public String getFilename() { return file; }
    public int getColumns() { return columns; }




    private void addTileMap(String path, int blockWidth, int blockHeight, Camera cam) {


        String imagePath;
        this.cam=cam;
        cam.setTileSize(16);

        int width = 0;
        int height = 0;
        int tileWidth;
        int tileHeight;
        int tileColumns;
        int layers = 0;
        int tileCount;
        SpriteSheet sprite;


        String[] data = new String[20];

        try {


            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("map");
            Node node = list.item(0);
            Element eElement = (Element) node;

            imagePath = "TileSet2234";
            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));


            this.columns = 20;
            this.file = imagePath;
            sprite = new SpriteSheet("tile/TileSet2234.png");


            list = doc.getElementsByTagName("layer");
            layers = list.getLength();

            for(int i = 0; i < layers; i++) {
                node = list.item(i);

                if (i <=0) {
                    width = Integer.parseInt(eElement.getAttribute("width"));
                    height = Integer.parseInt(eElement.getAttribute("height"));
                }

                data[i] = eElement.getElementsByTagName("data").item(i).getTextContent();
                if (i!=1) {
                    tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, columns));
                    System.out.println(i+"----------6666666666666666666666666666666666666666666666666666666666666666666666666666666");

                }
                else {
                    tm.add(new TileMapObj(data[i], sprite, width, height, blockWidth, blockHeight, columns));
                    //System.out.println(i+"----------6666666666666666666666666666666666666666666666666666666666666666666666666666666");

                }



                cam.setLimit(1280,432);

            }




        } catch(Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap:");
            e.printStackTrace();
            System.exit(0);
        }

        this.width = width;
        this.height = height;
    }
    private void addTileMap(String path, int blockWidth, int blockHeight) {


        String imagePath;


        int width = 0;
        int height = 0;
        int tileWidth;
        int tileHeight;
        int tileColumns;
        int layers = 0;
        int tileCount;
        SpriteSheet sprite;


        String[] data = new String[20];

        try {


            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("map");
            Node node = list.item(0);
            Element eElement = (Element) node;

            imagePath = "MENIUTileSet";
            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));


            this.columns = 20;
            this.file = imagePath;
            sprite = new SpriteSheet("tile/MENIUTileSet.png");


            list = doc.getElementsByTagName("layer");
            layers = list.getLength();

            for (int i = 0; i < layers; i++) {
                node = list.item(i);


                width = Integer.parseInt(eElement.getAttribute("width"));
                height = Integer.parseInt(eElement.getAttribute("height"));


                data[i] = eElement.getElementsByTagName("data").item(i).getTextContent();

                tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, columns));

            }
        } catch(Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap:");
            e.printStackTrace();
            System.exit(0);
        }

        this.width = width;
        this.height = height;
    }



    public void render(Graphics2D g) {

        tm.get(0).render(g,cam.getBounds());//backgroundul
        tm.get(1).render(g,cam.getBounds());//ar trebui mobila
        tm.get(3).render(g,cam.getBounds());//decorul
        tm.get(2).render(g,cam.getBounds());//asta e de urcat
    }

}
