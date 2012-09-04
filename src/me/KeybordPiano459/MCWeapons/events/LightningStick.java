package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LightningStick implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		World world = player.getWorld();
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
        	if (player.hasPermission("mcweapons.lightningstick")) {
        		if (player.getItemInHand().getType() == Material.STICK) {
        			Block targetblock = player.getTargetBlock(null, 50);
  		          	Location location = targetblock.getLocation();
  		          	world.strikeLightning(location);
  		          	world.createExplosion(location, 2);
        		}
        	}
        } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        	if (player.hasPermission("mcweapons.lightningstick")) {
        		if (player.getItemInHand().getType() == Material.STICK) {
        			Block targetblock = player.getTargetBlock(null, 50);
  		          	Location location = targetblock.getLocation();
  		          	world.strikeLightning(location);
  		          	world.createExplosion(location, 2);
        		}
        	}
        } else {
        	//You don't have permission
        }
    }
}