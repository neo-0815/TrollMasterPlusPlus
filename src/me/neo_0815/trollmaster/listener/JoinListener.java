package me.neo_0815.trollmaster.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.neo_0815.trollmaster.TrollMasterPlusPlus;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);

		Bukkit.broadcastMessage("�e" + e.getPlayer().getDisplayName() + " hat das Spiel betreten.");

		for(Player target : TrollMasterPlusPlus.trollPlayers)
			e.getPlayer().hidePlayer(target);
	}
}
