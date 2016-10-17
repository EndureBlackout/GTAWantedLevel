
package me.endureblackout.gwl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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

						for (OfflinePlayer t : Bukkit.getOfflinePlayers()) {

							if (!LevelHandler.level.isEmpty()) {
								if (LevelHandler.level.containsKey(t.getUniqueId())) {
									int points = LevelHandler.level.get(t.getUniqueId());

									if (points > top15 && !(t.getName().equals(p14))) {
										if (points > top14 && !(t.getName().equals(p13))) {
											if (points > top13 && !(t.getName().equals(p12))) {
												if (points > top12 && !(t.getName().equals(p11))) {
													if (points > top11 && !(t.getName().equals(p10))) {
														if (points > top10 && !(t.getName().equals(p9))) {
															if (points > top9 && !(t.getName().equals(p8))) {
																if (points > top8 && !(t.getName().equals(p7))) {
																	if (points > top7 && !(t.getName().equals(p6))) {
																		if (points > top6 && !(t.getName().equals(p5))) {
																			if (points > top5 && !(t.getName().equals(p4))) {
																				if (points > top4 && !(t.getName().equals(p3))) {
																					if (points > top3 && !(t.getName().equals(p2))) {
																						if (points > top2 && !(t.getName().equals(p1))) {
																							if (points > top1) {
																								if ((p1 == null)) {
																									top1 = points;
																									p1 = t.getName();
																									continue;
																								}
																							}
																							if ((p2 == null)) {
																								top2 = points;
																								p2 = t.getName();
																								continue;
																							}
																						}
																						if ((p3 == null)) {
																							top3 = points;
																							p3 = t.getName();
																							continue;
																						}
																					}
																					if ((p4 == null)) {
																						top4 = points;
																						p4 = t.getName();
																						continue;
																					}
																				}
																				if ((p5 == null)) {
																					top5 = points;
																					p5 = t.getName();
																					continue;
																				}
																			}
																			if ((p6 == null)) {
																				top6 = points;
																				p6 = t.getName();
																				continue;
																			}
																		}
																		if ((p7 == null)) {
																			top7 = points;
																			p7 = t.getName();
																			continue;
																		}
																	}
																	if ((p8 == null)) {
																		top8 = points;
																		p8 = t.getName();
																		continue;
																	}
																}
																if ((p9 == null)) {
																	top9 = points;
																	p9 = t.getName();
																	continue;
																}
															}
															if ((p10 == null)) {
																top10 = points;
																p10 = t.getName();
																continue;
															}
														}
														if ((p11 == null)) {
															top11 = points;
															p11 = t.getName();
															continue;
														}
													}
													if ((p12 == null)) {
														top12 = points;
														p12 = t.getName();
														continue;
													}
												}
												if ((p13 == null)) {
													top13 = points;
													p13 = t.getName();
													continue;
												}
											}
											if ((p14 == null)) {
												top14 = points;
												p14 = t.getName();
												continue;
											}
										}
										if ((p15 == null)) {
											top15 = points;
											p15 = t.getName();
											continue;
										}
									}
								}
							}
						}
					}

					if (!LevelHandler.level.isEmpty()) {
						if (!(p1 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p1 + "&7:" + top1));
						if (!(p2 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p2 + "&7:" + top2));
						if (!(p3 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p3 + "&7:" + top3));
						if (!(p4 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p4 + "&7:" + top4));
						if (!(p5 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p5 + "&7:" + top5));
						if (!(p6 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p6 + "&7:" + top6));
						if (!(p7 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p7 + "&7:" + top7));
						if (!(p8 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p8 + "&7:" + top8));
						if (!(p9 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p9 + "&7:" + top9));
						if (!(p10 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p10 + "&7:" + top10));
						if (!(p11 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p11 + "&7:" + top11));
						if (!(p12 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p12 + "&7:" + top12));
						if (!(p13 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p13 + "&7:" + top13));
						if (!(p14 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p14 + "&7:" + top14));
						if (!(p15 == null)) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + p15 + "&7:" + top15));
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
