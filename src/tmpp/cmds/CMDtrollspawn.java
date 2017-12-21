package tmpp.cmds;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;

import tmpp.TrollMasterPlusPlus;

public class CMDtrollspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("trollspawn")) if(sender instanceof Player) {
			Player p = (Player) sender;

			if(!p.hasPermission("tmpp.trollspawn")) {
				p.sendMessage(TrollMasterPlusPlus.noperm);

				return true;
			}else {
				if(args.length < 1 || args.length > 3) return false;
				else {
					Location loc = p.getLocation();
					World world = p.getWorld();

					String arg1 = args[0];
					int arg2 = -1;

					try {
						arg2 = Integer.valueOf(args[1]);
					}catch(Exception e) {
						// System.out.println(p.getName() + "hat ein Entity
						// (" + arg1 + ") mit \"arg[0]==NULL\" ausgeführt");
					}

					if(p.hasPermission("tmpp.trollspawn.danger")) {
						if(arg2 == -1) mobChooserA(arg1, p, world, loc);
						else if(arg2 == 0) p.sendMessage(TrollMasterPlusPlus.pr + "Bitte gib die Anzahl vom Entity \"" + arg1 + "\" an!");
						else if(arg2 >= 1 && arg2 <= 30) while(arg2 != 0) {
							mobChooserA(arg1, p, world, loc);
							arg2--;
						}
					}else if(arg2 == -1) mobChooserB(arg1, p, world, loc);
					else if(arg2 == 0) p.sendMessage(TrollMasterPlusPlus.pr + "Bitte gib die Anzahl vom Entity \"" + arg1 + "\" an!");
					else if(arg2 >= 1 && arg2 <= 10) while(arg2 != 0) {
						mobChooserB(arg1, p, world, loc);
						arg2--;
					}
				}

				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("unused")
	public static void mobChooserA(String arg1, Player p, World world, Location loc) {
		Zombie zombie;
		Skeleton skeleton;
		Creeper creeper;
		Witch witch;
		Blaze blaze;
		Ghast ghast;
		Giant giant;
		Guardian guardian;
		EnderDragon enderdragon;
		Wither wither;
		TNTPrimed tnt;
		Wolf wolf;
		Spider spider;
		CaveSpider cavespider;
		LightningStrike lightning;

		switch(arg1.toLowerCase()) {
		case "zombie":
			zombie = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
			break;
		case "skellet":
			skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
			break;
		case "skeleton":
			skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
			break;
		case "creeper":
			creeper = (Creeper) world.spawnEntity(loc, EntityType.CREEPER);
			break;
		case "witch":
			witch = (Witch) world.spawnEntity(loc, EntityType.WITCH);
			break;
		case "hexe":
			witch = (Witch) world.spawnEntity(loc, EntityType.WITCH);
			break;
		case "blaze":
			blaze = (Blaze) world.spawnEntity(loc, EntityType.BLAZE);
			break;
		case "lohe":
			blaze = (Blaze) world.spawnEntity(loc, EntityType.BLAZE);
			break;
		case "ghast":
			ghast = (Ghast) world.spawnEntity(loc, EntityType.GHAST);
			break;
		case "giant":
			giant = (Giant) world.spawnEntity(loc, EntityType.GIANT);
			break;
		case "riese":
			giant = (Giant) world.spawnEntity(loc, EntityType.GIANT);
			break;
		case "guardian":
			guardian = (Guardian) world.spawnEntity(loc, EntityType.GUARDIAN);
			break;
		case "wächter":
			guardian = (Guardian) world.spawnEntity(loc, EntityType.GUARDIAN);
			break;
		case "enderdragon":
			enderdragon = (EnderDragon) world.spawnEntity(loc, EntityType.ENDER_DRAGON);
			break;
		case "enderdrache":
			enderdragon = (EnderDragon) world.spawnEntity(loc, EntityType.ENDER_DRAGON);
			break;
		case "wither":
			wither = (Wither) world.spawnEntity(loc, EntityType.WITHER);
			break;
		case "tnt":
			tnt = (TNTPrimed) world.spawnEntity(loc, EntityType.PRIMED_TNT);
			break;
		case "wolf":
			wolf = (Wolf) world.spawnEntity(loc, EntityType.WOLF);
			wolf.setAngry(true);
			break;
		case "spider":
			spider = (Spider) world.spawnEntity(loc, EntityType.SPIDER);
			break;
		case "spinne":
			spider = (Spider) world.spawnEntity(loc, EntityType.SPIDER);
			break;
		case "cavespider":
			cavespider = (CaveSpider) world.spawnEntity(loc, EntityType.CAVE_SPIDER);
			break;
		case "höhlenspinne":
			cavespider = (CaveSpider) world.spawnEntity(loc, EntityType.CAVE_SPIDER);
			break;
		case "lightning":
			lightning = (LightningStrike) world.spawnEntity(loc, EntityType.LIGHTNING);
			break;
		case "lightningstrike":
			lightning = (LightningStrike) world.spawnEntity(loc, EntityType.LIGHTNING);
			break;
		case "blitz":
			lightning = (LightningStrike) world.spawnEntity(loc, EntityType.LIGHTNING);
			break;
		}
	}

	@SuppressWarnings("unused")
	public static void mobChooserB(String arg1, Player p, World world, Location loc) {
		Zombie zombie;
		Skeleton skeleton;
		Creeper creeper;
		Witch witch;
		Blaze blaze;
		Guardian guardian;
		TNTPrimed tnt;
		Spider spider;

		switch(arg1.toLowerCase()) {
		case "zombie":
			zombie = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
			break;
		case "skellet":
			skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
			break;
		case "skeleton":
			skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
			break;
		case "creeper":
			creeper = (Creeper) world.spawnEntity(loc, EntityType.CREEPER);
			break;
		case "witch":
			witch = (Witch) world.spawnEntity(loc, EntityType.WITCH);
			break;
		case "hexe":
			witch = (Witch) world.spawnEntity(loc, EntityType.WITCH);
			break;
		case "blaze":
			blaze = (Blaze) world.spawnEntity(loc, EntityType.BLAZE);
			break;
		case "lohe":
			blaze = (Blaze) world.spawnEntity(loc, EntityType.BLAZE);
			break;
		case "guardian":
			guardian = (Guardian) world.spawnEntity(loc, EntityType.GUARDIAN);
			break;
		case "wächter":
			guardian = (Guardian) world.spawnEntity(loc, EntityType.GUARDIAN);
			break;
		case "tnt":
			tnt = (TNTPrimed) world.spawnEntity(loc, EntityType.PRIMED_TNT);
			break;
		case "spider":
			spider = (Spider) world.spawnEntity(loc, EntityType.SPIDER);
			break;
		case "spinne":
			spider = (Spider) world.spawnEntity(loc, EntityType.SPIDER);
			break;
		}
	}
}
