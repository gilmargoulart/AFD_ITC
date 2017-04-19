package eventos.comandos;

import mainProgram.MainProgram;
//import resources.SoundEffectTracks;
import utilitarios.Command;
//import utilitarios.SoundEffectPlayer;

public class PlayIntroSound implements Command {
    @Override
    public void Apply(MainProgram game) {
        //SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.IntroSound));
    }
}
