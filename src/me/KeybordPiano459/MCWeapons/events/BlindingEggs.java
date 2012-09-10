package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindingEggs implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent event) {
		Entity entity = event.getEntity();
		if (event.getDamager() instanceof Egg && entity instanceof Player) {
			Player player = (Player) entity;
			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
		}
	}
}