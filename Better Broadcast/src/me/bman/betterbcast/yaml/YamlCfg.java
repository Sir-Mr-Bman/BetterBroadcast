package me.bman.betterbcast.yaml;
import me.bman.betterbcast.main.*;
public class YamlCfg {
	
	private static BetterBcast plugin;
	public  YamlCfg(BetterBcast plugin) {
		YamlCfg.plugin = plugin;
	}
	// Boolean: use custom permissions
		public boolean customPerm = plugin.getConfig().getBoolean("use-perm");
		
		// Boolean: display message
		public boolean dispMsg = plugin.getConfig().getBoolean("disp-message");
		
		// String: custom permissions
		public String prefPerm = plugin.getConfig().getString("pref-perm");
		
		public String errPrefix = plugin.getConfig().getString("err-prefix");
		
		// String: broadcast prefix
		public String bcastPrefix = plugin.getConfig().getString("bcast-prefix");
		
		// String: No arguments message
		public String noArgs = plugin.getConfig().getString("no-args");
		
		// String: No permissions
		public String noPerms = plugin.getConfig().getString("no-perm");
		
}
