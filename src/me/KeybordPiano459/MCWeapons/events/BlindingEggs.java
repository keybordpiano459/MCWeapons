package me.KeybordPiano459.MCWeapons.events;

import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindingEggs implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onEggHit(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Egg) {
			Player player = (Player) event.getEntity();
			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1));
		}
    }
}