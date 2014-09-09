package com.eternaldoom.serverutils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ListCommand extends Command{
	public ListCommand() {
		super("list");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(new ComponentBuilder("Currently online:").color(ChatColor.GREEN).create());
		for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()){
			sender.sendMessage(new ComponentBuilder(player.getName()).color(ChatColor.GOLD).create());
		}
	}

}
