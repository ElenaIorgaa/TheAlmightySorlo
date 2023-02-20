package com.Sorlo.game;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class GameLauncher {
    public GameLauncher(){
       Window.getInstance();
    }


    /**
     * main-ul care va rula jocul facand o noua instanta a clasei GameLauncher
     * @param args
     * @throws Exception
     */
    public static void main(String []args) throws Exception {

        GameLauncher l = new GameLauncher();


    }
}
