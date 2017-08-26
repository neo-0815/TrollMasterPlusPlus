package tmpp.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DeathListener implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player killer = e.getEntity().getKiller();
		ItemStack stack = killer.getInventory().getItemInMainHand();

		e.setDeathMessage(null);

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack bow = new ItemStack(Material.BOW);
		ItemStack stick = new ItemStack(Material.STICK);

		ItemMeta sword_meta = sword.getItemMeta();
		ItemMeta bow_meta = bow.getItemMeta();
		ItemMeta stick_meta = stick.getItemMeta();

		sword_meta.setDisplayName("§c§n§lTroll-Schwert");
		sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
		sword_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		sword_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> sword_lore = new ArrayList<>();
		sword_lore.add("§8Schwert zum Trollen von Spielern.");
		sword_meta.setLore(sword_lore);
		bow_meta.setDisplayName("§c§n§lTroll-Bogen");
		bow_meta.addEnchant(Enchantment.ARROW_DAMAGE, 100, true);
		bow_meta.addEnchant(Enchantment.ARROW_INFINITE, 100, true);
		bow_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		bow_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> bow_lore = new ArrayList<>();
		bow_lore.add("§8Bogen zum Trollen von Spielern.");
		bow_meta.setLore(bow_lore);
		stick_meta.setDisplayName("§c§n§lTroll-Stick");
		stick_meta.addEnchant(Enchantment.KNOCKBACK, 100, true);
		stick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		stick_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> stick_lore = new ArrayList<>();
		stick_lore.add("§8Stick zum Trollen von Spielern.");
		stick_meta.setLore(stick_lore);

		sword.setItemMeta(sword_meta);
		bow.setItemMeta(bow_meta);
		stick.setItemMeta(stick_meta);

		if(stack == sword) {
			Bukkit.broadcastMessage(p.getDisplayName() + " was slain by " + killer.getDisplayName() + " with using §3[" + sword_meta.getDisplayName() + "§3]");
			p.sendMessage("§aTROLLOOOOLLLOOOLLLLOOOLLLLOOO");
		}else if(stack == bow) {
			Bukkit.broadcastMessage(p.getDisplayName() + " was slain by " + killer.getDisplayName() + " with using §3[" + bow_meta.getDisplayName() + "§3]");
			p.sendMessage("§aTROLLOOOOLLLOOOLLLLOOOLLLLOOO");
		}else if(stack == stick) {
			Bukkit.broadcastMessage(p.getDisplayName() + " was slain by " + killer.getDisplayName() + " with using §3[" + stick_meta.getDisplayName() + "§3]");
			p.sendMessage("§aTROLLOOOOLLLOOOLLLLOOOLLLLOOO");
		}
	}
}
