package com.eternaldoom.serverutils;

import net.md_5.bungee.api.plugin.Plugin;

public class ServerUtils extends Plugin {
	
	@Override
	public void onEnable(){
		getLogger().info("Sucessfully Loaded");
		this.getProxy().getPluginManager().registerListener(this, new Events());
		this.getProxy().getPluginManager().registerCommand(this, new PingCommand());
		this.getProxy().getPluginManager().registerCommand(this, new ListCommand());
		this.getProxy().getPluginManager().registerCommand(this, new SayColoredCommand());
	}

}