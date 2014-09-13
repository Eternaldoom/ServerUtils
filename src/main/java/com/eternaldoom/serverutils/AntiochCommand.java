package com.eternaldoom.serverutils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AntiochCommand extends Command{

	public AntiochCommand() {
		super("antioch");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxyServer server = ProxyServer.getInstance();
		ProxiedPlayer player = server.getPlayer(sender.getName());
		if(sender.hasPermission("serverutils.antioch")){
			player.chat("/summon PrimedTnt ~ ~-1 ~ {ExplosionPower:10,Fuse:100}");
		}else{
			sender.sendMessage(new ComponentBuilder("You do not have permission to use this command.").color(ChatColor.RED).create());
		}
	}
}
