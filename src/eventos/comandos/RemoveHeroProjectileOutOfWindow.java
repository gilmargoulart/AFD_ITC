package eventos.comandos;

import atores.HeroProjectile;
import mainProgram.MainProgram;
import utilitarios.Command;

public class RemoveHeroProjectileOutOfWindow implements Command {
    private final HeroProjectile heroProjectileOutOfWindow;

    public RemoveHeroProjectileOutOfWindow(HeroProjectile heroProjectileOutOfWindow){
        this.heroProjectileOutOfWindow = heroProjectileOutOfWindow;
    }

    @Override
    public void Apply(MainProgram game) {
        int indexOfDeadProjectile = game.allHeroProjectiles.indexOf(heroProjectileOutOfWindow);
        game.allHeroProjectiles.remove(indexOfDeadProjectile);
    }
}
