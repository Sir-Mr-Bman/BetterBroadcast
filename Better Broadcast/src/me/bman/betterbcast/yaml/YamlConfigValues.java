package me.bman.betterbcast.yaml;

/* [================================================]
 * |        Better broadcast, by Sir_Mr_Bman        |
 * |  (C) 2013-14, please see README for details.   |
 * [================================================]
 */

import me.bman.betterbcast.main.BetterBcast;

public class YamlConfigValues {
	
	public static BetterBcast plugin;
	// Boolean: use custom permissions
	public static boolean customPerm = plugin.getConfig().getBoolean("use-perm");
	
	// Boolean: display message
	public static boolean dispMsg = plugin.getConfig().getBoolean("disp-message");
	
	// String: custom permissions
	public static String prefPerm = plugin.getConfig().getString("pref-perm");
	
	// String: error message prefix
	public static String errPrefix = plugin.getConfig().getString("err-prefix");
	
	// String: broadcast prefix
	public static String bcastPrefix = plugin.getConfig().getString("bcast-prefix");
	
	// String: No arguments message
	public static String noArgs = plugin.getConfig().getString("no-args");
	
	// String: No permissions
	public static String noPerms = plugin.getConfig().getString("no-perm");
	
	
}
