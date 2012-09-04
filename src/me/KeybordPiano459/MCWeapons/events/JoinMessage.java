package me.KeybordPiano459.MCWeapons.events;

import me.KeybordPiano459.MCWeapons.MCWeapons;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;

public class JoinMessage implements Listener {
	PluginDescriptionFile pdfFile = MCWeapons.plugin.getDescription();
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("[" + ChatColor.DARK_GREEN + "MCWeapons" + ChatColor.RESET + "] " + ChatColor.GREEN + "This server is running MCWeapons " + pdfFile.getVersion());
	}
}