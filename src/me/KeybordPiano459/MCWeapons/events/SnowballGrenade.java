package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballGrenade implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSnowballThrow(ProjectileHitEvent event) {
		if (event.getEntity() instanceof Snowball) {
			Snowball snow = (Snowball) event.getEntity();
			if (snow.getShooter() instanceof Player) {
				Player player = (Player) snow.getShooter();
				if (player.hasPermission("mcweapons.snowballgrenade")) {
					final Location loc = event.getEntity().getLocation();
					final TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
					tnt.setFuseTicks(20);
					tnt.setYield(4);
				}
			}
		}
	}
}