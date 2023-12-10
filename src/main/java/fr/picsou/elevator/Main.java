package fr.picsou.elevator;

import fr.picsou.elevator.components.listener.ListenerManager;
import fr.picsou.elevator.utils.Commands.SimpleCommand;
import org.bukkit.craftbukkit.v1_20_R2.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable(){
        saveDefaultConfig();
        instance = this;
        System.out.println("[Elevator] ON");
        new ListenerManager(this);
    }

    @Override
    public void onDisable() {
        System.out.println("[Elevator] OFF");
    }
    private void createCommand(SimpleCommand command) {
        CraftServer server = (CraftServer) getServer();
        server.getCommandMap().register(getName(), command);
    }

    public static Main getInstance() {
        return instance;
    }
    }

