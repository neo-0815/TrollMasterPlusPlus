package me.neo_0815.trollmaster.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.neo_0815.trollmaster.TrollMasterPlusPlus;

public class CMDtrollmode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("trollmode")) if(sender instanceof Player) {
			final Player p = (Player) sender;
			if(!p.hasPermission("trollmaster.trollmode")) {
				p.sendMessage(TrollMasterPlusPlus.noperm);

				return true;
			}else if(args.length != 0) return false;
			else {
				p.sendMessage(TrollMasterPlusPlus.pr + "§7Trollmode aktiviert.");

				final Collection<? extends Player> targets = Bukkit.getServer().getOnlinePlayers();

				for(final Player targetPlayer : targets)
					targetPlayer.hidePlayer(p);

				TrollMasterPlusPlus.saveInv(p);
				TrollMasterPlusPlus.saveArmor(p);

				final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
				final ItemStack bow = new ItemStack(Material.BOW);
				final ItemStack stick = new ItemStack(Material.STICK);
				final ItemStack arrow = new ItemStack(Material.ARROW);

				final ItemMeta sword_meta = sword.getItemMeta();
				final ItemMeta bow_meta = bow.getItemMeta();
				final ItemMeta stick_meta = stick.getItemMeta();
				final ItemMeta arrow_meta = arrow.getItemMeta();

				sword_meta.setDisplayName("§c§n§lTroll-Schwert");
				sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
				sword_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				sword_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				final ArrayList<String> sword_lore = new ArrayList<>();
				sword_lore.add("§8Schwert zum Trollen von Spielern.");
				sword_meta.setLore(sword_lore);

				bow_meta.setDisplayName("§c§n§lTroll-Bogen");
				bow_meta.addEnchant(Enchantment.ARROW_DAMAGE, 100, true);
				bow_meta.addEnchant(Enchantment.ARROW_INFINITE, 100, true);
				bow_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				bow_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				final ArrayList<String> bow_lore = new ArrayList<>();
				bow_lore.add("§8Bogen zum Trollen von Spielern.");
				bow_meta.setLore(bow_lore);

				stick_meta.setDisplayName("§c§n§lTroll-Stick");
				stick_meta.addEnchant(Enchantment.KNOCKBACK, 100, true);
				stick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				stick_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				final ArrayList<String> stick_lore = new ArrayList<>();
				stick_lore.add("§8Stick zum Trollen von Spielern.");
				stick_meta.setLore(stick_lore);

				arrow_meta.setDisplayName("§c§n§lTroll-Pfeil");
				arrow_meta.addEnchant(Enchantment.ARROW_INFINITE, 100, true);
				arrow_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				arrow_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				final ArrayList<String> arrow_lore = new ArrayList<>();
				arrow_lore.add("§8Pfeil zum Trollen von Spielern.");
				arrow_meta.setLore(arrow_lore);

				sword.setItemMeta(sword_meta);
				bow.setItemMeta(bow_meta);
				stick.setItemMeta(stick_meta);
				arrow.setItemMeta(arrow_meta);

				p.getInventory().setItem(1, sword);
				p.getInventory().setItem(2, bow);
				p.getInventory().setItem(3, stick);
				p.getInventory().setItemInOffHand(arrow);

				p.setGameMode(GameMode.CREATIVE);

				TrollMasterPlusPlus.trollPlayers.add(p);
			}
		}

		return true;
	}
}
