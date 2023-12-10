package fr.picsou.elevator.components.listener;

import fr.picsou.elevator.components.listener.Player.PlayerMoveListener;
import fr.picsou.elevator.components.listener.Player.PlayerSneakListener;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerManager {

    public ListenerManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new PlayerMoveListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerSneakListener(), plugin);
    }
}
