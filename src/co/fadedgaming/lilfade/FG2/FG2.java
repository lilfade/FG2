package co.fadedgaming.lilfade.FG2;


import java.util.logging.Logger;

//import org.bukkit.command.Command;
//import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FG2 extends JavaPlugin {

	public static Logger logger;
	
	@Override
	public void onEnable(){
		//	PluginDescriptionFile pdfFile = this.getDescription();
		//	this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has been Enabled!");		
			PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(new FG2FirstJoinListner(this),  this);
				
			final FileConfiguration config = this.getConfig();
			//copy over the default config file
			config.options().copyDefaults(true);
			saveConfig();
				
			logger = getLogger();
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    /*public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("bug")) {
			//we got a bug here, store it in the db with who reported it
			FG2Utilitys.sendGetRequest(getConfig().getString("http-server")+getConfig().getString("auth-page"), "action=addbug&player="+player.getName()+"&report="+FG2Utilitys.convertArgsToString(args));
			player.sendMessage("Bug sent thanks for telling us about it!");
		}else if(commandLabel.equalsIgnoreCase("suggestion")){
			//we got a suggestion, add it to the bd but say who its from as well 
			FG2Utilitys.sendGetRequest(getConfig().getString("http-server")+getConfig().getString("auth-page"), "action=addsuggestion&player="+player.getName()+"&suggestion="+FG2Utilitys.convertArgsToString(args));
			player.sendMessage("Suggestion sent thanks!");
		}else if(commandLabel.equalsIgnoreCase("bv")) {
			//simple command to find the server version 
			player.sendMessage("Bukkit Version:" + getServer().getBukkitVersion());
		}else if(commandLabel.equalsIgnoreCase("pm")) {
			//someone wants to send a private message to someone 
			player.sendMessage("Hello: "+ player.getName() + "Your message: " + FG2Utilitys.convertArgsToString1(args));
		}
		return false;
	}*/
}
