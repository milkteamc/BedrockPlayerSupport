package cn.dsnbo.bedrockplayersupport.command;

import cn.dsnbo.bedrockplayersupport.utils.Forms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

/**
 * @author DongShaoNB
 */
public class TpaHereCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
                if (!(Bukkit.getOnlinePlayers().size() <= 1)) {
                    Forms.openBedrockTeleportHereMenu(player);
                } else {
                    player.sendMessage("§c当前没有其他玩家在线!");
                }
            } else {
                player.sendMessage("§c你不是基岩版玩家!");
            }
        }
        return false;
    }

}