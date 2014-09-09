package com.eternaldoom.serverutils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command{

	public PingCommand() {
		super("ping");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.BLUE + "The server is responsive!");
	}

}
