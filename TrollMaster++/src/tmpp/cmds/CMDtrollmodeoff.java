package tmpp.cmds;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tmpp.main.Main;

public class CMDtrollmodeoff implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("trollmodeoff")) if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!p.hasPermission("tmpp.trollmode")) {
				p.sendMessage(Main.noperm);

				return true;
			}else if(args.length != 0) return false;
			else {
				p.sendMessage(Main.pr + "§7Trollmode deaktiviert.");

				Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

				for(Player targetPlayer : targets)
					targetPlayer.showPlayer(p);

				Main.loadInv(p);

				p.setGameMode(Bukkit.getDefaultGameMode());

				Main.loadArmor(p);

				Main.trollPlayers.remove(p);
			}
		}

		return true;
	}
}
