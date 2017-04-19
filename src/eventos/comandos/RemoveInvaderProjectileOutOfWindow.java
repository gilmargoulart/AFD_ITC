package eventos.comandos;

import atores.InvaderProjectile;
import mainProgram.MainProgram;
import utilitarios.Command;

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
