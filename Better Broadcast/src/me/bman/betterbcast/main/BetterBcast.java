package me.bman.betterbcast.main;

/* [================================================]
 * |        Better broadcast, by Sir_Mr_Bman        |
 * |  (C) 2013-14, please see README for details.   |
 * [================================================]
 */

import java.util.logging.Logger;

import me.bman.betterbcast.command.*;
import me.bman.betterbcast.yaml.YamlCfg;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterBcast extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[BetterBroadcast] Now loading BetterBroadcast version " + pdfFile.getVersion() + " please wait.");
		getCommand("bb").setExecutor(new Command_bb());
		try {
			plugin = this;
			this.saveDefaultConfig();
			this.logger.info("[BetterBroadcast] Finished loading BetterBroadcast");
			
		} catch ( Exception e ) {
			this.logger.severe("[BetterBroadcast] BetterBroadcast failed to load!");
			this.logger.severe("[BetterBroadcast] Now disabling BetterBroadcast...");
			this.onDisable();
		}
	}
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[BetterBroadcast] BetterBroadcast by Sir_Mr_Bman version " + pdfFile.getVersion() + " has been disabled.");
	}
	
}
