package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ExplosiveArrow implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onArrowShot(ProjectileHitEvent event) {
		if (event.getEntity() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getEntity();
			if (arrow.getShooter() instanceof Player) {
				Player player = (Player) arrow.getShooter();
				if (player.hasPermission("mcweapons.explosivearrow")) {
					final Location loc = event.getEntity().getLocation();
					final TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
					tnt.setFuseTicks(0);
					tnt.setYield(4);
					Entity ent = event.getEntity();
					if (ent.getType() == EntityType.ARROW) {
						ent.remove();
					}
				}
			}
		}
	}
}