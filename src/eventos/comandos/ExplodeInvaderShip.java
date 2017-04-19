package eventos.comandos;

import atores.InvaderShip;
import eventos.ResolucaoEventos;
import mainProgram.MainProgram;
//import resources.SoundEffectTracks;
import utilitarios.Command;
//import utilities.SoundEffectPlayer;
import efeitosVisuais.Explosao;

public class ExplodeInvaderShip implements Command {
    private final InvaderShip invaderShipThatIsHit;
    private final ResolucaoEventos eventResolution;

    public ExplodeInvaderShip(
        InvaderShip invaderShipThatIsHit,
        ResolucaoEventos eventResolution){
        this.invaderShipThatIsHit = invaderShipThatIsHit;
        this.eventResolution = eventResolution;
    }

    @Override
    public void Apply(MainProgram game) {
        int indexOfExplodedShip = game.allInvaderShips.indexOf(invaderShipThatIsHit);
        if(indexOfExplodedShip >= 0){
            game.allExplosionVFX.add(new Explosao(invaderShipThatIsHit.GetLocation()));
            game.allInvaderShips.remove(indexOfExplodedShip);
            //SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.InvaderExplosion));
            game.Score = game.Score + 100 + bonusPointsWithExponentialDecay(game.GetRuntimeInSeconds());
            if(game.allInvaderShips.isEmpty())
                eventResolution.Push(new FimJogo(true));
        }
    }
    private static final int TotalBonusPoints = 1000;
    private static final double ExponentialDecayConstant = 0.1;
    private int bonusPointsWithExponentialDecay(long time){
        return (int)(TotalBonusPoints * Math.exp(-ExponentialDecayConstant * time));
    }
}
