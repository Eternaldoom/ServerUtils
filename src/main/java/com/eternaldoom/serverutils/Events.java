package com.eternaldoom.serverutils;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPostLogin(PostLoginEvent evt){
		evt.getPlayer().sendMessage(ChatColor.DARK_GREEN + "Welcome to the server, " + evt.getPlayer().getName());
		if(ServerUtils.mutelist.get(evt.getPlayer().getName().toLowerCase()) == null){
			ServerUtils.mutelist.set(evt.getPlayer().getName().toLowerCase(), false);
			try {
				ConfigurationProvider.getProvider(YamlConfiguration.class).save(ServerUtils.mutelist, new File(ServerUtils.datafolder, "muteplayers.yml"));
			} catch (IOException e) {}
		}
	}
	
	@EventHandler
	public void onPlayerChat(ChatEvent evt){
		if(!evt.isCommand() && evt.getSender() instanceof ProxiedPlayer){
			ProxiedPlayer player = (ProxiedPlayer)evt.getSender();
			ProxyServer server = ProxyServer.getInstance();
			if (!ServerUtils.mutelist.getBoolean(player.getName().toLowerCase()))server.broadcast(new ComponentBuilder("<" + player.getName() + "> " + evt.getMessage()).create());
			evt.setCancelled(true);
		}
	}
}