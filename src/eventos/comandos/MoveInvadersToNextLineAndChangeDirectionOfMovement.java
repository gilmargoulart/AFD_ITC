package eventos.comandos;

import mainProgram.MainProgram;
import utilitarios.Command;

public class MoveInvadersToNextLineAndChangeDirectionOfMovement implements Command {
    @Override
    public void Apply(MainProgram game) {
        game.allInvaderShips
        .stream()
        .filter(invaderShip -> !invaderShip.IsGoingToChangeDirection())
        .forEach(invader -> {
            invader.ChangeDirectionOfMovement();
            invader.MoveToNextLine();
        });
    }
}
