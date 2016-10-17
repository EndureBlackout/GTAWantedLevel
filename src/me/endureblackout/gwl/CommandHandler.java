
package me.endureblackout.gwl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

	GWL				core;
	static int		top1	= 0;
	static int		top2	= 0;
	static int		top3	= 0;
	static int		top4	= 0;
	static int		top5	= 0;
	static int		top6	= 0;
	static int		top7	= 0;
	static int		top8	= 0;
	static int		top9	= 0;
	static int		top10	= 0;
	static int		top11	= 0;
	static int		top12	= 0;
	static int		top13	= 0;
	static int		top14	= 0;
	static int		top15	= 0;

	static String	p1		= null;
	static String	p2		= null;
	static String	p3		= null;
	static String	p4		= null;
	static String	p5		= null;
	static String	p6		= null;
	static String	p7		= null;
	static String	p8		= null;
	static String	p9		= null;
	static String	p10		= null;
	static String	p11		= null;
	static String	p12		= null;
	static String	p13		= null;
	static String	p14		= null;
	static String	p15		= null;

	public CommandHandler(GWL instance) {
		core = instance;
	}
	
    private static Map<UUID, Integer> sortByComparator(Map<UUID, Integer> unsortMap, final boolean order)
    {

        List<Entry<UUID, Integer>> list = new LinkedList<Entry<UUID, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<UUID, Integer>>()
        {
            public int compare(Entry<UUID, Integer> o1,
                    Entry<UUID, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }

        });

        // Maintaining insertion order with the help of LinkedList
        Map<UUID, Integer> sortedMap = new LinkedHashMap<UUID, Integer>();
        for (Entry<UUID, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("wanted")) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("unselect")) {
						if (p.getInventory().contains(Material.COMPASS)) {
							p.setCompassTarget(p.getLocation());
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Compass unselect")));
						} else {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("No compass")));
						}
					}

					if (args[0].equalsIgnoreCase("list")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8-=-=- (&9Wanted&8) -=-=-"));
						Map<UUID, Integer> board = sortByComparator(LevelHandler.level, true);
						
						for(int i = 0; i < 15; i++) {
							if(i < board.size()) {
								for(Entry<UUID, Integer> k : board.entrySet()) {
									Player t = Bukkit.getPlayer(k.getKey());
									
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + t.getName() + "&7: " + k.getValue()));
								}
							}
						}
					}
				}
			}

			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("reset")) {
					for (Player w : Bukkit.getOnlinePlayers()) {
						if (args[1].equalsIgnoreCase(w.getName())) {
							if (LevelHandler.level.containsKey(w.getUniqueId())) {
								LevelHandler.level.remove(w.getUniqueId());
								w.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Removed level")));
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Removed other level").replaceAll("%player%", w.getName())));
							} else {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Error")));
							}
						}
					}
				}

				if (args[0].equalsIgnoreCase("select")) {
					for (Player t : Bukkit.getOnlinePlayers()) {
						if (args[1].equalsIgnoreCase(t.getName())) {
							if (p.getInventory().contains(Material.COMPASS)) {
								p.setCompassTarget(t.getLocation());
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("Set tracking").replaceAll("%player%", t.getName())));
							} else {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', core.getConfig().getString("No compass")));
							}
						}
					}
				}
			}

			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("add")) {
					for (Player w : Bukkit.getOnlinePlayers()) {
						if (args[1].equalsIgnoreCase(w.getName())) {
							if (LevelHandler.level.containsKey(w.getUniqueId())) {
								int add = LevelHandler.level.get(w.getUniqueId());
								add = add + Integer.parseInt(args[2]);

								LevelHandler.level.remove(w.getUniqueId());
								LevelHandler.level.put(w.getUniqueId(), add);
							}
						}
					}
				}
			}
		}

		return true;
	}

}
