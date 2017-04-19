package eventos.comandos;

import atores.InvaderProjectile;
import atores.InvaderShip;
import mainProgram.MainProgram;
//import resources.SoundEffectTracks;
import utilitarios.Command;
//import utilitarios.SoundEffectPlayer;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class InvaderShipShoot implements Command {
    @Override
    public void Apply(MainProgram game) {
        if(game.allInvaderShips.isEmpty())
            return;

        InvaderShip randomInvader = game.allInvaderShips.get(new Random().nextInt(game.allInvaderShips.size()));
        Rectangle2D randomInvaderBounds2D = randomInvader.GetCollisionArea().getBounds2D();
        Point projectileLocation = new Point(
            (int)(randomInvaderBounds2D.getX() + InvaderShip.WIDTH / 2 * InvaderShip.DRAWING_SCALE),
            (int)(randomInvaderBounds2D.getY()));
        game.allInvaderProjectiles.add(new InvaderProjectile(projectileLocation));
        //SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.InvaderShoot));
    }
}
