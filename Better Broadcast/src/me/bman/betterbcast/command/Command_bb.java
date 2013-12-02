package me.bman.betterbcast.command;

/* [===============================================]
 * |        Betterbroadcast, by Sir_Mr_Bman        |
 * |  (C) 2013-14, please see README for details.  |
 * [===============================================]
 */

import me.bman.betterbcast.main.BetterBcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_bb implements CommandExecutor {
	// Create instance of plugin and command for reference.
	public static BetterBcast plugin;
	public static Command_bb command;
	
	// Bukkit's onCommand method
	public boolean onCommand( CommandSender sender, Command command,
			String label, String[] args ) {
		// Check to see if the command is sent
		if ( label.equalsIgnoreCase("bb") ) {
			// Find out if we are using custom permissions
			if ( plugin.getConfig().getBoolean("use-perm") == true ) {
				// If we are using custom permissions... does the user have them?
				if ( sender.hasPermission(plugin.getConfig().getString("pref-perm") + ".say") ) {
					// The user has the permission, but forgot to include a message.
					if(args.length == 0) {
						sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + plugin.getConfig().getString("err-prefix") + ChatColor.RED + "] " + ChatColor.GREEN + plugin.getConfig().getString("no-args"));
					}
					// The user has the permission, and included the message. This breaks down additional args, and builds the message
					else if(args.length >= 1) {
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						    sb.append(args[i] + " ");
						}
						// Send the broadcast to the server
						String reason = sb.toString().trim();
						Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + plugin.getConfig().getString("bcast-prefix") + ChatColor.RED + "] " + ChatColor.YELLOW + args[0] + " " + reason);
					
					}
				// Otherwise, the custom permission was not given to the user
				} else {
					sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + plugin.getConfig().getString("err-prefix") + ChatColor.RED + "] " + ChatColor.GREEN + plugin.getConfig().getString("no-perm"));
				}
			// What if we arn't using custom perms?
			} else if ( plugin.getConfig().getBoolean("use-perm") == false ) { 
				// Does the user have the normal perm?
				if ( sender.hasPermission("betterbcast.say")) {
					// The user has the permission, but forgot to include a message
					if(args.length == 0) {
						sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + plugin.getConfig().getString("err-prefix") + ChatColor.RED + "] " + ChatColor.GREEN + plugin.getConfig().getString("no-args"));
					}
					// The user has the permission, and included the message. This breaks down additional args, and builds the message
					else if(args.length >= 1) {
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						    sb.append(args[i] + " ");
						}
						// Send the broadcast to the server
						String reason = sb.toString().trim();
						Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + plugin.getConfig().getString("bcast-prefix") + ChatColor.RED + "] " + ChatColor.YELLOW + args[0] + " " + reason);
					
					}
				// Otherwise, the normal permission was not given to the user
				} else {
					sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + plugin.getConfig().getString("err-prefix") + ChatColor.RED + "] " + ChatColor.GREEN + plugin.getConfig().getString("no-perm"));
				}
			}
		}
	return false;
	}
}