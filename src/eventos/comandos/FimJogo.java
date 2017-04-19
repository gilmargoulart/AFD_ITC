package eventos.comandos;

import mainProgram.MainProgram;
import utilitarios.Command;

public class FimJogo implements Command {
    private final boolean playerWon;
    public FimJogo(boolean playerWon) {
        this.playerWon = playerWon;
    }

    @Override
    public void Apply(MainProgram game) {
        game.IsGameOver = true;
        game.EndTime = java.time.LocalDateTime.now();
        game.PlayerWon = playerWon;
    }
}
