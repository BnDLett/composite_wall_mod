package Mod;

import arc.*;
import arc.scene.ui.Dialog;
import arc.util.*;
import content.blocks.CompositeWalls;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.mod.*;

public class Main extends Mod {
    @Override
    public void loadContent() {
        CompositeWalls.load();
    }

    public Main() {
        Events.on(ClientLoadEvent.class, e -> {
            if (Vars.headless) {
                return;
            }

            Dialog dialog = new Dialog("Greetings");
            dialog.cont.add("hiii :3").row();
            dialog.cont.button("hello!!! :333", dialog::hide).size(500f, 75f);
            dialog.show();
        });
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.<Player>register("team", "<team_id>", "Switch your team.", (args, player) -> {
            int team_id;

            try {
                team_id = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                player.sendMessage("That is not a correct team ID!");
                return;
            }

            Team team = Team.get(team_id);
            player.team(team);
            player.sendMessage("Welcome to your new team.");
        });
    }
}
