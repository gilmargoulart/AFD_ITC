package eventos.comandos;

import game.Game;
import resources.SoundEffectTracks;
import utilities.Command;
import utilities.SoundEffectPlayer;

public class PlayIntroSound implements Command {
    @Override
    public void Apply(MainProgram game) {
        SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.IntroSound));
    }
}
