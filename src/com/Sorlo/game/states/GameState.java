package com.Sorlo.game.states;

import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


/** Aceasta este clasa abstracta GameState pentru starile jocurilor
 * contine metodele abstracte update,input si render
 */
public abstract class GameState {
    protected GameStateManager gsm;
    public GameState(GameStateManager gam){

        this.gsm=gam;
    }
    public abstract void update() throws IOException, InterruptedException, SQLException;
    public abstract void input(MouseHandler mouse, KeyHandler key) throws SQLException;
    public abstract void render(Graphics2D g) throws InterruptedException, IOException;

}
