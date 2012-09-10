package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ThrowableArrow implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
        	if (player.hasPermission("mcweapons.throwablearrow")) {
        		if (player.getItemInHand().getType() == Material.ARROW) {
        			if (player.getGameMode() == GameMode.CREATIVE) {
        				player.launchProjectile(Arrow.class);
        			} else if (player.getGameMode() == GameMode.SURVIVAL) {
        				player.launchProjectile(Arrow.class);
    					int amount = player.getPlayer().getItemInHand().getAmount();
        				player.getItemInHand().setAmount(amount-1);
        			}
        		}
        	}
        } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
        	if (player.hasPermission("mcweapons.throwablearrow")) {
        		if (player.getItemInHand().getType() == Material.ARROW) {
        			if (player.getGameMode() == GameMode.SURVIVAL){ 
        				player.launchProjectile(Arrow.class);
    					int amount = player.getPlayer().getItemInHand().getAmount();
        				player.getItemInHand().setAmount(amount-1);
        			} else if (player.getGameMode() == GameMode.CREATIVE) {
        				player.launchProjectile(Arrow.class);
        			}
        		}
        	} else {
        		//You don't have permissions
        	}
        }
	}
}