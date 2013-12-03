package me.bman.betterbcast.command;

/* [================================================]
 * |        Better broadcast, by Sir_Mr_Bman        |
 * |  (C) 2013-14, please see README for details.   |
 * [================================================]
 */

import me.bman.betterbcast.main.BetterBcast;
import me.bman.betterbcast.yaml.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_bb implements CommandExecutor {
	// Create instance of plugin and command for reference.
	public static BetterBcast plugin;
	// Bukkit's onCommand method
	public boolean onCommand( CommandSender sender, Command command,
			String label, String[] args ) {
		// Check to see if the command is sent
		if ( command.getName().equalsIgnoreCase("bb") ) {
			// Find out if we are using custom permissions
			if ( YamlConfigValues.customPerm == true ) {
				// If we are using custom permissions... does the user have them?
				if ( sender.hasPermission(YamlConfigValues.prefPerm + ".say") ) {
					// The user has the permission, but forgot to include a message.
					if(args.length == 0) {
						sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + YamlConfigValues.errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + YamlConfigValues.noArgs);
					}
					// The user has the permission, and included the message. This breaks down additional args, and builds the message
					else if(args.length >= 1) {
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						    sb.append(args[i] + " ");
						}
						// Send the broadcast to the server
						String reason = sb.toString().trim();
						Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + YamlConfigValues.bcastPrefix + ChatColor.RED + "] " + ChatColor.YELLOW + args[0] + " " + reason);
						if ( YamlConfigValues.dispMsg == true ) {
							sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + YamlConfigValues.errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + "Message sent using Better Broadcast version 0.2 by Sir_Mr_Bman");
						}
					}
				// Otherwise, the custom permission was not given to the user
				} else {
					sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + YamlConfigValues.errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + YamlConfigValues.noPerms);
				}
			// What if we arn't using custom permissions?
			} else { 
				// Does the user have the normal permission?
				if ( sender.hasPermission("betterbcast.say")) {
					// The user has the permission, but forgot to include a message
					if(args.length == 0) {
						sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + YamlConfigValues.errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + YamlConfigValues.noArgs);
					}
					// The user has the permission, and included the message. This breaks down additional args, and builds the message
					else if(args.length >= 1) {
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						    sb.append(args[i] + " ");
						}
						// Send the broadcast to the server
						String reason = sb.toString().trim();
						Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + YamlConfigValues.bcastPrefix + ChatColor.RED + "] " + ChatColor.YELLOW + args[0] + " " + reason);
						if ( plugin.getConfig().getBoolean("disp-message") == true ) {
							sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + YamlConfigValues.errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + "Message sent using Better Broadcast version 0.2 by Sir_Mr_Bman");
						}
					}
				// Otherwise, the normal permission was not given to the user
				} else {
					sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + YamlConfigValues.errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + YamlConfigValues.noPerms);
				}
			}
		}
	return false;
	}
}
