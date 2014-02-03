package info.tregmine.bungee.listeners;

import info.tregmine.bungee.Essentials;

import org.bukkit.event.Listener;

public class PortalListener implements Listener {
	private Essentials plugin;

	public PortalListener(Essentials instance) {
		this.plugin = instance;
	}

	/*ArrayList<String> players = new ArrayList<String>();
	int taskID = 0;
	
	@EventHandler
	public void onUseServerPortal(PlayerMoveEvent e) {

		Player p = e.getPlayer();
		World world = p.getWorld();
		Location playerLoc = p.getLocation();
		Material portal = playerLoc.getWorld().getBlockAt(playerLoc).getRelative(0, 0, 0).getType();

		if (portal != Material.PORTAL) {
			return;
		}

		int X = p.getLocation().getBlockX();
		int Z = p.getLocation().getBlockZ();
		int Y = p.getLocation().getBlockY();
		Block b = world.getBlockAt(X, Y, Z);
		
		findBlock(world, b, p);
	}

	public void findBlock(World w, Block b, Player p) {
		int x = b.getX();
		int z = b.getZ();
		int y = p.getLocation().getBlockY();
		int take = 0;
		Block check = w.getBlockAt(x, y, z);

		while (w.getBlockAt(x, y, z).getType() == Material.PORTAL) {
			y--;
			take++;
			continue;
		}
		Material m = check.getLocation().subtract(0, take + 1, 0).getBlock().getType();

		checkTypes(m, p);
	}
	
	public void checkTypes(Material m, Player p){
		
		if(plugin.getConfig().getString("portals." + m.toString()) == null){
			return;
		}
		
		String server = plugin.getConfig().getString("portals." + m.toString() + ".server");
		
		if(!players.contains(p.getName())){

			taskID++;
			players.add(p.getName());

			p.sendMessage(ChatColor.GREEN + "Teleporting you to " + ChatColor.GOLD + server + ChatColor.GREEN + "!");
			
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("Connect");
			out.writeUTF(server);
			p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			
			remPlayer(p, taskID);
		}
	}
	
	public void remPlayer(final Player p, int task) {
		task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				players.remove(p.getName());
				taskID--;
			}
		}, 100L);
	}*/
}