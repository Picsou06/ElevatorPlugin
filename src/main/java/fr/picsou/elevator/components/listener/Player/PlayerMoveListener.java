package fr.picsou.elevator.components.listener.Player;

import fr.picsou.elevator.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();
        Player player = event.getPlayer();

        // Obtenez la position du bloc en dessous du joueur
        Location blockLocationUnderPlayer = new Location(from.getWorld(), from.getX(), from.getY() - 1, from.getZ(), 0, 0);

        // Vérifiez si le joueur monte et n'est ni en train de nager ni de voler
        if (from.getBlockY() < to.getBlockY() && !player.isSwimming() && !player.isFlying() && from.getWorld().getBlockAt(blockLocationUnderPlayer).getType() == Material.(Main.getInstance().getConfig().getString("bloc"))) {
            teleportPlayerToObsidianAbove(player, blockLocationUnderPlayer);
        }
    }

    private void teleportPlayerToObsidianAbove(Player player, Location blockLocationUnderPlayer) {
        for (int i = 1; i <= Main.getInstance().getConfig().getInt("HauteurMax"); i++) {
            Location currentLocation = new Location(blockLocationUnderPlayer.getWorld(), blockLocationUnderPlayer.getX(), blockLocationUnderPlayer.getY() + i, blockLocationUnderPlayer.getZ());

            if (currentLocation.getBlock().getType() == Material.(Main.getInstance().getConfig().getString("bloc"))) {
                Location teleportLocation = new Location(currentLocation.getWorld(), currentLocation.getX(), currentLocation.getY() + 1, currentLocation.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                player.teleport(teleportLocation);
                break;
            }
        }
    }
}
