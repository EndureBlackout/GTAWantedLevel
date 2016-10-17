
package me.endureblackout.gwl;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class GWL extends JavaPlugin {

	public void onEnable() {
		File file = new File(getDataFolder(), "config.yml");
		if (!(file.exists())) {
			try {
				saveConfig();
				setupConfig(getConfig());
				getConfig().options().copyDefaults(true);
				saveConfig();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Bukkit.getServer().getPluginManager().registerEvents(new LevelHandler(this), this);
		getCommand("wanted").setExecutor(new CommandHandler(this));
	}
	
	private void setupConfig(FileConfiguration config) throws IOException {
		if (!new File(getDataFolder(), "RESET.FILE").exists()) {
			new File(getDataFolder(), "RESET.FILE").createNewFile();
			getConfig().set("Added level", "&5[Wanted] Your wanted level has went up!");
			getConfig().set("Removed level", "&5[Wanted] Your wanted level has been removed!");
			getConfig().set("Set level", "&5[Wanted] Your wanted level has been set to %level%");
			getConfig().set("No compass", "&5[Wanted] You don't have a compass in your inventory!");
			getConfig().set("Set tracking", "&5[Wanted] You are now tracking %player%");
			getConfig().set("Removed other level", "&5[Wanted] You removed %player%'s level!");
			getConfig().set("Error", "&5[Wanted] Nothing to do!");
			getConfig().set("Compass unselect", "&5[Wanted] You are no longer tracking anyone!");
		}
	}
}
