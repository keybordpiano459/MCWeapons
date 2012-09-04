package me.KeybordPiano459.MCWeapons.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMCWeapons implements CommandExecutor {
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  Player player = (Player) sender;
		  Logger log = Logger.getLogger("Minecraft");
		  if (cmd.getName().equalsIgnoreCase("mcweapons")) {
			  if (sender instanceof Player) {
				  if (args.length == 0) {
					  player.sendMessage(ChatColor.DARK_GREEN + "MCWeapons v1.0");
					  player.sendMessage("");
					  player.sendMessage(ChatColor.RED + "Developed by " + ChatColor.DARK_RED + "KeybordPiano459");
					  player.sendMessage("");
					  player.sendMessage(ChatColor.AQUA + "Plugin sites:");
					  player.sendMessage(ChatColor.DARK_AQUA + "  http://dev.bukkit.org/server-mods/mcweapons/");
					  player.sendMessage(ChatColor.DARK_AQUA + "  http://mcstats.org/plugin/mcweapons/");
					  player.sendMessage(ChatColor.DARK_AQUA + "  https://github.com/keybordpiano459/MCWeapons/");
				  } else {
					  player.sendMessage("[" + ChatColor.DARK_GREEN + "MCWeapons" + ChatColor.RESET + "] " + ChatColor.RED + "Incorrect usage! Type /MCWeapons");
				  }
			  } else {
				  if (args.length == 0) {
					  log.info("MCWeapons v1.0");
					  log.info("");
					  log.info("Developed by KeybordPiano459");
					  log.info("");
					  log.info("Plugin sites:");
					  log.info("  http://dev.bukkit.org/server-mods/mcweapons/");
					  log.info("  http://mcstats.org/plugin/mcweapons/");
					  log.info("  https://github.com/keybordpiano459/MCWeapons/");
				  } else {
					  log.info("[MCWeapons] Incorrect usage! Type /MCWeapons");
				  }
			  }
		  }
		  return true;
	  }
}