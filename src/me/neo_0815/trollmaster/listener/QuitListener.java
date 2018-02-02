package me.neo_0815.trollmaster.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);

		Bukkit.broadcastMessage("§e" + e.getPlayer().getDisplayName() + " hat das Spiel verlassen.");
	}
}