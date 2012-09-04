package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class BlindingEggs implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
        	if (player.hasPermission("mcweapons.blindingegg")) {
        		if (player.getItemInHand().getType() == Material.EGG) {
        			if (player.getGameMode() == GameMode.CREATIVE) {
        				final Vector direction = player.getPlayer().getEyeLocation().getDirection().multiply(2);
    					final Egg egg = player.getPlayer().getWorld().spawn(player.getPlayer().getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Egg.class);
    					egg.setShooter(player.getPlayer());
        			}
        		}
        	}
        } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        	if (player.hasPermission("mcweapons.blindingegg")) {
        		if (player.getItemInHand().getType() == Material.EGG) {
        			if (player.getGameMode() == GameMode.SURVIVAL){ 
        				final Vector direction = player.getPlayer().getEyeLocation().getDirection().multiply(2);
    					final Egg egg = player.getPlayer().getWorld().spawn(player.getPlayer().getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Egg.class);
    					egg.setShooter(player.getPlayer());
    					int amount = player.getPlayer().getItemInHand().getAmount();
        				player.getItemInHand().setAmount(amount-1);
        			}
        		}
        	}
        } else {
        	//You don't have permission
        }
    }
}