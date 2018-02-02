package me.neo_0815.trollmaster.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.trollmaster.TrollMasterPlusPlus;

public class CMDtrollmodeoff implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("trollmodeoff")) if(sender instanceof Player) {
			final Player p = (Player) sender;
			if(!p.hasPermission("trollmaster.trollmode")) {
				p.sendMessage(TrollMasterPlusPlus.noperm);

				return true;
			}else if(args.length != 0) return false;
			else {
				p.sendMessage(TrollMasterPlusPlus.pr + "§7Trollmode deaktiviert.");

				final Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

				for(final Player targetPlayer : targets)
					targetPlayer.showPlayer(p);

				TrollMasterPlusPlus.loadInv(p);

				p.setGameMode(Bukkit.getDefaultGameMode());

				TrollMasterPlusPlus.loadArmor(p);

				TrollMasterPlusPlus.trollPlayers.remove(p);
			}
		}

		return true;
	}
}
