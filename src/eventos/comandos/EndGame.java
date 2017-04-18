package eventos.comandos;

import game.Game;
import utilities.Command;

public class EndGame implements Command {
    private final boolean playerWon;
    public EndGame(boolean playerWon) {
        this.playerWon = playerWon;
    }

    @Override
    public void Apply(MainProgram game) {
        game.IsGameOver = true;
        game.EndTime = java.time.LocalDateTime.now();
        game.PlayerWon = playerWon;
    }
}
