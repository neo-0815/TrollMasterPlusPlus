package me.neo_0815.trollmaster.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.trollmaster.TrollMasterPlusPlus;

public class CMDtrollleave implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("trollleave")) if(sender instanceof Player) {
			final Player p = (Player) sender;

			if(!p.hasPermission("trollmaster.trollleave")) p.sendMessage(TrollMasterPlusPlus.noperm);
			else if(args.length != 1) return false;
			else if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
				final Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

				for(final Player targetPlayer : targets)
					targetPlayer.hidePlayer(Bukkit.getPlayer(args[0]));

				Bukkit.broadcastMessage("§e" + Bukkit.getPlayer(args[0]).getDisplayName() + " hat das Spiel verlassen.");
			}else Bukkit.broadcastMessage("§e" + args[0] + " hat das Spiel verlassen.");
		}else if(args.length != 1) return false;
		else if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
			final Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

			for(final Player targetPlayer : targets)
				targetPlayer.hidePlayer(Bukkit.getPlayer(args[0]));

			Bukkit.broadcastMessage("§e" + Bukkit.getPlayer(args[0]).getDisplayName() + " hat das Spiel verlassen.");
		}else Bukkit.broadcastMessage("§e" + args[0] + " hat das Spiel verlassen.");

		return false;
	}
}
