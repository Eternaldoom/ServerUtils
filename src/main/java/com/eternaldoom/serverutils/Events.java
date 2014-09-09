package com.eternaldoom.serverutils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPostLogin(PostLoginEvent evt){
		evt.getPlayer().sendMessage(ChatColor.DARK_GREEN + "Welcome to the server, " + evt.getPlayer().getName());
		
	}
}