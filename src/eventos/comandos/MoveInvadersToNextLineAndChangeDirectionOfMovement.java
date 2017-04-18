package eventos.comandos;

import game.Game;
import utilities.Command;

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
