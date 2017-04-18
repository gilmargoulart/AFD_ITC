package eventos.comandos;

import actors.InvaderProjectile;
import game.Game;
import utilities.Command;

public class RemoveInvaderProjectileOutOfWindow implements Command {
    private final InvaderProjectile invaderProjectileOutOfWindow;

    public RemoveInvaderProjectileOutOfWindow(InvaderProjectile invaderProjectileOutOfWindow){
        this.invaderProjectileOutOfWindow = invaderProjectileOutOfWindow;
    }

    @Override
    public void Apply(MainProgram game) {
        int indexOfDeadProjectile = game.allInvaderProjectiles.indexOf(invaderProjectileOutOfWindow);
        game.allInvaderProjectiles.remove(indexOfDeadProjectile);
    }
}
