package com.eternaldoom.serverutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class ServerUtils extends Plugin {
    public static Configuration mutelist = null;
    public static File datafolder;
	@Override
	public void onEnable(){
		
		if (!this.getDataFolder().exists())
            this.getDataFolder().mkdir();
		
		datafolder = this.getDataFolder();

        File file = new File(getDataFolder(), "muteplayers.yml");

        if (!file.exists()) {
            try {
				Files.copy(getResourceAsStream("muteplayers.yml"), file.toPath());
			} catch (IOException e) {}
        }
        try {
			mutelist = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
		} catch (IOException e) {}
        
		this.getProxy().getPluginManager().registerListener(this, new Events());
		this.getProxy().getPluginManager().registerCommand(this, new PingCommand());
		this.getProxy().getPluginManager().registerCommand(this, new ListCommand());
		this.getProxy().getPluginManager().registerCommand(this, new SayColoredCommand());
		this.getProxy().getPluginManager().registerCommand(this, new AntiochCommand());
		this.getProxy().getPluginManager().registerCommand(this, new MuteCommand());
		this.getProxy().getPluginManager().registerCommand(this, new UnmuteCommand());
		getLogger().info("Sucessfully Loaded");
	}
}