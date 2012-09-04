package me.KeybordPiano459.MCWeapons;

import java.io.IOException;

import me.KeybordPiano459.MCWeapons.events.ExplosiveArrow;
import me.KeybordPiano459.MCWeapons.events.JoinMessage;
import me.KeybordPiano459.MCWeapons.events.LightningStick;
import me.KeybordPiano459.MCWeapons.events.PlayerDeath;
import me.KeybordPiano459.MCWeapons.events.SnowballGrenade;
import me.KeybordPiano459.MCWeapons.events.ThrowableFireCharge;
import me.KeybordPiano459.MCWeapons.util.Metrics;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MCWeapons extends JavaPlugin {
	
	public static MCWeapons plugin;
	
	public void onEnable() {
		getLogger().info("MCWeapons v1.0 has been enabled!");
		
		registerEvents();
		//getCommands();
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit stats :-(
		}
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ThrowableFireCharge(), this);
		pm.registerEvents(new SnowballGrenade(), this);
		pm.registerEvents(new ExplosiveArrow(), this);
		pm.registerEvents(new LightningStick(), this);
		
		if (getConfig().getBoolean("explosive-deaths")) {
			pm.registerEvents(new PlayerDeath(), this);
		} else {
			getLogger().info("Explosive deaths are disabled.");
		}
		
		if (getConfig().getBoolean("join-message")) {
			pm.registerEvents(new JoinMessage(), this);
		}
		getLogger().info("Weapons have been activated!");
	}
	/*
	public void getCommands() {
		getCommand("mcweapons", new CommandMCWeapons());
	}
	public void getCommand(String command, CommandExecutor commandexecutor) {
		Bukkit.getServer().getPluginCommand(command).setExecutor(commandexecutor);
	}
	*/
	public void onDisable() {
		getLogger().info("MCWeapons v1.0 has been disabled.");
	}
}