package eventos;

import mainProgram.MainProgram;
import utilitarios.Command;

import java.util.ArrayList;
import java.util.List;

public class ResolucaoEventos {
    private final List<Command> actions = new ArrayList<Command>();
    private final List<Command> actionsBuffer = new ArrayList<Command>();
    private final MainProgram game;

    public ResolucaoEventos(MainProgram game) {
        this.game = game;
    }

    public void Push(Command command){
        actionsBuffer.add(command);
    }

    public void Resolve(){
        actions.addAll(actionsBuffer);
        actionsBuffer.clear();
        actions.forEach(action -> action.Apply(game));
        actions.clear();
    }
}
