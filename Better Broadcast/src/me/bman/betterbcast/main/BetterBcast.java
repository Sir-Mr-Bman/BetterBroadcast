package me.bman.betterbcast.main;

/* [================================================]
 * |        Better broadcast, by Sir_Mr_Bman        |
 * |  (C) 2013-14, please see README for details.   |
 * [================================================]
 */

import java.util.logging.Logger;

import me.bman.betterbcast.command.*;
import me.bman.betterbcast.yaml.YamlConfigValues;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterBcast extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static BetterBcast plugin;
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[BetterBroadcast] Now loading BetterBroadcast version " + pdfFile.getVersion() + " please wait.");
		try {
			this.saveDefaultConfig();
			
			this.logger.info("[BetterBroadcast] Finished loading BetterBroadcast");
			getCommand("bb").setExecutor(new Command_bb());
			
			YamlConfigValues.plugin = this;
			Command_bb.plugin = this;
		} catch ( Exception e ) {
			this.logger.severe("[BetterBroadcast] BetterBroadcast failed to load!");
			this.logger.severe("[BetterBroadcast] Now disabling BetterBroadcast...");
			this.onDisable();
		}
	}
	
	@Override
	public void onDisable() {
		YamlConfigValues.plugin = null;
		Command_bb.plugin = null;
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[BetterBroadcast] BetterBroadcast by Sir_Mr_Bman version " + pdfFile.getVersion() + " has been disabled.");
	}
	
}
