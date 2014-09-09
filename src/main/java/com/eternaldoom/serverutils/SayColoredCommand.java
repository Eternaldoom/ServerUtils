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
		
		StringBuilder builder = new StringBuilder();
		
		if(args.length>1){
			for(int i = 1; i < args.length; i++){
				if(i > 1)builder.append(" ");
				builder.append(args[i-1]);
			}
		}
		
		String message = builder.toString();
		String color = "white";
		if(args.length > 0) color = args[args.length-1];
		
		if(args.length > 0 && args.length < 2) server.broadcast(prefix+args[0]);
		else if (args.length > 0){
			switch(color){
			case "red": server.broadcast(prefix + ChatColor.RED + message);break;
			case "dark_red": server.broadcast(prefix + ChatColor.DARK_RED + message);break;
			case "blue": server.broadcast(prefix + ChatColor.BLUE + message);break;
			case "dark_blue": server.broadcast(prefix + ChatColor.DARK_BLUE + message);break;
			case "green": server.broadcast(prefix + ChatColor.GREEN + message);break;
			case "dark_green": server.broadcast(prefix + ChatColor.DARK_GREEN + message);break;
			case "black": server.broadcast(prefix + ChatColor.BLACK + message);break;
			case "aqua": server.broadcast(prefix + ChatColor.AQUA + message);break;
			case "dark_aqua": server.broadcast(prefix + ChatColor.DARK_AQUA + message);break;
			case "gold": server.broadcast(prefix + ChatColor.GOLD + message);break;
			case "gray": server.broadcast(prefix + ChatColor.GRAY + message);break;
			case "dark_gray": server.broadcast(prefix + ChatColor.DARK_GRAY + message);break;
			case "purple": server.broadcast(prefix + ChatColor.LIGHT_PURPLE + message);break;
			case "dark_purple": server.broadcast(prefix + ChatColor.DARK_PURPLE + message);break;
			case "yellow": server.broadcast(prefix + ChatColor.YELLOW + message);break;
			default: server.broadcast(prefix + message);
			}
		}else{
			sender.sendMessage(new ComponentBuilder("Usage: /saycolored <message> <color>").color(ChatColor.RED).create());
		}
	}
}
