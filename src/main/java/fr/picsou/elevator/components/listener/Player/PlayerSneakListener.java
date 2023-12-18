package fr.picsou.elevator.components.listener.Player;

import fr.picsou.elevator.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerSneakListener implements Listener {
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        Boolean isSneaking = player.isSneaking();
        Location blockLocationUnderPlayer = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY() - 1, player.getLocation().getZ(), 0, 0);
            if (isSneaking && blockLocationUnderPlayer.getBlock().getType() == Material.(Main.getInstance().getConfig().getString("bloc"))) {
            teleportPlayerToObsidianAbove(player, blockLocationUnderPlayer);
        }
    }

    private void teleportPlayerToObsidianAbove(Player player, Location blockLocationUnderPlayer) {
        for (int i = 1; i <= Main.getInstance().getConfig().getInt("HauteurMax"); i++) {
            Location currentLocation = new Location(blockLocationUnderPlayer.getWorld(), blockLocationUnderPlayer.getX(), blockLocationUnderPlayer.getY() - i, blockLocationUnderPlayer.getZ());

            if (currentLocation.getBlock().getType() == Material.(Main.getInstance().getConfig().getString("bloc"))) {
                Location teleportLocation = new Location(currentLocation.getWorld(), currentLocation.getX(), currentLocation.getY() + 1, currentLocation.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                player.teleport(teleportLocation);
                break;
            }
        }
    }
}
