package me.bman.betterbcast.yaml;

import me.bman.betterbcast.main.BetterBcast;

public class YamlConfigValues {
	
	public static BetterBcast plugin;
	// Boolean: use custom perms
	public static boolean customPerm = plugin.getConfig().getBoolean("use-perm");
	
	// Boolean: display message
	public static boolean dispMsg = plugin.getConfig().getBoolean("disp-message");
	
	// String: custom perm
	public static String prefPerm = plugin.getConfig().getString("pref-perm");
	
	// String: error msg prefix
	public static String errPrefix = plugin.getConfig().getString("err-prefix");
	
	// String: broadcast prefix
	public static String bcastPrefix = plugin.getConfig().getString("bcast-prefix");
	
	// String: No args message
	public static String noArgs = plugin.getConfig().getString("no-args");
	
	// String: No permissions
	public static String noPerms = plugin.getConfig().getString("no-perm");
	
	
}
