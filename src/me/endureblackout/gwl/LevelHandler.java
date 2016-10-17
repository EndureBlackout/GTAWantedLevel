
package me.endureblackout.gwl;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LevelHandler implements Listener {

	GWL										core;
	public static HashMap<UUID, Integer>	level	= new HashMap<UUID, Integer>();

	public LevelHandler(GWL instance) {
		this.core = instance;
	}

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent e) {
		Player p = e.getEntity();

		if (p.getKiller() instanceof Player) {
			Player k = p.getKiller();

			if (!level.containsKey(k.getUniqueId())) {
				level.put(k.getUniqueId(), 1);
				k.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Added level")));
			} else if (level.containsKey(k.getUniqueId())) {
				if (level.containsKey(k.getUniqueId())) {
					int add = level.get(k.getUniqueId());
					add = add + 1;

					level.remove(k.getUniqueId());
					level.put(k.getUniqueId(), add);
					k.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Added level")));
				}
			}
		}
	}
}
