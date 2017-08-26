package tmpp.cmds;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tmpp.main.Main;

public class CMDtrolljoin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("trolljoin")) if(sender instanceof Player) {
			Player p = (Player) sender;

			if(!p.hasPermission("tmpp.trolljoin")) p.sendMessage(Main.noperm);
			else if(args.length != 1) return false;
			else if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
				Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

				for(Player targetPlayer : targets)
					targetPlayer.showPlayer(Bukkit.getPlayer(args[0]));

				Bukkit.broadcastMessage("§e" + Bukkit.getPlayer(args[0]).getDisplayName() + " hat das Spiel betreten.");
			}else Bukkit.broadcastMessage("§e" + args[0] + " hat das Spiel betreten.");
		}else if(args.length != 1) return false;
		else if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
			Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

			for(Player targetPlayer : targets)
				targetPlayer.showPlayer(Bukkit.getPlayer(args[0]));

			Bukkit.broadcastMessage("§e" + Bukkit.getPlayer(args[0]).getDisplayName() + " hat das Spiel betreten.");
		}else Bukkit.broadcastMessage("§e" + args[0] + " hat das Spiel betreten.");

		return false;
	}
}
