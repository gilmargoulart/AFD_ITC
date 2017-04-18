package eventos.comandos;

import actors.HeroShip;
import actors.HeroProjectile;
import game.Game;
import resources.SoundEffectTracks;
import utilities.Command;
import utilities.SoundEffectPlayer;

import java.awt.*;

public class HeroShipShoot implements Command {
    private final Point heroShipLocation;
    public HeroShipShoot(Point heroShipLocation) {
        this.heroShipLocation = heroShipLocation;
    }

    @Override
    public void Apply(MainProgram game) {
        Point projectileLocation = new Point(
            (int)(heroShipLocation.getX() + HeroShip.WIDTH / 2 * HeroShip.DRAWING_SCALE),
            (int)(heroShipLocation.getY()));
        game.allHeroProjectiles.add(new HeroProjectile(projectileLocation));
        SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.HeroShoot));
    }
}
