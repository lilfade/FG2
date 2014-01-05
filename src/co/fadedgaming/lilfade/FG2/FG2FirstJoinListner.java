package co.fadedgaming.lilfade.FG2;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FG2FirstJoinListner implements Listener {
	FG2 plugin;
	
	public FG2FirstJoinListner(FG2 instance) {
		plugin = instance;
	}
	
	//gets new player event, and passes data to the webserver for pre-registration
	@EventHandler(priority = EventPriority.HIGHEST)
    public void firstJoin(PlayerJoinEvent event) {
		// Define our variables.
        Player player = event.getPlayer();
        //will be true if the player has played before
        Boolean b = player.hasPlayedBefore();
        //if they have lets setup the health and what not
        if(!b){
        	//could set players inital values here
            //player.setLevel(0);
            //player.setHealth(20);
            //player.setFoodLevel(1);
        	
        	//pass info to server for registration
        	FG2Utilitys.sendGetRequest(plugin.getConfig().getString("http-server")+plugin.getConfig().getString("auth-page"), "action=addplayer&player="+player.getName());
        		
        } else {
        	//user has logged on before do what we need to do here, maybe update money
        	//FG2Utilitys.sendGetRequest(plugin.getConfig().getString("http-server")+plugin.getConfig().getString("pm-page"), "action=checkmessage&player="+player.getName());
        }        
	}
}
