package eventos.comandos;

import atores.HeroProjectile;
import mainProgram.MainProgram;
import utilitarios.Command;

public class AbsorbProjectile implements Command {
    private final HeroProjectile heroProjectileThatHit;

    public AbsorbProjectile(HeroProjectile heroProjectileThatHit){
        this.heroProjectileThatHit = heroProjectileThatHit;
    }

    @Override
    public void Apply(MainProgram game) {
        int indexOfDeadProjectile = game.allHeroProjectiles.indexOf(heroProjectileThatHit);
        game.allHeroProjectiles.remove(indexOfDeadProjectile);
    }

}
