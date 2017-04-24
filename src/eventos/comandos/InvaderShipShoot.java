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

        InvaderShip randomInvader = null;
        
        int heroShipX = (int)game.heroShip.GetCollisionArea().getBounds2D().getCenterX();
        int invaderShipX = 0;
        
        boolean found = false;
        for (InvaderShip ship : game.allInvaderShips) {
        	invaderShipX = (int) ship.GetCollisionArea().getBounds2D().getCenterX();
        	
        	if ((invaderShipX - MainProgram.INVADER_COLUMN_WIDTH) <= heroShipX
        			&& (invaderShipX + MainProgram.INVADER_COLUMN_WIDTH) >= heroShipX) {
        		randomInvader = ship;
        		//System.out.println("Encontrei nave, atirando...");
        		found = true;
        		break;
			}
		}
        
        //Se a nave não estiver embaixo dos Invaders, selecionar uma nave aleatoriamente.
        if (!found)
        	randomInvader = game.allInvaderShips.get(new Random().nextInt(game.allInvaderShips.size()));
        
        Rectangle2D randomInvaderBounds2D = randomInvader.GetCollisionArea().getBounds2D();
        //Rectangle2D randomInvaderBounds2D = randomInvader.GetCollisionArea().getBounds2D();

        Point projectileLocation = new Point(
            (int)(randomInvaderBounds2D.getX() + InvaderShip.WIDTH / 2 * InvaderShip.DRAWING_SCALE), //Faz o tiro sair bem do meio da nave
            (int)(randomInvaderBounds2D.getY()));
        game.allInvaderProjectiles.add(new InvaderProjectile(projectileLocation));
        
        //SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.InvaderShoot));
    }
}
