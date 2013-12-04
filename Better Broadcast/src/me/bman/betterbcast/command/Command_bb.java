package me.bman.betterbcast.command;

/* [================================================]
 * |        Better broadcast, by Sir_Mr_Bman        |
 * |  (C) 2013-14, please see README for details.   |
 * [================================================]
 */

import me.bman.betterbcast.main.BetterBcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_bb implements CommandExecutor {
	public static BetterBcast plugin;
	// Boolean: use custom permissions
	public static boolean customPerm = plugin.getConfig().getBoolean("use-perm");
	
	// Boolean: display message
	public static boolean dispMsg = plugin.getConfig().getBoolean("disp-message");
	
	// String: custom permissions
	public static String prefPerm = plugin.getConfig().getString("pref-perm");
	
	public static String errPrefix = plugin.getConfig().getString("err-prefix");
	
	// String: broadcast prefix
	public static String bcastPrefix = plugin.getConfig().getString("bcast-prefix");
	
	// String: No arguments message
	public static String noArgs = plugin.getConfig().getString("no-args");
	
	// String: No permissions
	public static String noPerms = plugin.getConfig().getString("no-perm");
	
	// Bukkit's onCommand method
	public boolean onCommand( CommandSender sender, Command command,
			String label, String[] args ) {
		// Check to see if the command is sent
		if ( command.getName().equalsIgnoreCase("bb") ) {
			// Find out if we are using custom permissions
			if ( customPerm == true ) {
				// If we are using custom permissions... does the user have them?
				if ( sender.hasPermission(prefPerm + ".say") ) {
					// The user has the permission, but forgot to include a message.
					if(args.length == 0) {
						sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + noArgs);
					}
					// The user has the permission, and included the message. This breaks down additional args, and builds the message
					else if(args.length >= 1) {
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						    sb.append(args[i] + " ");
						}
						// Send the broadcast to the server
						String reason = sb.toString().trim();
						Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + bcastPrefix + ChatColor.RED + "] " + ChatColor.YELLOW + args[0] + " " + reason);
						if ( dispMsg == true ) {
							sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + "Message sent using Better Broadcast version 0.2 by Sir_Mr_Bman");
						}
					}
				// Otherwise, the custom permission was not given to the user
				} else {
					sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + noPerms);
				}
			// What if we arn't using custom permissions?
			} else { 
				// Does the user have the normal permission?
				if ( sender.hasPermission("betterbcast.say")) {
					// The user has the permission, but forgot to include a message
					if(args.length == 0) {
						sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + noArgs);
					}
					// The user has the permission, and included the message. This breaks down additional args, and builds the message
					else if(args.length >= 1) {
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						    sb.append(args[i] + " ");
						}
						// Send the broadcast to the server
						String reason = sb.toString().trim();
						Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + bcastPrefix + ChatColor.RED + "] " + ChatColor.YELLOW + args[0] + " " + reason);
						if ( plugin.getConfig().getBoolean("disp-message") == true ) {
							sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + "Message sent using Better Broadcast version 0.2 by Sir_Mr_Bman");
						}
					}
				// Otherwise, the normal permission was not given to the user
				} else {
					sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + errPrefix + ChatColor.RED + "] " + ChatColor.GREEN + noPerms);
				}
			}
		}
	return false;
	}
}
