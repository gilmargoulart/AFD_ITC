package efeitosVisuais;

import mainProgram.MainProgram;

import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorVfx {
    private final MainProgram game;

    public GerenciadorVfx(MainProgram game) {
        this.game = game;
    }

    public void Update(){
        List<Explosao> finishedExplosions =
            game.allExplosionVFX.stream()
            .filter(Explosao::IsFinished)
            .collect(Collectors.toList());
        for (Explosao finishedExplosion: finishedExplosions){
            int indexOfExplosion= game.allExplosionVFX.indexOf(finishedExplosion);
            game.allExplosionVFX.remove(indexOfExplosion);
        }
    }
}
