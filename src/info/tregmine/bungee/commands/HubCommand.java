package info.tregmine.bungee.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import info.tregmine.bungee.Essentials;

public class HubCommand implements CommandExecutor {

	Essentials plugin;

	public HubCommand(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("portal")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("GetServers");
				p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());

				int task = 0;
				task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						if (Arrays.asList(Essentials.serverList).contains("hub")){
							Bukkit.broadcastMessage("contains Hub");
						}else{
							Bukkit.broadcastMessage("doesnt contain");
						}
					}
				}, 10L);
				
			} else {
				plugin.getLogger().info("You can't use this command from the console!");
			}
		}
		return true;
	}
}