package com.eternaldoom.serverutils;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class MuteCommand extends Command{

	public MuteCommand() {
		super("mute");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender.hasPermission("serverutils.mute")){
		if (!ServerUtils.mutelist.getBoolean(args[0].toLowerCase())){
			ServerUtils.mutelist.set(args[0].toLowerCase(), true);
			try {
				ConfigurationProvider.getProvider(YamlConfiguration.class).save(ServerUtils.mutelist, new File(ServerUtils.datafolder, "muteplayers.yml"));
			} catch (IOException e) {}
			sender.sendMessage(new ComponentBuilder("Muted " + args[0] + " sucessfully").color(ChatColor.GREEN).create());
		}else{
			sender.sendMessage(new ComponentBuilder("Command could not execute.").color(ChatColor.RED).create());
		}
		}else{
			sender.sendMessage(new ComponentBuilder("You do not have permission to execute this command.").color(ChatColor.RED).create());
		}
	}
}
