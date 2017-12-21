package tmpp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tmpp.cmds.CMDtrolljoin;
import tmpp.cmds.CMDtrollleave;
import tmpp.cmds.CMDtrollmode;
import tmpp.cmds.CMDtrollmodeoff;
import tmpp.cmds.CMDtrollspawn;
import tmpp.listener.DeathListener;
import tmpp.listener.JoinListener;
import tmpp.listener.QuitListener;

public class TrollMasterPlusPlus extends JavaPlugin {

	public static String pr = "§8[§4TMPP§8] ";
	public static String noperm = pr + "§cDazu hast du keine Berechtigung!";

	public static ArrayList<Player> buildList = new ArrayList<>();
	public static ArrayList<Player> trollPlayers = new ArrayList<>();

	String nameOfPl = getDescription().getName();
	String versionOfPl = getDescription().getVersion();
	String authorOfPl = getDescription().getAuthors().get(0);
	String websiteOfPl = getDescription().getWebsite();

	@Override
	public void onEnable() {
		System.out.println("[TMPP] " + nameOfPl + ", Version: " + versionOfPl + ", von: " + authorOfPl);
		Bukkit.broadcastMessage(pr + nameOfPl + ", Version: " + versionOfPl + ", von: " + authorOfPl);

		fileCheck();

		registerCmds();
		registerListener();
	}

	private void registerCmds() {
		getCommand("trollmode").setExecutor(new CMDtrollmode());
		getCommand("trollmodeoff").setExecutor(new CMDtrollmodeoff());
		getCommand("trollspawn").setExecutor(new CMDtrollspawn());
		getCommand("trolljoin").setExecutor(new CMDtrolljoin());
		getCommand("trollleave").setExecutor(new CMDtrollleave());
	}

	private void registerListener() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new DeathListener(), this);
	}

	public static void saveInv(Player p) {
		ArrayList<ItemStack> list = new ArrayList<>();
		String name = p.getName();
		File file = new File("plugins//TrollMaster++//Inventory//inv_" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[TMPP] Pfad nicht gefunden!");
		}

		YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
		ItemStack[] contents = p.getInventory().getContents();

		for(ItemStack item : contents)
			list.add(item);

		inv.set("Inventory", list);

		try {
			inv.save(file);
		}catch(IOException e) {
			System.out.println("[TMPP] Pfad nicht gefunden!");
		}

		p.getInventory().clear();
	}

	public static void loadInv(Player p) {
		String name = p.getName();
		File file = new File("plugins//TrollMaster++//Inventory//inv_" + name + ".yml");

		if(file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for(int i = 0; i < list.size(); i++)
				contents[i] = (ItemStack) list.get(i);

			p.getInventory().setContents(contents);
		}
	}

	public static void saveArmor(Player p) {
		ArrayList<ItemStack> list = new ArrayList<>();
		String name = p.getName();
		File file = new File("plugins//TrollMaster++//Inventory//armor_" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[TMPP] Pfad nicht gefunden!");
		}

		YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
		ItemStack[] contents = p.getInventory().getArmorContents();

		for(ItemStack item : contents)
			list.add(item);

		inv.set("Inventory", list);

		try {
			inv.save(file);
		}catch(IOException e) {
			System.out.println("[TMPP] Pfad nicht gefunden!");
		}

		p.getInventory().setArmorContents(null);
	}

	public static void loadArmor(Player p) {
		String name = p.getName();
		File file = new File("plugins//TrollMaster++//Inventory//armor_" + name + ".yml");

		if(file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);

			ItemStack[] contents = p.getInventory().getArmorContents();
			List<?> list = inv.getList("Inventory");

			for(int i = 0; i < list.size(); i++)
				contents[i] = (ItemStack) list.get(i);

			p.getInventory().setArmorContents(contents);
		}
	}

	private void fileCheck() {
		File path = new File("plugins//TrollMaster++//Inventory");

		if(!path.exists()) path.mkdir();
	}
}
