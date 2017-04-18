package efeitosVisuais;

import game.Game;

import java.util.List;
import java.util.stream.Collectors;

public class VfxManager {
    private final MainProgram game;

    public VfxManager(MainProgram game) {
        this.game = game;
    }

    public void Update(){
        List<Explosion> finishedExplosions =
            game.allExplosionVFX.stream()
            .filter(Explosion::IsFinished)
            .collect(Collectors.toList());
        for (Explosion finishedExplosion: finishedExplosions){
            int indexOfExplosion= game.allExplosionVFX.indexOf(finishedExplosion);
            game.allExplosionVFX.remove(indexOfExplosion);
        }
    }
}
