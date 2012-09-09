package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AttackArrow implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
        if (e.getAction() == Action.PHYSICAL) {
        	if (player.hasPermission("mcgrenades.attackarrow")) {
        		if (player.getItemInHand().getType() == Material.ARROW) {
        			//HURT ENTITY
        		}
        	} else {
        		//Normal stuff
        	}
        }
    }
}