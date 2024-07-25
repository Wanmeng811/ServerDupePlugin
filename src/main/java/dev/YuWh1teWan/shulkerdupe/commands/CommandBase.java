package dev.YuWh1teWan.shulkerdupe.commands;

import dev.YuWh1teWan.shulkerdupe.util.ChatUtil;
import dev.YuWh1teWan.shulkerdupe.util.FileUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBase implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length == 1)
                switch (args[0]) {
                    case "info":
                        if (player.hasPermission("ShulkerDupe.command.infoself")) {
                            if (FileUtil.getPlayerDataConfig().get(sender.getName()) != null) {
                                player.sendMessage(ChatUtil.prefix() +
                                        ChatUtil.color("&6&l") +
                                        FileUtil.getPlayerDataConfig().getInt(player.getName() + ".DupeCount"));
                                break;
                            }
                            player.sendMessage(ChatUtil.prefix() +
                                    ChatUtil.color(" &c&l"));
                            break;
                        }
                        player.sendMessage(ChatUtil.noPrem());
                        break;
                    case "help":
                        player.sendMessage(ChatUtil.color("&8-----&eShulker&d&lDupe&8作者:&bYuWh1teWan"));
                        player.sendMessage(ChatUtil.color("&a/sd info &6                      查看您的复制数量!"));
                        player.sendMessage(ChatUtil.color("&a/sd info <ID>&6                  查看他人复制数量!"));
                        player.sendMessage(ChatUtil.color("&a/sd dupe on &6                       开启dupe喵~"));
                        player.sendMessage(ChatUtil.color("&a/sd dupe off &6                      禁用dupe喵~"));
                        player.sendMessage(ChatUtil.color("&a/sd notify on &6                      开启通知喵~"));
                        player.sendMessage(ChatUtil.color("&a/sd notify off &6                     禁用通知喵~"));
                        player.sendMessage(ChatUtil.color("&8---------------------------------"));
                        break;
                    case "dupe":
                        if (player.hasPermission("ShulkerDupe.command.dupe")) {
                            player.sendMessage(ChatUtil.prefix() +
                                    ChatUtil.color(" &c&c&l/sd dupe <on/off>"));
                            break;
                        }
                        player.sendMessage(ChatUtil.noPrem());
                        break;
                    case "notify":
                        if (player.hasPermission("ShulkerDupe.command.notify")) {
                            player.sendMessage(ChatUtil.prefix() +
                                    ChatUtil.color(" &c&c&l/sd notify <on/off>"));
                            break;
                        }
                        player.sendMessage(ChatUtil.noPrem());
                        break;
                }
            if (args.length >= 2)
                switch (args[0]) {
                    case "info":
                        if (player.hasPermission("ShulkerDupe.command.infoplayer")) {
                            if (FileUtil.getPlayerDataConfig().get(args[0]) != null) {
                                player.sendMessage(ChatUtil.prefix() +
                                        ChatUtil.color("&a&2&0") + args[1] +

                                        ChatUtil.color("&a&6&l") +
                                        FileUtil.getPlayerDataConfig().getInt(args[1] + ".DupeCount"));
                                break;
                            }
                            player.sendMessage(ChatUtil.prefix() +
                                    ChatUtil.color(" &c&l"));
                            break;
                        }
                        player.sendMessage(ChatUtil.noPrem());
                        break;
                    case "dupe":
                        if (player.hasPermission("ShulkerDupe.command.dupe")) {
                            if (args[1].equals("on")) {
                                FileUtil.getPlayerDataConfig().set(player.getName() + ".Dupe", Boolean.valueOf(true));
                                player.sendMessage(ChatUtil.prefix() + ChatUtil.color(" &a"));
                                        FileUtil.save();
                                break;
                            }
                            if (args[1].equals("off")) {
                                FileUtil.getPlayerDataConfig().set(player.getName() + ".Dupe", Boolean.valueOf(false));
                                player.sendMessage(ChatUtil.prefix() + ChatUtil.color(" &a"));
                                        FileUtil.save();
                                break;
                            }
                            player.sendMessage(ChatUtil.prefix() +
                                    ChatUtil.color(" &c&c&l/sd dupe <on/off>"));
                            break;
                        }
                        player.sendMessage(ChatUtil.noPrem());
                        break;
                    case "notify":
                        if (player.hasPermission("ShulkerDupe.command.notify")) {
                            if (args[1].equals("on")) {
                                FileUtil.getPlayerDataConfig().set(player.getName() + ".Notify", Boolean.valueOf(true));
                                player.sendMessage(ChatUtil.prefix() + ChatUtil.color(" &a"));
                                        FileUtil.save();
                                break;
                            }
                            if (args[1].equals("off")) {
                                FileUtil.getPlayerDataConfig().set(player.getName() + ".Notify", Boolean.valueOf(false));
                                player.sendMessage(ChatUtil.prefix() + ChatUtil.color(" &a"));
                                        FileUtil.save();
                                break;
                            }
                            player.sendMessage(ChatUtil.prefix() +
                                    ChatUtil.color(" &c&c&l/sd notify <on/off>"));
                            break;
                        }
                        player.sendMessage(ChatUtil.noPrem());
                        break;
                }
            if (args.length < 1) {
                player.sendMessage(ChatUtil.color("&8-----&eShulker&d&lDupe&8作者:&9&b YuWh1teWan"));
                player.sendMessage(ChatUtil.color("&a/sd info &6                      查看您的复制数量!"));
                player.sendMessage(ChatUtil.color("&a/sd info <ID>&6                  查看他人复制数量!"));
                player.sendMessage(ChatUtil.color("&a/sd dupe on &6                       开启dupe喵~"));
                player.sendMessage(ChatUtil.color("&a/sd dupe off &6                      禁用dupe喵~"));
                player.sendMessage(ChatUtil.color("&a/sd notify on &6                      开启通知喵~"));
                player.sendMessage(ChatUtil.color("&a/sd notify off &6                     禁用通知喵~"));
                player.sendMessage(ChatUtil.color("&8---------------------------------"));
            }
        }
        return true;
    }
}
