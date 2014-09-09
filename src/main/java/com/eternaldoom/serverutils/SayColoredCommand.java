package com.eternaldoom.serverutils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class SayColoredCommand extends Command{

	public SayColoredCommand() {
		super("saycolored");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxyServer server = ProxyServer.getInstance();
		String prefix = "<"+sender.getName()+"> ";
		if(args.length > 0 && args.length < 2) server.broadcast(prefix+args[0]);
		else if (args.length > 0 && args.length == 2){
			switch(args[1]){
			case "red": server.broadcast(prefix + ChatColor.RED + args[0]);break;
			case "dark_red": server.broadcast(prefix + ChatColor.DARK_RED + args[0]);break;
			case "blue": server.broadcast(prefix + ChatColor.BLUE + args[0]);break;
			case "dark_blue": server.broadcast(prefix + ChatColor.DARK_BLUE + args[0]);break;
			case "green": server.broadcast(prefix + ChatColor.GREEN + args[0]);break;
			case "dark_green": server.broadcast(prefix + ChatColor.DARK_GREEN + args[0]);break;
			case "black": server.broadcast(prefix + ChatColor.BLACK + args[0]);break;
			case "aqua": server.broadcast(prefix + ChatColor.AQUA + args[0]);break;
			case "dark_aqua": server.broadcast(prefix + ChatColor.DARK_AQUA + args[0]);break;
			case "gold": server.broadcast(prefix + ChatColor.GOLD + args[0]);break;
			case "gray": server.broadcast(prefix + ChatColor.GRAY + args[0]);break;
			case "dark_gray": server.broadcast(prefix + ChatColor.DARK_GRAY + args[0]);break;
			case "purple": server.broadcast(prefix + ChatColor.LIGHT_PURPLE + args[0]);break;
			case "dark_purple": server.broadcast(prefix + ChatColor.DARK_PURPLE + args[0]);break;
			case "yellow": server.broadcast(prefix + ChatColor.YELLOW + args[0]);break;
			default: server.broadcast(prefix + args[0]);
			}
		}else{
			sender.sendMessage(new ComponentBuilder("Usage: /saycolored <message> <color>").color(ChatColor.RED).create());
		}
	}
}
