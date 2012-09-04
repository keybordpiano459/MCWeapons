package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class ThrowableFireCharge implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
        	if (player.hasPermission("mcweapons.firecharge")) {
        		if (player.getItemInHand().getType() == Material.FIREBALL) {
        			if (player.getGameMode() == GameMode.CREATIVE) {
        				boolean small = false;
        				final Vector direction = player.getPlayer().getEyeLocation().getDirection().multiply(2);
        				final Fireball fireball = player.getPlayer().getWorld().spawn(player.getPlayer().getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), small ? SmallFireball.class : Fireball.class);
        				fireball.setShooter(player.getPlayer());
        			} else if (player.getGameMode() == GameMode.SURVIVAL) {
        				boolean small = false;
        				final Vector direction = player.getPlayer().getEyeLocation().getDirection().multiply(2);
        				final Fireball fireball = player.getPlayer().getWorld().spawn(player.getPlayer().getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), small ? SmallFireball.class : Fireball.class);
        				fireball.setShooter(player.getPlayer());
        				int amount = player.getPlayer().getItemInHand().getAmount();
        				player.getItemInHand().setAmount(amount-1);
        			}
        		}
        	} else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        		//Place fire
        	} else {
        		//Place fire
        	}
        } else {
        	//Place fire
        }
    }
}