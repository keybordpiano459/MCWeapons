package me.KeybordPiano459.MCWeapons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import me.KeybordPiano459.MCWeapons.commands.CommandMCWeapons;
import me.KeybordPiano459.MCWeapons.events.ExplosiveArrow;
import me.KeybordPiano459.MCWeapons.events.LightningStick;
import me.KeybordPiano459.MCWeapons.events.PlayerDeath;
import me.KeybordPiano459.MCWeapons.events.SnowballGrenade;
import me.KeybordPiano459.MCWeapons.events.ThrowableFireCharge;
import me.KeybordPiano459.MCWeapons.util.Metrics;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MCWeapons extends JavaPlugin {
	
	boolean update;
	public static MCWeapons plugin;
	
	public void onEnable() {
		getLogger().info("MCWeapons v1.0.5 has been enabled!");
		
		autoUpdater();
		registerEvents();
		getCommands();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit stats :-(
		}
	}
	
	public void onDisable() {
		getLogger().info("MCWeapons v1.0.5 has been disabled.");
	}
	
	public void getCommands() {
		getCommand("mcweapons", new CommandMCWeapons());
	}
	
	public void getCommand(String command, CommandExecutor commandexecutor) {
		Bukkit.getServer().getPluginCommand(command).setExecutor(commandexecutor);
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ThrowableFireCharge(), this);
		pm.registerEvents(new SnowballGrenade(), this);
		pm.registerEvents(new ExplosiveArrow(), this);
		pm.registerEvents(new LightningStick(), this);
		//pm.registerEvents(new BlindingEggs(), this);
		if (getConfig().getBoolean("explosive-deaths")) {
			pm.registerEvents(new PlayerDeath(), this);
		} else {
			getLogger().info("Explosive deaths are disabled.");
		}
		getLogger().info("Weapons have been activated!");
	}
	
	public void autoUpdater() {
		if(getConfig().getBoolean("auto-updater")) {		
			try {
		    	getLogger().info("Checking for a new version");
		        URL url = new URL("http://ubuntuone.com/1jiX3t59pMnDMa0S0bZpbs");
		        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		        String string;
		        while ((string = in.readLine()) != null) {
		        	int currentVersion = Integer.parseInt(Bukkit.getServer().getPluginManager().getPlugin("MCWeapons").getDescription().getVersion().replace(".", ""));
		        	int newestVersion = Integer.parseInt(string.replace(".", ""));
		        	if (currentVersion < newestVersion) {
		        		System.out.println("[MCWeapons] [WARNING] There is a new version of MCWeapons! Download version " + string + " now! [WARNING]");
		        		System.out.println("[MCWeapons] [WARNING] Download it at http://dev.bukkit.org/server-mods/mcweapons/ [WARNING]");
		        		update = true;
		            } else {
		            	System.out.println("[MCWeapons] You're running the latest version of MCWeapons.");
		            }
		        }
		        in.close();
			} catch (MalformedURLException e) {
				System.out.println("[MCWeapons] [WARNING] URL is invalid! Go to the MCWeapons thread and tell me now! [WARNING]");
			} catch (IOException e) {
		        System.out.println("[MCWeapons] [WARNING] Bad read/write! [WARNING]");
		    }
		}
	}
}