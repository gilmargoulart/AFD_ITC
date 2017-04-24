package interfaceGrafica;

import mainProgram.MainProgram;
import utilitarios.GraphicalShape;

import java.awt.*;
import java.awt.geom.Area;

public class GameOverScreenOverlay implements GraphicalShape{
    private final MainProgram game;
    public GameOverScreenOverlay(MainProgram game) {
        this.game = game;
    }

    @Override
    public void Paint(Graphics2D graphics) {
        graphics.setColor(new Color(0, 0, 0, 175));
        Area background = new Area(new Rectangle(0, StatusRibbon.HEIGHT, MainProgram.CANVAS_WIDTH, MainProgram.CANVAS_HEIGHT - StatusRibbon.HEIGHT));
        graphics.fill(background);

        graphics.setColor(Color.white);
        graphics.setFont(new Font("Arial Black", Font.PLAIN, 25));
        String message = game.PlayerWon ? "GANHOU" : "PERDEU";
        graphics.drawString(message, MainProgram.CANVAS_WIDTH/2 - 60, (int)(MainProgram.CANVAS_HEIGHT*0.4));
        
    }
}
